package giraffeView;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class HighScoresFrm extends JFrame{
	public JButton btnBack;
	public JScrollPane scrollPane;
	public JTable table;
	
	public HighScoresFrm() {
		setResizable(false);
		getContentPane().setBackground(new Color(0, 0, 51));
		getContentPane().setLayout(null);
		
		btnBack = new JButton("back");
		btnBack.setIcon(new ImageIcon(HighScoresFrm.class.getResource("/giraffeView/images/buttonBack (2).png")));
		btnBack.setForeground(new Color(255, 153, 51));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBackground(new Color(0, 0, 102));
		btnBack.setBounds(0, 720, 99, 45);
		getContentPane().add(btnBack);
		
		JLabel lblHighScores = new JLabel("Up To Top Ten High Scores");
		lblHighScores.setForeground(new Color(255, 222, 173));
		lblHighScores.setFont(new Font("Forte", Font.BOLD, 24));
		lblHighScores.setBounds(124, 32, 322, 45);
		getContentPane().add(lblHighScores);
		
	    
	    table =new JTable();
	    table.setBackground(new Color(255, 204, 153));
	    table.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table.setFont(new Font("Times New Roman", Font.BOLD, 16)); // NOI18N
        table.setForeground(new Color(0, 0, 51));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Email","High Score"
            }
        ));
       
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(90, 107,469, 496);
        getContentPane().add(scrollPane);
        
        scrollPane.setViewportView(table);
        
		this.setPreferredSize(new Dimension(700, 800));
		 this.pack();
	}

}
