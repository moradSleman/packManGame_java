package giraffeView;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import giraffeModel.Constants;
import giraffeModel.MazeData;
import giraffeModel.Player;
import giraffeModel.Question;
import giraffeModel.RegularGhost;
import giraffeModel.Sugar;

import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Font;

@SuppressWarnings("serial")
public class MazeSecondPlayerFrm extends JFrame  {
//	private JPanel topPanel;
//	private JPanel bottomPanel;
//////////////////////////////////
	    private final JPanel rightPanel;       // container panel for the top
	    private JLabel lblPlayerName;
	    public JLabel lblContentQuestion;
	    public JLabel lblAnswer1;
	    public JLabel lblAnswer2;
	    public JLabel lblAnswer3;
	    public JLabel lblAnswer4;
	    public JLabel lbl_time;
	   public JLabel lbl_time_val;
	   public JLabel lblScoresValue;
	   public JLabel lblLivesValue;
	   private boolean isOnePlayer=false;
	   private boolean isLastRound=false;
	   private boolean gameOver=false;
	   private Integer level;
	   private Player player;
       TwoDArrayPanel twoDArrayPanel; 

	public MazeSecondPlayerFrm(boolean isLastRoud,boolean isOnePlayer,Player player,Constants.difficulty difficulty,ArrayList<Question> quesToChooseFrom,
			Integer lives,Integer Score,Integer level,String mapFile) {
		this.isOnePlayer=isOnePlayer;
		this.isLastRound=isLastRound;
		this.level=level;
		this.player=player;
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 16));
		getContentPane().setBackground(Color.black);
//		
//		this.getContentPane().add(contentPaneLeft);
//		this.getContentPane().add(twoDArrayPanel);
//		this.getContentPane().add(contentPaneRight);
//
		
	        
	        rightPanel=new JPanel();
	        rightPanel.setBounds(1923, 0, 1, 865);
	        rightPanel.setBackground(Color.black);
	        rightPanel.setPreferredSize(new Dimension(200, 800));
//	        innerCenter=new JPanel();
//	        innerCenter.setBackground(Color.black);
//	        System.out.println(twoDArrayPanel.getWidth());
	        /////
	        Border border = BorderFactory.createLineBorder(Color.ORANGE, 10);
	        Border border2= BorderFactory.createLineBorder(new Color(255, 204, 153),3);
	        
			///
	        JLabel label_Now_Playing_Name= new JLabel("  ") ;
	        label_Now_Playing_Name.setBorder(border);
	        label_Now_Playing_Name.setBackground(Color.BLACK);
	        label_Now_Playing_Name.setAlignmentX(CENTER_ALIGNMENT);
	        label_Now_Playing_Name.setForeground(new Color(8, 31, 68));
	        label_Now_Playing_Name.setFont(new Font("David", Font.BOLD, 24));
	        label_Now_Playing_Name.setBounds(293, 43, 240, 43);
	        rightPanel.setBackground(Color.BLACK);
	        /////
	        /////
	        //***//
	        /*************************************/
	        JLabel lblPlayerQuestion= new JLabel("Player Question") ;
	        lblPlayerQuestion.setBackground(Color.BLACK);
	        lblPlayerQuestion.setAlignmentX(CENTER_ALIGNMENT);
	        lblPlayerQuestion.setForeground(new Color(255, 160, 122));
	        lblPlayerQuestion.setFont(new Font("David", Font.BOLD, 24));
	        lblPlayerQuestion.setBounds(293, 43, 240, 43);
	        getContentPane().setLayout(null);
	        getContentPane().add(rightPanel);
	        
	        lbl_time= new JLabel("") ;
	        lbl_time.setBounds(1768, 13, 173, 48);
	        getContentPane().add(lbl_time);
	        lbl_time.setIcon(new ImageIcon(MazeFrm.class.getResource("/giraffeView/images/btnTime.png")));
	        lbl_time.setBackground(Color.BLACK);
	        lbl_time.setAlignmentX(CENTER_ALIGNMENT);
	        lbl_time.setForeground(new Color(255, 160, 122));
	        lbl_time.setFont(new Font("David", Font.BOLD, 18));
	        
	        lbl_time_val= new JLabel(" 0 ") ;
	        lbl_time_val.setBounds(1771, 84, 140, 44);
	        getContentPane().add(lbl_time_val);
	        lbl_time_val.setBorder(border2);
	        lbl_time_val.setBackground(Color.BLACK);
	        lbl_time_val.setAlignmentX(CENTER_ALIGNMENT);
	        lbl_time_val.setForeground(new Color(255, 204, 153));
	        lbl_time_val.setFont(new Font("Dialog", Font.BOLD, 30));
	        //
	       
	        /////
	       
	        lblPlayerName= new JLabel("Player ") ;
	        lblPlayerName.setBounds(18, 13, 244, 60);
	        getContentPane().add(lblPlayerName);
	        lblPlayerName.setBorder(border2);
	        lblPlayerName.setBackground(Color.BLACK);
	        lblPlayerName.setAlignmentX(CENTER_ALIGNMENT);
	        lblPlayerName.setForeground(new Color(255, 204, 153));
	        lblPlayerName.setFont(new Font("Forte", Font.BOLD, 36));
	        ////
	        JLabel lblScores= new JLabel("") ;
	        lblScores.setBounds(1758, 418, 173, 44);
	        getContentPane().add(lblScores);
	        lblScores.setIcon(new ImageIcon(MazeFrm.class.getResource("/giraffeView/images/btnScores.png")));
	        lblScores.setBackground(Color.BLACK);
	        lblScores.setAlignmentX(CENTER_ALIGNMENT);
	        lblScores.setForeground(new Color(8, 31, 68));
	        lblScores.setFont(new Font("David", Font.BOLD, 18));
	        ////
	        JLabel lblLives= new JLabel("") ;
	        lblLives.setBounds(1758, 550, 157, 44);
	        getContentPane().add(lblLives);
	        lblLives.setIcon(new ImageIcon(MazeFrm.class.getResource("/giraffeView/images/btnLives.png")));
	        lblLives.setBackground(Color.BLACK);
	        lblLives.setAlignmentX(CENTER_ALIGNMENT);
	        lblLives.setForeground(new Color(255, 160, 122));
	        lblLives.setFont(new Font("David", Font.BOLD, 18));
	        
	        lblScoresValue= new JLabel(" ") ;
	        lblScoresValue.setBounds(1758, 475, 140, 48);
	        getContentPane().add(lblScoresValue);
	        lblScoresValue.setBorder(border2);
	        lblScoresValue.setBackground(Color.BLACK);
	        lblScoresValue.setAlignmentX(CENTER_ALIGNMENT);
	        lblScoresValue.setForeground(new Color(255, 204, 153));
	        lblScoresValue.setFont(new Font("Dialog", Font.BOLD, 24));
	        ///
	        lblLivesValue= new JLabel("  ") ;
	        lblLivesValue.setBounds(1754, 607, 157, 48);
	        getContentPane().add(lblLivesValue);
	        lblLivesValue.setBorder(border2);
	        lblLivesValue.setBackground(Color.BLACK);
	        lblLivesValue.setAlignmentX(CENTER_ALIGNMENT);
	        lblLivesValue.setForeground(new Color(255, 204, 153));
	        lblLivesValue.setFont(new Font("Dialog", Font.BOLD, 24));
	        ////
	        lblContentQuestion= new JLabel(" Content the question") ;
	        lblContentQuestion.setBounds(13, 242, 381, 60);
	        getContentPane().add(lblContentQuestion);
	        lblContentQuestion.setBorder(border2);
	        lblContentQuestion.setBackground(Color.BLACK);
	        lblContentQuestion.setAlignmentX(CENTER_ALIGNMENT);
	        lblContentQuestion.setForeground(new Color(255, 160, 122));
	        lblContentQuestion.setFont(new Font("Constantia", Font.BOLD, 20));
	        
	        lblAnswer1= new JLabel("ans1 ") ;
	        lblAnswer1.setBounds(19, 338, 79, 48);
	        getContentPane().add(lblAnswer1);
	        lblAnswer1.setBorder(border2);
	        lblAnswer1.setBackground(Color.BLACK);
	        lblAnswer1.setAlignmentX(CENTER_ALIGNMENT);
	        lblAnswer1.setForeground(new Color(0, 0, 255));
	        lblAnswer1.setFont(new Font("Constantia", Font.BOLD, 16));
	        ////
	        lblAnswer2= new JLabel("ans2  ") ;
	        lblAnswer2.setBounds(19, 414, 79, 48);
	        getContentPane().add(lblAnswer2);
	        lblAnswer2.setBorder(border2);
	        lblAnswer2.setBackground(Color.BLACK);
	        lblAnswer2.setAlignmentX(CENTER_ALIGNMENT);
	        lblAnswer2.setForeground(Color.ORANGE);
	        lblAnswer2.setFont(new Font("Constantia", Font.BOLD, 16));
	        ///
	        lblAnswer3= new JLabel("ans3") ;
	        lblAnswer3.setBounds(18, 491, 80, 48);
	        getContentPane().add(lblAnswer3);
	        lblAnswer3.setBorder(border2);
	        lblAnswer3.setBackground(Color.BLACK);
	        lblAnswer3.setAlignmentX(CENTER_ALIGNMENT);
	        lblAnswer3.setForeground(Color.PINK);
	        lblAnswer3.setFont(new Font("Constantia", Font.BOLD, 16));
	        
	        lblAnswer4= new JLabel("ans4") ;
	        lblAnswer4.setBounds(18, 552, 80, 48);
	        getContentPane().add(lblAnswer4);
	        lblAnswer4.setBorder(border2);
	        lblAnswer4.setBackground(Color.BLACK);
	        lblAnswer4.setAlignmentX(CENTER_ALIGNMENT);
	        lblAnswer4.setForeground(Color.RED);
	        lblAnswer4.setFont(new Font("Constantia", Font.BOLD, 16));
	        ////
	        this.lblScoresValue.setText(Score.toString());
	        this.lblLivesValue.setText(lives.toString());
			////
			this.setResizable(false);
            this.setPreferredSize(new Dimension(2000,1000));
//           this.setMinimumSize(t.getMinimumSize());   // cannot be resized-
	        this.pack();
	        this.lblPlayerName.setText(player.getPlayerUserName().toString());
	        twoDArrayPanel = new TwoDArrayPanel(player,difficulty,quesToChooseFrom,mapFile);
	        twoDArrayPanel.setPreferredSize(new Dimension(1400, 900));
	        twoDArrayPanel.setBounds(405, 0, 1341, 865);
	        getContentPane().add(twoDArrayPanel);
	        
	        JButton button = new JButton("");
	        button.setIcon(new ImageIcon(MazeSecondPlayerFrm.class.getResource("/giraffeView/images/button_play.png")));
	        button.setFont(new Font("David", Font.BOLD, 22));
	        button.setBackground(Color.BLACK);
	        button.setAlignmentX(0.5f);
	        button.setBounds(1160, 887, 291, 78);
	        getContentPane().add(button);
	        addActionKeyToPlay();
	        this.setFocusable(true);
}
	
	public void runGhosts() {
		for(RegularGhost rg: twoDArrayPanel.getMazeData().getRegularGhosts()) {
			rg.setMazeSecondPlayerFrm(MazeSecondPlayerFrm.this);
			rg.setMazeMatrix(twoDArrayPanel.getMazeData().getMazeMatrix());
			new Thread(rg).start();
		}
	}

	public void addActionKeyToPlay() {
		 this.addKeyListener(new KeyAdapter() {
			 
		        
				@SuppressWarnings("static-access")
				public void keyPressed(KeyEvent event) {

					int keyCode = event.getKeyCode();

					
					if(keyCode==event.VK_LEFT) {
						
						Object objReturned;
						objReturned=twoDArrayPanel.getMazeData().movePackManLeft();
						updateInfo(objReturned);
						twoDArrayPanel.repaint();
					}
					else
						if(keyCode==event.VK_RIGHT) {
							Object objReturned;
							objReturned=twoDArrayPanel.getMazeData().movePackManRight();
							updateInfo(objReturned);
							twoDArrayPanel.repaint();
						}
						else
							if(keyCode==event.VK_UP) {
								Object objReturned;
								objReturned=twoDArrayPanel.getMazeData().movePackManUp();
								updateInfo(objReturned);
								twoDArrayPanel.repaint();
							}
							else
								if(keyCode==event.VK_DOWN) {
									Object objReturned;
									objReturned=twoDArrayPanel.getMazeData().movePackManDown();
									updateInfo(objReturned);
									twoDArrayPanel.repaint();
								}
				}
			});
	}
	public void updateInfo(Object objReturned) {
	if(objReturned instanceof Question) {
		MazeSecondPlayerFrm.this.lblContentQuestion.setText(((Question)objReturned).getQuestion());
		if(((Question)objReturned).getAnswers().size()>0) {
		this.lblAnswer1.setText(((Question)objReturned).getAnswers().get(0).toString());
		this.lblAnswer2.setText(((Question)objReturned).getAnswers().get(1).toString());
		this.lblAnswer3.setText(((Question)objReturned).getAnswers().get(2).toString());
		this.lblAnswer4.setText(((Question)objReturned).getAnswers().get(3).toString());
		}
		for(RegularGhost rg: twoDArrayPanel.getMazeData().getRegularGhosts()) {
			rg.setMazeSecondPlayerFrm(MazeSecondPlayerFrm.this);
			rg.setMazeMatrix(twoDArrayPanel.getMazeData().getMazeMatrix());
			new Thread(rg).start();
		}
	}
	else
	if(objReturned instanceof String && gameOver==false) {
		if(objReturned==Constants.SugarType.YellowSugar.toString()) {
			twoDArrayPanel.getMazeData().getPacMan().addPoints(1);
			lblScoresValue.setText((twoDArrayPanel.getMazeData().getPacMan().getTotalPoints()).toString());
			return;
		}
		else
			if(objReturned.equals(Constants.SugarType.BadSugar.toString())) {
				twoDArrayPanel.getMazeData().getPacMan().setTotalPoints(0);
				lblScoresValue.setText(twoDArrayPanel.getMazeData().getPacMan().getTotalPoints().toString());
				if(twoDArrayPanel.getMazeData().getPacMan().getLives()>0)
				{	
					twoDArrayPanel.getMazeData().getPacMan().takeLife();
					MazeSecondPlayerFrm.this.lblLivesValue.setText(twoDArrayPanel.getMazeData().getPacMan().getLives().toString());
					return;
				}
				else
				{
					gameOver=true;
					JOptionPane.showConfirmDialog(MazeSecondPlayerFrm.this,"game Over wait until time end!");
					return;
				}
			}
			else
				if(objReturned.equals(Constants.SugarType.MoneySugar.toString())) {
					twoDArrayPanel.getMazeData().getPacMan().addPoints(50);
					lblScoresValue.setText(twoDArrayPanel.getMazeData().getPacMan().getTotalPoints().toString());
					return;
				}
			
				else
					if(objReturned.equals("RegularGhost")) {
						if((Integer.parseInt(MazeSecondPlayerFrm.this.lblLivesValue.getText()))>0)
						{
							twoDArrayPanel.getMazeData().getPacMan().takeLife();
							MazeSecondPlayerFrm.this.lblLivesValue.setText(twoDArrayPanel.getMazeData().getPacMan().getLives().toString());
							return;
						}
						else
						{

							gameOver=true;
							JOptionPane.showConfirmDialog(MazeSecondPlayerFrm.this,"game Over wait until time end!");
							return;
						}
						
					}
					else
						if(objReturned.equals(Constants.AnswerStatus.True)) {
							if(level==1) {
								twoDArrayPanel.getMazeData().getPacMan().addPoints(100);
								this.lblScoresValue.setText(twoDArrayPanel.getMazeData().getPacMan().getTotalPoints().toString());
							}
							if(level==2) {
								twoDArrayPanel.getMazeData().getPacMan().addPoints(200);
								this.lblScoresValue.setText(twoDArrayPanel.getMazeData().getPacMan().getTotalPoints().toString());
							}
							if(level==3) {
								twoDArrayPanel.getMazeData().getPacMan().addPoints(500);
								this.lblScoresValue.setText(twoDArrayPanel.getMazeData().getPacMan().getTotalPoints().toString());
							}
						}
						else
							if(objReturned.equals(Constants.AnswerStatus.False)) {
								if(level==1) {
									twoDArrayPanel.getMazeData().getPacMan().addPoints(-250);
									this.lblScoresValue.setText(twoDArrayPanel.getMazeData().getPacMan().getTotalPoints().toString());
								}
								if(level==2) {
									twoDArrayPanel.getMazeData().getPacMan().addPoints(-100);
									this.lblScoresValue.setText(twoDArrayPanel.getMazeData().getPacMan().getTotalPoints().toString());
								}
								if(level==3) {
									twoDArrayPanel.getMazeData().getPacMan().addPoints(-50);
									this.lblScoresValue.setText(twoDArrayPanel.getMazeData().getPacMan().getTotalPoints().toString());
								}
							}
	}
	}
	public void finishGame() {
		
	}
	public TwoDArrayPanel getTwoDArrayPanel() {
		return twoDArrayPanel;
	}


	public void setTwoDArrayPanel(TwoDArrayPanel twoDArrayPanel) {
		this.twoDArrayPanel = twoDArrayPanel;
	}
}