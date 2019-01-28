package com.mancala;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MancalaGame {

	private final Logger manacalaLog = LoggerFactory.getLogger(this.getClass());
	int currentPlayer = 0;
	Board board;
	Player[] players;

	MancalaGame(String name0, String name1) {
		board = new Board();
		board.distributeStones();
		manacalaLog.info("Macala Board ready for play");
		players = new Player[2];
		players[0] = new Player(name0, 0);
		players[1] = new Player(name1, 1);
		manacalaLog.info("Players" + name0 + " and " + name1 + " are ready to start");
		currentPlayer = 0;
	}

	public static void main(String[] args) throws IOException {
		MancalaGame mancala = new MancalaGame(args[0], args[1]);
		mancala.start();
		mancala.end();
	}

	private void displayMancalaBoard() {
		String mancalaLineFiller = "";
		System.out.println("-------------------------------------------------------------");
		System.out.print("        ");
		for (int i = Board.playingPits + 2; i < Board.totalPits; ++i) {
			System.out.print(" " + String.format("%02d", i) + "     ");
		}
		System.out.println();
		System.out.print("        ");
		for (int i = 1; i <= Board.playingPits; i++) {
			System.out.print("[" + String.format("%02d", board.stonesInPit(1, i)) + "]" + "    ");
			mancalaLineFiller += "        ";
		}
		displayPlayer(1);
		System.out.print("[" + String.format("%02d", board.stonesInMancala(1)) + "]" + "    ");
		System.out.print(mancalaLineFiller);
		System.out.println("[" + String.format("%02d", board.stonesInMancala(0)) + "]");

		System.out.print("        ");

		for (int i = Board.playingPits; i >= 1; i--)
			System.out.print("[" + String.format("%02d", board.stonesInPit(0, i)) + "]" + "    ");
		displayPlayer(0);
		System.out.print("        ");
		for (int i = Board.playingPits; i >= 1; i--) {
			System.out.print(" " + String.format("%02d", i) + "     ");
		}
		System.out.println();
		System.out.println("-------------------------------------------------------------");
	}

	private void displayPlayer(int playerNum) {
		if (currentPlayer == playerNum)
			System.out.print("            -->");
		else
			System.out.print("                  ");
		System.out.println("Player  " + (playerNum + 1) + "(  " + players[playerNum].getName() + ")");
	}

	public void start() throws IOException {
		displayMancalaBoard();
		while (!board.isGameOver()) {
			int pitNum = players[currentPlayer].enterTheMove(board);
			boolean playAgain = board.makeTheMove(currentPlayer, pitNum);

			if (!playAgain)
				currentPlayer ^= 1;
			else
				System.out.println("Player  " + (currentPlayer + 1) + "  goes  again");
			displayMancalaBoard();
		}
	}

	public void end() {
		board.finishGame();
		displayMancalaBoard();
		declareResult();
	}

	public void declareResult() {
		if (board.stonesInMancala(0) > board.stonesInMancala(1))
			System.out.println(players[0].getName() + "  wins");
		else if (board.stonesInMancala(0) < board.stonesInMancala(1))
			System.out.println(players[1].getName() + "  wins");
		else
			System.out.println("Tie");
	}
}
