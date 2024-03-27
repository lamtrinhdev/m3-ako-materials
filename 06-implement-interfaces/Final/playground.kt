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

interface Edible {
  val isItReallyEdible: Boolean
  fun taste(): String

  fun consumer(): String {
    return "Human"
  }
}

class Fruit : Edible {
  override val isItReallyEdible = true

  override fun taste(): String {
    return "Sweet"
  }

}

class Mushroom : Edible {
  override val isItReallyEdible = false

  override fun taste(): String {
    return "Delicious"
  }

  override fun consumer(): String {
    return "Pig"
  }
}

fun main() {
  val items = listOf<Edible>(Fruit(), Mushroom())
  items.forEach { item ->
    println("${item.javaClass.simpleName} really edible: ${item.isItReallyEdible}, taste: ${item.taste()}, consumed by ${item.consumer()}")
  }
}

// multiple interfaces

interface Edible {
  fun taste(): String
}

interface Sweet {
  fun andSour(): String
}

class Fruit(val name: String, val sour: Boolean = false) : Edible, Sweet {
  override fun taste(): String {
    return "$name is very good"
  }

  override fun andSour(): String {
    return if(sour)"Maybe" else "Definitely not!"
  }
}

class Garlic : Edible {
  override fun taste(): String {
    return "delicious"
  }
}

fun main() {
  // Error: Type mismatch: inferred type is Garlic but Sweet was expected
  //  val sweetItems = listOf<Sweet>(Fruit("Peach"), Garlic())
  //  sweetItems.forEach { item ->
  //    println( "${item.javaClass.simpleName} sour: ${item.andSour()}")
  //  }

  val items = listOf<Edible>(Fruit("Peach"), Garlic())
  items.forEach { item ->
    println( "${item.javaClass.simpleName} taste: ${item.taste()}")
  }
  //Fruit taste: Peach is very good
  // Garlic taste: delicious

  // Same, but for Sweet
  //  val sweetItems = listOf<Sweet>(Fruit("Peach"), Fruit("Tomato", false))
//  sweetItems.forEach { item ->
//    // Error:
//    // Unresolved reference: name
//    // Unresolved reference: taste
//    println( "${item.name} taste: ${item.taste()}. Sour? ${item.andSour()}")
//  }
//
// Same, but name is not available
  val sweetItems = listOf<Sweet>(Fruit("Peach"), Fruit("Tomato", true))
  sweetItems.forEach { item ->
    println("${item.javaClass.simpleName} is Sweet. Sour? ${item.andSour()}")
  }
//Fruit is Sweet. Sour? Definitely not!
//Fruit is Sweet. Sour? Maybe

// Same, but for Fruit
  val fruitItems = listOf<Fruit>(Fruit("Peach"), Fruit("Tomato", true))
  fruitItems.forEach { item ->
    println( "${item.name} taste: ${item.taste()}. Sour? ${item.andSour()}")
  }
}
//Peach taste: Peach is very good. Sour? Definitely not!
//Tomato taste: Tomato is very good. Sour? Maybe


