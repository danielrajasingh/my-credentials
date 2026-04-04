package chapter6.DeckOfCards.src.main.java.coding.challenge;

import chapter6.DeckOfCards.src.main.java.coding.challenge.card.*;
import chapter6.DeckOfCards.src.main.java.coding.challenge.deck.*;


public class Main {

    public static void main(String[] args) {

        // create a single classical card
        Card sevenHeart = new StandardCard(StandardSuit.HEARTS, 7);

        // create a complete deck of standard cards      
        Pack cp = new StandardPack();
        Deck deck = new Deck(cp);
        
        System.out.println("Remaining cards: " + deck.remainingCards());
    }
}
