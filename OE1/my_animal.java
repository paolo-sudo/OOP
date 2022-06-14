/*
Paolo S.
CS 2-1 | OE1
*/

package OE1;
public class my_animal {

    public static void main(String[] args) {
        //animal dog = new animal("Askal", "Red");
        dog dog1 = new dog("Kevin", "Poodle", 7.5, "Black", "Arf-Arf");
        fish fish1 = new fish("Dexter", "Guppy", 0.13, "Blue-Yellow", "Pops");
        cat cat1 = new cat("Maui", "Persian", 4.5, "Cream", "Meow");
        bird bird1 = new bird("Baldy", "Philippine Eagle", 6, "White and Dark Brown", "Scream");

        //System.out.println("Dog name: " dog.getBreed());
        //System.out.println("Dog name: " dog.getColor());
        //System.out.println("Dog1: " dog1.getDog());
        System.out.println();
        dog1.getDog();
        System.out.println();
        fish1.getFish();
        System.out.println();
        cat1.getCat();
        System.out.println();
        bird1.getBird();
        System.out.println();
    }
}