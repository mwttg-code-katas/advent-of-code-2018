name := "advent-of-code-2018"

version := "0.1"

lazy val commonSettings = Seq(
  scalaVersion := "2.12.7",
  libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)

lazy val common = (project in file("common"))
  .settings(commonSettings)

lazy val day1 = (project in file("day1-chronal-calibration"))
  .settings(commonSettings)
  .dependsOn(common)

lazy val day2 = (project in file("day2-inventory-management-system"))
  .settings(commonSettings)
  .dependsOn(common)

lazy val day3 = (project in file("day3-no-matter-how-you-slice-it"))
  .settings(commonSettings)
  .dependsOn(common)

lazy val day4 = (project in file("day4-repose-record"))
    .settings(commonSettings)
    .dependsOn(common)

lazy val day5 = (project in file("day5-alchemical-reduction"))
    .settings(commonSettings)
    .dependsOn(common)

lazy val day6 = (project in file("day6-chronal-coordinates"))
    .settings(commonSettings)
    .dependsOn(common)