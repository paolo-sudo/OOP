/*
Paolo S.
CS 2-1 | OE3
*/

package OE3;

import java.lang.*;
import java.util.Scanner;
import java.util.Arrays;

public class SortandSearch {
    public static void bubbleSortandBinarysearch(){
        int num, item;

        //Bubble Sort
        Scanner in = new Scanner(System.in);
        System.out.println("\n\n\tCreate the Array List");
        System.out.print("\tEnter the size of the array: ");
        num = in.nextInt();

        int my_array[] = new int[num]; // create array to store all the numbers
        System.out.println();
        
        for(int x = 0; x < num; x++)
        {
            System.out.print("\tEnter Array element: ");
            my_array[x] = in.nextInt();
        }
        System.out.print("\n\tUnsorted Array List: " + Arrays.toString(my_array) + "\n\n");

        for(int i = 0; i < (num-1); i++)
        {
            boolean flag = false;
            for(int j = 0; j < (num-i-1); j++)
            {
                if(my_array[j] > my_array[j+1])
                {
                    flag = true;
                    int temp = my_array[j];
                    my_array[j] = my_array[j+1];
                    my_array[j+1] = temp;
                }
            }
            if(!flag){
                //return;
            }
        }
        System.out.print("\tSorted Array List: " + "[");
        for(int i = 0; i < num; i++)
        {
            System.out.print(my_array[i] + ", ");
        }
        System.out.print("]");


        //Binary Search
        System.out.print("\n\n\n\tEnter search value: ");
        item = in.nextInt();

        int low = 0;
        int high = num - 1;

        while(high >= low){
            int middle = (low + high)/2;
            if(my_array[middle] == item){
                System.out.println("\n\tThe number " + item + " is at position " + middle + " in the list\n\n");
                return; //target value was found
            }
            if(my_array[middle] < item){
                low = middle + 1;
            }
            if(my_array[middle] > item){
                high = middle - 1;
            }
        }
        System.out.println("\n\tThe number " + item + " is not in the list\n\n");

        in.close(); //close the scanner to not leak resources
    }

    public static void main(String args[]){
        bubbleSortandBinarysearch();
    }
}