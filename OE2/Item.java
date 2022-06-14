package OE2;

public abstract class Item implements Get{

    private String name;
	private double price;
	private String cookieType;
	
	protected Item(String name, double price, String cookieType) {
		this.name = name;
		this.price = price;
		this.cookieType = cookieType;
	}

    public String getItemName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        
    }

    public String getDepartment(){
        return this.cookieType;
    }
}