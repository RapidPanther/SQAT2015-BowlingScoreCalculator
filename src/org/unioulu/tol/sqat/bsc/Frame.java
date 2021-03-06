package org.unioulu.tol.sqat.bsc;

public class Frame {
	private int firstThrow;
	private int secondThrow;
	
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}
	
	//the score of a single frame
	public int score(){
		int score = this.getFirstThrow() + this.getSecondThrow();
		return score;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		boolean isStrike = false;
		if(this.getFirstThrow() == 10 && this.getSecondThrow() == 0){
			isStrike = true;
		}

		return isStrike;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		boolean isSpare = false;
		
		if(this.score() == 10 && this.getFirstThrow() != 10){
			isSpare = true;
		}
		
		return isSpare;
	}

	//return whether this is the last frame of the match
	public boolean isLastFrame(){
		//to be implemented
		return false;
	}

	//bonus throws
	public int bonus(){
		//to be implemented
		return 0;
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public void setFirstThrow(int firstThrow) {
		this.firstThrow = firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}

	public void setSecondThrow(int secondThrow) {
		this.secondThrow = secondThrow;
	}
	
	
}
