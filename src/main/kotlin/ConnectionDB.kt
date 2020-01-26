package kotlin;
import java.sql.*
import java.util.Properties


public class ConnectionDB {

	internal var conn: Connection? = null
	internal var username = "root" // provide the username
	internal var password = "" // provide the corresponding password

	fun main2(args: Array<String>) {
		getConnection()
		executeMySQLQuery()
	}

	fun executeMySQLQuery() {

		var stmt: Statement? = null
		var resultset: ResultSet? = null

		try {
			stmt = conn!!.createStatement()
			resultset = stmt!!.executeQuery("Select * from people;")

			if (stmt.execute("select * from people;")) {
				resultset = stmt.resultSet
			}

			while (resultset!!.next()) {
				println(resultset.getString("registrationDB"))
			}

		} catch (ex: SQLException) {
			ex.printStackTrace()

		} finally {
			if (resultset != null) {

				try {
					resultset.close()
				} catch (sqlEx: SQLException) {

				}

				resultset = null
			}

			if (stmt != null) {
				try {
					stmt.close()

				} catch (sqlEx: SQLException) {
				}

				stmt = null
			}

			if (conn != null) {

				try {
					conn!!.close()

				} catch (sqlEx: SQLException) {

				}

				conn = null

			}
		}
	}

	fun getConnection() {

		val connectionProps = Properties()

		connectionProps.put("root", username)

		connectionProps.put("", password)

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance()

			conn = DriverManager.getConnection(

				"jdbc:" + "mysql" + "://" +

						"127.0.0.1" +

						":" + "3306" + "/" +

						"",

				connectionProps
			)

		} catch (ex: SQLException) {

			// handle any errors

			ex.printStackTrace()

		} catch (ex: Exception) {

			// handle any errors

			ex.printStackTrace()

		}

	}

} 