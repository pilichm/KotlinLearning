/*
* PART I
* Create class, SimpleSpice.
* Let the class be a property with a String for the name of the spice, and a String for the level of spiciness.
* Set the name to curry and the spiciness to mild.
* Using a string for spiciness is nice for users, but not useful for calculations. Add a heat property to your class
* with a getter that returns a numeric value for spiciness. Use a value of 5 for mild.
* Create an instance of SimpleSpice and print out its name and heat.
* */
sealed class SimpleSpice {
    val spiceName: String = "curry"
    val spiciness: String = "mild"
    val heat: Int
        get():Int {
            return when (spiciness) {
                "mild" -> 5
                else -> 1
            }
        }
}

/*
* PART II
* Create a new class, Spice.
* Pass in a mandatory String argument for the name, and a String argument for the level of spiciness where the default
* value is mild for not spicy.
* Add a variable, heat, to your class, with a getter that returns a numeric value for each type of spiciness.
* Instead of the list of spices as Strings you used earlier, create a list of Spice objects and give each object a name
* and a spiciness level.
* Add an init block that prints out the values for the object after it has been created. Create a spice.
* Create a list of spices that are spicy or less than spicy. Hint: Use a filter and the heat property.
* Because salt is a very common spice, create a helper function called makeSalt().
* */
class Spice2(val name: String, val spiciness: String = "mild") {
    val heat: Int
        get():Int {
            return when (spiciness) {
                "weak" -> 1
                "mild" -> 5
                "hot" -> 10
                "very hot" -> 15
                else -> 0
            }
        }

    init {
        println(this.toString())
    }

    companion object {
        fun makeSalt(): Spice2 {
            return Spice2("salt", "no spiciness")
        }
    }

    override fun toString(): String ="name: $name\nspiciness: $spiciness\nheat: $heat"
}

/*
* PART III
* Create a class, Book, with a title and an author.
* Add a method, readPage(), that increases the value of a private variable, currentPage, by 1.
* Create a subclass of Book; name it eBook.
* eBook also takes in a format, which defaults to "text".In eBooks, counting words makes more sense than pages. Override
* the readPage() method to increase the word count by 250, the average number of words per page from typewriter days.
* */
open class Book(val title:String, val author:String) {
    private var currentPage:Int = 0

    open fun readPage(){
        currentPage += 1
    }
}

class eBook(title:String, author:String, val format:String = "text"): Book(title, author) {
    private var wordCount:Int = 0

    override fun readPage() {
        wordCount += 250
    }
}

/*
* PART IV
* Make Spice abstract.
* Create a subclass, Curry. Curry can have varying levels of spiciness, so we don't want to use the default value,
* but rather pass in the spiciness value.
* Spices are processed in different ways before they can be used. Add an abstract method prepareSpice to Spice,
* and implement it in Curry.
* Curry is ground into a powder, so let's call a method grind(). However, grinding is something that's not unique to
* curry, or even to spices, and it's always done in a grinder. So we can create an Interface, Grinder, that implements
* the grind() method. Do that now.
* Then add the Grinder interface to the Curry class.
* Create an interface, SpiceColor, that has a color property. You can use a String for the color.
* Create a singleton subclass, YellowSpiceColor, using the object keyword, because all instances of Curry and other
* spices can use the same YellowSpiceColor instance.
* Add a color property to Curry of type SpiceColor, and set the default value to YellowSpiceColor.
* Add SpiceColor as an interface, and let it be by color.
* Create an instance of Curry, and print its color. However, color is actually a property common to all spices, so
* you can move it to the parent class.
* Change your code so that the SpiceColor interface is added to the Spice class and inherited by Curry.
* */
abstract class Spice3(val name: String, val spiciness: String = "mild") {
    val color: SpiceColor = YellowSpiceColor

    val heat: Int
        get():Int {
            return when (spiciness) {
                "weak" -> 1
                "mild" -> 5
                "hot" -> 10
                "very hot" -> 15
                else -> 0
            }
        }

    init {
        println(this.toString())
    }

    companion object {
        fun makeSalt(): Spice2 {
            return Spice2("salt", "no spiciness")
        }
    }

    abstract fun prepareSpice()

    override fun toString(): String ="name: $name\nspiciness: $spiciness\nheat: $heat"
}

class Curry(name: String, spiciness: String = "mild"): Spice3(name, spiciness), Grinder {
    override fun prepareSpice() {
        println("Preparing curry.")
    }

    override fun grind() {
        println("Grinding curry.")
    }
}

interface SpiceColor {
    val color:Color
}

object YellowSpiceColor: SpiceColor {
    override val color: Color
        get() = Color.YELLOW

}

interface Grinder {
    fun grind()
}

/*
* PART V
* Create a simple data class, SpiceContainer, that holds one spice.
* Give SpiceContainer a property, label, that is derived from the name of the spice.
* Create some containers with spices and print out their labels.
* */
data class SpiceContainer(val spice: Spice2) {
    val label = spice.name
}

/*
* PART VI
* In SpiceColor, change the type of color from String to the Color class, and set the appropriate
* color in YellowSpiceColor.
* Make Spice a sealed class.
*  */
enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00);
}

fun main() {
    println("main() - start.")

    /* PART I */
//    val spice = SimpleSpice()
//    println("Created spice with name: ${spice.spiceName} and heat: ${spice.heat}")

    /* PART II */
//    val spices = listOf<Spice2>(
//        Spice2("curry", "mild"),
//        Spice2("pepper", "hot"),
//        Spice2("cayenne", "mild"),
//        Spice2("ginger", "weak"),
//        Spice2("red curry", "hot"),
//        Spice2("green curry", "mild"),
//        Spice2("red pepper", "very hot")
//    )
//
//    val spicyLessThanSpicy = spices.filter { it.heat < 10 }
//
//    println("Spicy less than spicy: ${spicyLessThanSpicy}")
//    println("Created salt ${Spice2.makeSalt()}")

    /* PART V */
//    val spiceCont1 = SpiceContainer(Spice2("cayenne", "mild"))
//    val spiceCont2 = SpiceContainer(Spice2("red pepper", "very hot"))
//    val spiceCont3 = SpiceContainer(Spice2("green curry", "mild"))
//
//    print(spiceCont1.label)
//    print(spiceCont2.label)
//    print(spiceCont3.label)
}