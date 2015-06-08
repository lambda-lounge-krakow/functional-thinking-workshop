package coffee.lambda

/* Problem 1: Closures.
 * Implement an immutable map (dictionary / hash) with String keys and Int values.
 * Don't use any classes, objects or built-in data structures (no Pairs, no Lists etc.).
 * Use just functions, storing all data in closures.
 */

object Ex01Map {
  type Map = Unit // Fill in the type here!

  def emptyMap : Map = ??? // What is an empty map?
  def fetch(map: Map, key: String): Option[Int] = ??? // How to fetch anything?
  def store(map: Map, key: String, value: Int): Map = ??? // And how to store?
}