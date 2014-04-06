package library

import play.api.libs.iteratee.{Enumeratee, Iteratee, Enumerator}
import scala.util.{Failure, Success}
import rx.lang.scala.{Subscription, Observer, Observable}
import utils.Config.executionContext

object EnumeratorImplicits {

  implicit class RichEnumerator[T](val enumerator: Enumerator[T]) {

    def toObservable = Observable { observer: Observer[T] =>
      var cancelled = false

      val breakIfCancelled = Enumeratee.breakE[T](_ => cancelled)
      val cancellableEnum = enumerator.through(breakIfCancelled)
      val observerIteratee = Iteratee.foreach(observer.onNext)

      cancellableEnum(observerIteratee).onComplete {
        case Success(_) => observer.onCompleted()
        case Failure(e) => observer.onError(e)
      }

      new Subscription { override def unsubscribe() = { cancelled = true } }
    }
  }
}
