package com.mancala;

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.stream.Stream;


public class MancalaTest {
	private MancalaGame game;
	
	@Before
	public void setUp() {
		game = new MancalaGame("player1","player2");
	}
	
	@Test
	public void test_validMove() throws IOException {	
		assertTrue(game.board.isMoveValid(1, 1)==false);
	}
	
	@Test
	public void test_moveAgain() {
		assertTrue(game.board.makeTheMove(0, 4)==true);
	}
	
	@Test
	public void test_movePlayer2() throws IOException {
		game.board.makeTheMove(1, 10);
		assertTrue(game.board.pits[10].stones==0);
		assertTrue(game.board.pits[7].stones==1);
		assertTrue(game.board.pits[8].stones==5);
	}
	
	@Test
	public void test_movePlayer1() throws IOException {
		game.board.makeTheMove(0, 1);
		assertTrue(game.board.pits[1].stones==0);
		assertTrue(game.board.pits[0].stones==1);
		assertTrue(game.board.pits[13].stones==5);
	}
	
	@Test
	public void test_capturingStones() throws IOException {
		game.board.makeTheMove(0, 1);
		game.board.makeTheMove(0, 5);
		assertTrue(game.board.pits[0].stones==7);
		assertTrue(game.board.pits[1].stones==0);
		assertTrue(game.board.pits[13].stones==0);
		assertTrue(game.board.pits[5].stones==0);
	}

}
