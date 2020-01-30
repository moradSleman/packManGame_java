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

import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.TextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

/**
 * @author Hajar Amara
 *
 */
@SuppressWarnings("serial")
public class AddQuestionFrm extends JFrame {

	private JPanel contentPane;
	public JTextPane answertxt1;
	public JTextPane answertxt2;
	public JTextPane answertxt3;
	public JTextPane answertxt4;
	public JTextPane teamTxt;
	@SuppressWarnings("rawtypes")
	public JComboBox answerQuestionCombox ;
	public JComboBox levelCombox;
	public JButton btnBack ;
	public JButton btnAdd;
	public TextField questionText ;
	private JLabel lblNewLabel;



	/**
	 * Create the frame.
	 */
	public AddQuestionFrm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1038, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterNewInsert = new JLabel("Insert a new Question");
		lblEnterNewInsert.setForeground(new Color(0, 0, 102));
		lblEnterNewInsert.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEnterNewInsert.setBounds(218, 0, 355, 43);
		contentPane.add(lblEnterNewInsert);
		
		JLabel lblInsertTheAnswers = new JLabel("Insert the Answers at least two answers up to 4 answers");
		lblInsertTheAnswers.setForeground(new Color(0, 0, 51));
		lblInsertTheAnswers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInsertTheAnswers.setBounds(31, 169, 506, 43);
		contentPane.add(lblInsertTheAnswers);
		
		answertxt1 = new JTextPane();
		answertxt1.setForeground(new Color(0, 0, 51));
		answertxt1.setFont(new Font("David", Font.BOLD, 16));
		answertxt1.setBackground(new Color(250, 240, 230));
		answertxt1.setBounds(31, 214, 273, 43);
		contentPane.add(answertxt1);
		
		answertxt3 = new JTextPane();
		answertxt3.setForeground(new Color(0, 0, 51));
		answertxt3.setFont(new Font("David", Font.BOLD, 16));
		answertxt3.setBackground(new Color(250, 240, 230));
		answertxt3.setBounds(337, 216, 272, 43);
		contentPane.add(answertxt3);
		
	    teamTxt = new JTextPane();
		teamTxt.setText("team name");
		teamTxt.setForeground(new Color(0, 0, 51));
		teamTxt.setFont(new Font("David", Font.BOLD, 16));
		teamTxt.setBackground(new Color(250, 240, 230));
		teamTxt.setBounds(31, 447, 273, 43);
		contentPane.add(teamTxt);
		
		answertxt2 = new JTextPane();
		answertxt2.setForeground(new Color(0, 0, 51));
		answertxt2.setFont(new Font("David", Font.BOLD, 16));
		answertxt2.setBackground(new Color(250, 240, 230));
		answertxt2.setBounds(31, 270, 273, 43);
		contentPane.add(answertxt2);
		
		answertxt4 = new JTextPane();
		answertxt4.setForeground(new Color(0, 0, 51));
		answertxt4.setFont(new Font("David", Font.BOLD, 16));
		answertxt4.setBackground(new Color(250, 240, 230));
		answertxt4.setBounds(337, 272, 272, 43);
		contentPane.add(answertxt4);
		
		answerQuestionCombox = new JComboBox();
		answerQuestionCombox.setForeground(new Color(0, 0, 51));
		answerQuestionCombox.setFont(new Font("David", Font.PLAIN, 16));
		answerQuestionCombox.setBackground(new Color(250, 240, 230));
		answerQuestionCombox.setBounds(31, 372, 273, 48);
		contentPane.add(answerQuestionCombox);
		
		
		levelCombox = new JComboBox();
		levelCombox.setForeground(new Color(0, 0, 51));
		levelCombox.setFont(new Font("David", Font.PLAIN, 16));
		levelCombox.setBackground(new Color(250, 240, 230));
		levelCombox.setBounds(336, 372, 273, 48);
		contentPane.add(levelCombox);
		
		btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(AddQuestionFrm.class.getResource("/giraffeView/images/button_add-question.png")));
		btnAdd.setForeground(new Color(0, 0, 51));
		btnAdd.setFont(new Font("David", Font.BOLD, 24));
		btnAdd.setBackground(new Color(255, 160, 122));
		btnAdd.setBounds(256, 513, 281, 43);
		contentPane.add(btnAdd);
		
		questionText = new TextField();
		questionText.setBackground(new Color(250, 240, 230));
		questionText.setForeground(new Color(0, 0, 51));
		questionText.setFont(new Font("David", Font.PLAIN, 16));
		questionText.setBounds(31, 74, 785, 89);
		contentPane.add(questionText);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(838, 430, -437, -32);
		separator.setBackground(Color.RED);
		contentPane.add(separator);
		
		JLabel lblQuestionContent = new JLabel("Question content");
		lblQuestionContent.setForeground(new Color(0, 0, 51));
		lblQuestionContent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuestionContent.setBounds(31, 30, 147, 43);
		contentPane.add(lblQuestionContent);
		
		btnBack = new JButton("Back to menu");
		btnBack.setIcon(new ImageIcon(AddQuestionFrm.class.getResource("/giraffeView/images/buttonBack (2).png")));
		btnBack.setForeground(new Color(255, 153, 51));
		btnBack.setBounds(0, 575, 84, 36);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddQuestionFrm.class.getResource("/giraffeView/images/pics/question-mark-1020004__340.jpg")));
		lblNewLabel.setBounds(621, 270, 299, 326);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose the number the true answer");
		lblNewLabel_1.setBounds(31, 340, 227, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblChooseGameLevel = new JLabel("Choose game level");
		lblChooseGameLevel.setBounds(337, 340, 227, 19);
		contentPane.add(lblChooseGameLevel);
		 this.setPreferredSize(new Dimension(950, 650));
		 this.pack();

	}
}
