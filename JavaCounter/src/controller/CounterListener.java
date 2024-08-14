package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

import view.CounterView;

public class CounterListener implements ActionListener{
	private CounterView counterView;
	
	public CounterListener(CounterView counterView) {
		this.counterView = counterView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("UP")) {
			this.counterView.increment();
		}
		else if(src.equals("DOWN")) {
			this.counterView.decrement();
		}
		else if(src.equals("EXIT")) {
			System.exit(0);
		}
		else if(src.equals("REDTEXT")) {
			this.counterView.setTextColor(Color.RED);
		}
		else if(src.equals("BLUETEXT")) {
			this.counterView.setTextColor(Color.BLUE);
		}
		else if(src.equals("YELLOWTEXT")) {
			this.counterView.setTextColor(Color.YELLOW);
		}
		else if(src.equals("REDBACKGROUND")) {
			this.counterView.setBackgroundColor(Color.RED);
		}
		else if(src.equals("BLUEBACKGROUND")) {
			this.counterView.setBackgroundColor(Color.BLUE);
		}
		else if(src.equals("YELLOWBACKGROUND")) {
			this.counterView.setBackgroundColor(Color.YELLOW);
		}
		else if(src.equals("1")) {
			this.counterView.changeStep(1);
		}
		else if(src.equals("2")) {
			this.counterView.changeStep(2);
		}
		else if(src.equals("5")) {
			this.counterView.changeStep(5);
		}
		else if(src.equals("10")) {
			this.counterView.changeStep(10);
		}
		else if(src.equals("TOOLBARVIEW")) {
			AbstractButton button = (AbstractButton) e.getSource();
			this.counterView.viewToolBar(button.getModel().isSelected());
		}
	}

}
