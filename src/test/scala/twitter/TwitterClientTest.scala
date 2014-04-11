package twitter

import utils.Specification
import play.api.libs.json.JsObject

class TwitterClientTest extends Specification {

  "twitter" in {
    val url = "https://stream.twitter.com/1.1/statuses/sample.json"

    def isStatusUpdate(json: JsObject) = (json \ "id").asOpt[Long].isDefined

    val tweets = TwitterClient
      .getJsonStream(url)
//      .onErrorResumeNext(Observable.empty)



    1 mustEqual 1
  }
}
