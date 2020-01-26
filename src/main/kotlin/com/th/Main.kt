package com.th;
import io.javalin.Javalin
import io.javalin.core.util.FileUtil

private val add = mutableMapOf<String?, String?>(
	"firstname" to "Firstname",
	"lastname" to "Lastname"
)

fun main(args: Array<String>) {

	val app = Javalin.create {
		it.addStaticFiles("/webapp")
	}.start(8585)

	app.post("/add-new") { ctx ->
		
		String firstname = ctx . formParam ("firstname");
		String lastname = ctx . formParam ("lastname");

		add[firstname] = lastname
		ctx.html(firstname)
		ctx.html(lastname)
		ctx.html("Add Successful!")
	}

}