package fpconcepts.orders

import cats.effect.IO

trait OrderRepository[F[_]] {
  def orders: F[List[Order]]
}

case class OrderInMemoryRepo(ordersList: List[Order]) extends OrderRepository[IO] {

  override def orders: IO[List[Order]] = IO {
    ordersList
  }
}
