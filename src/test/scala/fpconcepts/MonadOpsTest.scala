package fpconcepts

import fpconcepts.MonadOps.maybeMonad
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MonadOpsTest extends AnyWordSpec with Matchers {
  val divideToMonad: Int ⇒ Maybe[Double] = i ⇒
    if (i == 0) Empty
    else Just(i / 2)

  val divide: Int ⇒ Double = i ⇒ i / 2 // what if is 0

  "Monad Operations" should {
    "flatten and map (flatmap)" in {
      val maybe = maybeMonad.unit(42)

      val result = maybeMonad.flatMap(maybe)(divideToMonad)

      result shouldBe Just(21d)

      maybeMonad.flatMap(maybeMonad.unit(0))(divideToMonad) shouldBe Empty

    }

    "map" in {
      maybeMonad.map(maybeMonad.unit(42))(divide) shouldBe Just(21d)
    }

    "sequence a list of maybe monads, stop if NotADickyBird" in {
//      val monads = List(Just(1), Just(2), Empty, Just(3))
//
//      val result = maybeMonad.sequence(monads)
//
//      result shouldBe Empty
    }

    "sequence a list of maybe monads, discard if NotADickyBird" in {
//      val monads = List(Just(1), Just(2), Empty, Just(3))
//
//      val result = maybeMonad.sequence(monads)
//
//            result shouldBe Just(List(1,2,3))
    }


  }

  "Monads in Scala" should {
    "List" in {
      val r = List(3, 4, 5, 6, 7, 9, 7, 3)
        .map(v ⇒ if (v > 3) Some(v) else None)
        .filter(_.nonEmpty)
        .flatMap(l ⇒ List(l, Some(11))) // flatten and map

      val flat = r.flatten // drops the None elements and pulls out the values from Option container

      r shouldBe List(Some(4), Some(11), Some(5), Some(11), Some(6),
        Some(11), Some(7), Some(11), Some(9), Some(11), Some(7), Some(11))
      flat shouldBe List(4, 11, 5, 11, 6, 11, 7, 11, 9, 11, 7, 11)
    }

    "Option" in {
      val check: String ⇒ Option[Char] = t ⇒ if (t.last == 'g') Some('g') else None
      val charOpt = Some("The quick brown fox jumps over the lazy dog") // Option[String]
        .flatMap(check) // Option[Char]

      val charNone = Some("The quick brown fox jumps over the lazy...")
        .flatMap(check)

      charOpt shouldBe Some('g')
      charNone shouldBe Empty
    }
  }
}
