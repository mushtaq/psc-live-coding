package top

import scala.concurrent.Await
import scala.concurrent.duration.DurationDouble
import utils.Specification
import utils.Config.executionContext

class MixedTest extends Specification {

  val timeout = 30.seconds

  "nonBlocking with async" in {






    1 mustEqual 1
  }

}
