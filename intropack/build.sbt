name := """intropack"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  javaCore,
  "org.apache.directory.api" % "apache-ldap-api" % "1.0.0-M14",
//  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "mysql" % "mysql-connector-java" % "5.1.18",
  "org.hibernate" % "hibernate-core" % "4.2.3.Final",
  "org.hibernate" % "hibernate-entitymanager" % "4.2.3.Final"
//"org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final"
)

//val appDependencies = Seq(
//  "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final"
//)
// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
