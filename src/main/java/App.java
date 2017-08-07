
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;



/**
 * Created by Guest on 8/7/17.
 */
public class App {
    public static void main(String[] args) {

        get("/", (request, response) -> {
            Map<String, Object> different = new HashMap<String, Object>();
            return new ModelAndView(different, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/change", (request, response) -> {
            Map<String, Object> different = new HashMap<String, Object>();
            String input = request.queryParams("totalCash");
            Float cash = Float.parseFloat(input);
            boolean tooHigh = (cash > 8.20);
            ChangeMachine changeMachine = new ChangeMachine();
            String output = changeMachine.makeChange(cash);
            different.put("output", output);
            different.put("tooHigh", tooHigh);
            return new ModelAndView(different, "change.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
