/**
 * 
 */
package giraffeView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

/**
 * @author Hajar Amara
 *
 */
public class UpdateQuestionFrm extends JFrame {

	private JPanel contentPane;
	public JComboBox questioncomboBox ;
	public JButton edit_button;
	public JComboBox answerComboBox;
	public JTextPane teamTxt;
	public JTextPane answer1_txt ;
	public JTextPane answer2_txt ;
	public JTextPane answer3_txt ;
	public JTextPane answer4_txt ;
	public JComboBox levelCombox;
	public JLabel lblUpdateAQuestion ;
	public JLabel lblUpdateAnAnswer;
	public JButton backbtn;



	/**
	 * Create the frame.
	 */
	public UpdateQuestionFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 642);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		questioncomboBox = new JComboBox();
		questioncomboBox .setForeground(new Color(0, 0, 51));
		questioncomboBox .setFont(new Font("David", Font.PLAIN, 16));
		questioncomboBox .setBackground(new Color(255, 255, 255));
		questioncomboBox .setBounds(241, 87, 531, 33);
		contentPane.add( questioncomboBox );
		
		JLabel label = new JLabel("choose Question");
		label.setForeground(new Color(0, 0, 51));
		label.setFont(new Font("David", Font.PLAIN, 20));
		label.setBounds(37, 77, 158, 43);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("true answer number");
		label_1.setForeground(new Color(0, 0, 51));
		label_1.setFont(new Font("David", Font.PLAIN, 20));
		label_1.setBounds(37, 131, 192, 43);
		contentPane.add(label_1);
		
		answerComboBox = new JComboBox();
		answerComboBox .setForeground(new Color(0, 0, 51));
		answerComboBox .setFont(new Font("David", Font.PLAIN, 16));
		answerComboBox .setBackground(new Color(255, 255, 255));
		answerComboBox .setBounds(241, 131, 240, 33);
		contentPane.add(answerComboBox );
		
		edit_button = new JButton("");
		edit_button.setIcon(new ImageIcon(UpdateQuestionFrm.class.getResource("/giraffeView/images/button_update-question.png")));
		edit_button.setForeground(new Color(0, 0, 51));
		edit_button.setFont(new Font("David", Font.BOLD, 22));
		edit_button.setBackground(new Color(255, 153, 51));
		edit_button.setBounds(241, 470, 240, 48);
		contentPane.add(edit_button);
		
		teamTxt = new JTextPane();
		teamTxt.setForeground(new Color(0, 0, 51));
		teamTxt.setFont(new Font("David", Font.PLAIN, 16));
		teamTxt.setText("team name");
		teamTxt.setBackground(new Color(255, 204, 153));
		teamTxt.setBounds(37, 418, 250, 33);
		contentPane.add(teamTxt);
		
	    answer3_txt = new JTextPane();
		answer3_txt.setForeground(new Color(0, 0, 51));
		answer3_txt.setFont(new Font("David", Font.PLAIN, 16));
		answer3_txt.setBackground(new Color(255, 204, 153));
		answer3_txt.setBounds(334, 234, 240, 33);
		contentPane.add(answer3_txt);
		
		answer2_txt = new JTextPane();
		answer2_txt.setText("\r\n");
		answer2_txt.setForeground(new Color(0, 0, 51));
		answer2_txt.setFont(new Font("David", Font.PLAIN, 16));
		answer2_txt.setBackground(new Color(255, 204, 153));
		answer2_txt.setBounds(37, 288, 240, 33);
		contentPane.add(answer2_txt);
		
	    answer1_txt = new JTextPane();
		answer1_txt.setForeground(new Color(0, 0, 51));
		answer1_txt.setFont(new Font("David", Font.PLAIN, 16));
		answer1_txt.setBackground(new Color(255, 204, 153));
		answer1_txt.setBounds(37, 234, 240, 33);
		contentPane.add(answer1_txt);
		
	    answer4_txt = new JTextPane();
		answer4_txt.setForeground(new Color(0, 0, 51));
		answer4_txt.setFont(new Font("David", Font.PLAIN, 16));
		answer4_txt.setBackground(new Color(255, 204, 153));
		answer4_txt.setBounds(334, 288, 240, 33);
		contentPane.add(answer4_txt);
		
		levelCombox = new JComboBox();
		levelCombox.setModel(new DefaultComboBoxModel(new String[] {"Level"}));
		levelCombox.setForeground(new Color(0, 0, 51));
		levelCombox.setFont(new Font("David", Font.PLAIN, 16));
		levelCombox.setBackground(new Color(255, 255, 255));
		levelCombox.setBounds(37, 361, 250, 33);
		contentPane.add(levelCombox);
		
		lblUpdateAQuestion = new JLabel("Edit a Question");
		lblUpdateAQuestion.setForeground(new Color(0, 0, 102));
		lblUpdateAQuestion.setFont(new Font("David", Font.BOLD, 36));
		lblUpdateAQuestion.setBounds(241, 13, 240, 43);
		contentPane.add(lblUpdateAQuestion);
		
		
		lblUpdateAnAnswer = new JLabel("Update an answer");
		lblUpdateAnAnswer.setForeground(new Color(0, 0, 51));
		lblUpdateAnAnswer.setFont(new Font("David", Font.PLAIN, 20));
		lblUpdateAnAnswer.setBounds(37, 178, 240, 43);
		contentPane.add(lblUpdateAnAnswer);
		
	    backbtn = new JButton("Back to menu");
	    backbtn.setIcon(new ImageIcon(UpdateQuestionFrm.class.getResource("/giraffeView/images/buttonBack (2).png")));
	    backbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    backbtn.setBackground(new Color(255, 255, 255));
		backbtn.setBounds(0, 562, 85, 33);
		contentPane.add(backbtn);
		this.setPreferredSize(new Dimension(800, 650));
		 this.pack();
	}

}
