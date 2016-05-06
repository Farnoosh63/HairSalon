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

    get("/stylists/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Stylist existingStylist = Stylist.find(Integer.parseInt(request.params(":id")));
      model.put("stylist", existingStylist);
      model.put("clients", existingStylist.getClients());
      model.put("template", "templates/clients.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/clients", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String clientName = request.queryParams("client-name");
      Stylist stylist = Stylist.find(Integer.parseInt(request.queryParams("stylistId")));
      Client newClient = new Client(clientName, stylist.getId());
      newClient.save();
      model.put("stylist", stylist);
      String url = String.format("/stylists/%d", stylist.getId());
      response.redirect(url);
      return null;
    });

    get("/stylists", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/stylists/:id/delete", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Stylist stylists = Stylist.find(Integer.parseInt(request.params("id")));
      stylists.delete();
      response.redirect("/stylists");
      return null;
    });

  }
}
