package top

import scala.concurrent.Future
import rx.lang.scala.Observable
import utils.Config.executionContext

object Squares {

  def blocking(numbers: Seq[Int]): Seq[Int] = {
    val squares = numbers.map(n => Square.blocking(n))

    squares
  }

  def async(numbers: Seq[Int]): Future[Seq[Int]] = {
    val futures = numbers.map(n => Square.async(n))

    Future.sequence(futures)
  }

  def nonBlocking(numbers: Seq[Int]): Future[Seq[Int]] = {
    val futures = numbers.map(n => Square.nonBlocking(n))

    Future.sequence(futures)
  }

  def streaming(numbers: Seq[Int]): Observable[Int] = {
    val observables = numbers.map(n => Square.streaming(n))

    Observable.from(observables).concat
  }
}
