package giraffeView;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

/**
 * Class LogInFrm this the main page for the player 
 * will allow them to enter to the game page 
 * if he will enter the correct details for him that were saved in the json file 
 * for the players
 *
 */
@SuppressWarnings("serial")
public class LogInFrm extends JFrame {
	
	public JTextField textField;
	public  JPasswordField passwordField;
	public JButton btnLogIn;
	public JButton btnBack;
	public JButton btnSignUp;


	/**
	 * Create the application.
	 */
	public  LogInFrm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setResizable(false);
		this.getContentPane().setForeground(new Color(210, 105, 30));
		this.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 18));
		this.getContentPane().setBackground(new Color(0, 0, 51));
		this.getContentPane().setLayout(null);
		
		JLabel lblLogIn = new JLabel("");
		lblLogIn.setIcon(new ImageIcon(LogInFrm.class.getResource("/giraffeView/images/buttonLogin.png")));
		lblLogIn.setBounds(388, 14, 415, 57);
		lblLogIn.setForeground(new Color(255, 228, 181));
		lblLogIn.setFont(new Font("David", Font.BOLD, 42));
		this.getContentPane().add(lblLogIn);
		
		JLabel lblUserName = new JLabel("E-Mail");
		lblUserName.setBounds(29, 129, 129, 23);
		lblUserName.setForeground(new Color(255, 153, 51));
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 24));
		this.getContentPane().add(lblUserName);
		
		textField = new JTextField();
		textField.setBounds(230, 126, 375, 37);
		textField.setDropMode(DropMode.INSERT);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textField.setForeground(new Color(0, 0, 102));
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(19, 185, 139, 23);
		lblPassword.setForeground(new Color(255, 153, 51));
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		this.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(230, 182, 375, 37);
		passwordField.setForeground(new Color(0, 0, 102));
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		this.getContentPane().add(passwordField);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.setIcon(new ImageIcon(LogInFrm.class.getResource("/giraffeView/images/button_login.png")));
		btnLogIn.setBounds(117, 255, 204, 45);
		btnLogIn.setForeground(new Color(0, 0, 102));
		btnLogIn.setFont(new Font("David", Font.BOLD, 28));
		btnLogIn.setBackground(new Color(255, 153, 51));
		this.getContentPane().add(btnLogIn);
		
		JLabel lblYetNotRegistered = new JLabel("yet  not registered");
		lblYetNotRegistered.setBounds(185, 365, 239, 27);
		lblYetNotRegistered.setFont(new Font("David", Font.BOLD, 20));
		lblYetNotRegistered.setForeground(new Color(255, 153, 51));
		this.getContentPane().add(lblYetNotRegistered);
		
		 btnSignUp = new JButton("Sign Up");
		 btnSignUp.setIcon(new ImageIcon(LogInFrm.class.getResource("/giraffeView/images/button_signup (1).png")));
		 lblYetNotRegistered.setLabelFor(btnSignUp);
		 btnSignUp.setBackground(new Color(255, 153, 51));
		btnSignUp.setBounds(185, 396, 123, 45);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSignUp.setForeground(new Color(0, 0, 102));
		
		this.getContentPane().add(btnSignUp);
		
		 btnBack = new JButton("Back");
		 btnBack.setIcon(new ImageIcon(LogInFrm.class.getResource("/giraffeView/images/buttonBack.png")));
		 btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnBack.setBackground(new Color(255, 153, 51));
		 btnBack.setForeground(new Color(0, 0, 102));
		btnBack.setBounds(0, 582, 82, 33);
		this.getContentPane().add(btnBack);
		
		JLabel lblGif = new JLabel("");
		lblGif.setIcon(new ImageIcon(LogInFrm.class.getResource("/giraffeView/images/pacman-dribbble.gif")));
		lblGif.setBounds(622, 84, 534, 417);
		this.getContentPane().add(lblGif);
		this.setBounds(100, 100, 1196, 632);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setPreferredSize(new Dimension(1200,650));
		this.pack();
	}
	
}