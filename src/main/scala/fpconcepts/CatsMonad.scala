package fpconcepts

import cats.effect._
import cats.implicits._
import fpconcepts.orders.{Order, OrderInMemoryRepo}
import fpconcepts.products.{Product, ProductInMemoryRepo}

import scala.concurrent.duration._

case class MyError(message: String) extends Throwable

case class OrderProducts(order: Order, products: List[Product])

object CatsMonad extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = program.timeout(5.seconds)
    .as((ExitCode.Success))

  def program: IO[List[OrderProducts]] = {
    val products = (1 to 10).map(i ⇒ Product(i, s"Name for $i", i.toDouble * 10)).toList
    val orders = List(Order(1, "2020-03-04", List(1, 2, 3)), Order(2, "2020-04-14", List(5, 9, 4, 2)))

    val ordersRepo = OrderInMemoryRepo(orders)
    val productsRepo = ProductInMemoryRepo(products)

    // rewrite to for comprehension
    for {
      orders ← ordersRepo.orders
      orderProducts ← retrieveProducts(orders, productsRepo)
      _ ← printOutput(orderProducts)
    } yield orderProducts
  }

  private def retrieveProducts(orders: List[Order], productsRepo: ProductInMemoryRepo): IO[List[OrderProducts]] = {
    orders.map(o ⇒ {
      productsRepo.productsByIds(o.products)
        .map(lp ⇒ OrderProducts(o, lp))
    })
      .sequence
  }

  def printOutput(output: List[OrderProducts]): IO[Unit] = IO {
    println("I'm done!")
    output.foreach(println)
  }
}
