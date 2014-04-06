package top

import scala.concurrent.Await
import scala.concurrent.duration.DurationDouble
import utils.Specification
import utils.Config.executionContext

class MixedTest extends Specification {

  val timeout = 30.seconds

  "nonBlocking with async" in {

    val resultNonBlockingF = Squares.nonBlocking(1 to 20)
    println("===============nonBlocking call returned================")
    resultNonBlockingF.onComplete(x => println("non blocking result", x))

    val resultAsyncF = Squares.async(1 to 20)
    println("===============async call returned================")
    resultAsyncF.onComplete(x => println("async result", x))

    Await.ready(resultNonBlockingF, timeout)
    Await.ready(resultAsyncF, timeout)
    1 mustEqual 1
  }

}
