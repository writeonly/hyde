package pl.writeonly.linkchecker.scala.common.url.urls

import pl.writeonly.linkchecker.scala.common.url.Domain
import pl.writeonly.linkchecker.scala.common.url.typed.InternalUrls

final case class UrlsWithThrowableList(urls: Urls, throwableList: ThrowableList) {

  def next(newUrls: NewUrls, newThrowableList: ThrowableList): UrlsWithThrowableList =
    new UrlsWithThrowableList(urls.next(newUrls), throwableList ++ newThrowableList)

  def showStep(): Unit = {
    urls.showStep()
    Urls.showPartThrowableList(details = true, "throwableList", throwableList)
  }

  def showResult(): Unit = {
    urls.showResult()
    Urls.showPartThrowableList(details = true, "throwableList", throwableList)
  }

  def isEmptyNextInternalUrls: Boolean = urls.isEmptyNextInternalUrls

  def nextUrls: InternalUrls = urls.nextInternalUrls
}

object UrlsWithThrowableList {
  def fromDomain(implicit d: Domain): UrlsWithThrowableList =
    new UrlsWithThrowableList(Urls.fromDomain, List.empty)
}
