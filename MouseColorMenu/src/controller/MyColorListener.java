package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MyColorView;

public class MyColorListener implements ActionListener{
	private MyColorView myColorView;
	public MyColorListener(MyColorView myColorView) {
		this.myColorView = myColorView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("BlackT")) {
			this.myColorView.setTextColorToBlack();
		}
		else if(src.equals("BlueT")) {
			this.myColorView.setTextColorToBlue();

		}
		else if(src.equals("WhiteT")) {
			this.myColorView.setTextColorToWhite();

		}
		else if(src.equals("MagentaT")) {
			this.myColorView.setTextColorToMagenta();

		}
		else if(src.equals("Black")) {
			this.myColorView.setBackgroundToBlack();
		}
		else if(src.equals("White")) {
			this.myColorView.setBackgroundToWhite();

		}
		else if(src.equals("Blue")) {
			this.myColorView.setBackgroundToBlue();

		}
		else if(src.equals("Magenta")) {
			this.myColorView.setBackgroundToMagenta();

		}
		
		
	}
	
}
