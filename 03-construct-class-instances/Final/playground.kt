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
class Food {
  val name: String
  var price: String = "1.0".also {
    println("Setting the price to $it")
  }
  var origin: String = "US"

  constructor(name: String) {
    this.name = name
  }

  constructor(name: String, price: String) : this(name) {
    println("Secondary constructor used")
    this.price = price
  }

  init {
    println("Init block in action")
    origin = "UK"
  }
}

object Box {
  var size: String = "0"
  val type = "Cardboard"
}

fun main() {
  // one-argument secondary constructor
  var tomato = Food("Tomato")
  println(tomato.name) // Tomato
  println(tomato.price) // 1.0
  println(tomato.origin) // US

  // two-argument secondary constructor
  val tomato2 = Food("Tomato", "2.0") // Secondary constructor used
  println(tomato2.name) // Tomato
  println(tomato2.price) // 2.0
  println(tomato2.origin) // US

  // init block
  tomato = Food("Tomato", "2.0")
  // Setting the price to 1.0
  // Init block in action
  // Secondary constructor used
  println(tomato.name) // Tomato
  println(tomato.price) // 2.0
  println(tomato.origin) // UK
}
