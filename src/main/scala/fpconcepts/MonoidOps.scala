package fpconcepts

/**
 *
 * @tparam T type
 */
trait Monoid[T] {
  /**
   * a binary associative operation, takes two values and combines them into one
   */
  def operation(a1: T, a2: T): T

  /**
   * operation(empty, a) == a
   */
  def empty: T
}

object MonoidOps {

  val stringMonoid: Monoid[String] = ???

  val intMonoid: Monoid[Int] = ???

  def productMonoid[A, B](A: Monoid[A], B: Monoid[B]): Monoid[(A, B)] = ???
}
