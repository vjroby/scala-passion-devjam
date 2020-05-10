package fpconcepts

trait Functor[F[_]] {
  /**
   * Preserves structure F
   *
   * @param ft functor with parameterize type T
   * @param f  function that transform type T to type R
   * @tparam T input type
   * @tparam R output type
   * @return functor with parameterize type R
   */
  def map[T, R](ft: F[T])(f: T ⇒ R): F[R]
}

object FunctorOps {
  val listFunctor: Functor[List] = ???

}
