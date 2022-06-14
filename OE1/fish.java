package OE1;
public class fish extends animal{
    private String name;
    private double wt;

    //Constructor
    public fish(String name, String breed, double wt, String color, String bark){
        super(breed, color, bark);
        this.name = name;
        this.wt = wt;

    }

    public void setFish(String name, double wt){
        this.name = name;
        this.wt = wt;
    }

    public void getFish() {
        System.out.println("Fish Name  : " + name);
        System.out.println("Fish Weight: " + wt + "kg");
        System.out.println("Fish Breed : " + getBreed());
        System.out.println("Fish Color : " + getColor());
        System.out.println("Bark Noise : " + getBark());
    }
}