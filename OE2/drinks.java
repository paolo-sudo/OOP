package OE2;

public class drinks extends Item {
    public String drinkType;
    private double price;
    public String getPrice;

    //constructor method
    public Drink(String dtype, double price){
    super(type, price, "Soda");
    drinkType = dtype;
    this.price = price;
    }

    public String getItemName() {return "Drinks";}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public String getType() {return drinkType;}

    @Override
    public String GetName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public float GetPrice() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String GetcookieType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String GetdrinkType() {
        // TODO Auto-generated method stub
        return null;
    }

}
