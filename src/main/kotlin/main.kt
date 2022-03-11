const val MINUTES = 60
const val HOURS = 60 * 60
const val DAYS = 24 * 60 * 60
fun main() {

    val guest1 = "Петя"
    val guest2 = "Василий"
    val guest3 = "Ярослава"
    val guest4 = "Валентина"
    val guest5 = "Павел"
    val guest6 = "Мария"

//    val current = LocalDateTime.now()
//
//    val newDate1 = current.minusSeconds(10)
//    val newDate2 = current.minusMinutes(10)
//    val newDate3 = current.minusHours(5)
//    val newDate4 = current.minusHours(25)
//    val newDate5 = current.minusHours(50)
//    val newDate6 = current.minusDays(4)
//
//    val second1 = calculateSeconds(current, newDate1)
//    val second2 = calculateSeconds(current, newDate2)
//    val second3 = calculateSeconds(current, newDate3)
//    val second4 = calculateSeconds(current, newDate4)
//    val second5 = calculateSeconds(current, newDate5)
//    val second6 = calculateSeconds(current, newDate6)
    val second1 = 10
    val second2 = 10 * 60
    val second3 = 5 * 60 * 60
    val second4 = 25 * 60 * 60
    val second5 = 50 * 60 * 60
    val second6 = 4 * 24 * 60 * 60

    println("$guest1 был(а) ${agoToText(second1)}")
    println("$guest2 был(а) ${agoToText(second2)}")
    println("$guest3 был(а) ${agoToText(second3)}")
    println("$guest4 был(а) ${agoToText(second4)}")
    println("$guest5 был(а) ${agoToText(second5)}")
    println("$guest6 был(а) ${agoToText(second6)}")

}

//fun calculateSeconds(timeCurrent: LocalDateTime, timeVisit: LocalDateTime): Int {
//    val getHour = timeCurrent.hour
//    val getMinutes = timeCurrent.minute
//    val getSecond = timeCurrent.second
//    val getDay = timeCurrent.dayOfYear
//
//    val getHourVisit = timeVisit.hour
//    val getMinutesVisit = timeVisit.minute
//    val getSecondVisit = timeVisit.second
//    val getDayVisit = timeVisit.dayOfYear
//
//    val totalSecondCurrent: Int = getHour * 60 * 60 + getMinutes * 60 + getSecond + getDay * 24 * 60 * 60
//    val totalSecondVisit: Int =
//        getHourVisit * 60 * 60 + getMinutesVisit * 60 + getSecondVisit + getDayVisit * 24 * 60 * 60
//
//    return totalSecondCurrent - totalSecondVisit
//}

fun agoToText(seconds: Int) = when (seconds) {
    in 0..MINUTES -> "только что"
    in (MINUTES + 1)..HOURS -> "${seconds / MINUTES} ${nameMinutes(seconds / MINUTES)} назад"
    in (HOURS + 1)..DAYS -> {
        val hours: Int = seconds / (HOURS)
        "$hours ${nameHours(seconds / HOURS)} назад"
    }
    in DAYS + 1..2 * DAYS -> "сегодня"
    in 2 * DAYS + 1..3 * DAYS -> "вчера"
    !in 0..3 * DAYS + 1 -> "давно"
    else -> "Не определено"
}


fun nameMinutes(minutes: Int) = when {
    minutes % 10 == 1 && minutes % 100 != 11 -> "минуту"
    minutes % 10 in 2..4 && minutes % 100 !in 12..14 -> "минуты"
    else -> "минут"
}

fun nameHours(hours: Int) = when {
    hours % 10 == 1 && hours % 100 != 11 -> "час"
    hours % 10 in 2..4 && hours % 100 !in 12..14 -> "часа"
    else -> "часов"
}


/**
Задача №1 - «Только что»
1 //DONE
Переменные не называются "отглагольно". То есть не getHour (получить час), а hour (час).
Отглагольно называются только функции. Переименовывайте.
2 //DONE
Не надо никаких LocalDateTime - это зависимость Java, а мы учимся программировать на Kotlin.
Просто Задайте произвольное количество секунд и всё. Вы больше кода написали, чем если бы вручную задали время для agotToText.
val second1 = 10
val second2 = 10 * 60
val second3 = 5 * 60 * 60
val second4 = 25 * 60 * 60
val second5 = 50 * 60 * 60
val second6 = 4 * 24 * 60 * 60
3 //DONE
Много "мифических значений": 60, 60 * 60, 24 * 60 * 60. Зафиксируйте их все в константах.
4 //DONE
Вам IDE разве не предлагает заменить это:
val textMessage = when (second) ...
return textMessage
На это:
return when (second) ...
Замените, пожалуйста, везде. Может даже стоит заменить block body на expression body, но это уже на Ваш вкус.
5 //DONE
val minutes: Int = second / (60 * 60) - это часы, а не минуты. Переименовывайте. Читаемость кода - это важно.
6 //DONE
Приведу на примере с минутами (к часам это тоже относится). Вы second / 60 высчитываете и в agoToText и в nameMinutes.
Может проще вместо секунд передать в nameMinutes только что подсчитанные минуты? Дорабатывайте.
7 //DONE
В agoToText передаются секунды (seconds), а не одна секунда (second). Переименуйте.
8
Что nameMinutes, что nameHours имеют по сути одну и ту же реализацию. Отличаются только строки. Слейте их в одну функцию,
а различия вынесите в параметры функции.
9 //DONE
Избавьтесь от ветки else -> "не определено" - там всё определено. Просто один из случаев выше переместите в ветку else.
 */