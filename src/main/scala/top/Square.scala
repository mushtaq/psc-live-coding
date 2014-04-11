package top

import scala.concurrent.Future
import scala.concurrent.duration.DurationInt
import rx.lang.scala.Observable
import utils.Scheduler
import scala.util.Random
import utils.Config.executionContext

object Square {

  def delay: Int = ???

  def square(a: Int): Int = ???

  def blocking(a: Int): Int = {




    ???
  }

  def async(a: Int): Future[Int] = {

    ???
  }

  def nonBlocking(a: Int): Future[Int] = {




      ???
  }

  def streaming(a: Int): Observable[Int] = {




    ???
  }
}
