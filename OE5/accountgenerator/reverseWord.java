/*
Paolo S.
CS 2-1 | OE5
*/

import java.lang.StringBuilder;
import java.util.Scanner;

public class reverseWord {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1; 
        String reversedString = "";

        System.out.print("Please enter a word: ");
        str1 = sc.nextLine();
        
        for(int i = str1.length()-1; i>=0; i--){
            reversedString = reversedString + str1.charAt(i);
          }
        System.out.print("The reversed string of the '"+str1+"' is: " + reversedString);
    }
    /*
    public static void main(String[] args){
        StringBuilder str = new StringBuilder("Object Oriented Programming"); //StringBuilder object

        System.out.println("String = " + str.toString()); //print string

        StringBuilder reverseStr = str.reverse(); //will reverse the string

        System.out.println("Reversed String = " + reverseStr.toString()); //print string in reverse
    } */

}
