class PersegiPanjang(val panjang: Int, val lebar: Int) {
    val luas: Int
        get() = panjang * lebar

    val keliling: Int
        get() = 2 * (panjang + lebar)
}

fun main(args: Array<String>) {
    if (args.size < 2) {
        println("Program membutuhkan 2 argumen: panjang dan lebar")
        return
    }

    val panjang = args[0].toInt()
    val lebar = args[1].toInt()

    val persegi = PersegiPanjang(panjang, lebar)

    println("Panjang: $panjang")
    println("Lebar: $lebar")
    println("Luas: ${persegi.luas}")
    println("Keliling: ${persegi.keliling}")
}