package giraffeView;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class ScoresHistoryPerPlayerFrm extends JFrame {
	public JButton btnBack;
	public JComboBox playerComboBox;
    public javax.swing.JScrollPane jScrollPane;
	public JTable table;
	
	public ScoresHistoryPerPlayerFrm() {
		setResizable(false);
		getContentPane().setFont(new Font("Dialog", Font.BOLD, 16));
		getContentPane().setForeground(new Color(25, 25, 112));
		getContentPane().setBackground(new Color(0, 0, 51));
		getContentPane().setLayout(null);
		
		
		JLabel lblHighScore = new JLabel("Choose Player");
		lblHighScore.setBackground(new Color(255, 245, 238));
		lblHighScore.setForeground(new Color(255, 204, 153));
		lblHighScore.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHighScore.setBounds(58, 109, 168, 45);
		getContentPane().add(lblHighScore);
		
		btnBack = new JButton("back");
		btnBack.setIcon(new ImageIcon(ScoresHistoryPerPlayerFrm.class.getResource("/giraffeView/images/buttonBack (2).png")));
		btnBack.setForeground(new Color(255, 240, 245));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setBounds(0, 720, 119, 45);
		getContentPane().add(btnBack);
		
		JLabel lblHighScoresHistory = new JLabel("Scores history ");
		lblHighScoresHistory.setForeground(new Color(255, 204, 153));
		lblHighScoresHistory.setFont(new Font("Forte", Font.BOLD, 24));
		lblHighScoresHistory.setBackground(new Color(255, 245, 238));
		lblHighScoresHistory.setBounds(152, 13, 239, 55);
		getContentPane().add(lblHighScoresHistory);
		
		JLabel lblA = new JLabel("a");
		lblA.setForeground(Color.ORANGE);
		lblA.setBounds(361, 30, 56, 16);
		getContentPane().add(lblA);
		
		playerComboBox = new JComboBox();
		playerComboBox.setBounds(233, 116, 262, 35);
		getContentPane().add(playerComboBox);
		    
		    
		    table =new JTable();
		    table.setBackground(new Color(255, 204, 153));
		    table.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
	        table.setFont(new Font("Times New Roman", Font.BOLD, 16)); // NOI18N
	        table.setForeground(new Color(0, 0, 51));
	        table.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	            },
	            new String [] {
	                "Score"
	            }
	        ));
	       
	        
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(58, 186,280, 431);
	        getContentPane().add(scrollPane);
	        
	        scrollPane.setViewportView(table);
	        
	        this.setPreferredSize(new Dimension(800,800));
			 this.pack();

		
	}
}
