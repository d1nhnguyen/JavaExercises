package model;

public class MouseModel {
	private int x;
	private int y;
	private int clickedCount;
	private String checkIn;
	public MouseModel() {
		this.x = 0;
		this.y = 0;
		this.clickedCount  = 0;
		this.checkIn = "NO";
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the clickedCount
	 */
	public int getClickedCount() {
		return clickedCount;
	}
	/**
	 * @param clickedCount the clickedCount to set
	 */
	public void setClickedCount(int clickedCount) {
		this.clickedCount = clickedCount;
	}
	/**
	 * @return the checkIn
	 */
	public String getCheckIn() {
		return checkIn;
	}
	/**
	 * @param checkIn the checkIn to set
	 */
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	
	public void addClick() {
		this.clickedCount++;
	}
	
	public void enter() {
		this.checkIn = "YES";
	}
	public void exit() {
		this.checkIn = "NO";
	}
}
