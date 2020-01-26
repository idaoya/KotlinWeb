package com.th;
import io.javalin.Javalin;
import java.util.HashMap;
import java.util.Map;

public class Main {

	private static Map<String, String> add = new HashMap<String, String>() {

		private static final long serialVersionUID = 1L;

		{
			put("firstname", "Firstname");
			put("lastname", "Lastname");
		}
	};

	public static void main(String[] args) {

		Javalin app = Javalin.create(config -> config.addStaticFiles("/webapp")).start(8585);

		app.post("/add-new", ctx -> {

			String firstname = ctx.formParam("firstname");
			String lastname = ctx.formParam("lastname");

			add.put(firstname, lastname);
			ctx.html(firstname);
			ctx.html(lastname);
			ctx.html("Add Successful!");
		});

	}

}