package OE1;
import java.util.Scanner;

public class my_class {
    int id;

    public my_class(int x){

    }

    public void setData(int x){
        this.id = x; // Setter/Mutator
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);//instance of Scanner class
        int x;
        System.out.print("Enter a number: ");
        x = in.nextInt();
        my_class value = new my_class(x);
        value.setData(x);

    }
}
