package bestHand;

import java.util.ArrayList;

public class Scorer {

	private Player[] players;

	public Scorer(Player[] players) {
		setPlayers(players);

		calculateSum(getPlayers());
		removeFaceCards(getPlayers());
		checkFaceCards(getPlayers());
		checkDoubles(getPlayers());
		showAllScores(getPlayers());
		determineWinner(getPlayers());

		System.out.println("\n\n");

	}

	private void showAllScores(Player[] players) {
		for (Player player : players) {

			sumScores(player);

			System.out.println(player.getName() + " Total Score : " + player.getTotalScore() + " Sums: "
					+ player.getSum() + " Faces: " + player.getFaceCardScore() + " Doubles: " + player.getDoublesScore()
					+ " Straights : " + player.getStraightScore());

			for (Card card : player.getCards()) {

				System.out.print("[" + card.getValue() + "" + card.getSuit() + "]");

			}
			System.out.print("\n\n");
		}
	}

	private void sumScores(Player player) {
		int sum = player.getSum();
		int faces = player.getFaceCardScore();
		int straight = player.getStraightScore();
		int doubles = player.getDoublesScore();

		player.setTotalScore(sum + faces + straight + doubles);
	}

	private void determineWinner(Player[] players) {
		Player winner = players[0];

		for (Player player : players) {
			if (player.getTotalScore() > winner.getTotalScore()) {
				winner = player;
			}
		}

		System.out.println("\n" + winner.getName() + " has won! Score:" + winner.getTotalScore());

	}

	private void checkDoubles(Player[] players) {

		for (Player player : players) {

			int[] arr = new int[14];
			int score = 0;
			for (Card card : player.getCards()) {

				arr[card.getValue()]++;
			}

			for (int i : arr) {
				if (i > 1) {
					score += 2 * i;
				}
			}

			System.out.println(player.getName() + " received " + score + " for their doubles");

			player.setDoublesScore(score);

		}
		System.out.println("\n");

	}

	private void checkFaceCards(Player[] players) {

		for (Player player : players) {

			int score = 0;

			ArrayList<Card> cards = player.getCards();

			for (int j = 0; j < cards.size(); j++) {

				if (cards.get(j).getValue() > 10) {
					score += 5;
					System.out.println("Face card found for " + player.getName() + " +5");

				}

			}

			System.out.println(player.getName() + " received " + score + " points for face cards left");

			player.setFaceCardScore(score);
		}
		System.out.println("\n");

	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	private void calculateSum(Player[] players) {
		for (Player player : players) {
			int sum = 0;
			for (Card card : player.getCards()) {
				sum += card.getValue();
				if (card.getValue() == 1) {
					sum += 10;
				}
			}
			System.out.println(player.getName() + ":  Sum of cards: " + sum);
			player.setSum(sum);
		}
	}

	private void removeFaceCards(Player[] players) {

		int[] arr = new int[3];

		for (Player player : players) {
			for (Card card : player.getCards()) {
				switch (card.getValue()) {
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

		for (int i = 0; i < 3; i++) {
			if (arr[i] > 1) {

				for (Player player : players) {

					ArrayList<Card> cards = player.getCards();
					int counter = 0;
					for (int j = 0; j < cards.size(); j++) {

						if (cards.get(j).getValue() == i + 11 && counter == 0) {
							cards.remove(j);
							counter++;
						}
					}
					player.setCards(cards);

				}
			}

		}

		System.out.println("\nCards remaining after red wedding: ");
		for (Player player : players) {
			System.out.println(player.getName() + ":  " + player.getCards().size());
		}
		System.out.println("");

	}
}