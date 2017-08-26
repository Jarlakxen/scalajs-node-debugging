// ··· Plugins ···

enablePlugins(ScalaJSPlugin)

// ··· Project Info ···

name := "scalajs-debugging"

scalaVersion := "2.12.2"

// ··· Project Options ···

scalacOptions ++= Seq(
    "-encoding",
    "utf8",
    "-feature",
    "-language:postfixOps",
    "-language:implicitConversions",
    "-language:higherKinds",
    "-unchecked",
    "-deprecation"
)

parallelExecution in Test := false

// ··· Project Dependancies ···

val nodeJsV       = "0.4.0"
val scalatestV    = "3.0.4"

libraryDependencies ++= Seq(
  "io.scalajs"      %%% "nodejs"      % nodeJsV,
  // Testing
  "org.scalatest"   %%% "scalatest"   % scalatestV     % "test"
)

// ··· ScalaJS Settings ···

scalaJSUseMainModuleInitializer := true
scalaJSModuleKind := ModuleKind.CommonJSModule

// Enable Debug in Tests
jsEnv in Test := new org.scalajs.jsenv.nodejs.NodeJSEnv(org.scalajs.jsenv.nodejs.NodeJSEnv.Config().withArgs(List("--inspect-brk")))

