package OE1;
public class animal extends my_animal {
    private String breed, color, bark;
    //Constructor
    public animal(String breed, String color, String bark){
        this.breed = breed;
        this.color = color;
        this.bark = bark;
    }

    public String getBreed(){
        return breed;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public String getBark(){
        return bark;
    }

    public void setBark(String bark){
        this.bark = bark;
    }
    
    public String getColor(){
        return color;
    }
}