package OE1;
public class dog extends animal{
    private String name;
    private double wt;

    //Constructor
    public dog(String name, String breed, double wt, String color, String bark){
        super(breed, color, bark);
        this.name = name;
        this.wt = wt;
    }

    public void setDog(String name, double wt){
        this.name = name;
        this.wt = wt;
    }
    
    public void getDog() {
        System.out.println("Dog Name  : " + name);
        System.out.println("Dog Weight: " + wt + "kg");
        System.out.println("Dog Breed : " + getBreed());
        System.out.println("Dog Color : " + getColor());
        System.out.println("Bark Noise: " + getBark());
    }
}