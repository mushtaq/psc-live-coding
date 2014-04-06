package top

import scala.concurrent.Await
import scala.concurrent.duration.DurationDouble
import utils.Specification
import utils.Config.executionContext

class SquaresTest extends Specification {

  val timeout = 30.seconds

  "blocking" in {
    val result = Squares.blocking(1 to 10)
    println("===============call returned================")
    println(result)

    1 mustEqual 1
  }


  "async" in {
    val resultF = Squares.async(1 to 20)
    println("===============call returned================")
    resultF.onComplete(println)

    Await.ready(resultF, timeout)
    1 mustEqual 1
  }


  "nonBlocking" in {
    val resultF = Squares.nonBlocking(1 to 20)
    println("===============call returned================")
    resultF.onComplete(println)

    Await.ready(resultF, timeout)
    1 mustEqual 1
  }

  "streaming" in {
    val resultO = Squares.streaming(1 to 20)
    println("===============call returned================")
    resultO.buffer(timeout).subscribe(x => println(x))

    resultO.toBlockingObservable.toList
    1 mustEqual 1
  }
}
