package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.unioulu.tol.sqat.bsc.BowlingGame;
import org.unioulu.tol.sqat.bsc.Frame;

public class TestBowlingScoreCalculator {
	BowlingGame bowlingGame;
	
	
	
	Frame frame0;
	Frame frame1;
	Frame frame2;
	Frame frame3;
	Frame frame4;
	Frame frame5;
	Frame frame6;
	Frame frame7;
	Frame frame8;
	Frame frame9;
	
	@Before
	public void setup(){
		bowlingGame = new BowlingGame();
		
		frame0 = new Frame(1, 5);
		frame1 = new Frame(3, 6);
		frame2 = new Frame(7, 2);
		frame3 = new Frame(3, 6);
		frame4 = new Frame(4, 4);
		frame5 = new Frame(5, 3);
		frame6 = new Frame(3, 3);
		frame7 = new Frame(4, 5);
		frame8 = new Frame(8, 1);
		frame9 = new Frame(2, 6);
	}
	
	public void addFrames(){
		bowlingGame.addFrame(frame0);
		bowlingGame.addFrame(frame1);
		bowlingGame.addFrame(frame2);
		bowlingGame.addFrame(frame3);
		bowlingGame.addFrame(frame4);
		bowlingGame.addFrame(frame5);
		bowlingGame.addFrame(frame6);
		bowlingGame.addFrame(frame7);
		bowlingGame.addFrame(frame8);
		bowlingGame.addFrame(frame9);
	}
	
	
	@Test
	public void testAddFrameTwoAndFour_ReturnTwoAndFour() {
		Frame frame = new Frame(2, 4);
		
		assertEquals(2, frame.getFirstThrow());
		assertEquals(4, frame.getSecondThrow());
	}
	
	@Test
	public void testScoreFrameZeroNine_ReturnsNine(){
		Frame frame = new Frame(0, 9);
		
		assertEquals(9, frame.score());
	}
	
	@Test
	public void testScoreFrameTwoSix_ReturnsEight(){
		Frame frame = new Frame(2, 6);
		
		assertEquals(8, frame.score());
	}
	
	@Test
	public void testAddFrame(){
		addFrames();
		
		//frame 1
		int firstScoreFrameTen = bowlingGame.getFrame(9).getFirstThrow();
		int secondScoreFrameTen = bowlingGame.getFrame(9).getSecondThrow();
		
		assertEquals(2, firstScoreFrameTen);
		assertEquals(6, secondScoreFrameTen);
		
		
		//frame 10
		int firstScoreFrameOne = bowlingGame.getFrame(0).getFirstThrow();
		int secondScoreFrameOne = bowlingGame.getFrame(0).getSecondThrow();
		
		assertEquals(1, firstScoreFrameOne);
		assertEquals(5, secondScoreFrameOne);
	}
	
	@Test
	public void testScoreBowlingGameWithDefaultFrames_ReturnEightyOne(){
		addFrames();
		int score = bowlingGame.score();
		
		assertEquals(81, score);
	}
	

}
