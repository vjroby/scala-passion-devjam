package fpconcepts

import fpconcepts.FunctorOps.listFunctor
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class FunctorOpsTest extends AnyWordSpec with Matchers {
  "Functor Operations" should {
    "map over lists of string and create tuples" in {
      val words = List("PHP", "Python", "Java", "Scala")

      val wordsAndStringLength = listFunctor.map[String, (String, Int)](words)(s ⇒ (s, s.length))

      wordsAndStringLength shouldBe List(("PHP", 3), ("Python", 6), ("Java", 4), ("Scala", 5))
    }

    "obey the law:  map(ft)(f: T ⇒ T) == ft" in {
      val words = List("PHP", "Python", "Java", "Scala")

      val result = listFunctor.map(words)(s ⇒ s)

      result shouldBe words
    }
  }
}