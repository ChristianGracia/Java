package bestHand;

public class Scorer {
	
	private Player[] players;
	
	public Scorer(Player[] players) {
		setPlayers(players);
		
		for(Player player : players) {
			calculateSum(player);
		}
		
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
	private void calculateSum(Player player) {
		int sum = 0;
		for(Card card : player.getCards()) {
			sum += card.getValue();
			if(card.getValue() == 1) {
				sum += 10;
			}
		}
		System.out.println(player.getName() + ":  Sum of cards: " + sum);
	}
//	private void removeFaceCards(Player[] players) {
//		for (Player player : players) {
//			
//			
//			
//		}
//
//	}

}