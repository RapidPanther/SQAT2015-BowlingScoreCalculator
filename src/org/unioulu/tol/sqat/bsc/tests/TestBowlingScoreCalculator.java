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
		
	}
	
	public void initializeFrames(){
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
	
	public void initializeFramesWithOneStrike(){
		frame0 = new Frame(10, 0);
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
	
	public void initializeFramesWithOneSpare(){
		frame0 = new Frame(1, 9);
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
	
	public void initializeFramesWithOneStrikeFollowedByOneSpare(){
		frame0 = new Frame(10, 0);
		frame1 = new Frame(4, 6);
		frame2 = new Frame(7, 2);
		frame3 = new Frame(3, 6);
		frame4 = new Frame(4, 4);
		frame5 = new Frame(5, 3);
		frame6 = new Frame(3, 3);
		frame7 = new Frame(4, 5);
		frame8 = new Frame(8, 1);
		frame9 = new Frame(2, 6);
	}
	
	public void initializeFramesWithOneStrikeFollowedByOneStrike(){
		frame0 = new Frame(10, 0);
		frame1 = new Frame(10, 0);
		frame2 = new Frame(7, 2);
		frame3 = new Frame(3, 6);
		frame4 = new Frame(4, 4);
		frame5 = new Frame(5, 3);
		frame6 = new Frame(3, 3);
		frame7 = new Frame(4, 5);
		frame8 = new Frame(8, 1);
		frame9 = new Frame(2, 6);
	}
	
	public void initializeFramesWithOneSpareFollowedByOneSpare(){
		frame0 = new Frame(8, 2);
		frame1 = new Frame(5, 5);
		frame2 = new Frame(7, 2);
		frame3 = new Frame(3, 6);
		frame4 = new Frame(4, 4);
		frame5 = new Frame(5, 3);
		frame6 = new Frame(3, 3);
		frame7 = new Frame(4, 5);
		frame8 = new Frame(8, 1);
		frame9 = new Frame(2, 6);
	}
	
	public void initializeFramesWithSpareAsLastFrame(){
		frame0 = new Frame(1, 5);
		frame1 = new Frame(3, 6);
		frame2 = new Frame(7, 2);
		frame3 = new Frame(3, 6);
		frame4 = new Frame(4, 4);
		frame5 = new Frame(5, 3);
		frame6 = new Frame(3, 3);
		frame7 = new Frame(4, 5);
		frame8 = new Frame(8, 1);
		frame9 = new Frame(2, 8);
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
		initializeFrames();
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
		initializeFrames();
		addFrames();
		int score = bowlingGame.score();
		
		assertEquals(81, score);
	}
	
	@Test
	public void testIsStrike_ReturnTrue(){
		initializeFramesWithOneStrike();
		addFrames();
		
		boolean isFrameStrike = bowlingGame.getFrame(0).isStrike();
		
		assertEquals(true, isFrameStrike);
	}
	
	@Test
	public void testIsStrike_ReturnFalse(){
		initializeFramesWithOneStrike();
		addFrames();
		
		boolean isFrameStrike = bowlingGame.getFrame(1).isStrike();
		
		assertEquals(false, isFrameStrike);
	}
	
	@Test
	public void testScoreOfStrike_ReturnNineteen(){
		initializeFramesWithOneStrike();
		addFrames();
		
		int score = bowlingGame.getFrameScore(0);
		
		assertEquals(19, score);
	}
	
	@Test
	public void testScoreBowlingGameWithOneStrike_Return94(){
		initializeFramesWithOneStrike();
		addFrames();
		int score = bowlingGame.score();
		
		assertEquals(94, score);
	}
	
	@Test
	public void testIsSpare_ReturnFalse(){
		initializeFramesWithOneSpare();
		addFrames();
		
		boolean isFrameSpare = bowlingGame.getFrame(1).isSpare();
		
		assertEquals(false, isFrameSpare);
	}
	
	@Test
	public void testIsSpare_ReturnTrue(){
		initializeFramesWithOneSpare();
		addFrames();
		
		boolean isFrameSpare = bowlingGame.getFrame(0).isSpare();
		
		assertEquals(true, isFrameSpare);
	}
	
	@Test
	public void testScoreOfStrike_ReturnThirteen(){
		initializeFramesWithOneSpare();
		addFrames();
		
		int score = bowlingGame.getFrameScore(0);
		
		assertEquals(13, score);
	}
	
	@Test
	public void testScoreBowlingGameWithOneSpare_Return88(){
		initializeFramesWithOneSpare();
		addFrames();
		int score = bowlingGame.score();
		
		assertEquals(88, score);
	}
	
	@Test
	public void testScoreOfStrikeWithFollowingSpare_ReturnTwenty(){
		initializeFramesWithOneStrikeFollowedByOneSpare();
		addFrames();
		
		int score = bowlingGame.getFrameScore(0);
		
		assertEquals(20, score);
	}
	
	@Test
	public void testScoreBowlingGameWithOneStrikeWithFollowingSpare_Return103(){
		initializeFramesWithOneStrikeFollowedByOneSpare();
		addFrames();
		int score = bowlingGame.score();
		
		assertEquals(103, score);
	}
	
	@Test
	public void testScoreOfStrikeWithFollowingStrike_ReturnTwentyseven(){
		initializeFramesWithOneStrikeFollowedByOneStrike();
		addFrames();
		
		int score = bowlingGame.getFrameScore(0);
		
		assertEquals(27, score);
	}
	
	@Test
	public void testScoreBowlingGameWithOneStrikeWithFollowingStrike_Return112(){
		initializeFramesWithOneStrikeFollowedByOneStrike();
		addFrames();
		int score = bowlingGame.score();
		
		assertEquals(112, score);
	}
	
	@Test
	public void testScoreBowlingGameWithOneSpareWithFollowingSpare_Return98(){
		initializeFramesWithOneSpareFollowedByOneSpare();
		addFrames();
		int score = bowlingGame.score();
		
		assertEquals(98, score);
	}
	
	@Test
	public void testScoreOfSpareOnLastPosition_ReturnSeventeen(){
		initializeFramesWithSpareAsLastFrame();
		addFrames();
		bowlingGame.setBonus(7, 0);
		
		int score = bowlingGame.getFrameScore(9);
		
		assertEquals(17, score);
	}
	
	@Test
	public void testScoreBowlingGameWithSpareAsLastFrame_Return90(){
		initializeFramesWithSpareAsLastFrame();
		addFrames();
		bowlingGame.setBonus(7, 0);
		
		int score = bowlingGame.score();
		
		assertEquals(90, score);
	}

}
