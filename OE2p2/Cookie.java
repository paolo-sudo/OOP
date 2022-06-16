package OE2p2;

public class Cookie extends bakerydriver {
    public String cookieType;
    private double price;

    //constructor method
    public Cookie(String type, double price){
    super(type, price);
    cookieType = type;
    this.price = price;
    }

    public String getItemName() {return "Cookie";}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public String getDepartment() {return "Bakery";}
    public String getType() {return cookieType;}
}
