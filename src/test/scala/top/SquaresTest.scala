package top

import scala.concurrent.Await
import scala.concurrent.duration.DurationDouble
import utils.Specification
import utils.Config.executionContext

class SquaresTest extends Specification {

  val timeout = 30.seconds

  "blocking" in {

    1 mustEqual 1
  }


  "async" in {

    1 mustEqual 1
  }


  "nonBlocking" in {


    1 mustEqual 1
  }

  "streaming" in {

    1 mustEqual 1
  }
}
