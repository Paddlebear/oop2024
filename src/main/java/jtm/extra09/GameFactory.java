package jtm.extra09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static jtm.extra09.CrocodileGame.crocodile;

public class GameFactory {

	/**
	 * Sets new board for the game
	 * 
	 * @param board
	 *            reference to the new board
	 */
	public static void setBoard(Board board) {
		// TODO #1: set passed board to the CrocodileGame
		CrocodileGame.board = board;
	}

	/**
	 * Adds new crocodile to the list of the game
	 * 
	 * @param crocodileType
	 *            type of the crocodile (CrocodileSimple or CrocodileGreedy)
	 */
	public static void addCrocodile(String crocodileType) {
		// TODO #2: add new Crocodile to the list according of CrocodileGame
		// according to the passed type
		// Check if list is initialized and initialize it if necessary
		if (crocodile == null) {
			crocodile = new LinkedList<>();
		}
		if ("CrocodileSimple".equals(crocodileType)) {
			crocodile.add(new CrocodileSimple());
		}
		if ("CrocodileGreedy".equals(crocodileType)) {
			crocodile.add(new CrocodileGreedy());
		}

	}

}
