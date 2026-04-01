import com.rabbitmq.client.*;
import com.google.gson.Gson;

/** Project:lab4
 * Purpose Details:Systems Integration Pizza Shop: File Files, RabbitMQ, and Web Service/JSON
 * Course:IST242
 * Author:Zizhou Xiang
 * Date Developed:2026/3/31
 * Last Date Changed:2026/3/31
 * Rev:1.0

 */
public class RabbitSender {
    private final static String QUEUE_NAME = "pizzaQueue";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            Pizza pizza = new Pizza("large", "thin", "pepperoni");
            String json = new Gson().toJson(pizza);

            channel.basicPublish("", QUEUE_NAME, null, json.getBytes());
            System.out.println("Sent: " + json);
        }
    }
}
