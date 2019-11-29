package bestHand;

public class Game {
	
	private int roundCount = 0;
	private Player[] players = new Player[4];
	
	public Game() {
		Deck deck = new Deck();
		  setPlayers(new Player[] {
				   new Player("Joe", deck.dealHand(deck.getDeck(), 5)), new Player("Dan", deck.dealHand(deck.getDeck(), 5)),   new Player("Cliff", deck.dealHand(deck.getDeck(), 5)),   new Player("Mark", deck.dealHand(deck.getDeck(), 5))
				  });
		  for(Player player : getPlayers()) {
			  for(Card item : player.getCards()) {
				  System.out.print(item.getSuit() + " " + item.() + " ");
			  }
			  System.out.println("\n\n");
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
