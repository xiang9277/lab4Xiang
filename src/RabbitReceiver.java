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
public class RabbitReceiver {
    private final static String QUEUE_NAME = "pizzaQueue";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        System.out.println("✅ Receiver is running and waiting for messages...");

        DeliverCallback callback = (consumerTag, delivery) -> {
            String json = new String(delivery.getBody());
            System.out.println("\n📥 Received JSON: " + json);
            Pizza pizza = new Gson().fromJson(json, Pizza.class);
            System.out.println("🍕 Pizza Details:");
            System.out.println("Size: " + pizza.getSize());
            System.out.println("Crust: " + pizza.getCrust());
            System.out.println("Topping: " + pizza.getTopping());
        };

        channel.basicConsume(QUEUE_NAME, true, callback, consumerTag -> {});
    }
}