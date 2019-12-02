package bestHand;

public class Scorer {
	
	private Player[] players;
	
	public Scorer(Player[] players) {
		setPlayers(players);
		
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
		}
		System.out.println(player.getName() + ":  Sum of cards: " + sum);
	}
//	private void removeFaceCards(Player player) {
//		int sum = 0;
//		for(Card card : player.getCards()) {
//			sum += card.getValue();
//		}
//		System.out.println(player.getName() + ":  Sum of cards: " + sum);
//	}

}