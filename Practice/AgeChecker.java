import java.util.Scanner;

public class AgeChecker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int age, y, n;
        char license;

        System.out.print("Enter Age: ");
        age = in.nextInt();
        System.out.print("Do you have license? y/n: ");
        license = in.next().charAt(0);

        if((age >= 21) && (license == 'y')){
            System.out.println("\nYou are an adult and can hire a car");
        }else{
            System.out.println("\nYou are not an adult");
        }

        

        in.close();
    }

        
}
