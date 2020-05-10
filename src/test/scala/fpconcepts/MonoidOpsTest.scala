package fpconcepts


import fpconcepts.MonoidOps.{intMonoid, productMonoid, stringMonoid}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MonoidOpsTest extends AnyWordSpec with Matchers {

  "Monoid Operations" should {
    "handle string operations" in {
      val words = List("Bear", "", "Fox", "Horse", "Turtle", stringMonoid.empty)
      val concatenatedWords = words.foldRight(stringMonoid.empty)(stringMonoid.operation)

      concatenatedWords shouldBe "BearFoxHorseTurtle"

      List.empty
        .foldRight(stringMonoid.empty)(stringMonoid.operation) shouldBe ""
    }

    "handle integer operations" in {
      val integers = List(5, 4, 0, 3, 2, 1)
      val sum = integers.foldRight(intMonoid.empty)(intMonoid.operation)
      sum shouldBe 15

      List.empty[Int]
        .foldRight(intMonoid.empty)(intMonoid.operation) shouldBe 0
    }

    "compose multiple monoids" in {
      val tuples: List[(String, Int)] = List(("Scala", 1), ("Java", 2), ("Python", 3))
      val tuplesMonoid = productMonoid(stringMonoid, intMonoid)

      val (words, ints) = tuples.foldLeft(tuplesMonoid.empty)(tuplesMonoid.operation)
      words shouldBe "ScalaJavaPython"
      ints shouldBe 6
    }
  }
}
