import java.time.LocalDateTime

fun main() {

    val guest1: String = "Петя"
    val guest2: String = "Василий"
    val guest3: String = "Ярослава"
    val guest4: String = "Валентина"
    val guest5: String = "Павел"
    val guest6: String = "Мария"

    val current = LocalDateTime.now()

    val newDate1 = current.minusSeconds(10)
    val newDate2 = current.minusMinutes(10)
    val newDate3 = current.minusHours(5)
    val newDate4 = current.minusHours(25)
    val newDate5 = current.minusHours(50)
    val newDate6 = current.minusDays(4)

    val second1 = calculateSeconds(current, newDate1)
    val second2 = calculateSeconds(current, newDate2)
    val second3 = calculateSeconds(current, newDate3)
    val second4 = calculateSeconds(current, newDate4)
    val second5 = calculateSeconds(current, newDate5)
    val second6 = calculateSeconds(current, newDate6)

    println("$guest1 был(а) ${agoToText(second1)}")
    println("$guest2 был(а) ${agoToText(second2)}")
    println("$guest3 был(а) ${agoToText(second3)}")
    println("$guest4 был(а) ${agoToText(second4)}")
    println("$guest5 был(а) ${agoToText(second5)}")
    println("$guest6 был(а) ${agoToText(second6)}")

}

fun calculateSeconds(timeCurrent: LocalDateTime, timeVisit: LocalDateTime): Int {
    val getHour = timeCurrent.hour
    val getMinutes = timeCurrent.minute
    val getSecond = timeCurrent.second
    val getDay = timeCurrent.dayOfYear

    val getHourVisit = timeVisit.hour
    val getMinutesVisit = timeVisit.minute
    val getSecondVisit = timeVisit.second
    val getDayVisit = timeVisit.dayOfYear

    val totalSecondCurrent: Int = getHour * 60 * 60 + getMinutes * 60 + getSecond + getDay * 24 * 60 * 60
    val totalSecondVisit: Int =
        getHourVisit * 60 * 60 + getMinutesVisit * 60 + getSecondVisit + getDayVisit * 24 * 60 * 60

    return totalSecondCurrent - totalSecondVisit
}

fun agoToText(second: Int): String {
    val textMessage = when (second) {
        in 0..60 -> "только что"
        in 61..60 * 60 -> "${second / 60} ${nameMinutes(second)} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> {
            val minutes: Int = second / (60 * 60)
            "$minutes ${nameHours(second)} назад"
        }
        in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> "сегодня"
        in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> "вчера"
        !in 0..3 * 24 * 60 * 60 + 1 -> "давно"
        else -> "Не определено"
    }
    return textMessage
}

fun nameMinutes(second: Int): String {
    val minutes = second / 60
    val nameMinute = when {
        minutes % 10 == 1 && minutes % 100 != 11 -> "минуту"
        minutes % 10 in 2..4 && minutes % 100 !in 12..14 -> "минуты"
        minutes % 10 in 5..9 || minutes % 10 == 0 || minutes % 100 in 11..14 -> "минут"
        else -> "не определено"
    }
    return nameMinute
}

fun nameHours(second: Int): String {
    val hours = second / 3600
    val nameHour = when {
        hours % 10 == 1 && hours % 100 != 11 -> "час"
        hours % 10 in 2..4 && hours % 100 !in 12..14 -> "часа"
        hours % 10 in 5..9 || hours % 100 in 10..20 -> "часов"
        else -> "не определено"
    }
    return nameHour
}