package model;

import java.awt.Color;

public class MyColorModel {
	private Color backgroundColor;
	private Color textColor;
	private int setNumber;
	
	public MyColorModel() {
		this.setNumber = 1;
	}
	
	private Color[] background = {Color.WHITE, Color.BLACK, Color.BLUE, Color.MAGENTA};
	private Color[] text = {Color.BLACK, Color.WHITE, Color.MAGENTA, Color.BLUE};
	private int[] index = {0, 1, 2, 3};

	/**
	 * @return the backgroundColor
	 */
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	/**
	 * @param backgroundColor the backgroundColor to set
	 */
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	/**
	 * @return the textColor
	 */
	public Color getTextColor() {
		return textColor;
	}
	/**
	 * @param textColor the textColor to set
	 */
	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}
	/**
	 * @return the setNumber
	 */
	public int getSetNumber() {
		return setNumber;
	}
	/**
	 * @param setNumber the setNumber to set
	 */
	public void setSetNumber(int setNumber) {
		this.setNumber = setNumber;
	}
	
	public void indexIncrease() {
		this.setNumber++;
		if(this.setNumber > 3) this.setNumber = 0;
	}
	
	public void changeColor() {
		this.backgroundColor = background[this.setNumber];
		this.textColor = text[this.setNumber];
	}
}
