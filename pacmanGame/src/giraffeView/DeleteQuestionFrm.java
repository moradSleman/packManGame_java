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
import javax.swing.ImageIcon;

/**
 * @author Hajar Amara
 *
 */
public class DeleteQuestionFrm extends JFrame {

	private JPanel contentPane;
	public JComboBox questionComboBox;
	public JButton deleteQuestion;
	public JButton btnBack;



	/**
	 * Create the frame.
	 */
	public DeleteQuestionFrm() {
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 382);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 153, 51));
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("choose Question");
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("David", Font.PLAIN, 24));
		label.setBounds(60, 108, 192, 43);
		contentPane.add(label);
		
		JLabel lblDeleteAQuestion = new JLabel("Delete  a Question");
		lblDeleteAQuestion.setForeground(new Color(0, 0, 102));
		lblDeleteAQuestion.setFont(new Font("David", Font.BOLD, 34));
		lblDeleteAQuestion.setBounds(246, 30, 297, 54);
		contentPane.add(lblDeleteAQuestion);
		
		questionComboBox = new JComboBox();
		questionComboBox.setForeground(new Color(0, 0, 128));
		questionComboBox.setFont(new Font("David", Font.PLAIN, 16));
		questionComboBox.setBackground(new Color(250, 240, 230));
		questionComboBox.setBounds(264, 117, 474, 33);
		contentPane.add(questionComboBox);
		
		deleteQuestion = new JButton("");
		deleteQuestion.setIcon(new ImageIcon(DeleteQuestionFrm.class.getResource("/giraffeView/images/button_delete-question.png")));
		deleteQuestion.setForeground(new Color(255, 153, 51));
		deleteQuestion.setFont(new Font("David", Font.BOLD, 22));
		deleteQuestion.setBackground(new Color(255, 250, 250));
		deleteQuestion.setBounds(172, 180, 297, 43);
		contentPane.add(deleteQuestion);
		
		btnBack = new JButton("Back to menu");
		btnBack.setIcon(new ImageIcon(DeleteQuestionFrm.class.getResource("/giraffeView/images/buttonBack (2).png")));
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setForeground(new Color(255, 153, 51));
		btnBack.setBounds(0, 310, 90, 43);
		contentPane.add(btnBack);
		this.setPreferredSize(new Dimension(800, 400));
		 this.pack();
	}

}
