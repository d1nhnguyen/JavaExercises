package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Counter;
import view.CounterView;

public class CounterListener implements ActionListener{
	private CounterView cv;
	
	public CounterListener(CounterView cv) {
		this.cv = cv;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src == "UP") {
			cv.Up();
		}
		else if(src == "DOWN") {
			cv.Down();
		}
		else if(src == "RESET") {
			cv.Reset();
		}
		
	}
}
