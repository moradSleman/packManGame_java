package giraffeView;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

public class SettingFrm extends JFrame{
	public ButtonGroup bGDifficulty;
	public JRadioButton rdbtnOn;
	public JRadioButton rdbtnOff;
	public ButtonGroup bGMusic;
	public JButton btnBackToMenu;
	private JLabel lblSettings;
	public JRadioButton rdbtnHard;
	public JRadioButton rdbtnNormal;
	public JRadioButton rdbtnEasy;
	public SettingFrm() {
		setResizable(false);
		setBackground(new Color(255, 153, 102));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().setForeground(new Color(255, 153, 51));
		getContentPane().setBackground(new Color(0, 0, 51));
		getContentPane().setLayout(null);
		bGDifficulty = new ButtonGroup();
		 
		 JLabel lblMusic = new JLabel("music");
		 lblMusic.setBackground(new Color(25, 25, 112));
		 lblMusic.setForeground(new Color(255, 222, 173));
		 lblMusic.setFont(new Font("David", Font.BOLD, 26));
		 lblMusic.setBounds(73, 152, 120, 45);
		 getContentPane().add(lblMusic);
		 
		 rdbtnOn = new JRadioButton("On");
		 rdbtnOn.setFont(new Font("David", Font.BOLD, 16));
		 rdbtnOn.setForeground(new Color(255, 255, 255));
		 rdbtnOn.setBackground(new Color(0, 0, 51));
		 rdbtnOn.setBounds(107, 219, 99, 29);
		 getContentPane().add(rdbtnOn);
		 
		 rdbtnOff = new JRadioButton("Off");
		 rdbtnOff.setFont(new Font("David", Font.BOLD, 16));
		 rdbtnOff.setForeground(new Color(255, 255, 255));
		 rdbtnOff.setBackground(new Color(0, 0, 51));
		 rdbtnOff.setBounds(220, 219, 99, 29);
		 getContentPane().add(rdbtnOff);
		 
		 bGMusic =new ButtonGroup();
		 bGMusic.add(rdbtnOn);
		 bGMusic.add(rdbtnOff);
		 
		 btnBackToMenu = new JButton("back to menu");
		 btnBackToMenu.setIcon(new ImageIcon(SettingFrm.class.getResource("/giraffeView/images/buttonBack (2).png")));
		 btnBackToMenu.setForeground(new Color(0, 0, 102));
		 btnBackToMenu.setFont(new Font("David", Font.BOLD, 16));
		 btnBackToMenu.setBackground(new Color(255, 153, 51));
		 btnBackToMenu.setBounds(0, 530, 83, 35);
		 getContentPane().add(btnBackToMenu);
		 
		 lblSettings = new JLabel("Settings ");
		 lblSettings.setForeground(new Color(255, 222, 173));
		 lblSettings.setFont(new Font("David", Font.BOLD, 36));
		 lblSettings.setBackground(new Color(25, 25, 112));
		 lblSettings.setBounds(227, 13, 168, 45);
		 getContentPane().add(lblSettings);
		 
		 JLabel difficulty = new JLabel("defficulty");
		 difficulty.setForeground(new Color(255, 222, 173));
		 difficulty.setFont(new Font("David", Font.BOLD, 26));
		 difficulty.setBackground(new Color(25, 25, 112));
		 difficulty.setBounds(73, 283, 120, 45);
		 getContentPane().add(difficulty);
		 
		 rdbtnEasy = new JRadioButton("easy");
		 rdbtnEasy.setForeground(Color.WHITE);
		 rdbtnEasy.setFont(new Font("David", Font.BOLD, 16));
		 rdbtnEasy.setBackground(new Color(0, 0, 51));
		 rdbtnEasy.setBounds(72, 355, 99, 29);
		 getContentPane().add(rdbtnEasy);
		 
		 rdbtnNormal = new JRadioButton("normal");
		 rdbtnNormal.setSelected(true);
		 rdbtnNormal.setForeground(Color.WHITE);
		 rdbtnNormal.setFont(new Font("David", Font.BOLD, 16));
		 rdbtnNormal.setBackground(new Color(0, 0, 51));
		 rdbtnNormal.setBounds(192, 355, 99, 29);
		 getContentPane().add(rdbtnNormal);
		 
		 rdbtnHard = new JRadioButton("hard");
		 rdbtnHard.setForeground(Color.WHITE);
		 rdbtnHard.setFont(new Font("David", Font.BOLD, 16));
		 rdbtnHard.setBackground(new Color(0, 0, 51));
		 rdbtnHard.setBounds(318, 355, 99, 29);
		 getContentPane().add(rdbtnHard);
		 
		 bGDifficulty.add(rdbtnEasy);
		 bGDifficulty.add(rdbtnNormal);
		 bGDifficulty.add(rdbtnHard);
		 this.setPreferredSize(new Dimension(700, 600));
		 this.pack();
	}
}
