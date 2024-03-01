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

// Classes & Instances
class Food(val name: String, val price: String) {
  val item1
    get() = "$name $price"
}
fun main() {
  val fruit = Food(name = "Tomato", price = "0.20")
  println(fruit.item1) // > Tomato 0.20
}

// Working with References

class Food(val name: String) {
  val title
    get() = "$name"
}

fun main() {
  val tomato = Food(name = "Supreme Tomato")
  var fridgeLeader = tomato

  println(tomato.title)      // > Supreme Tomato
  println(fridgeLeader.title) // > Supreme Tomato
}

// Class Instance Identity
import java.util.*
class Food(val name: String) {
  val title
    get() = "$name"
}

fun main() {
  val tomato = Food(name = "Supreme Tomato")
  var fridgeLeader = tomato

  println(fridgeLeader === tomato) // > true

  val imposterTomato = Food(name = "Evil Tomato")

  println(tomato === fridgeLeader) // true
  println(tomato === imposterTomato) // false
  println(imposterTomato === fridgeLeader) // false

  fridgeLeader = imposterTomato
  println(tomato === fridgeLeader) // false

  fridgeLeader = tomato
  println(tomato === fridgeLeader) // true

  // Create fake, imposter Tomatoes
  var imposters = (0..100).map {
    Food(name = "Evil Tomato")
  }

  // Equality (==) is not effective when Supreme Tomato cannot be identified by his name alone
  val containsSupremeTomato = imposters.map {
    it.name == "Supreme Tomato"
  }.contains(true)
  println(containsSupremeTomato)// true

  // Check to ensure the real Supreme Tomato is not found among the imposters.
  println(imposters.contains(tomato)) // > false

// Now hide the "real" Tomato somewhere among the imposters.
  val mutableImposters = mutableListOf<Food>()
  mutableImposters.addAll(imposters)
  mutableImposters.contains(tomato) // false
  mutableImposters.add(Random().nextInt(5), tomato)

// our Supreme Tomato can now be found among the imposters.
  println(mutableImposters.contains(tomato)) // > true

}
