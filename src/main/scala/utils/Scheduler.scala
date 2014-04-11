package utils

import scala.concurrent.duration.Duration
import scala.concurrent.{Future, Promise}
import scala.util.Try
import rx.lang.scala.Observable
import utils.Config.executionContext

object Scheduler {

  def asFuture[T](delay: Duration)(block: =>T): Future[T] = {







    ???
  }

  def asObservable[T](delay: Duration)(block: =>T): Observable[T] = {



    ???
  }

}
