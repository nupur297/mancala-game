package com.mancala;

public class Board {

	Pit[] pits;
	static final int playingPits = 6, totalPits = 2 * (playingPits + 1);

	Board() {
		pits = new Pit[totalPits];
		for (int i = 0; i < totalPits; i++)
			pits[i] = new Pit();
	}

	public void distributeStones() {
		for (int i = 0; i < totalPits; i++)
			if (!isMancala(i))
				pits[i].addStones(4);
	}

	public int stonesInMancala(int playerNum) {
		return pits[getMancala(playerNum)].getStones();
	}

	public int stonesInPit(int playerNum, int pitNum) {
		return pits[getPitNum(playerNum, pitNum)].getStones();
	}

	private int getPitNum(int playerNum, int pitNum) {
		return playerNum * (playingPits + 1) + pitNum;
	}

	private int getMancala(int playerNum) {
		return playerNum * (playingPits + 1);
	}

	private boolean isMancala(int pitNum) {
		return pitNum % (playingPits + 1) == 0;
	}

	public boolean makeTheMove(int currentPlayerNum, int pitNum) {
		if (!isMoveValid(currentPlayerNum, pitNum)) {
			System.out.println("Invalid Move, Please select the right pit");
			return true;
		}

		int stones = pits[pitNum].removeStones();
		if (stones == 0) {
			System.out.println("Invalid Move, Can not select empty pit");
			return true;
		}
		int otherPlayerMancala = getMancala(otherPlayerNum(currentPlayerNum));
		while (stones != 0) {
			pitNum--;
			if (pitNum < 0)
				pitNum = totalPits - 1;
			if (pitNum != otherPlayerMancala) {
				pits[pitNum].addStones(1);
				stones--;
			}
		}
		if (isLastStoneInOwnMancala(currentPlayerNum, pitNum))
			return true;

		if (isLastStoneInOwnEmptyPit(currentPlayerNum, pitNum)) {
			stones = pits[oppositePitNum(pitNum)].removeStones();
			pits[getMancala(currentPlayerNum)].addStones(stones);
			stones = pits[pitNum].removeStones();
			pits[getMancala(currentPlayerNum)].addStones(stones);
		}
		return false;
	}

	public boolean isMoveValid(int currentPlayerNum, int chosenPitNum) {
		return (!(chosenPitNum == getMancala(currentPlayerNum)) && ownerOf(chosenPitNum) == currentPlayerNum);
	}

	private boolean isLastStoneInOwnMancala(int currentPlayerNum, int lastPit) {
		return (lastPit == getMancala(currentPlayerNum));
	}

	private boolean isLastStoneInOwnEmptyPit(int currentPlayerNum, int pitNum) {
		return (ownerOf(pitNum) == currentPlayerNum && pits[pitNum].getStones() == 1);
	}

	private int ownerOf(int pitNum) {
		return pitNum / (playingPits + 1);
	}

	private int oppositePitNum(int pitNum) {
		return totalPits - pitNum;
	}

	private int otherPlayerNum(int playerNum) {
		if (playerNum == 0)
			return 1;
		else
			return 0;
	}

	public boolean isGameOver() {
		for (int player = 0; player < 2; player++) {
			int stones = 0;
			for (int k = 1; k <= playingPits; k++)
				stones += pits[getPitNum(player, k)].getStones();
			if (stones == 0)
				return true;
		}
		return false;
	}

	public void finishGame() {
		for (int player = 0; player < 2; player++)
			for (int k = 0; k <= playingPits; k++) {
				int stones = pits[getPitNum(player, k)].removeStones();
				pits[getMancala(player)].addStones(stones);
			}
	}
}
