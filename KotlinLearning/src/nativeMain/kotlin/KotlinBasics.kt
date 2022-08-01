/*
    Looping over arrays and lists is a fundamental technique that has a lot of flexibility in Kotlin. Let's practice.
 */

fun main() {
    // 1. Create an integer array of numbers called numbers, from 11 to 15.
    val numbers = IntArray(5) {it + 11}

    // 2. Create an empty mutable list for Strings.
    val writings = mutableListOf<String>()

    // 3. Write a for loop that loops over the array and adds the string representation of each number to the list.
    for (num in numbers) {
        writings.add(num.toString())
    }

    println("Numbers as strings: $writings")

    // How can you use a for loop to create (a list of) the numbers between 0 and 100 that are divisible by 7?
    val divisibleBySeven = mutableListOf<Int>()
    for (num in 1..100){
        if (num%7==0){
            divisibleBySeven.add(num)
        }
    }

    println("Numbers less than 100 divisible by 7: $divisibleBySeven")
}