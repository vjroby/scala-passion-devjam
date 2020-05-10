package fpconcepts


trait Monad[M[_]] extends Functor[M] {
  /**
   * @return a type T monad
   */
  def unit[T](t: ⇒ T): M[T]

  /**
   * Transforms a monad to a new monad
   *
   * @param mt monad with type parameter T
   * @param f  function that will create a R Monad from T
   * @tparam T input type
   * @tparam R output type
   */
  def flatMap[T, R](mt: M[T])(f: T ⇒ M[R]): M[R]

  override def map[T, R](ft: M[T])(f: T ⇒ R): M[R] = ???

  // extra method
  def sequence[T](listMonad: List[M[T]]): M[List[T]] = ???
}

sealed trait Maybe[+T]

final case class Just[+T](v: T) extends Maybe[T]

object NotADickyBird extends Maybe[Nothing]


object MonadOps {
  val maybeMonad: Monad[Maybe] = ???
}
