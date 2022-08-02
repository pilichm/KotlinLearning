import java.util.*
import kotlin.random.Random

/*
* PART I
* Basic Task
* Create a new Kotlin file.
* Copy and paste the main() function from Hello World into the file.
* Create a new function, dayOfWeek().
* In the body of the function, print "What day is it today?"
* Call dayOfWeek() from main().
* Run your program.
* Extended Task
* In the body of the dayOfWeek() function, answer the question by printing the current day of the week.
* */
fun dayOfWeek(){
    println("What day is it today?")
    val dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)

    when (dayOfWeek) {
        0 -> println("It's Sunday")
        1 -> println("It's Monday")
        2 -> println("It's Tuesday")
        3 -> println("It's Wednesday")
        4 -> println("It's Thusday")
        5 -> println("It's Friday")
        6 -> println("It's Saturday")
        else -> println("I don't know :(")
    }
}

/*
* PART II
* From the main() function, call a function, getFortuneCookie(), that returns a String.
* Create a getFortuneCookie() function that takes no arguments and returns a String.
* In the body of getFortuneCookie(), create a list of fortunes.
* Below the list, print: "Enter your birthday: "
* Create a variable, birthday.
* Read the user's input form the standard input and assign it to birthday. If there is no valid input, set birthday to 1.
* Divide the birthday by the number of fortunes, and use the remainder as the index for the fortune to return.
* Return the fortune.
* In main(), print: "Your fortune is: ", followed by the fortune string.
* Extra practice:
* Use a for loop to run the program 10 times, or until the "Take it easy" fortune has been selected.
* */
fun getFortuneCookie(): String {
    val fortunes = listOf<String>(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )

    print("Enter your birthday: ")
    val birthday = readLine()?.toIntOrNull() ?: 1

    return fortunes[birthday/fortunes.size]
}

/*
* PART III
* Use the code you created in the last practice, or copy the starter code from below.
* The getFortune() function should really only be getting the fortune, and not be in the business of getting the birthday.
* Change your Fortune Cookie program as follows:
* Create a function called getBirthday() that gets the birthday from the user.
* Pass the result of getBirthday() to getFortune() using an Integer argument, and use it to return the correct fortune.
* Remove getting the birthday from getFortune()
* Instead of calculating the fortune based on the birthday, use a when statement to assign some fortunes as follows (or use your own conditions):
* If the birthday is 28 or 31...
* If the birthday is in the first week…
* else … return the calculated fortune as before.
* */
fun getFortuneCookie2(dayOfBirth: Int): String {
    val fortunes = listOf<String>(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )

    return when (dayOfBirth) {
        28 -> fortunes[0]
        31 -> fortunes[1]
        else -> fortunes[Random.nextInt(fortunes.size)]
    }
}

fun getBirthday(): Int {
    print("Enter your birthday: ")
    return  readLine()?.toIntOrNull() ?: 1
}

/*
* PART IV
* Create a program that suggests an activity based on various parameters.
* Start in a new file with a main function.
* From main(), create a function, whatShouldIDoToday().
* Let the function have three parameters.
* mood: a required string parameter
* weather: a string parameter that defaults to "sunny"
* temperature: an Integer parameter that defaults to 24 (Celsius).
* Use a when construct to return some activities based on combinations of conditions.
* Copy/paste your finished function into REPL, and call it with combinations of arguments.
* */
fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 25): String{
    return when {
        mood == "happy" && weather == "Sunny" -> "go for a walk"
        else -> "Stay home and read."
    }
}

/*
* PART V
* Improve your whatShouldIDoToday() program with the new knowledge from this segment.
* Add 3 more situations and activities. For example:
* Create a single-expression function for each condition and then use it in your when expression.
* Challenge
* Instead of passing in the mood, get a mood string from the user.
* */
fun condition1() = "go for a walk"
fun condition2() = "stay in bed"
fun condition3() = "go swimming"
fun defaultCondition() = "Stay home and read."

fun whatShouldIDoToday2(weather: String = "sunny", temperature: Int = 25): String{
    print("What os your mood?")
    val mood = readLine()?.toString() ?: "good"

    return when {
        mood == "happy" && weather == "Sunny" -> condition1()
        mood == "sad" && weather == "rainy" && temperature == 0 -> condition2()
        temperature > 35 -> condition3()
        else -> defaultCondition()
    }
}

/*
* PART VI
* This lesson introduced the while and repeat loops. To practice using them, do the following:
* Change your fortune cookie program to use repeat() instead of a for loop. What happens to the break instruction?
* Using the error message from the compiler, with what you've learned so far, can you think of why?
* Change your fortune cookie program to use a while loop, which is the better choice when you are looping until
* a condition is met.
* */

/*
* PART VII
* Create a list of spices, as follows:
* val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
* Create a filter that gets all the curries and sorts them by string length.
* Filter the list of spices to return all the spices that start with 'c' and end in 'e'.
* Take the first three elements of the list and return the ones that start with 'c'.
* */
fun applyFilters(){
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
    println("Spices sorted by len: ${spices.sortedBy { it.length }}")
    println("Spices starting with c and ending with e first version: " +
            "${spices.filter { it.startsWith('c') }.filter { it.endsWith('e') }}")
    println("Spices starting with c and ending with e second version: " +
            "${spices.filter { it[0] == 'c' }.filter { it[it.length-1] == 'e' }}")
    println("First 3 elements if they are starting with c: " +
            "${spices.take(3).filter { it.startsWith('c') }}")
}

/*
* PART VIII
* Create a lambda and assign it to rollDice, which returns a dice roll (number between 1 and 12).
* Extend the lambda to take an argument indicating the number of sides of the dice used for the roll.
* If you haven't done so, fix the lambda to return 0 if the number of sides passed in is 0.
*/
val rollDice = { numOfSides: Int -> if (numOfSides > 0)(1..numOfSides).random() else 0 }

fun main() {

    /* PART I */
//    dayOfWeek()

    /* PART II */
//    for (num in 0..10) {
//        val fortune = getFortuneCookie()
//        println("Your fortune is: $fortune")
//        if (fortune == "Take it easy and enjoy life!") {
//            break
//        }
//    }

    /* PART III */
//    for (num in 0..10) {
//        val fortune = getFortuneCookie2(getBirthday())
//        println("Your fortune is: $fortune")
//        if (fortune == "Take it easy and enjoy life!") {
//            break
//        }
//    }

    /* PART IV */
//    println(whatShouldIDoToday("sad"))

    /* PART V */
//    println(whatShouldIDoToday2())

    /* PART VI */
//    var counter = 0
//    var fortune = getFortuneCookie2(getBirthday())
//    while (counter < 10 && fortune != "Take it easy and enjoy life!") {
//        println("Your fortune is: $fortune")
//        fortune = getFortuneCookie2(getBirthday())
//        counter += 1
//    }

    /* PART VII */
//    applyFilters()

    /* PART VIII */
//    println(rollDice(12))
}