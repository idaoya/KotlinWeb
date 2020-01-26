import io.javalin.Javalin
import io.javalin.core.util.FileUtil

private val reservations = mutableMapOf<String?, String?>(
	"firstname" to "Firstname",
	"lastname" to "Lastname"
)

fun main(args: Array<String>) {

	val app = Javalin.create {
		it.addStaticFiles("/webapp")
	}.start(8585)


	app.post("/add-new") { ctx ->
		reservations[ctx.formParam("firstname")] = ctx.formParam("lastname")
		ctx.html(ctx.formParam("firstname"))
		ctx.html(ctx.formParam("lastname"))
		ctx.html("Add Successful!")
	}

}
