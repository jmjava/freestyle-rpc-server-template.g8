lazy val root = project
  .in(file("."))
  .settings(name := "$project$")
  .settings(moduleName := "root")
  .settings(noPublishSettings: _*)
  .settings(scalaMetaSettings: _*)
  .settings(libraryDependencies ++= commonDeps ++ freestyleCoreDeps())
  .settings(libraryDependencies += "io.frees" %% "frees-rpc-server" % "0.14.0")
  .settings(libraryDependencies += "io.frees" %% "frees-rpc-config" % "0.14.0")
  .settings(libraryDependencies += "io.frees" %% "frees-rpc-prometheus-server" % "0.14.0")
  .settings(libraryDependencies += "io.frees" %% "frees-rpc-dropwizard-server" % "0.14.0")
  .settings(libraryDependencies += "io.frees" %% "frees-rpc-netty-ssl" % "0.14.0")
  .dependsOn(coreJVM)
  .aggregate(coreJS, coreJVM)

lazy val core = crossProject
  .in(file("core"))
  .settings(moduleName := "$project$")
  .settings(scalaMetaSettings: _*)
  .crossDepSettings(commonDeps ++ freestyleCoreDeps(): _*)
  .settings(libraryDependencies += "io.frees" %% "frees-rpc-server" % "0.14.0")
  .settings(libraryDependencies += "io.frees" %% "frees-rpc-config" % "0.14.0")
  .settings(libraryDependencies += "io.frees" %% "frees-rpc-prometheus-server" % "0.14.0")
  .settings(libraryDependencies += "io.frees" %% "frees-rpc-dropwizard-server" % "0.14.0")
  .settings(libraryDependencies += "io.frees" %% "frees-rpc-netty-ssl" % "0.14.0")
  .jsSettings(sharedJsSettings: _*)


lazy val coreJVM = core.jvm
lazy val coreJS = core.js
