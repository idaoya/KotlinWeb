import io.javalin.Javalin;
import java.util.HashMap;
import java.util.Map;

public class Main {

	private static Map<String, String> reservations = new HashMap<String, String>() {

		private static final long serialVersionUID = 1L;

		{
			put("firstname", "Firstname");
			put("lastname", "Lastname");
		}
	};

	public static void main(String[] args) {

		Javalin app = Javalin.create(config -> {
			config.addStaticFiles("/webapp");
		}).start(8585);

		app.post("/add-new", ctx -> {
			reservations.put(ctx.formParam("firstname"), ctx.formParam("lastname"));
			ctx.html(ctx.formParam("firstname"));
			ctx.html(ctx.formParam("lastname"));
			ctx.html("Add Successful!");
		});

	}

}