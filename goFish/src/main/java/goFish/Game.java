package goFish;

public class Game {
	
	public Game() {
		Deck deck = new Deck();
		Player player1 = new Player(1, deck.dealHand(deck.getDeck(), 5));
		Player player2 =  new Player(2, deck.dealHand(deck.getDeck(), 5));
		
//		for(Card item : player2.getCards()) {
//		System.out.print(item.getCardNumber());
//		System.out.print(" ");
//		System.out.print(item.getValue());
//		System.out.print(" ");
//		System.out.print(item.getSuit());
//		System.out.println(deck.getDeck().size());
//
//	}

	}

}

