package utils

import java.util.concurrent.{ScheduledExecutorService, Executors}
import scala.concurrent.{ExecutionContextExecutorService, ExecutionContext}

object Config extends Config(numberOfThreads = 4)


class Config(numberOfThreads: Int) {

  val threadPool: ScheduledExecutorService =
    ???

  implicit val executionContext: ExecutionContextExecutorService =
    ???
}
