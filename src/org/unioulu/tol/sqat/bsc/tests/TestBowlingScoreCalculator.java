package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.unioulu.tol.sqat.bsc.BowlingGame;
import org.unioulu.tol.sqat.bsc.Frame;

public class TestBowlingScoreCalculator {
	BowlingGame bowlingGame;
	
	@Before
	public void setup(){
		bowlingGame = new BowlingGame();
	}
	
	
	@Test
	public void testAddFrameTwoAndFour_ReturnTwoAndFour() {
		Frame frame = new Frame(2, 4);
		
		assertEquals(2, frame.getFirstThrow());
		assertEquals(4, frame.getSecondThrow());
	}
	
	@Test
	public void testScoreFrameTwoSix_ReturnsEight(){
		Frame frame = new Frame(0, 9);
		
		assertEquals(9, frame.score());
	}
	
	@Test
	public void testScoreFrameTwoSix_ReturnsEight(){
		Frame frame = new Frame(2, 6);
		
		assertEquals(8, frame.score());
	}
	

}
