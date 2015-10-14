package org.unioulu.tol.sqat.bsc;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	public void addFrame(Frame frame){
		frames.add(frame);
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	public int score(){
		int score = 0;
		
		for(int i = 0; i < frames.size(); i++){
			score = score + getFrameScore(i);
		}
		
		return score;
	}
	
	public boolean isNextFrameBonus(){
		//to be implemented
		return false;
	}
	
	public Frame getFrame(int frameNumber){
		return frames.get(frameNumber);
	}

	public int getFrameScore(int frameNumber) {
		int score = 0;
		
		score = frames.get(frameNumber).score();
		
		if(frames.get(frameNumber).isStrike() && frameNumber +1 < frames.size()){
			score = score + frames.get(frameNumber +1).score();
			
			if(frames.get(frameNumber + 1).getFirstThrow() == 10 && frameNumber +1 < frames.size())
			{
				score = score + frames.get(frameNumber + 2).getFirstThrow();
			}
				
		}
		else if(frames.get(frameNumber).isSpare() && frameNumber +1 < frames.size()){
			score = score + frames.get(frameNumber +1).getFirstThrow();
		}
			
		return score;
	}
}
