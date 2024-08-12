package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.CounterListener;
import model.Counter;

public class CounterView extends JFrame{
	private Counter counter;
	private JButton buttonUp;
	private JButton buttonDown;
	private JButton buttonReset;
	private JLabel labelText;
	public CounterView() {
		this.counter = new Counter();
		this.init();
		this.setVisible(true);
	}
	
	public void init() {
		this.setTitle("SimpleJavaCounter");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ActionListener ac = new CounterListener(this);
		
		this.buttonUp = new JButton("UP");
		this.buttonUp.addActionListener(ac);
		this.buttonDown = new JButton("DOWN");
		this.buttonDown.addActionListener(ac);
		this.buttonReset = new JButton("RESET");
		this.buttonReset.addActionListener(ac);
		this.labelText = new JLabel(""+this.counter.getCounter(), JLabel.CENTER);
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		jpanel.add(buttonUp, BorderLayout.EAST);
		jpanel.add(buttonDown, BorderLayout.WEST);
		jpanel.add(buttonReset, BorderLayout.SOUTH);
		jpanel.add(labelText, BorderLayout.CENTER);
		
		
		this.setLayout(new BorderLayout());
		this.add(jpanel);
	}
	
	public void Up() {
		this.counter.increment();
		this.labelText.setText("" + this.counter.getCounter());
	}
	
	public void Down() {
		this.counter.decrement();
		this.labelText.setText("" + this.counter.getCounter());
	}
	
	public void Reset() {
		this.counter.setCounter(0);
		this.labelText.setText("0");
	}
}
