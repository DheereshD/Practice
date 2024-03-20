// package com.surya.training.kotlin.conventions
//
// import io.kotest.core.spec.style.StringSpec
// import java.time.Year
// import kotlin.test.assertEquals
// e
// /**
// * Implement a kind of date arithmetic. Support adding years, weeks and days to a date. You could be able to write the code like this: date + YEAR * 2 + WEEK * 3 + DAY * 15.
// *
// * At first, add an extension function 'plus()' to MyDate, taking a TimeInterval as an argument. Use an utility function MyDate.addTimeIntervals() declared in DateUtil.kt
// *
// * Then, try to support adding several time intervals to a date. You may need an extra class.
// */
// data class TimeIntervals(val intervals: Map<TimeInterval, Int>)
//
// operator fun TimeInterval.times(int: Int): TimeIntervals {
//     return TimeIntervals(mapOf(this to int))
// }
//
// operator fun MyDate.plus(timeIntervals: TimeIntervals): MyDate {
//     var result = this
//     for ((interval, value) in timeIntervals.intervals) {
//         result = result.addTimeIntervals(interval, value)
//     }
//     return result
// }
// class Five : StringSpec({
//
//    operator fun MyDate.plus(timeInterval: TimeInterval): MyDate {
//        return addTimeIntervals(TimeInterval.DAY, 1)
//    }
//
//    fun task1(today: MyDate): MyDate {
//        return today + TimeInterval.YEAR + TimeInterval.WEEK
//    }
//
//     fun MyDate.multiply (timeInterval: TimeInterval, multiplier: Int): MyDate {
//         return addTimeIntervals(TimeInterval.DAY, multiplier)
//     }
//
//    fun task2(today: MyDate): MyDate {
//        return today + ((MyDate(TimeInterval.YEAR , 2)) + (TimeInterval.WEEK * 3) + (TimeInterval.DAY * 5))
//    }
//
//    "Add time intervals" {
//        assertEquals(MyDate(2014, 5, 22), MyDate(1983, 5, 22).addTimeIntervals(TimeInterval.YEAR, 31))
//        assertEquals(MyDate(1983, 5, 29), MyDate(1983, 5, 22).addTimeIntervals(TimeInterval.DAY, 7))
//        assertEquals(MyDate(1983, 5, 29), MyDate(1983, 5, 22).addTimeIntervals(TimeInterval.WEEK, 1))
//    }
//
//    "Add one time interval" {
//        assertEquals(MyDate(2015, 5, 8), task1(MyDate(2014, 5, 1)))
//    }
//
//    "One month" {
//        assertEquals(MyDate(2016, 0, 27), task2(MyDate(2014, 0, 1)))
//    }
//
//    "Month Change" {
//        assertEquals(MyDate(2016, 1, 20), task2(MyDate(2014, 0, 25)))
//    }
// })
