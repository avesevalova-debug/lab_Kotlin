fun main() {
    // вспомогательная функция для минут
    fun minutGoText(sec: Int): String {
        val min = sec / 60
        var text = ""
        if (min % 10 == 1 && min % 100 != 11) {
            text = "$min минуту назад"
        } else if (min % 10 in 2..4 && (min % 100 !in 12..14)) {
            text = "$min минуты назад"
        } else {
            text = "$min минут назад"
        }
        return text
    }

    // вспомогательная функция для часов
    fun chasGoText(sec: Int): String {
        val hour = sec / 3600
        var text = ""
        if (hour % 10 == 1 && hour % 100 != 11) {
            text = "$hour час назад"
        } else if (hour % 10 in 2..4 && (hour % 100 !in 12..14)) {
            text = "$hour часа назад"
        } else {
            text = "$hour часов назад"
        }
        return text
    }

    // основная функция
    fun agoToText(sec: Int): String {
        var res = "был(а) "

        when {
            sec in 0..60 -> res += "только что"
            sec in 61..3600 -> res += minutGoText(sec)
            sec in 3601..86400 -> res += chasGoText(sec)
            sec in 86401..172800 -> res += "вчера"
            sec in 172801..259200 -> res += "позавчера"
            else -> res += "давно"
        }

        return res
    }

    println("Введите время отсутвия (в секундах):")
    val timeOfAbsence = readln()
    if (timeOfAbsence.toIntOrNull() != null) {
        println(agoToText(timeOfAbsence.toInt()))
    } else {
        println("Неправильно введены данные")
    }


}