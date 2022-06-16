import java.util.Scanner;

public class InputVariables {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int intVal;
        double doubleVal;
        char charVal;

        System.out.print("\nPlease enter a Integer value: ");
        intVal = in.nextInt();

        System.out.print("\nPlease enter a double value: ");
        doubleVal = in.nextDouble();

        System.out.print("\nPlease enter a character value: ");
        charVal = in.next().charAt(0);

        in.close();
        
        System.out.print("\nInteger value: " + intVal);
        System.out.print("\nDouble value: " + doubleVal);
        System.out.print("\nChar value: " + charVal);


    }
}
