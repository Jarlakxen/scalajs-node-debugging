package com.github.scalajs

import io.scalajs.nodejs.fs._
import io.scalajs.nodejs.path._
import io.scalajs.nodejs.os._

package object file {

  class File(val path: String, val basename: String) {

    def mkdirs =
      if (!exists) {
        Fs.mkdirSync(path)
      }

    def exists: Boolean = Fs.existsSync(path)

    def readLines(): List[String] =
      readString().split(OS.EOL).toList

    def writeLines(lines: List[String]): Unit = {
      writeString(lines.mkString(OS.EOL))
    }

    def writeString(contents: String): Unit =
      Fs.writeFileSync(path, contents)

    def readString(): String =
      Fs.readFileSync(path, "utf-8")

    override def toString(): String = path
  }

  object File {
    
    val TempDir = s"${OS.tmpdir()}${Path.sep}"

    def temp(name: String): File = {
      val path = Fs.mkdtempSync(s"${TempDir}${name}")
      File(path)
    }

    def apply(path: String): File = new File(path, Path.basename(path))

  }

}