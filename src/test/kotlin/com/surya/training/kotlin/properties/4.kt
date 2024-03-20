package com.surya.training.kotlin.properties

import com.surya.training.kotlin.conventions.MyDate
import io.kotest.core.spec.style.StringSpec
import java.util.Calendar
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty
import kotlin.test.assertEquals

/**
 * You may declare your own delegates. Implement the methods of the class 'EffectiveDate' so it can be delegated to. Store only the time in milliseconds in 'timeInMillis' property.
 *
 * Use the extension functions MyDate.toMillis() and Long.toDate(), defined at MyDate.kt
 */

class D {
    var date: MyDate by EffectiveDate()
}

class EffectiveDate<R> : ReadWriteProperty<R, MyDate> {

    var timeInMillis: Long? = null

    override fun getValue(thisRef: R, property: KProperty<*>): MyDate {
        TODO()
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate) {
        TODO()
    }
}

class Four : StringSpec({

    "Date" {
        val d = D()
        /* Month numbering starts with 0 (0-Jan, 1-Feb, ... 11-Dec) */
        d.date = MyDate(2014, 1, 13)
        assertEquals(2014, d.date.year)
        assertEquals(1, d.date.month)
        assertEquals(13, d.date.dayOfMonth)
    }
})

fun MyDate.toMillis(): Long {
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth, 0, 0, 0)
    c.set(Calendar.MILLISECOND, 0)
    return c.timeInMillis
}

fun Long.toDate(): MyDate {
    val c = Calendar.getInstance()
    c.timeInMillis = this
    return MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE))
}
