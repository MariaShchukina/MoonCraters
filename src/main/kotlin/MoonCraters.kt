import java.io.BufferedReader
import java.io.File
import java.io.FileReader

var COUNTOFCRATERS = 0


fun main() {
    val table: Array<Array<Int>> = Array(4, { Array(6, {0}) })
    table[0] = arrayOf(1, 0, 1, 0, 0, 0)
    table[1] = arrayOf(0, 0, 1, 0, 0, 1)
    table[2] = arrayOf(0, 0, 0, 0, 1, 1)
    table[3] = arrayOf(0, 0, 0, 0, 1, 1)
    calculate(table)
    println(COUNTOFCRATERS)


}

fun calculate(table: Array<Array<Int>>) {
    for (row in (0..table[0].size)) {
        for (column in (0..table.size)) {
            if (checking(table, row, column)) {
                COUNTOFCRATERS += 1
            }
        }
    }
}

fun checking(map: Array<Array<Int>>, row: Int, column: Int): Boolean {
    var rowSize = map[0].size
    var columSize = map.size

    var row = row
    var column = column

    if (row == -1 || column == -1 || rowSize == map[0].size + 1 || columSize == map.size + 1) {
        return false
    }


    if (map[row][column] == 1) {
        map[row][column] = 0
        checking(map, row + 1, column)
        checking(map, row, column + 1)
        checking(map, row - 1, column)
        checking(map, row, column - 1)
    } else {
        return false
    }
    return true
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