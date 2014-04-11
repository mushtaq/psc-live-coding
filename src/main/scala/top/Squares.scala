package top

import scala.concurrent.Future
import rx.lang.scala.Observable
import utils.Config.executionContext

object Squares {

  def blocking(numbers: Seq[Int]): Seq[Int] = {

    ???
  }

  def async(numbers: Seq[Int]): Future[Seq[Int]] = {

    ???
  }

  def nonBlocking(numbers: Seq[Int]): Future[Seq[Int]] = {

    ???
  }

  def streaming(numbers: Seq[Int]): Observable[Int] = {

    ???
  }
}
