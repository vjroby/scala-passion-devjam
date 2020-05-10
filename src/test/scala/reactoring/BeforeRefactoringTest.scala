package reactoring

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class BeforeRefactoringTest extends AnyWordSpec with Matchers {
  "uniqueLists " should {
    "return unique elements across lists in a set and keep the largest" in {
      val input = Set(List(1, 2, 3), List(2, 3, 4, 5, 6), List(1, 2, 3), List(9, 9, 9))

      val resultsBefore = BeforeRefactoring.uniqueLists(input)
      val resultsAfter = AfterRefactoring.unique(input)

      resultsBefore shouldBe Set(List(2, 3, 4, 5, 6), List(9, 9, 9))
      resultsAfter shouldBe resultsBefore
    }

    "toEvenSet" should {
      "return even lists of lucky numbers and keep the order" in {
        val input = List(13, 45, 7, 8, 10)

        val resultsBefore = BeforeRefactoring.toEvenSet(input)
        val resultsAfter = AfterRefactoring.toEvenSet(input)

        resultsBefore shouldBe Set(List(45, 7, 8, 10), List(8, 10))
        resultsAfter shouldBe resultsBefore
      }
    }
  }
}
