/*
 * Player.java
 * Author: Jiyoon Shin
 * Submission Date: 
 *
 * Purpose: 
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither 
 * received nor given inappropriate assistance. I have not copied 
 * or modified code from any source other than the course webpage 
 * or the course textbook. I recognize that any unauthorized 
 * assistance or plagiarism will be handled in accordance with 
 * the University of Georgia's Academic Honesty Policy and the 
 * policies of this course. I recognize that my work is based 
 * on an assignment created by the School of Computing 
 * at the University of Georgia. Any publishing or
 * posting of source code for this assignment is strictly 
 * prohibited unless you have written consent from the 
 * School of Computing at the University of Georgia.  
 */

public class Player {
	
	private int x;
	private int y;
	private Lamp lamp;
	private Key key;
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Lamp getLamp() {
		return this.lamp;
	}
	
	public Key getKey() {
		return this.key;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setLamp(Lamp theLamp) {
		this.lamp = theLamp;
	}
	
	public void setKey(Key theKey) {
		this.key = theKey;		
	}
	
}
