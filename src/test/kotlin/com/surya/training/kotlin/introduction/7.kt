package com.surya.training.kotlin.introduction

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Read about null safety and safe calls in Kotlin and rewrite the following Java code using only one if expression:
 * ```
 * public void sendMessageToClient(
 *     @Nullable Client client,
 *     @Nullable String message,
 *     @NotNull Mailer mailer
 * ) {
 *     if (client == null || message == null) return;
 *
 *     PersonalInfo personalInfo = client.getPersonalInfo();
 *     if (personalInfo == null) return;
 *
 *     String email = personalInfo.getEmail();
 *     if (email == null) return;
 *
 *     mailer.sendMessage(email, message);
 * }
 * ```
 */

fun sendMessageToClient(
    client: Client?,
    message: String?,
    mailer: Mailer,
) {
    val personalInfo = client?.personalInfo
    val email = personalInfo?.email
    if (email == null || personalInfo == null || client == null || message == null) {
        throw NullPointerException("There cannot be any null in the function.")
    } else {
        mailer.sendMessage(email, message)
    }
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}

class Seven : StringSpec({
    fun testSendMessageToClient(
        client: Client?,
        message: String?,
        email: String? = null,
        shouldBeInvoked: Boolean = false,
    ) {
        var invoked = false
        sendMessageToClient(
            client,
            message,
            object : Mailer {
                override fun sendMessage(actualEmail: String, actualMessage: String) {
                    invoked = true
                    assertEquals(message, actualMessage, "The message is not as expected:")
                    assertEquals(email, actualEmail, "The email is not as expected:")
                }
            },
        )
        assertEquals(
            shouldBeInvoked,
            invoked,
            "The function 'sendMessage' should${if (shouldBeInvoked) "" else "n't"} be invoked",
        )
    }

    "Everything is OK" {
        testSendMessageToClient(
            Client(PersonalInfo("bob@gmail.com")),
            "Hi Bob! We have an awesome proposition for you...",
            "bob@gmail.com",
            true,
        )
    }

    "No Message" {
        testSendMessageToClient(Client(PersonalInfo("bob@gmail.com")), null)
    }
    "No Email" {
        testSendMessageToClient(Client(PersonalInfo(null)), "Hi Bob! We have an awesome proposition for you...")
    }
    "No personal info" {
        testSendMessageToClient(Client(null), "Hi Bob! We have an awesome proposition for you...")
    }
    "No client" {
        testSendMessageToClient(null, "Hi Bob! We have an awesome proposition for you...")
    }
})
