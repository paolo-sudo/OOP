package Practice;
public class oraclesample {
    public static void main(String[] args) {


        String str1 = "Hello";
        String str2 = "Paolo";
        String str3 = "You are " + str2;

        System.out.println("Welcome: " + str3);
        System.out.println("Length: " + str1.length());
        System.out.println("Substring: " + str3.substring(0,5));
        System.out.println("Uppercase: " + str2.toUpperCase());

        System.out.println("\n" + str1.compareTo(str2));
        System.out.println("\n" + str1.equals(str2));
    }
}
