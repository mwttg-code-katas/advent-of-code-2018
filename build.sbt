name := "advent-of-code-2018"

version := "0.1"

lazy val commonSettings = Seq(
  scalaVersion := "2.12.7",
  libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)

lazy val day1 = (project in file("day1-chronal-calibration"))
  .settings(commonSettings)

lazy val day2 = (project in file("day2-inventory-management-system"))
    .settings(commonSettings)

lazy val day3 = (project in file("day3-no-matter-how-you-slice-it"))
    .settings(commonSettings)