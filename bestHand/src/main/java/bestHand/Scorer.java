package bestHand;

import java.util.ArrayList;

public class Scorer {
	
	private Player[] players;
	
	public Scorer(Player[] players) {
		setPlayers(players);
		
		for(Player player : players) {
			
			player.setScore(calculateSum(player));
		}
		removeFaceCards(getPlayers());
		
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
	private int calculateSum(Player player) {
		int sum = 0;
		for(Card card : player.getCards()) {
			sum += card.getValue();
			if(card.getValue() == 1) {
				sum += 10;
			}
		}
		System.out.println(player.getName() + ":  Sum of cards: " + sum);
		return sum
	}
	private void removeFaceCards(Player[] players) {
		
		int[] arr = new int[3];
		
		for (Player player : players) {
			for (Card card : player.getCards()) {
				switch(card.getValue()) {
				case 11:
					arr[0]++;
					break;
				case 12:
					arr[1]++;
					break;
				case 13:
					arr[2]++;
					break;
				default:
					break;
				}
			}
		}
			
			for(int i = 0; i < 3; i++) {
				int value = 0;
				if(arr[i] > 1) {
					
					System.out.println((i + 11) + " duplicate found");
					
					
				
					switch(i) {
					case 0:
						
						for(Player player : players) {
							
							ArrayList<Card> cards = player.getCards();
							
					       cards.removeIf(t -> t.getValue() == 11);
						}
						break;
					case 1:
						
						for(Player player : players) {
							
							ArrayList<Card> cards = player.getCards();
							
					       cards.removeIf(t -> t.getValue() == 12);
						}
						break;
					case 2:
						
						for(Player player : players) {
							
							ArrayList<Card> cards = player.getCards();
							
					       cards.removeIf(t -> t.getValue() == 11);
						}
						break;
					default:
						break;
					}
					
	
				
			       } 
			
			
			
		}
			
			for(Player player : players) {
				for (Card card : player.getCards()) {
					System.out.print(card.getValue() + card.getSuit() + " ");
				}
			}

	}

}