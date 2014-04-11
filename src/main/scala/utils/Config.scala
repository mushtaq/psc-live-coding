package utils

import java.util.concurrent.{ScheduledExecutorService, Executors}
import scala.concurrent.{ExecutionContextExecutorService, ExecutionContext}

object Config extends Config(numberOfThreads = 4)

object BlockingConfig extends Config(numberOfThreads = 4)

class Config(numberOfThreads: Int) {

  val threadPool: ScheduledExecutorService =
    Executors.newScheduledThreadPool(numberOfThreads)

  implicit val executionContext: ExecutionContextExecutorService =
    ExecutionContext.fromExecutorService(threadPool)
}
