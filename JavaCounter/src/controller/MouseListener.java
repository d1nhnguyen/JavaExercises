package controller;

import java.awt.event.MouseEvent;

import view.CounterView;

public class MouseListener implements java.awt.event.MouseListener{
	private CounterView counterView;
	
	public MouseListener(CounterView counterView) {
		this.counterView = counterView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.isPopupTrigger()) {
			this.counterView.jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.isPopupTrigger()) {
			this.counterView.jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
