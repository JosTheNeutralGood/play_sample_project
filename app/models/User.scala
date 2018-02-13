package models
case class User(id: Pk[Long] = NotAssigned, name: String, password: String, isAdmin: Boolean, gender: Option[Int])
object User {
 
 import play.api.db._
 import play.api.Play.current
 // create a SqlQuery for all of the "select all" methods
 import anorm.SQL
 val sqlQuery = SQL("select * from users order by symbol asc")
 
 def selectAll(): List[User] = DB.withConnection { implicit connection =>
 sqlQuery().map ( row =>
 User(row[Long]("id"),
 row[String]("name"),
 row[String]("password"),
 row[Boolean]("is_admin")
 row[Option[Int]]("gender"))
 ).toList
 }

}