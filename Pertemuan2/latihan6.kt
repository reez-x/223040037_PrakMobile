fun main() {

    print("Masukkan nilai: ")
    val nilai = readLine()!!.toInt()

    val indexNilai = when {
        nilai in 80..100 -> "A"
        nilai in 70..79 -> "B"
        nilai in 60..69 -> "C"
        nilai in 50..59 -> "D"
        nilai < 50 -> "E"
        else -> "Nilai tidak valid"
    }

    println("Indeks nilai: $indexNilai")
}
