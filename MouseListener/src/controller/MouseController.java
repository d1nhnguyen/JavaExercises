package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import view.MouseView;

public class MouseController implements MouseListener, MouseMotionListener{
	private MouseView mv;

	public MouseController(MouseView mv) {
		this.mv = mv;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.mv.addClick();
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
		this.mv.enter();

	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.mv.exit();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		this.mv.updateXY(x, y);
	}
	
}
