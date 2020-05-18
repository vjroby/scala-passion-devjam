package fpconcepts.products

import cats.effect.IO


trait ProductRepository[F[_]] {
  def productsByIds(ids: List[Int]): F[List[Product]]
}

case class ProductInMemoryRepo(products: List[Product]) extends ProductRepository[IO] {
  override def productsByIds(ids: List[Int]): IO[List[Product]] = IO.apply {
    products.filter(p ⇒ ids.contains(p.id))
  }
}
