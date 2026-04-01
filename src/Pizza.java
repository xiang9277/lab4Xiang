/** Project:lab4
 * Purpose Details:Systems Integration Pizza Shop: File Files, RabbitMQ, and Web Service/JSON
 * Course:IST242
 * Author:Zizhou Xiang
 * Date Developed:2026/3/31
 * Last Date Changed:2026/3/31
 * Rev:1.0

 */
public class Pizza {

    private String size;


    private String crust;


    private String topping;

    public Pizza() {}

    public Pizza(String size, String crust, String topping) {
        this.size = size;
        this.crust = crust;
        this.topping = topping;
    }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public String getCrust() { return crust; }
    public void setCrust(String crust) { this.crust = crust; }
    public String getTopping() { return topping; }
    public void setTopping(String topping) { this.topping = topping; }
}