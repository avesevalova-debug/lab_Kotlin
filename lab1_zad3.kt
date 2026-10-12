fun main() {
    val purchaseAmount = 12780.0   // сумма покупки в рублях
    val isRegularCustomer = true   // постоянный покупатель или нет

    //определение общей скидки
    var discount = 0.0

    if (purchaseAmount >= 0 && purchaseAmount <= 1000) {
        discount = 0.0
    } else if (purchaseAmount > 1000 && purchaseAmount <= 10000) {
        discount = 100.0
    } else {
        // purchaseAmount > 10000
        discount = purchaseAmount * 0.05
    }

    // Цена с общей скидкой
    val priceAfterFirstDiscount = purchaseAmount - discount

    // доп скидка для постоянных
    var finalPrice = priceAfterFirstDiscount

    if (isRegularCustomer == true) {
        finalPrice = priceAfterFirstDiscount * 0.99
    } else {
        finalPrice = priceAfterFirstDiscount
    }

    // Общая скидка
    val totalDiscount = purchaseAmount - finalPrice

    println("Сумма покупки: $purchaseAmount руб.")
    println("Скидка по акции: $discount руб.")
    println("Постоянный покупатель: $isRegularCustomer")
    println("Общая скидка: $totalDiscount руб.")
    println("Итоговая цена: $finalPrice руб.")
}