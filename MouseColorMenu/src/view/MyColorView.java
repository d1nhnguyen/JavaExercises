package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controller.MyColorListener;
import controller.MyMouseListener;
import model.MyColorModel;

public class MyColorView extends JFrame{
	private MyColorModel myColorModel;
	private JLabel textColor;
	private JLabel backgroundColor;
	private JPanel jpCenter;
	private JLabel colorSetText;
	private String[] background = {"White", "Black", "Blue", "Magenta"};
	private String[] text = {"Black", "White", "Magenta", "Blue"};
	public MyColorView() {
		this.myColorModel = new MyColorModel();
		this.setTitle("DrawExample");
		this.setSize(800,450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyColorListener mcl = new MyColorListener(this);
		
		Font font = new Font("Arial" , Font.BOLD, 20);
		JMenuBar menuBar = new JMenuBar();
		JMenu menuColorText = new JMenu("Text color");
		JMenuItem color1 = new JMenuItem("WhiteT");
		color1.addActionListener(mcl);
		JMenuItem color2 = new JMenuItem("BlackT");
		color2.addActionListener(mcl);
		JMenuItem color3 = new JMenuItem("BlueT");
		color3.addActionListener(mcl);
		JMenuItem color4 = new JMenuItem("MagentaT");
		color4.addActionListener(mcl);
		menuColorText.add(color1);
		menuColorText.add(color2);
		menuColorText.add(color3);
		menuColorText.add(color4);
		JMenu menuColorBackground = new JMenu("Background color");
		JMenuItem color11 = new JMenuItem("White");
		color11.addActionListener(mcl);
		JMenuItem color21 = new JMenuItem("Black");
		color21.addActionListener(mcl);
		JMenuItem color31 = new JMenuItem("Blue");
		color31.addActionListener(mcl);
		JMenuItem color41 = new JMenuItem("Magenta");
		color41.addActionListener(mcl);
		menuColorBackground.add(color11);
		menuColorBackground.add(color21);
		menuColorBackground.add(color31);
		menuColorBackground.add(color41);
		menuBar.add(menuColorText);
		menuBar.add(menuColorBackground);
		
		
		colorSetText = new JLabel("Current colorset is: ", JLabel.CENTER);
		colorSetText.setFont(font);
		this.textColor = new JLabel("Text: Black", JLabel.CENTER);
		this.textColor.setFont(font);
		this.backgroundColor = new JLabel("Background: White", JLabel.CENTER);
		this.backgroundColor.setFont(font);
		
		MyMouseListener myMouseListener = new MyMouseListener(this);
		
		jpCenter = new JPanel(new GridLayout(1,3));
		jpCenter.addMouseListener(myMouseListener);
		this.jpCenter.add(colorSetText);
		this.jpCenter.add(this.textColor);
		this.jpCenter.add(this.backgroundColor);
		
		this.setJMenuBar(menuBar);
		this.setLayout(new BorderLayout());
		this.add(jpCenter, BorderLayout.CENTER);
		this.setVisible(true);
	}
	public void setBackgroundToBlack() {
		this.myColorModel.setBackgroundColor(Color.BLACK);
		this.backgroundColor.setText("Background: Black" );
		this.jpCenter.setBackground(this.myColorModel.getBackgroundColor());
	}
	public void setBackgroundToBlue() {
		this.myColorModel.setBackgroundColor(Color.BLUE);
		this.backgroundColor.setText("Background: Blue" );
		this.jpCenter.setBackground(this.myColorModel.getBackgroundColor());
	}
	public void setBackgroundToMagenta() {
		this.myColorModel.setBackgroundColor(Color.MAGENTA);
		this.backgroundColor.setText("Background: Magenta" );
		this.jpCenter.setBackground(this.myColorModel.getBackgroundColor());
	}
	public void setBackgroundToWhite() {
		this.myColorModel.setBackgroundColor(Color.WHITE);
		this.backgroundColor.setText("Background: White" );
		this.jpCenter.setBackground(this.myColorModel.getBackgroundColor());
	}
	public void setTextColorToBlack() {
		this.myColorModel.setTextColor(Color.BLACK);
		this.backgroundColor.setText("Text: Black" );
		this.textColor.setForeground(this.myColorModel.getTextColor());
		this.textColor.setForeground(this.myColorModel.getTextColor());
		this.backgroundColor.setForeground(this.myColorModel.getTextColor());
	}
	public void setTextColorToWhite() {
		this.myColorModel.setTextColor(Color.WHITE);
		this.textColor.setText("Text: White" );
		this.colorSetText.setForeground(this.myColorModel.getTextColor());
		this.textColor.setForeground(this.myColorModel.getTextColor());
		this.backgroundColor.setForeground(this.myColorModel.getTextColor());
	}
	public void setTextColorToBlue() {
		this.myColorModel.setTextColor(Color.BLUE);
		this.textColor.setText("Text: Blue" );
		this.colorSetText.setForeground(this.myColorModel.getTextColor());
		this.textColor.setForeground(this.myColorModel.getTextColor());
		this.backgroundColor.setForeground(this.myColorModel.getTextColor());
	}
	public void setTextColorToMagenta() {
		this.myColorModel.setTextColor(Color.MAGENTA);
		this.textColor.setText("Text: Magenta" );
		this.colorSetText.setForeground(this.myColorModel.getTextColor());
		this.textColor.setForeground(this.myColorModel.getTextColor());
		this.backgroundColor.setForeground(this.myColorModel.getTextColor());
	}
	public void setColor() {
		this.myColorModel.indexIncrease();
		this.myColorModel.changeColor();
		this.textColor.setText("Text: " + this.text[this.myColorModel.getSetNumber()]);
		this.backgroundColor.setText("Background: " + this.background[this.myColorModel.getSetNumber()]);
		this.colorSetText.setForeground(this.myColorModel.getTextColor());
		this.textColor.setForeground(this.myColorModel.getTextColor());
		this.backgroundColor.setForeground(this.myColorModel.getTextColor());
		this.jpCenter.setBackground(this.myColorModel.getBackgroundColor());
	}
}
