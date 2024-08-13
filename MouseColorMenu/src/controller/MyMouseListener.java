package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.MyColorView;

public class MyMouseListener implements MouseListener{
	private MyColorView myColorView;
	public MyMouseListener(MyColorView myColorView) {
		this.myColorView = myColorView;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		this.myColorView.setColor();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
