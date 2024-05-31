package jtm.extra09;

import java.util.List;

/**
 * Crocodile board game which compares scores of different crocodiles
 * 
 */
public class CrocodileGame {
	public static Board board = null; // Shared board of the game
	public static List<Crocodile> crocodile = null; // List of crocodiles

	public static String runGame() {
		float ratio = 0;
		String type = null;
		String gameStatus;
		// TODO #1: Reset game board before each crocodile movement by using
		// .getClone()
		// method of the Board
		// TODO #2: Go through the list of Crocodiles and move them on the Board
		// using
		// .move() method of crocodile
		for (Crocodile crocodile : crocodile) {
			crocodile.move(board.getClone());
			float currentRatio = crocodile.getCandies() / crocodile.getMoves();
			System.out.println("currentRatio:" + currentRatio);
			if ((currentRatio - ratio) > 0.001) {
				type = crocodile.getClass().getName() + " wins";
			} else {
				type = "Tie";
			}
			ratio = currentRatio;
			System.out.println("type:" + type + " ratio:" + ratio);
		}
		// TODO #3: Store score of the crocodile as ratio of eaten candies /
		// made moves

		// Calculate winning crocodile in following way:
		// 1. if score between previous and current crocodile is < 0.001, return
		// "Tie"
		// 2. if score of current crocodile is better return its "getType wins",
		// e.g. "CrocodileGreedy wins"

		return type;
	}

}
