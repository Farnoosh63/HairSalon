import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {

    ProcessBuilder process = new ProcessBuilder();
       Integer port;
       if (process.environment().get("PORT") != null) {
           port = Integer.parseInt(process.environment().get("PORT"));
       } else {
           port = 4567;
       }

      setPort(port);


    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String stylistName = request.queryParams("stylist-name");
      Stylist newStylist = new Stylist(stylistName);
      newStylist.save();
      response.redirect("/");
      return null;
    });

    post("/clients", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.queryParams("stylistId")));
      String client-name = request.queryParams("client-name");
      Client newClient = new Client(client-name, stylist.getId());
      newClient.save();
      model.put("stylist", stylist);
      model.put("template", "templates/stylist-tasks-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    //
    // get("/cuisines/:id", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   Cuisine existingCuisine = Cuisine.find(Integer.parseInt(request.params(":id")));
    //   model.put("cuisine", existingCuisine);
    //   model.put("restaurants", existingCuisine.getRestaurants());
    //   model.put("template", "templates/restaurants.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    // post("/restaurants", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   String restaurantName = request.queryParams("restaurant-name"); //olive garden
    //   Cuisine existingCuisine = Cuisine.find(Integer.parseInt(request.queryParams("cuisineId")));
    //   Restaurant newRestaurant = new Restaurant(restaurantName,existingCuisine.getId());
    //   newRestaurant.save();
    //   String url = String.format("/cuisines/%d", existingCuisine.getId());
    //   response.redirect(url);
    //   return null;
    // });
    //
    // get("/restaurants/:id", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   Restaurant existingRestaurant = Restaurant.find(Integer.parseInt(request.params(":id")));
    //   model.put("restaurant", existingRestaurant);
    //   model.put("reviews", existingRestaurant.getReviews());
    //   model.put("template", "templates/reviews.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // post("/reviews", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   String reviewDescription = request.queryParams("description"); //olive garden
    //   Restaurant existingRestaurant = Restaurant.find(Integer.parseInt(request.queryParams("restaurantId")));
    //   Review newReview = new Review(reviewDescription,existingRestaurant.getId());
    //   newReview.save();
    //   String url = String.format("/restaurants/%d", existingRestaurant.getId());
    //   response.redirect(url);
    //   return null;
    // });

  }
}
