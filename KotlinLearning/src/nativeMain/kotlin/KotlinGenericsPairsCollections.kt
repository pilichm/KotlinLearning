import java.util.Random

/* PART I
* Let’s create a basic book class, with a title, author, and year. Of course, you could get
* each of the properties separately.
* Create a method that returns both the title and the author as a Pair.
* Create a method that returns the title, author and year as a Triple. Use the documentation to find out how to use Triple.
* Create a book instance.
* Print out the information about the book in a sentence, such as: “Here is your book X written by Y in Z.”
* */
class Book(private val title:String, private val author:String, private var year:Int){
    fun getTitleAndAuthor(): Pair<String, String> = (title to author)
    fun getTitleAuthorAndYear():Triple<String, String, Int> = Triple(title, author, year)
}

/* PART II
* Create a Set of book titles called allBooks, for example, by William Shakespeare.
* Create a Map called library that associates the set of books, allBooks, to the author.
* Use the collections function any() on library to see if any of the books are “Hamlet’
* Create a MutableMap called moreBooks, and add one title/author to it.
* Use getOrPut() to see whether a title is in the map, and if the title is not in the map, add it.
* */

/*
* PART III
* Create a top-level constant for the maximum number of books a person could borrow.
* Inside the Book class, create a method canBorrow() that returns true or false depending on whether a user
* has already borrowed the max number of books.
* Create a Constants object that provides constants to the book. For this example, provide the BASE_URL for all books
* in the library catalog. Inside Book, add a method printUrl that creates and prints a URL composed of BASE_URL,
* the book title, and “.html”.
* The base URL is really of interest to the Book class. As such, it makes sense to limit its scope to the Book class.
* Use a companion object to define the constant in Book.
*  */
const val maxNumOfBooksPerPerson = 3

class LibraryBook(private val title:String, private val author:String, private var year:Int){
    companion object {
        const val BASE_URL = "https://book.catalog.com.pl/"
    }

    fun getTitleAndAuthor(): Pair<String, String> = (title to author)
    fun getTitleAuthorAndYear():Triple<String, String, Int> = Triple(title, author, year)
    fun canBorrow(numOfBorrowed: Int): Boolean = maxNumOfBooksPerPerson > numOfBorrowed
    fun printUrl() = println("${BASE_URL}$title.html")
}

class Constants {
    companion object {
        const val BASE_URL = "https://book.catalog.com.pl/"
    }
}

/* PART IV
* Add a mutable property pages to Book.
* Create an extension function on Book that returns the weight of a book as the page count multiplied by 1.5 grams.
* Create another extension, tornPages(), that takes the number of torn pages as an argument and changes
* the page count of the book.
* Write a class Puppy with a method playWithBook() that takes a book as an argument, and removes a random number
* of pages from the book.
* Create a puppy and give it a book to play with, until there are no more pages.
* */
class BookWithPages(private val title:String, private val author:String, private var year:Int, public var pages:Int){
    companion object {
        const val BASE_URL = "https://book.catalog.com.pl/"
    }

    fun getTitleAndAuthor(): Pair<String, String> = (title to author)
    fun getTitleAuthorAndYear():Triple<String, String, Int> = Triple(title, author, year)
    fun canBorrow(numOfBorrowed: Int): Boolean = maxNumOfBooksPerPerson > numOfBorrowed
    fun printUrl() = println("${BASE_URL}$title.html")
}

fun BookWithPages.getWeight():Double = this.pages * 1.5

fun BookWithPages.tornPages(numOfPages: Int) {
    this.pages = if (this.pages - numOfPages > 0) this.pages - numOfPages else 0
}

class Puppy() {
    fun playWithBook(book: BookWithPages) {
        book.tornPages(Random().nextInt(book.pages))
    }
}

/* PART V
* Create a class BaseBuildingMaterial with a property numberNeeded that is set to 1. You always need 1 of the base material.
* Create two subclasses, Wood and Brick. For BaseBuildingMaterial you need 4 units of wood or 8 units of brick.
* Now you have a type hierarchy.
* Create a generic class Building that can take any building material as its argument, and only building materials.
* A building always requires 100 base materials. Add a property baseMaterialsNeeded and set it to 100.
* Add another property, actualMaterialsNeeded and use a one-line function to calculate this from numberNeeded of the passed-in material.
* Add a method build() that prints the type and number of materials needed.
* Create a main function and make a building using Wood.
* If you did this correctly, running main() will print something like “400 Wood required”.
* */
open class BaseBuildingMaterial(val numberNeeded:Int = 1)

class Wood(numberNeeded: Int = 4): BaseBuildingMaterial(numberNeeded)

class Brick(numberNeeded: Int = 8): BaseBuildingMaterial(numberNeeded)

class Building(val buildingMaterial: BaseBuildingMaterial) {
    val baseMaterialsNeeded:Int = 100
    val actualMaterialsNeeded:Int = baseMaterialsNeeded*buildingMaterial.numberNeeded
    fun build() = println("Building with material: ${buildingMaterial::class.simpleName} with $actualMaterialsNeeded actual materials.")
}

/* PART VI
* Create a generic function for type BaseBuildingMaterial and call it isSmallBuilding, which takes a Building
* with a building material T as an argument. If the materials needed are less than 500, print "small building",
* otherwise, print "large building".
* */
fun <T: BaseBuildingMaterial> isSmallBuilding(buiding: T): String
        = if (buiding.numberNeeded < 500) "small building" else "large building"

fun main() {
    println("main() - start.")

    /* PART I */
//    val book = Book("Powstanie 44", "Norman Davies", 2012)
//    val bookInfo = book.getTitleAuthorAndYear()
//    println("Here is your book ${bookInfo.first} written by ${bookInfo.second} in ${bookInfo.third}.")

    /* PART II */
//    val henryV = Book("Henry V", "William Shakespeare", 1600)
//    val romeoAndJuliet = Book("Romeo and Juliet", "William Shakespeare", 1597)
//    val macbeth = Book("Macbeth", "William Shakespeare", 1623)
//    val hamlet = Book("Hamlet", "William Shakespeare", 1599)
//
//    val booksByShakespeare = setOf(henryV, romeoAndJuliet, macbeth, hamlet)
//
//    val library = mapOf(("William Shakespeare" to booksByShakespeare))
//    println("Does library contains Hamlet: ${library.any{it.value.contains(hamlet)}}")
//
//    val moreBooks = mutableMapOf(("William Shakespeare" to booksByShakespeare))
//    val powstanie44 = Book("Powstanie 44", "Norman Davies", 2012)
//    moreBooks["Norman Davies"] = setOf(powstanie44)
//
//    moreBooks.getOrPut("Norman Davies") { setOf(powstanie44) }

    /* PART III */
//    val libraryBook = LibraryBook("Henry V", "William Shakespeare", 1600)
//    println("Book catalog url: ${libraryBook.printUrl()}")

    /* PART IV */
//    val bookWithPages = BookWithPages("Henry V", "William Shakespeare", 1600, 256)
//    println("Book weights: ${bookWithPages.getWeight()} g.")
//    println("Number of pages before torining some pages: ${bookWithPages.pages}.")
//    bookWithPages.tornPages(500)
//    println("Number of pages after torning pages: ${bookWithPages.pages}.")
//    val hamletWithPages = BookWithPages("Hamlet", "William Shakespeare", 1599, 111)
//    val puppy = Puppy()
//    puppy.playWithBook(hamletWithPages)
//    println("Number of pages left after puppy playes with it: ${hamletWithPages.pages}")

    /* PART V */
//    val building = Building(Wood()).build()

}