package whyscala

/**
 * It does not extend App
 */
object Fp {
  def reverse(input: String): String = input.reverse
  def reverse2: String ⇒ String = input ⇒ input.reverse
  val reverse3: String ⇒ String = input ⇒ input.reverse

  def main(args: Array[String]): Unit = {
    val input = "Monoid"

    println("All reverse functions are doing the same thing.")
    println(reverse(input).equals(reverse2(input)) && reverse2(input) == reverse3(input))

    println("Try function composition:")

    println((reverse _ compose reverse3)(input))

    println("Sorted and reverse")
    println((reverse3 compose sort)(input))
  }

  def sort(i: String): String = i.toSeq.sorted.mkString
}
