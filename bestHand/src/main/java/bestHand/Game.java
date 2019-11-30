package bestHand;
import java.util.ArrayList;


public class Game {
	
	private int roundCount = 0;
	private Player[] players = new Player[4];
	public static final String ANSI_RESET = "\033[0m";;
	public static final String ANSI_RED = "\033[0;31m";
	
	public Game() {
		Deck deck = new Deck();
		  setPlayers(new Player[] {
				   new Player("Joe", deck.dealHand(deck.getDeck(), 8)), new Player("Dan", deck.dealHand(deck.getDeck(), 8)),   new Player("Cliff", deck.dealHand(deck.getDeck(), 8)),   new Player("Mark", deck.dealHand(deck.getDeck(), 8))
				  });
		  for(Player player : getPlayers()) {
			  System.out.println(player.getName());
		      showCards(player);
			  System.out.println("\n");
		  }
		  
		  System.out.println(deck.getDeck().size() + " cards left.");
	}
	
	 private void showCards(Player player) {
		  System.out.println("Your cards:");
		  for (Card card: player.getCards()) {
		
		   System.out.print(card.getValue() + " " + card.getSuit() + "      ");


		  }
		  
	

		 }

	public int getRoundCount() {
		return roundCount;
	}

	public void setRoundCount(int roundCount) {
		this.roundCount = roundCount;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

}
