package com.github.scalajs

import java.util.{ Timer, TimerTask }
import java.util.concurrent.TimeUnit

import scala.collection.JavaConverters._
import scala.concurrent.duration._
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest._
import org.scalatest.time._

trait Spec extends FlatSpec
    with Matchers
    with OptionValues
    with Inside
    with Retries
    with TryValues
    with Inspectors
    with TypeCheckedTripleEquals
    with BeforeAndAfterAll { self =>

}