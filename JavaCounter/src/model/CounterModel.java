package model;

public class CounterModel {
	private int currentCount;
	private int steps;
	
	public CounterModel() {
		this.currentCount = 0;
		this.steps = 1;
	}

	/**
	 * @return the currentCount
	 */
	public int getCurrentCount() {
		return currentCount;
	}

	/**
	 * @param currentCount the currentCount to set
	 */
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	
	
	/**
	 * @return the steps
	 */
	public int getSteps() {
		return steps;
	}

	/**
	 * @param steps the steps to set
	 */
	public void setSteps(int steps) {
		this.steps = steps;
	}

	public void increment() {
		this.currentCount = this.currentCount + steps;
	}
	
	public void decrement() {
		this.currentCount = this.currentCount - steps;
	}
	
	public void reset() {
		this.currentCount = 0;
	}
}
