package OE1;
public class bird extends animal{
    private String name;
    private double wt;

    //Constructor
    public bird(String name, String breed, double wt, String color, String bark){
        super(breed, color, bark);
        this.name = name;
        this.wt = wt;
    }

    public void setBird(String name, double wt){
        this.name = name;
        this.wt = wt;
    }

    public void getBird() {
        System.out.println("Bird Name  : " + name);
        System.out.println("Bird Weight: " + wt + "kg");
        System.out.println("Bird Breed : " + getBreed());
        System.out.println("Bird Color : " + getColor());
        System.out.println("Bark Noise : " + getBark());
    }
}