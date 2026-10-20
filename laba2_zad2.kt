import kotlin.math.roundToInt

// функция расчёта комиссии
fun calculate(cardType: String, prevSum: Double, transferSum: Double): String {
    var result = ""
    var commission = 0.0

    if (cardType == "VK Pay") {
        result = "Комиссия 0 руб. (VK Pay)"
    }
    else if (cardType == "Mastercard" || cardType == "Maestro") {
        val total = prevSum + transferSum
        if (transferSum >= 300 && total <= 75000) {
            result = "Комиссия 0 руб. (в рамках акции)"
        } else {
            commission = transferSum * 0.006 + 20
            result = "Комиссия ${commission.roundToInt()} руб. (0.6% + 20)"
        }
    }
    else if (cardType == "Visa" || cardType == "Mir") {
        commission = transferSum * 0.0075
        if (commission < 35) {
            commission = 35.0
        }
        result = "Комиссия ${commission.roundToInt()} руб. (0.75%, мин 35)"
    }
    else {
        result = "Неизвестная карта"
    }

    return result
}

// проверка что строка не пустая и это число
fun readDouble(message: String): Double {
    var input = ""
    var number = 0.0
    var ok = false

    while (!ok) {
        print(message)
        input = readln().trim()

        if (input.isEmpty()) {
            println("Ошибка: вы ничего не ввели. Попробуйте снова.")
            continue
        }

        try {
            number = input.toDouble()
            if (number < 0) {
                println("Ошибка: сумма не может быть отрицательной.")
                continue
            }
            ok = true
        } catch (e: NumberFormatException) {
            println("Ошибка: '$input' — это не число. Попробуйте снова.")
        }
    }

    return number
}

// проверка что ввели непустую строку
fun readString(message: String): String {
    var input = ""

    while (true) {
        print(message)
        input = readln().trim()

        if (input.isEmpty()) {
            println("Ошибка: вы ничего не ввели. Попробуйте снова.")
        } else {
            break
        }
    }

    return input
}

fun main() {
    println("=== Расчёт комиссии за перевод ===")

    // 1. тип карты
    var cardType = readString("Какой у вас тип карты/счёта? (VK Pay / Mastercard / Maestro / Visa / Mir): ")

    // приводим к нормальному виду — вдруг написали маленькими буквами
    cardType = cardType.lowercase()
    if (cardType == "vk pay") cardType = "VK Pay"
    if (cardType == "mastercard") cardType = "Mastercard"
    if (cardType == "maestro") cardType = "Maestro"
    if (cardType == "visa") cardType = "Visa"
    if (cardType == "mir") cardType = "Mir"

    // проверка что карта вообще из списка
    val allowed = listOf("VK Pay", "Mastercard", "Maestro", "Visa", "Mir")
    if (!allowed.contains(cardType)) {
        println("Вы ввели '$cardType', но такой карты нет в списке. Работаем как с обычной (Visa).")
        cardType = "Visa"
    }

    // 2. сумма предыдущих переводов
    val prevSum = readDouble("Сколько вы уже перевели в этом месяце (в рублях, 0 если ничего)? ")

    // 3. сумма перевода
    val transferSum = readDouble("Сколько хотите перевести сейчас (в рублях)? ")

    // итог
    println("\n--- Результат ---")
    println("Карта: $cardType")
    println("Переведено за месяц до этого: $prevSum руб.")
    println("Сумма перевода: $transferSum руб.")
    println(calculate(cardType, prevSum, transferSum))
}