fun main () {
    val amount = 15200.0 // сумма перевода в рублях

    val commission = amount * 0.0075 // 0.75% от суммы

    val finalCommission = if (commission < 35) 35.0 else commission

    println("Сумма перевода: $amount руб.")
    println("Комиссия: $finalCommission руб.")
}