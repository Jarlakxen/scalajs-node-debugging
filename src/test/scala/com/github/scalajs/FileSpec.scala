package com.github.scalajs

import file._

class FileSpec extends Spec {
  
  "File" should "create a tmp file" in {
    File.temp("test").path shouldBe (File.TempDir + "test")
  }
  
}