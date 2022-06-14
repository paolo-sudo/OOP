package OE1;
public class cat extends animal{
    private String name;
    private double wt;

    //Constructor
    public cat(String name, String breed, double wt, String color, String bark){
        super(breed, color, bark);
        this.name = name;
        this.wt = wt;
    }

    public void setCat(String name, double wt){
        this.name = name;
        this.wt = wt;
    }

    public void getCat() {
        System.out.println("Cat Name  : " + name);
        System.out.println("Cat Weight: " + wt + "kg");
        System.out.println("Cat Breed : " + getBreed());
        System.out.println("Cat Color : " + getColor());
        System.out.println("Bark Noise: " + getBark());
    }
}