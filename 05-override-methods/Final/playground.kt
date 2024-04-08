/*
 * Copyright (c) 2024 Kodeco LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

open class Food(
  val name: String,
  var price: String,
  var origin: String
) {

  open fun label(): String {
    return "$name of $origin. Price: $price"
  }
}

class Fruit(
  name: String,
  price: String,
  origin: String,
  val stone: Boolean = false
) : Food(name, price, origin) {
  fun hasStone(): Boolean {
    return stone
  }

  override fun label(): String {
    val stonedLabel = if (hasStone()) "Stoned " else ""
    return "${stonedLabel}Fruit ${super.label()}"
  }
}

fun main() {
  val tomato = Food("Tomato", "1.0", "US")
  val tomato2 = Fruit("Tomato", "1.0", "US")

  println(tomato.label()) // Tomato of US. Price: 1.0
  println(tomato2.label()) // Fruit Tomato of US. Price: 1.0

  val peach = Fruit("Peach", "2.0", "Chile", true)
  println(peach.label()) // Stoned Fruit Peach of Chile. Price: 2.0

}
// Benefits

//Flexibility and Extensibility
open class Fruit {
  open fun describeColor() {
    println("Fruits can be of various colors.")
  }
}

class Peach : Fruit() {
  override fun describeColor() {
    println("A peach is usually pinkish or yellowish.")
  }
}

class Plum : Fruit() {
  override fun describeColor() {
    println("A plum is usually purple or reddish.")
  }
}

fun main() {
  val myFruit: Fruit = Fruit()
  val myPeach: Fruit = Peach()
  val myPlum: Fruit = Plum()

  myFruit.describeColor() // Fruits can be of various colors.
  myPeach.describeColor() // A peach is usually pinkish or yellowish.
  myPlum.describeColor() // A plum is usually purple or reddish.
}

// Polymorphism


// Override constructor

open class Team(open val name: String)

class LocalTeam(nameParam: String, val isLocal: Boolean): Team(nameParam) {
  // Override the name property during initialization
  override val name = nameParam.toUpperCase()

  fun secretName(): String {
    return super.name
  }
}

fun main() {
  val team=LocalTeam("Tigers", false)
  println(team.name) // TIGERS
  println(team.secretName()) // Tigers
}


// Overriding equals and hashcode
open class Food(
  val name: String,
  var price: String,
  var origin: String
) {

  open fun label(): String {
    return "$name of $origin. Price: $price"
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is Food) return false
    return name == other.name
  }

  override fun hashCode(): Int {
    return 1 + price.hashCode()
  }

}

class Fruit(
  name: String,
  price: String,
  origin: String,
  val stone: Boolean = false
) : Food(name, price, origin) {
  fun hasStone(): Boolean {
    return stone
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is Fruit) return false
    return name == other.name && stone == other.stone
  }

}

fun main() {
  val tomato = Food("Tomato", "1.0", "US")
  val stonedtomato = Fruit("Tomato", "1.0", "US", true)

  println(tomato.equals(stonedtomato)) // true
  println(stonedtomato.equals(tomato)) // false
}

// overriding
fun main() {
  val tomato = Food("Tomato", "1.0")
  val cucumber = Food("Tomato", "2.0")
  //1
  val foods = mutableSetOf<Food>()
  foods.add(tomato)
  //2
  println(cucumber in foods) // false
  //3
  println(cucumber == foods.first()) // true
  //4
  println(tomato == cucumber) // true
}
