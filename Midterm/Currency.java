/*
Paolo S.
CS 2-1 | Midterm Hands-on Exam
*/

import java.util.*;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Currency {

    public static void main(String args[]){
        
        double money, peso, usdollar, euro;
        int num, repeat=1;
    
        Scanner sc = new Scanner(System.in);
    
        DecimalFormat fmt = new DecimalFormat("0.00");

        while(repeat!=0){
            System.out.println();
            System.out.println("\tWelcome to Currency Exchange!\n");
            System.out.println("\t1: Peso to US Dollar");
            System.out.println("\t2: US Dollar to Peso");
            System.out.println("\t3: Peso to Euro");
            System.out.println("\t4: Euro to Peso");
            System.out.println("\t5: US Dollar to Euro");
            System.out.println("\t6: Euro to US Dollar");
            System.out.println("\t0: Exit Program");
        
            System.out.println();
            System.out.print("\tEnter and choose a currency you have: ");
            num = sc.nextInt();
        
            switch(num){
                case 0:{
                    System.out.println();
                    System.out.println("\tThank you for trying the Currency Converter! Come back again!\n");
                    repeat--;

                    break;
                }
                case 1:{ //Peso to US Dollar
                    System.out.println();
                    System.out.print("\tEnter the amount you want to convert: PHP ");
                    money = sc.nextFloat();

                    usdollar = money / 56.39;
                    System.out.println();
                    System.out.println("\t" + money + " PHP = " + fmt.format(usdollar) + " USD");

                    break;
                }

                case 2:{ //US Dollars to Peso
                    System.out.println();
                    System.out.print("\tEnter the amount you want to convert: USD ");
                    money = sc.nextFloat();

                    peso = money * 56.39;
                    System.out.println();
                    System.out.println("\t" + money + " USD = " + fmt.format(peso) + " PHP");
        
                    break;
                }

                case 3:{ //Peso to Euro
                    System.out.println();
                    System.out.print("\tEnter the amount you want to convert: PHP ");
                    money = sc.nextFloat();

                    euro = money / 56.57;
                    System.out.println();
                    System.out.println("\t" + money + " PHP = " + fmt.format(euro) + " EUR");
        
                    

                    break;
                }

                case 4:{ //Euro to Peso
                    System.out.println();
                    System.out.print("\tEnter the amount you want to convert: EUR ");
                    money = sc.nextFloat();

                    peso = money * 56.57;
                    System.out.println();
                    System.out.println("\t" + money + " EUR = " + fmt.format(peso) + " PHP");

                    break;
                }

                case 5:{ //US Dollar to Euro
                    System.out.println();
                    System.out.print("\tEnter the amount you want to convert: USD ");
                    money = sc.nextFloat();
                    
                    euro = money / 0.99;
                    System.out.println();
                    System.out.println("\t" + money + " USD = " + fmt.format(euro) + " EUR");

                    break;
                }

                case 6:{ //Euro to US Dollar
                    System.out.println();
                    System.out.print("\tEnter the amount you want to convert: EUR ");
                    money = sc.nextFloat();

                    usdollar = money / 1.00;
                    System.out.println();
                    System.out.println("\t" + money + " EUR = " + fmt.format(usdollar) + " USD");

                    break;
                }
            }
        }
    }
}