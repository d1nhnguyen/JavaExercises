package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;

import controller.CounterListener;
import model.CounterModel;

public class CounterView extends JFrame{
	private CounterModel counterModel;
	private JLabel counterLabel = new JLabel("0", JLabel.CENTER) ;
	private JToolBar jToolBar = new JToolBar();
	public CounterView () {
		this.counterModel = new CounterModel();
		this.init();
	}
	
	public void init() {
		this.setTitle("Counter");
		this.setSize(480, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ActionLisener
		CounterListener counterListener = new  CounterListener(this);
		
		//Tạo font
		Font font = new Font("Arial", Font.BOLD, 40);
		
		// setIcon
		URL iconUrl = CounterView.class.getResource("Icon.png");
		Image iconImage = Toolkit.getDefaultToolkit().createImage(iconUrl);
		this.setIconImage(iconImage);
		
		//Tạo menubar
		JMenuBar jMenuBar = new JMenuBar();
		JMenuItem exit = new JMenuItem();
		exit.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(CounterView.class.getResource("exit.png"))));
		exit.setActionCommand("EXIT");
		exit.addActionListener(counterListener);
		JCheckBoxMenuItem toolBarView = new JCheckBoxMenuItem();
		toolBarView.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(CounterView.class.getResource("view.png"))));
		toolBarView.setActionCommand("TOOLBARVIEW");
		toolBarView.addActionListener(counterListener);
		JMenu menuColor = new JMenu();
		menuColor.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(CounterView.class.getResource("color.png"))));
		JMenu textColor = new JMenu();
		textColor.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(CounterView.class.getResource("text_color.png"))));
		JMenu backgroundColor = new JMenu();
		backgroundColor.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(CounterView.class.getResource("background_color.png"))));
		
		//Tạo toolbar
		JButton stepChoice1 = new JButton("1");
		JButton stepChoice2 = new JButton("2");
		JButton stepChoice5 = new JButton("5");
		JButton stepChoice10 = new JButton("10");
		this.jToolBar.add(stepChoice1);
		stepChoice1.addActionListener(counterListener);
		this.jToolBar.add(stepChoice2);
		stepChoice2.addActionListener(counterListener);
		this.jToolBar.add(stepChoice5);
		stepChoice5.addActionListener(counterListener);
		this.jToolBar.add(stepChoice10);
		stepChoice10.addActionListener(counterListener);

		
		
		//màu text và background
		JMenuItem redText = new JMenuItem("RED");
		redText.setActionCommand("REDTEXT");
		redText.setForeground(Color.RED);
		JMenuItem blueText = new JMenuItem("BLUE");
		blueText.setActionCommand("BLUETEXT");
		blueText.setForeground(Color.BLUE);
		JMenuItem yellowText = new JMenuItem("YELLOW");
		yellowText.setActionCommand("YELLOWTEXT");
		yellowText.setForeground(Color.YELLOW);
		redText.addActionListener(counterListener);
		blueText.addActionListener(counterListener);
		yellowText.addActionListener(counterListener);
		textColor.add(redText);
		textColor.add(blueText);
		textColor.add(yellowText);
	
		JMenuItem redBackground = new JMenuItem("RED");
		redBackground.setActionCommand("REDBACKGROUND");
		redBackground.setBackground(Color.RED);
		JMenuItem blueBackground = new JMenuItem("BLUE");
		blueBackground.setActionCommand("BLUEBACKGROUND");
		blueBackground.setBackground(Color.BLUE);
		JMenuItem yellowBackground = new JMenuItem("YELLOW");
		yellowBackground.setActionCommand("YELLOWBACKGROUND");
		yellowBackground.setBackground(Color.YELLOW);
		redBackground.addActionListener(counterListener);
		blueBackground.addActionListener(counterListener);
		yellowBackground.addActionListener(counterListener);
		backgroundColor.add(redBackground);
		backgroundColor.add(blueBackground);
		backgroundColor.add(yellowBackground);
		
		menuColor.add(textColor);
		menuColor.add(backgroundColor);
		jMenuBar.setLayout(new FlowLayout());
		jMenuBar.add(toolBarView);
		jMenuBar.add(menuColor);
		jMenuBar.add(exit);
		
		//Tạo button
		JButton buttonUp = new JButton();
		buttonUp.setActionCommand("UP");
		buttonUp.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(CounterView.class.getResource("plus_icon.png"))));
		buttonUp.addActionListener(counterListener);
		JButton buttonDown = new JButton();
		buttonDown.setActionCommand("DOWN");
		buttonDown.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(CounterView.class.getResource("minus_icon.png"))));
		buttonDown.addActionListener(counterListener);
		
		//Tạo counter label
		this.counterLabel.setFont(font);
		this.counterLabel.setOpaque(true);
		
		//Tạo panel
		JPanel jPanelCenter = new JPanel();
		jPanelCenter.setLayout(new GridLayout(1,3));
		jPanelCenter.add(buttonDown);
		jPanelCenter.add(this.counterLabel);
		jPanelCenter.add(buttonUp);
		this.setLayout(new BorderLayout());
		this.add(jToolBar, BorderLayout.NORTH);
		this.jToolBar.setVisible(false);
		this.setJMenuBar(jMenuBar);
		this.add(jPanelCenter, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public void increment() {
		this.counterModel.increment();
		this.counterLabel.setText("" + this.counterModel.getCurrentCount());
	}
	
	public void decrement() {
		this.counterModel.decrement();
		this.counterLabel.setText("" + this.counterModel.getCurrentCount());
	}
	public void setBackgroundColor(Color x) {
			this.counterLabel.setBackground(x);
	}
	public void setTextColor(Color x) {
		this.counterLabel.setForeground(x);
	}
	public void changeStep(int x) {
		this.counterModel.setSteps(x);
	}
	public void viewToolBar(boolean x) {
		this.jToolBar.setVisible(x);
	}
}
