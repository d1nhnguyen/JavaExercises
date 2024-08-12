package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.MouseController;
import model.MouseModel;

public class MouseView extends JFrame{
	private MouseModel mm;
	private JLabel clickValue;
	private JLabel mouseCheckValue;
	private JLabel X;
	private JLabel Y;
	private JPanel jPanel_mouse;
	public MouseView() throws HeadlessException {
		this.mm = new MouseModel();
		this.init();
	}
	
	public void init() {
		this.setTitle("MouseExample");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		MouseController mc = new MouseController(this);
		
		jPanel_mouse = new JPanel();
		jPanel_mouse.setBackground(Color.BLACK);
		jPanel_mouse.addMouseListener(mc);
		jPanel_mouse.addMouseMotionListener(mc);
		
		Font font = new Font("Arial" , Font.BOLD, 20);
		
		JPanel jPanel_info = new JPanel();
		jPanel_info.setLayout(new GridLayout(3,3));
		
		JLabel position = new JLabel("Position");
		position.setFont(font);
		X = new JLabel("x = ");
		X.setFont(font);
		Y = new JLabel("y = ");
		Y.setFont(font);
		JLabel clickCounted = new JLabel("Number of clicks: ");
		clickCounted.setFont(font);
		clickValue = new JLabel("0");
		clickValue.setFont(font);
		JLabel blank1 = new JLabel();
		JLabel blank2 = new JLabel();
		JLabel mouseCheck = new JLabel("Mouse is in component: ");
		mouseCheck.setFont(font);
		mouseCheckValue = new JLabel("NaN");
		mouseCheckValue.setFont(font);
		jPanel_info.add(position);
		jPanel_info.add(X);
		jPanel_info.add(Y);
		jPanel_info.add(clickCounted);
		jPanel_info.add(clickValue);
		jPanel_info.add(blank1);
		jPanel_info.add(mouseCheck);
		jPanel_info.add(mouseCheckValue);
		jPanel_info.add(blank2);
		
		this.setLayout(new BorderLayout());
		this.add(jPanel_mouse, BorderLayout.CENTER);
		this.add(jPanel_info, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	public void addClick() {
		this.mm.addClick();
		this.clickValue.setText(this.mm.getClickedCount()+"");
	}
	public void enter() {
		this.mm.enter();
		this.mouseCheckValue.setText(this.mm.getCheckIn());
	}
	public void exit() {
		this.mm.exit();
		this.mouseCheckValue.setText(this.mm.getCheckIn());
		this.X.setText("X = " + "NaN");
		this.Y.setText("Y = " + "NaN");
	}
	public void updateXY(int x, int y) {
		this.mm.setX(x);
		this.mm.setY(y);
		this.X.setText("X = " + this.mm.getX());
		this.Y.setText("Y = " + this.mm.getY());
	}
}
