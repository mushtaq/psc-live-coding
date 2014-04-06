package top

import scala.concurrent.Await
import scala.concurrent.duration.DurationDouble
import utils.Specification
import rx.lang.scala.Observable
import rx.lang.scala.Notification.OnError

class SquaresTest extends Specification {

  val timeout = 20.seconds

  "blocking" in {
    val result = Squares.blocking(1 to 10)

    println("===============call returned================")

    println(result)

    result.sum mustEqual 385
  }


  "async" in {
    val resultF = Squares.async(1 to 20)

    println("===============call returned================")

    val result = Await.result(resultF, timeout)

    println(result)

    result.sum mustEqual 2870
  }


  "nonBlocking" in {
    val resultF = Squares.nonBlocking(1 to 20)

    println("===============call returned================")

    val result = Await.result(resultF, timeout)

    println(result)

    result.sum mustEqual 2870
  }

  "streaming" in {
    val resultO = Squares
      .streaming(1 to 20)

    println("===============call returned================")

    val result = resultO.toBlockingObservable.toList

    println(result)

    result.sum mustEqual resultO.sum.toBlockingObservable.single
  }
}
