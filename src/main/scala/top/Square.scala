package top

import scala.concurrent.Future
import scala.concurrent.duration.DurationInt
import rx.lang.scala.Observable
import utils.Scheduler
import utils.Config.executionContext
import scala.util.Random

object Square {

  def delay = Random.nextInt(5000)

  def blocking(a: Int): Int = {
    println(s"begin squaring $a")
    Thread.sleep(delay)
    val result = square(a)
    println(s"END SQUARING $a")
    result
  }

  def async(a: Int): Future[Int] = Future {
    blocking(a)
  }

  def nonBlocking(a: Int): Future[Int] = {
    println(s"begin squaring $a")
    Scheduler.asFuture(delay.millis) {
      val result = square(a)
      println(s"END SQUARING $a")
      result
    }
  }

  def streaming(a: Int): Observable[Int] = {
    println(s"begin squaring $a")
    Scheduler.asObservable(delay.millis) {
      val result = square(a)
      println(s"END SQUARING $a")
      result
    }
  }

  def square(a: Int) = a match {
    case x if x > 12 && x < 18  => throw new RuntimeException(s"can not square $x")
    case x                      => x * x
  }
}
