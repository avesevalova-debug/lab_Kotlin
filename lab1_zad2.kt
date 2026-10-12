fun main () {
    val likes = 157

    val lastTwo = likes % 100
    val lastOne = likes % 10

    var word = "человек" // по умолчанию

    if (lastTwo in 11..14) {
        word = "человек"
    } else if (lastOne == 1) {
        word = "человеку"
    } else if (lastOne == 2 || lastOne == 3 || lastOne == 4) {
        word = "людям"
    } else {
        word = "человек"
    }

    println("Понравилось $likes $word")
}