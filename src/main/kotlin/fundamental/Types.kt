package fundamental

fun main() {
    var number: Byte = 127
    val counts: Long = 3_123_123_123  //explicit types is redundant
    val countsImpl = 3_123_123_123 //similar like counts
    val price: Float = 10.16F
    val letter: Char = 'A'
    val isOkay: Boolean = true

    val numberExt = number
    number = 100 //not updated cause its primitive type

    if (isOkay)
        println("Number: $numberExt and Character: $letter")
    else
        print("Counts: $counts and Price: $price")


}