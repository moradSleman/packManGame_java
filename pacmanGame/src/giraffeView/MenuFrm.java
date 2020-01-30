package giraffeView;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MenuFrm extends JFrame{
	public JButton btnEditQuestions;
	public JButton btnSetting;
	public JButton btnTop10;
	public JButton btnShowPerPlayer;
	public JButton btnStartGame;
	public JButton btnLogOut;
	public JButton btnJoinSecondPlayer;
	public JButton btnLogAsAdmin;
	private JLabel lblBorder1;
	private JLabel label;
	public MenuFrm() {
		setResizable(false);

		getContentPane().setBackground(new Color(0, 0, 51));
		
		btnEditQuestions = new JButton("Edit  & Delete Questions");
		btnEditQuestions.setBounds(31, 419, 315, 45);
		btnEditQuestions.setForeground(new Color(255, 153, 0));
		btnEditQuestions.setFont(new Font("Forte", Font.BOLD, 20));
		btnEditQuestions.setBackground(new Color(0, 0, 51));
		btnEditQuestions.setVisible(false);
		
		btnSetting = new JButton("Music and defficulty Settings");
		btnSetting.setBounds(426, 419, 315, 45);
		btnSetting.setForeground(new Color(0, 0, 51));
		btnSetting.setFont(new Font("Forte", Font.BOLD, 20));
		btnSetting.setBackground(new Color(255, 153, 51));
		btnSetting.setBorder(BorderFactory.createBevelBorder(2));
		
		btnTop10 = new JButton("Show Top Ten players");
		btnTop10.setBounds(426, 490, 315, 45);
		btnTop10.setForeground(new Color(0, 0, 51));
		btnTop10.setFont(new Font("Forte", Font.BOLD, 20));
		btnTop10.setBackground(new Color(255, 153, 51));
		btnTop10.setBorder(BorderFactory.createBevelBorder(2));
		
		btnShowPerPlayer = new JButton("Show History per player");
		btnShowPerPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShowPerPlayer.setBorder(BorderFactory.createBevelBorder(2));
		btnShowPerPlayer.setBounds(426, 566, 315, 45);
		btnShowPerPlayer.setForeground(new Color(0, 0, 51));
		btnShowPerPlayer.setFont(new Font("Forte", Font.BOLD, 20));
		btnShowPerPlayer.setBackground(new Color(255, 153, 51));
		
		btnStartGame = new JButton("Start game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStartGame.setBorder(BorderFactory.createBevelBorder(4));
		btnStartGame.setBounds(426, 253, 315, 45);
		btnStartGame.setForeground(new Color(0, 0, 51));
		btnStartGame.setFont(new Font("Forte", Font.BOLD, 20));
		btnStartGame.setBackground(new Color(255, 153, 51));
		
		btnLogOut = new JButton("log out");
		btnLogOut.setIcon(new ImageIcon(MenuFrm.class.getResource("/giraffeView/images/images/pics/logoutSmall.png")));
		btnLogOut.setBounds(12, 707, 156, 45);
		btnLogOut.setForeground(new Color(255, 153, 0));
		btnLogOut.setFont(new Font("Forte", Font.BOLD, 20));
		btnLogOut.setBackground(new Color(0, 0, 51));
		
		JLabel lblGameMenu = new JLabel("Menu");
		lblGameMenu.setBounds(513, 188, 139, 50);
		lblGameMenu.setFont(new Font("Forte", Font.BOLD, 48));
		lblGameMenu.setForeground(new Color(255, 153, 51));
		getContentPane().setLayout(null);
		getContentPane().add(btnEditQuestions);
		getContentPane().add(btnSetting);
		getContentPane().add(btnTop10);
		getContentPane().add(btnShowPerPlayer);
		getContentPane().add(btnLogOut);
		getContentPane().add(lblGameMenu);
		getContentPane().add(btnStartGame);
		
		btnJoinSecondPlayer = new JButton("Join Second Player");
		btnJoinSecondPlayer.setForeground(new Color(0, 0, 51));
		btnJoinSecondPlayer.setFont(new Font("Forte", Font.BOLD, 20));
		btnJoinSecondPlayer.setBackground(new Color(255, 153, 51));
		btnJoinSecondPlayer.setBounds(426, 335, 315, 45);
		btnJoinSecondPlayer.setBorder(BorderFactory.createBevelBorder(2));
		getContentPane().add(btnJoinSecondPlayer);
		
		btnLogAsAdmin = new JButton("Log as Admin");
		btnLogAsAdmin.setForeground(new Color(255, 153, 51));
		btnLogAsAdmin.setFont(new Font("Forte", Font.BOLD, 20));
		btnLogAsAdmin.setBackground(new Color(0, 0, 51));
		btnLogAsAdmin.setBounds(31, 361, 315, 45);
		getContentPane().add(btnLogAsAdmin);
		
		Border compound1,compound2, raisedbevel, loweredbevel;
		Border redline = BorderFactory.createLineBorder(Color.ORANGE);
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		compound1 = BorderFactory.createCompoundBorder(
				  raisedbevel, loweredbevel);
		compound2 = BorderFactory.createCompoundBorder(
				  redline, compound1);
		
		JLabel lblBorder2 = new JLabel("");
		lblBorder2.setBounds(400, 174, 366, 470);
		lblBorder2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		getContentPane().add(lblBorder2);
		
		lblBorder1 = new JLabel("");
		lblBorder1.setBounds(12, 279, 354, 241);
		lblBorder1.setBorder(compound2);
		
		getContentPane().add(lblBorder1);
		
		JLabel lblAdminSide = new JLabel("Admin Side");
		lblAdminSide.setFont(new Font("Forte", Font.BOLD, 26));
		lblAdminSide.setForeground(new Color(255, 153, 51));
		lblAdminSide.setBackground(new Color(0, 0, 51));
		lblAdminSide.setBounds(142, 295, 145, 36);
		getContentPane().add(lblAdminSide);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(MenuFrm.class.getResource("/giraffeView/images/pacman.png")));
		label.setBounds(94, 26, 386, 94);
		getContentPane().add(label);
		
		 this.setPreferredSize(new Dimension(800, 800));
		 this.pack();


	}
}
