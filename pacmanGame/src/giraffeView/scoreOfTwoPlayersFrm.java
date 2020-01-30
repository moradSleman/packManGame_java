package giraffeView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JButton;

public class scoreOfTwoPlayersFrm extends JFrame{
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JLabel lblFirstplayer;
	public JLabel lblSecondplayer;
	public JButton btnMenu;
	public scoreOfTwoPlayersFrm() {
		initialize();
	}

	public void initialize() {
	this.setResizable(false);
	this.getContentPane().setForeground(new Color(210, 105, 30));
	this.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 18));
	this.getContentPane().setBackground(new Color(0, 0, 51));
	this.getContentPane().setLayout(null);
	
	 lblFirstplayer = new JLabel("firstplayer");
	lblFirstplayer.setForeground(new Color(255, 153, 51));
	lblFirstplayer.setFont(new Font("Times New Roman", Font.BOLD, 24));
	lblFirstplayer.setBounds(93, 108, 129, 23);
	getContentPane().add(lblFirstplayer);
	
	 lblSecondplayer = new JLabel("secondPlayer");
	lblSecondplayer.setForeground(new Color(255, 153, 51));
	lblSecondplayer.setFont(new Font("Times New Roman", Font.BOLD, 24));
	lblSecondplayer.setBounds(93, 178, 129, 23);
	getContentPane().add(lblSecondplayer);
	
	JLabel lblTheWinner = new JLabel("the winner");
	lblTheWinner.setForeground(new Color(255, 153, 51));
	lblTheWinner.setFont(new Font("Times New Roman", Font.BOLD, 24));
	lblTheWinner.setBounds(81, 302, 141, 23);
	getContentPane().add(lblTheWinner);
	
	textField = new JTextField();
	textField.setForeground(new Color(0, 0, 102));
	textField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
	textField.setDropMode(DropMode.INSERT);
	textField.setColumns(10);
	textField.setBounds(237, 295, 311, 37);
	getContentPane().add(textField);
	
	textField_1 = new JTextField();
	textField_1.setForeground(new Color(0, 0, 102));
	textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
	textField_1.setDropMode(DropMode.INSERT);
	textField_1.setColumns(10);
	textField_1.setBounds(302, 171, 205, 37);
	getContentPane().add(textField_1);
	
	textField_2 = new JTextField();
	textField_2.setForeground(new Color(0, 0, 102));
	textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
	textField_2.setDropMode(DropMode.INSERT);
	textField_2.setColumns(10);
	textField_2.setBounds(302, 101, 205, 37);
	getContentPane().add(textField_2);
	
    btnMenu = new JButton("Menu");
	btnMenu.setForeground(new Color(0, 0, 102));
	btnMenu.setFont(new Font("David", Font.BOLD, 28));
	btnMenu.setBackground(new Color(255, 153, 51));
	btnMenu.setBounds(214, 436, 204, 45);
	getContentPane().add(btnMenu);
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	this.setPreferredSize(new Dimension(1200,650));
	this.pack();
	}
}
