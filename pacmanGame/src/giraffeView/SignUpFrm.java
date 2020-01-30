package giraffeView;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

/**
 * Class  SignUpFrm this theRegisteration page page for the player 
 * will allow them to write his E-Mail and password 
 *
 */
@SuppressWarnings("serial")
public class SignUpFrm extends JFrame{
	public JTextField txtEmail;
	public JButton btnSignUp;
	public JLabel label;
	public JPasswordField passwordField;
	public JLabel lblConfirmPassword;
	public JPasswordField passwordField_1;
	public JLabel lblEmail;
	public JButton btnBack;
	public JButton btnLogIn;
	private JLabel label_1;
	
	public SignUpFrm() {
		setResizable(false);
		getContentPane().setForeground(new Color(255, 165, 0));
		getContentPane().setBackground(new Color(0, 0, 51));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create a new Account");
	//	lblNewLabel.setIcon(new ImageIcon(SignUpFrm.class.getResource("/giraffeView/images/ghostorange2.png")));
		lblNewLabel.setForeground(new Color(255, 153, 51));
		lblNewLabel.setFont(new Font("David", Font.BOLD, 36));
		lblNewLabel.setBounds(310, 13, 441, 84);
		getContentPane().add(lblNewLabel);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("David", Font.BOLD, 24));
		txtEmail.setColumns(10);
		txtEmail.setBackground(new Color(240, 248, 255));
		txtEmail.setBounds(242, 123, 364, 37);
		getContentPane().add(txtEmail);
		
		btnSignUp = new JButton("sign up");
		btnSignUp.setIcon(new ImageIcon(SignUpFrm.class.getResource("/giraffeView/images/buttonSignUp.png")));
		btnSignUp.setFont(new Font("David", Font.BOLD, 24));
		btnSignUp.setForeground(new Color(25, 25, 112));
		btnSignUp.setBackground(new Color(255, 153, 51));
		btnSignUp.setBounds(156, 359, 209, 65);
		getContentPane().add(btnSignUp);
		
		label = new JLabel("Password");
		label.setForeground(new Color(255, 165, 0));
		label.setFont(new Font("Times New Roman", Font.BOLD, 22));
		label.setBounds(40, 210, 139, 23);
		getContentPane().add(label);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 0, 139));
		passwordField.setFont(new Font("David", Font.BOLD, 24));
		passwordField.setBounds(242, 196, 364, 44);
		getContentPane().add(passwordField);
		
		lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(new Color(255, 165, 0));
		lblConfirmPassword.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblConfirmPassword.setBounds(40, 290, 191, 23);
		getContentPane().add(lblConfirmPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setForeground(new Color(0, 0, 139));
		passwordField_1.setFont(new Font("David", Font.BOLD, 24));
		passwordField_1.setBounds(242, 276, 364, 44);
		getContentPane().add(passwordField_1);
		
		lblEmail = new JLabel("User Email");
		lblEmail.setForeground(new Color(255, 165, 0));
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblEmail.setBounds(40, 130, 139, 23);
		getContentPane().add(lblEmail);
		
		JLabel lblHaveAnAccount = new JLabel("have an account");
		lblHaveAnAccount.setForeground(new Color(255, 153, 51));
		lblHaveAnAccount.setFont(new Font("David", Font.BOLD, 20));
		lblHaveAnAccount.setBounds(43, 447, 164, 23);
		getContentPane().add(lblHaveAnAccount);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.setIcon(new ImageIcon(SignUpFrm.class.getResource("/giraffeView/images/loginBtn.png")));
		btnLogIn.setBackground(new Color(255, 153, 51));
		btnLogIn.setForeground(new Color(0, 0, 128));
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogIn.setBounds(40, 471, 124, 37);
		getContentPane().add(btnLogIn);
		
		btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(SignUpFrm.class.getResource("/giraffeView/images/button_back1.png")));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBackground(new Color(255, 153, 51));
		btnBack.setBounds(0, 571, 84, 44);
		getContentPane().add(btnBack);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SignUpFrm.class.getResource("/giraffeView/images/pacman-dribbble.gif")));
		label_1.setBounds(682, 95, 452, 448);
		getContentPane().add(label_1);
		setBackground(Color.BLACK);
		
		this.setPreferredSize(new Dimension(1200, 650));
		 this.pack();
	}
}
