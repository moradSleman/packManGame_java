package giraffeView;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AdminQuestionFrm extends JFrame{
	public JButton btnDeleteQues;
	public JButton btnAddquestion;
	public JButton btnEditQues;
	public JButton btnAddBackTo;
	private JLabel lblPressOnThe;
	private JLabel lblToAccessYour;
	private JPanel contentPane;
	
	public AdminQuestionFrm() {
		setResizable(false);
		 initialize() ;

	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setForeground(new Color(25, 25, 112));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().setForeground(new Color(25, 25, 112));
		getContentPane().setLayout(null);
		
		btnDeleteQues = new JButton("");
		btnDeleteQues.setIcon(new ImageIcon(AdminQuestionFrm.class.getResource("/giraffeView/images/button_delete-question.png")));
		btnDeleteQues.setForeground(new Color(255, 153, 51));
		btnDeleteQues.setFont(new Font("David", Font.BOLD, 16));
		btnDeleteQues.setBackground(new Color(25, 25, 112));
		btnDeleteQues.setBounds(228, 282, 226, 48);
		contentPane.add(btnDeleteQues);
		
		btnAddquestion = new JButton("");
		btnAddquestion.setIcon(new ImageIcon(AdminQuestionFrm.class.getResource("/giraffeView/images/button_add-question.png")));
		btnAddquestion.setForeground(new Color(255, 153, 51));
		btnAddquestion.setFont(new Font("David", Font.BOLD, 16));
		btnAddquestion.setBackground(new Color(25, 25, 112));
		btnAddquestion.setBounds(228, 177, 226, 48);
		contentPane.add(btnAddquestion);
		
		btnEditQues = new JButton("");
		btnEditQues.setIcon(new ImageIcon(AdminQuestionFrm.class.getResource("/giraffeView/images/button_update-question.png")));
		btnEditQues.setForeground(new Color(255, 153, 51));
		btnEditQues.setFont(new Font("David", Font.BOLD, 16));
		btnEditQues.setBackground(new Color(25, 25, 112));
		btnEditQues.setBounds(251, 539, 226, 48);
		btnEditQues.setVisible(false);
		contentPane.add(btnEditQues);
		
		List numAns=new ArrayList();
		numAns.add(1);
		numAns.add(2);
		numAns.add(3);
		numAns.add(4);
		
		List levelAns=new ArrayList();
		levelAns.add("Easy");
		levelAns.add("Normal");
		levelAns.add("Hard");
		
		btnAddBackTo = new JButton("");
		btnAddBackTo.setIcon(new ImageIcon(AdminQuestionFrm.class.getResource("/giraffeView/images/buttonBack (2).png")));
		btnAddBackTo.setForeground(new Color(255, 153, 51));
		btnAddBackTo.setFont(new Font("David", Font.BOLD, 16));
		btnAddBackTo.setBackground(new Color(255, 255, 255));
		btnAddBackTo.setBounds(0, 626, 134, 39);
		contentPane.add(btnAddBackTo);
		
		lblPressOnThe = new JLabel("Press on the appropriate button");
		lblPressOnThe.setBackground(new Color(245, 222, 179));
		lblPressOnThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPressOnThe.setForeground(new Color(0, 0, 102));
		lblPressOnThe.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPressOnThe.setBounds(12, 13, 670, 76);
		contentPane.add(lblPressOnThe);
		
		lblToAccessYour = new JLabel("\r\n to access your functionality");
		lblToAccessYour.setBackground(new Color(245, 222, 179));
		lblToAccessYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblToAccessYour.setForeground(new Color(0, 0, 102));
		lblToAccessYour.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblToAccessYour.setBounds(22, 77, 670, 65);
		contentPane.add(lblToAccessYour);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AdminQuestionFrm.class.getResource("/giraffeView/images/pics/quest.png")));
		lblNewLabel.setBounds(602, 296, 180, 312);
		contentPane.add(lblNewLabel);
		this.setPreferredSize(new Dimension(800, 700));
		this.pack();
	}
}
