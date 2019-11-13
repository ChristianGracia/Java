package yahtzeeGame;

public class Yahtzee {

	public static void play() {
		roll();
		
	}
	private static int roll() {
		int roll = (int) (Math.random() * 6);
		System.out.println(roll);
		return roll;
		
	}
	
	

}
