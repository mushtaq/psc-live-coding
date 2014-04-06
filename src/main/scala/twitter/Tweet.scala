package twitter

import play.api.libs.json.JsObject

case class Tweet(id: Long, text: String, name: String, lang: String)

object Tweet {
  def make(json: JsObject) = new Tweet(
    id = (json \ "id").as[Long],
    text = (json \ "text").as[String],
    name = (json \ "user" \ "screen_name").as[String],
    lang = (json \ "user" \ "lang").as[String]
  )
}
