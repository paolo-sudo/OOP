/*
Paolo S.
CS 2-1 | OE2
*/

package OE2;

public class bakerydriver {
    public static void main(String[] args) {
        Cookie cookie = new Cookie("Choco Chip: ", 10);
        Cookie cookie2 = new Cookie("Coke      : ", 34.75);
        Cookie cookie3 = new Cookie("Piatos    : ", 14);
        Cookie cookie4 = new Cookie("Popcorn   : ", 99);

        System.out.println("\n" + cookie.getDepartment());
        System.out.println("\n" + cookie.getItemName());
        System.out.println(cookie.getType() + "PHP " + cookie.getPrice());
        System.out.println(cookie2.getType() + "PHP " + cookie2.getPrice());
        System.out.println(cookie3.getType() + "PHP " + cookie3.getPrice());
        System.out.println(cookie4.getType() + "PHP " + cookie4.getPrice());
        System.out.println();

        //cookie.setPrice(1.5);
    }
}