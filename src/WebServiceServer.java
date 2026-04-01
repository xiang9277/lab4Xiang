import static spark.Spark.*;
import com.google.gson.Gson;

/** Project:lab4
 * Purpose Details:Systems Integration Pizza Shop: File Files, RabbitMQ, and Web Service/JSON
 * Course:IST242
 * Author:Zizhou Xiang
 * Date Developed:2026/3/31
 * Last Date Changed:2026/3/31
 * Rev:1.0

 */
public class WebServiceServer {
    public static void main(String[] args) {
        port(4567);
        post("/pizza", (req, res) -> {
            Pizza pizza = new Gson().fromJson(req.body(), Pizza.class);
            System.out.println("Web Service Received:");
            System.out.println(pizza.getSize() + " " + pizza.getTopping());
            return "Received OK";
        });
    }
}