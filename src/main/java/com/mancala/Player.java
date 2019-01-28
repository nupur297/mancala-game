package com.mancala;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {

	String name;
	int playerNum;

	Player(String name, int playerNum) {
		this.name = name;
		this.playerNum = playerNum;
	}

	public String getName() {
		return name;
	}

	public int getPlayerNum() {
		return this.playerNum;
	}

	public int enterTheMove(Board board) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter  a  pit  to  move from:  ");
		System.out.flush();
		int pitNum = Integer.parseInt(br.readLine());
		return pitNum;
	}
}
