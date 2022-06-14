package OE2;

public class Cookie extends Item {
    public String cookieType;
    private double price;

    //constructor method
    public Cookie(String type, double price){
    super(type, price, "Cookie");
    cookieType = type;
    this.price = price;
    }

    public String getItemName() {return "Your Cart Items";}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public String getDepartment() {return "Bakery";}
    public String getType() {return cookieType;}

    @Override
    public String GetName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double GetPrice() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String GetcookieType() {
        // TODO Auto-generated method stub
        return null;
    }
}
