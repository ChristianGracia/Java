package bestHand;

import java.util.Arrays;
import java.util.Random;

public class Deck {
	private Card[] deck;
	
	public Deck() {
		this.setDeck(createDeck());	
		Card[] deck = shuffleDeck(getDeck(), 51);
		
		Card[] temp = dealHand(deck, 8);
		
		
		for(Card item : temp) {
			System.out.print(item.getCardNumber());
			System.out.print(" ");
			System.out.print(item.getValue());
			System.out.print(" ");
			System.out.print(item.getSuit());
			System.out.println(" ");
			
			
		}
	
	}

	public Card[] getDeck() {
		return deck;
	}

	public void setDeck(Card[] deck) {
		this.deck = deck;
	}
	
	private Card[] createDeck() {
		Card[] newDeck = new Card[52];
		
		for(int i = 1, j = 0, k=0; k < 52 ; i++, j++, k++ ) {
			if(j % 4 == 0) {
				j = 0;
			}
			if(i % 14 == 0) {
				i = 1;
			}
			newDeck[k] = new Card(i, j, k);
			
		}
	
		return newDeck;
		
	}
	private Card[] shuffleDeck(Card[] deck, int length) {
        Random r = new Random(); 

        for (int i = length-1; i > 0; i--) { 

            int j = r.nextInt(i+1);

            Card temp = deck[i]; 
            deck[i] = deck[j]; 
            deck[j] = temp; 
        } 

        return deck;
	}
	private Card[] dealHand(Card[] deck, int count) {
		Card[] handArray = new Card[count];
		
		for(int i = 0; i < count; i++) {
			handArray[i] = deck[i];
		}

		return handArray;
		
	}

}
