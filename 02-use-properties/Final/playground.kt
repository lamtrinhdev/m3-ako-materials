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
// Constructor properties
class Food(var name: String, var price: String)

class RealFood(val name: String, var price: String)

class BetterFood(
  val name: String,
  var price: String,
  var kind: String = "Vegetable"
)

fun main() {
  // with named arguments
  val oneTomato = Food(
    name = "Tomato",
    price = "2.0"
  )
  // without named arguments
  val twoTomato = Food("Tomato", "3.0")

  println(twoTomato.name) // "Tomato"
  println(twoTomato.price) // "3.0"

  oneTomato.name = "Fresh Tomato"
  println(oneTomato.name) // "Fresh Tomato"

  // create RealFood
  val realTomato = RealFood("Tomato", "2.5")
  // Error: Val cannot be reassigned
  realTomato.name = "Real Tomato"

  // create BetterFood
  val betterFood = BetterFood("Tomato", "4.0")
  // reassign kind
  betterFood.kind = "Fruit"

  // create BetterFood which is Fruit
  val betterFood2 = BetterFood("Tomato", "4.0", "Fruit")
}

// Custom accessors

class Food(
  val name: String,
  var price: String,
  var origin: String) {

  // 1
  val label: String
    get() {
      // 2
      val result = if( origin == "US") {
        "Local $name. Price: \$$price"
      } else {
        "$origin $name. Price: $price"
      }
      // 3
      return result
    }
  // custom setter
  //1
  var country: String
    // 2
    get() = "Country of origin: $origin"
    // 3
    set(value) {
      origin = value
    }  // companion object property
  companion object {
    @JvmStatic val maxDiscount = 0.3
  }
}

fun main() {
  val tomato = Food("Tomato", "2.0", "US")
  println(tomato.label) // Local Tomato. Price: $2.0
  tomato.origin = "UK"
  println(tomato.label) // UK Tomato. Price: 2.0

  tomato.country = "Chile"
  println(tomato.label) // Chile Tomato. Price: 2.0
  println(tomato.country) // Country of origin: Chile

  cucumber = Food("Cucumber", "1.0", "US")

  // Error: Unresolved reference
  // Can't access members of the companion object on an instance
  //println(cucumber.maxDiscount)
  //println(tomato.maxDiscount)
  println(Food.maxDiscount) // 0.3
}

// lateinit
class Shopkeeper

class Shop {
  lateinit var keeper: Shopkeeper
}

fun main() {
  val shop = Shop()
// ... shop has no shopkeeper, need to hire one!

  println(shop.keeper)
// Error: kotlin.UninitializedPropertyAccessException:
// lateinit property keeper has not been initialized

// ... hired someone
  shop.keeper = Shopkeeper()
  println(shop.keeper) // no error
}

// extension properties
class Food(val name: String, val price: String)

fun main() {
  val Food.newPrice: Double
    get() = 0.7 * price
  val pear = Food("Pear", 10)
  println(pear.newPrice) // 7.0
}

