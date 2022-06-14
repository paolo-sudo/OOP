/*
Paolo S.
CS 2-1 | Prelim
*/

package Prelim;

import java.util.*;

public class Display {
    public static void main(String[] args) { 
        Deck deck = new Deck();
   
        System.out.println();
        for (int suit = Card.DIAMONDS; suit <= Card.DIAMONDS; suit++) { 
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                Card card = deck.getCard(suit, rank); 
                System.out.format("\t%s of %s%n", 
                    card.rankToString(card.getRank()),
                    card.suitToString(card.getSuit()));
            }
        }
        System.out.println();
        for (int suit = Card.CLUBS; suit <= Card.CLUBS; suit++) { 
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                Card card = deck.getCard(suit, rank); 
                System.out.format("\t%s of %s%n", 
                    card.rankToString(card.getRank()),
                    card.suitToString(card.getSuit()));
            }
        }
        System.out.println();
        for (int suit = Card.HEARTS; suit <= Card.HEARTS; suit++) { 
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                Card card = deck.getCard(suit, rank); 
                System.out.format("\t%s of %s%n", 
                    card.rankToString(card.getRank()),
                    card.suitToString(card.getSuit()));
            }
        }
        System.out.println();
        for (int suit = Card.SPADES; suit <= Card.SPADES; suit++) { 
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                Card card = deck.getCard(suit, rank); 
                System.out.format("\t%s of %s%n", 
                    card.rankToString(card.getRank()),
                    card.suitToString(card.getSuit()));
            }
        }

             
        /* 
        for (int suit = Card.DIAMONDS; suit <= Card.SPADES; suit++) { 
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                Card card = deck.getCard(suit, rank); 
                System.out.format("\t%s of %s%n", 
                    card.rankToString(card.getRank()),
                    card.suitToString(card.getSuit()));
            }
        }
        */

    }
        
}
