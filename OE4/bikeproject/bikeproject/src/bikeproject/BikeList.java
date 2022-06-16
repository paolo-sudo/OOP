/*
Paolo S.
CS 2-1 | OE4
*/
package bikeproject;

import java.util.*;

public class BikeList {
    public static void main(String args[]){
        
        ArrayList<Bike> bikes = new ArrayList<Bike>();

        int mountainBikeSales = 0;
        int roadBikeSales = 0;

        fillArray(bikes);
        displayStock(bikes);
        displayBikeNumbers(bikes);

    }

    static void fillArray(ArrayList<Bike> bikes){
        Random random = new Random(); //To generate random numbers

        int bikenum;

        for(int i = 0; i < 10; i++){
            bikenum = random.nextInt(2);

            if(bikenum < 1){
                bikes.add(new MountainBike());
            }
            else{
                bikes.add(new RoadBike());
            }
        }
    }

    static void displayStock(ArrayList<Bike> bikes){
        for(Bike bike : bikes){
            bike.printDescription();
        }
    }

    static int calculateStock(ArrayList<Bike> bikes){
        int bikesSold = 0;

        for(Bike bike : bikes){
            if(bike instanceof MountainBike){
                bikesSold++;
            }
        }
        return bikesSold;
    }

    static int displayBikeNumbers(ArrayList<Bike> bikes){
        int mb, rb;

        mb = calculateStock(bikes);
        rb = bikes.size() - mb;

        System.out.println();
        System.out.println("\tStock Levels");
        System.out.println("\tWe have " + mb + "Mountain Bikes in stock");
        System.out.println("\tWe have " + rb + "Road Bikes in stock\n\n");
        return bikes.size(); 
    }
}
