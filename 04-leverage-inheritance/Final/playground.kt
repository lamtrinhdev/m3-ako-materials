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
// Food and Fruit example
class Food(
  val name: String,
  var price: String,
  var origin: String)

class Fruit(
  val name: String,
  var price: String,
  var origin: String,
  val stone: Boolean
) {
  fun hasStone() {
    return stone
  }
}

// Fruit is a Food example
open class Food(
  val name: String,
  var price: String,
  var origin: String) {

  fun label(): String {
    return "$name of $origin. Price: $price"
  }
}

class Fruit(
  name: String,
  price: String,
  origin: String,
  val stone: Boolean = false
): Food(name, price, origin) {
  fun hasStone(): Boolean {
    return stone
  }
}
fun main() {
  val tomato = Food("Tomato", "1.0", "US")
  val tomato2 = Fruit("Tomato", "1.0", "US")

  println(tomato.label()) //Tomato of US. Price: 1.0
  println(tomato2.label()) //Tomato of US. Price: 1.0

  // Food has no knowledge about stone
  // Error: Unresolved reference: hasStone
  // println(tomato.hasStone())
  println(tomato2.hasStone()) // false
}

// Polymorphism
open class Food(
  val name: String,
  var price: String,
  var origin: String) {

  fun label(): String {
    return "$name of $origin. Price: $price"
  }
}

class Fruit(
  name: String,
  price: String,
  origin: String,
  val stone: Boolean = false
): Food(name, price, origin) {
  fun hasStone(): Boolean {
    return stone
  }
}
class Veg(
  name: String,
  price: String,
  origin: String,
  val rooted: Boolean = false
): Food(name, price, origin) {
  fun isRooted(): Boolean {
    return rooted
  }
}

fun foodLabel(food: Food) : String {
  return "Label: ${food.label()}"
}

fun main() {
  val tomato = Fruit("Tomato", "1.0", "US")
  val carrot = Veg("The Carrot", "2.0", "Canada", true)

  println(foodLabel(tomato)) // Label: Tomato of US. Price: 1.0
  println(foodLabel(carrot)) // Label: The Carrot of Canada. Price: 2.0

  // Runtime hierarchy checks
  val otherTomato: Food =  Fruit("Tomato", "3.0", "UK")
  // Error: Unresolved reference: hasStone
  //otherTomato.hasStone()

}

