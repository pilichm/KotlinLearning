/*
* PART I
* Create an enum class, Directions, that has the directions NORTH, SOUTH, EAST and WEST, as well as START, and END.
* Create a class Game.
* Inside Game, declare a var, path, that is a mutable list of Direction. Initialize it with one element, START.
* Create 4 lambdas, north, south, east, and west, that add the respective direction to the path.
* Add another lambda, end, that:
* Adds END to path
* Prints “Game Over”
* Prints the path
* Clears the path
* Returns false
* Create a main function.
* Inside main(), create an instance of Game.
* To test your code so far, in main() print the path, then invoke north, east, south, west, and end. Finally, print the path again.
* */
enum class Directions {
    NORTH, SOUTH, EAST, WEST, START, END
}

class Game(){
    var path = mutableListOf<Directions>(Directions.START)
}

val north = {game: Game -> game.path.add(Directions.NORTH)}
val south = {game: Game -> game.path.add(Directions.SOUTH)}
val west = {game: Game -> game.path.add(Directions.WEST)}
val east = {game: Game -> game.path.add(Directions.EAST)}
val end: (game: Game) -> Boolean = {
    it.path.add(Directions.END)
    println("Game Over")
    println(it.path)
    it.path.clear()
    false
}

/*
* PART II
* Create an extension on List using a higher order function that returns all the numbers in the list that
* are divisible by 3. Start by creating an extension function on List that takes an lambda on Int and applies it to
* each item in the list. When the lambda returns zero, include the item in the output. For example, this list:
* */
fun getDivisibleByThree(list: List<Int>, function:Int.() -> Int): List<Int> {
    val divisibleList = mutableListOf<Int>()
    for (element in list) {
        if (function(element)==0){
            divisibleList.add(element)
        }
    }

    return divisibleList.toList()
}

/* PART III
* In the game class, create a function move() that takes an argument called where, which is a lambda with no
* arguments that returns Unit.
* Inside move(), invoke the passed-in lambda.
* In the Game class, create a function makeMove() that takes a nullable String argument and returns nothing.
* Inside makeMove, test whether the String is any of the 4 directions and invoke move() with the corresponding lambda.
* Otherwise, invoke move() with end.
* In main() add a while loop that is always true.
* Inside the loop, print instructions to the player:
* Call makeMove() with the contents of the input from the user via readLine()
* Remove the code for testing the first version of your game.
* Run your program.
* */
val north2 = {game: Game2 -> game.path.add(Directions.NORTH)}
val south2 = {game: Game2 -> game.path.add(Directions.SOUTH)}
val west2 = {game: Game2 -> game.path.add(Directions.WEST)}
val east2 = {game: Game2 -> game.path.add(Directions.EAST)}
val end2: (game: Game2) -> Boolean = {
    it.path.add(Directions.END)
    println("Game Over")
    println(it.path)
    it.path.clear()
    false
}

class Game2(){
    var path = mutableListOf<Directions>(Directions.START)

    fun move(where: () -> Unit) {
        where()
    }

    fun makeMove(direction: String?) {
        when (direction) {
            Directions.NORTH.toString() -> move { north2(this) }
            Directions.SOUTH.toString() -> move { south2(this) }
            Directions.EAST.toString() -> move { east2(this) }
            Directions.WEST.toString() -> move { west2(this) }
            else -> move { end2(this) }
        }
    }
}

fun main() {
    println("main() - start.")

    /* PART I */
//    val game = Game()
//    println(game.path)
//    north(game)
//    south(game)
//    east(game)
//    west(game)
//    end(game)

    /* PART II */
//    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
//    val lambda: (Int) -> Int = { it%3 }
//    println(getDivisibleByThree(numbers, lambda))

    /* PART III */
//    val game2 = Game2()
//    while (true) {
//        print("Enter a direction: n/s/e/w")
//        val direction = readln()
//        game2.makeMove(direction)
//
//        if (!listOf(
//                Directions.NORTH.toString(),
//                Directions.SOUTH.toString(),
//                Directions.WEST.toString(),
//                Directions.EAST.toString()
//        ).contains(direction)) {
//            break
//        }
//    }
}