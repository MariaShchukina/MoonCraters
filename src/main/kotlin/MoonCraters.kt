import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    readFile()
}


fun readFile(): MutableList<MutableList<Int>> {
    val file = File("craters.txt")
    val bufferText = BufferedReader(FileReader(file))
    val arrayOfArray = mutableListOf<MutableList<Int>>()
    var line: String
    while (true) {
        line = bufferText.readLine() ?: break
        val array = mutableListOf<Int>()
        for (element in line) {
            array.add(element.digitToInt())
        }
        arrayOfArray.add(array)
    }
    return arrayOfArray
}