package twitter

import utils.Specification
import play.api.libs.json.JsObject

class TwitterClientTest extends Specification {

  "demo" in {
    val url = "https://stream.twitter.com/1.1/statuses/sample.json"

    def isStatusUpdate(json: JsObject) = (json \ "id").asOpt[Long].isDefined

    val tweets = TwitterClient
      .getJsonStream(url)
      .filter(isStatusUpdate)
      .map(Tweet.make).filter(_.lang == "en")
//      .onErrorResumeNext(Observable.empty)

    tweets.subscribe(tweet => {
      println(tweet)
      println("=" * 80)
    })

    Thread.sleep(15000)

    1 mustEqual 1
  }
}
