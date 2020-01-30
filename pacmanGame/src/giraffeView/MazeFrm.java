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

import giraffeController.SysData;
import giraffeModel.Constants;
import giraffeModel.MazeData;
import giraffeModel.PacMan;
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
public class MazeFrm extends JFrame  {
//	private JPanel topPanel;
//	private JPanel bottomPanel;
//////////////////////////////////
	    private final JPanel rightPanel;       // container panel for the top
	    private JLabel lblPlayerName;
	    private TwoDArrayPanel twoDArrayPanel;
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
	   private boolean isPlayerdied=false;
	public MazeFrm(boolean isLastRoud,boolean isOnePlayer,Player player,Constants.difficulty difficulty,ArrayList<Question> quesToChooseFrom,
			Integer lives,Integer Score,Integer level,String mapFile) {
		this.isOnePlayer=isOnePlayer;
		this.isLastRound=isLastRound;
		this.level=level;
		this.player=player;
		getContentPane().setFont(new Font("Forte", Font.BOLD, 16));

//		topPanel=new JPanel();
//		bottomPanel=new JPanel();
//
//		//this.contentPane.setLayout(new BorderLayout(10, 10));
//		this.getContentPane().setLayout(new GridLayout());
//		 //this.setResizable(true);
//		// this.setPreferredSize(new Dimension(1000,1500));
		twoDArrayPanel = new TwoDArrayPanel(player,difficulty,quesToChooseFrom,mapFile);
		twoDArrayPanel.setBounds(180, 0, 1341, 865);
		twoDArrayPanel.setPreferredSize(new Dimension(1000, 700));
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
	        ///

//	        rightPanel.setPreferredSize(new Dimension(1800,twoDArrayPanel.getHeight() ));
//	        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
//	        innerCenter.add(rightPanel);
//	        splitPane.setBottomComponent(bottomPanel);
//	        getContentPane().setLayout(new BoxLayout(getContentPane(), .getLayout(),BoxLayout.X_AXIS));
	        this.getContentPane().add(twoDArrayPanel);
	        getContentPane().add(rightPanel);
	        
	        lbl_time= new JLabel("") ;
	        getContentPane().add(lbl_time);
	        lbl_time.setIcon(new ImageIcon(MazeFrm.class.getResource("/giraffeView/images/btnTime.png")));
	        lbl_time.setBackground(Color.BLACK);
	        lbl_time.setAlignmentX(CENTER_ALIGNMENT);
	        lbl_time.setForeground(new Color(255, 160, 122));
	        lbl_time.setFont(new Font("David", Font.BOLD, 18));
	        lbl_time.setBounds(14, 13, 173, 48);
	        
	        lbl_time_val= new JLabel(" 0 ") ;
	        getContentPane().add(lbl_time_val);
	        lbl_time_val.setBorder(border2);
	        lbl_time_val.setBackground(Color.BLACK);
	        lbl_time_val.setAlignmentX(CENTER_ALIGNMENT);
	        lbl_time_val.setForeground(new Color(255, 204, 153));
	        lbl_time_val.setFont(new Font("Dialog", Font.BOLD, 30));
	        lbl_time_val.setBounds(24, 74, 106, 44);
	        //
	       
	        /////
	       
	        lblPlayerName= new JLabel("Player ") ;
	        getContentPane().add(lblPlayerName);
	        lblPlayerName.setBorder(border2);
	        lblPlayerName.setBackground(Color.BLACK);
	        lblPlayerName.setAlignmentX(CENTER_ALIGNMENT);
	        lblPlayerName.setForeground(new Color(255, 204, 153));
	        lblPlayerName.setFont(new Font("Forte", Font.BOLD, 26));
	        lblPlayerName.setBounds(1623, 13, 187, 78);
	        ////
	        JLabel lblScores= new JLabel("") ;
	        getContentPane().add(lblScores);
	        lblScores.setIcon(new ImageIcon(MazeFrm.class.getResource("/giraffeView/images/btnScores.png")));
	        lblScores.setBackground(Color.BLACK);
	        lblScores.setAlignmentX(CENTER_ALIGNMENT);
	        lblScores.setForeground(new Color(8, 31, 68));
	        lblScores.setFont(new Font("David", Font.BOLD, 18));
	        lblScores.setBounds(8, 208, 149, 44);
	        ////
	        JLabel lblLives= new JLabel("") ;
	        getContentPane().add(lblLives);
	        lblLives.setIcon(new ImageIcon(MazeFrm.class.getResource("/giraffeView/images/btnLives.png")));
	        lblLives.setBackground(Color.BLACK);
	        lblLives.setAlignmentX(CENTER_ALIGNMENT);
	        lblLives.setForeground(new Color(255, 160, 122));
	        lblLives.setFont(new Font("David", Font.BOLD, 18));
	        lblLives.setBounds(14, 420, 132, 44);////
	        
	        lblScoresValue= new JLabel(" ") ;
	        getContentPane().add(lblScoresValue);
	        lblScoresValue.setBorder(border2);
	        lblScoresValue.setBackground(Color.BLACK);
	        lblScoresValue.setAlignmentX(CENTER_ALIGNMENT);
	        lblScoresValue.setForeground(new Color(255, 204, 153));
	        lblScoresValue.setFont(new Font("Dialog", Font.BOLD, 20));
	        lblScoresValue.setBounds(8, 263, 123, 48);
	        ///
	        lblLivesValue= new JLabel("  ") ;
	        getContentPane().add(lblLivesValue);
	        lblLivesValue.setBorder(border2);
	        lblLivesValue.setBackground(Color.BLACK);
	        lblLivesValue.setAlignmentX(CENTER_ALIGNMENT);
	        lblLivesValue.setForeground(new Color(255, 204, 153));
	        lblLivesValue.setFont(new Font("Dialog", Font.BOLD, 20));
	        lblLivesValue.setBounds(14, 477, 116, 44);
	        ////
	        lblContentQuestion= new JLabel(" Content the question") ;
	        getContentPane().add(lblContentQuestion);
	        lblContentQuestion.setBorder(border2);
	        lblContentQuestion.setBackground(Color.BLACK);
	        lblContentQuestion.setAlignmentX(CENTER_ALIGNMENT);
	        lblContentQuestion.setForeground(new Color(255, 160, 122));
	        lblContentQuestion.setFont(new Font("Constantia", Font.BOLD, 20));
	        lblContentQuestion.setBounds(1530, 208, 381, 60);
	        
	        lblAnswer1= new JLabel("ans1 ") ;
	        getContentPane().add(lblAnswer1);
	        lblAnswer1.setBorder(border2);
	        lblAnswer1.setBackground(Color.BLACK);
	        lblAnswer1.setAlignmentX(CENTER_ALIGNMENT);
	        lblAnswer1.setForeground(new Color(0, 0, 255));
	        lblAnswer1.setFont(new Font("Constantia", Font.BOLD, 16));
	        lblAnswer1.setBounds(1536, 281, 372, 48);
	       
	        ////
	        lblAnswer2= new JLabel("ans2  ") ;
	        getContentPane().add(lblAnswer2);
	        lblAnswer2.setBorder(border2);
	        lblAnswer2.setBackground(Color.BLACK);
	        lblAnswer2.setAlignmentX(CENTER_ALIGNMENT);
	        lblAnswer2.setForeground(Color.ORANGE);
	        lblAnswer2.setFont(new Font("Constantia", Font.BOLD, 16));
	        lblAnswer2.setBounds(1536, 350, 372, 48);////
	        ///
	        lblAnswer3= new JLabel("ans3") ;
	        getContentPane().add(lblAnswer3);
	        lblAnswer3.setBorder(border2);
	        lblAnswer3.setBackground(Color.BLACK);
	        lblAnswer3.setAlignmentX(CENTER_ALIGNMENT);
	        lblAnswer3.setForeground(Color.PINK);
	        lblAnswer3.setFont(new Font("Constantia", Font.BOLD, 16));
	        lblAnswer3.setBounds(1536, 416, 372, 48);
	        
	        lblAnswer4= new JLabel("ans4") ;
	        getContentPane().add(lblAnswer4);
	        lblAnswer4.setBorder(border2);
	        lblAnswer4.setBackground(Color.BLACK);
	        lblAnswer4.setAlignmentX(CENTER_ALIGNMENT);
	        lblAnswer4.setForeground(Color.RED);
	        lblAnswer4.setFont(new Font("Constantia", Font.BOLD, 16));
	        lblAnswer4.setBounds(1536, 490, 372, 48);
	        lblContentQuestion.setVisible(false);
	        lblAnswer1.setVisible(false);
	        lblAnswer2.setVisible(false);
	        lblAnswer3.setVisible(false);
	        lblAnswer4.setVisible(false);
	        ////
	        this.lblScoresValue.setText(Score.toString());
	        this.lblLivesValue.setText(lives.toString());
			////
			this.setResizable(false);
            this.setPreferredSize(new Dimension(2000,1000));
//           this.setMinimumSize(t.getMinimumSize());   // cannot be resized-
	        this.pack();
	        this.lblPlayerName.setText(player.getPlayerUserName().toString());
	        addActionKeyToPlay();
	        this.setFocusable(true);
}
	
	public void runGhosts() {
		for(RegularGhost rg: twoDArrayPanel.getMazeData().getRegularGhosts()) {
			rg.setMazeFrm(MazeFrm.this);
			rg.setMazeMatrix(twoDArrayPanel.getMazeData().getMazeMatrix());
			new Thread(rg).start();
		}
//		for(int i=0; i<3; i++) {
//			twoDArrayPanel.getMazeData().getRegularGhosts().get(i).setMazeFrm(MazeFrm.this);
//			twoDArrayPanel.getMazeData().getRegularGhosts().get(i).setMazeMatrix(twoDArrayPanel.getMazeData().getMazeMatrix());
//			twoDArrayPanel.getMazeData().getRegularGhosts().get(i).start();
//		}
	}

	public void addActionKeyToPlay() {
		 this.addKeyListener(new KeyAdapter() {
			 
		        
				@SuppressWarnings("static-access")
				public void keyPressed(KeyEvent event) {

					int keyCode = event.getKeyCode();

					
					if(keyCode==event.VK_LEFT && !isPlayerdied) {
						
						Object objReturned;
						objReturned=twoDArrayPanel.getMazeData().movePackManLeft();
						updateInfo(objReturned);
						twoDArrayPanel.repaint();
						if(isSugarFinished() || gameOver) {
							finishGame();
						}
					}
					else
						if(keyCode==event.VK_RIGHT && !isPlayerdied) {
							Object objReturned;
							objReturned=twoDArrayPanel.getMazeData().movePackManRight();
							updateInfo(objReturned);
							twoDArrayPanel.repaint();
							if(isSugarFinished() || gameOver) {
								finishGame();
							}
						}
						else
							if(keyCode==event.VK_UP && !isPlayerdied) {
								Object objReturned;
								objReturned=twoDArrayPanel.getMazeData().movePackManUp();
								updateInfo(objReturned);
								twoDArrayPanel.repaint();
								if(isSugarFinished() || gameOver) {
									finishGame();
								}
							}
							else
								if(keyCode==event.VK_DOWN && !isPlayerdied) {
									Object objReturned;
									objReturned=twoDArrayPanel.getMazeData().movePackManDown();
									updateInfo(objReturned);
									twoDArrayPanel.repaint();
									if(isSugarFinished() || gameOver) {
										finishGame();
									}
								}
				}
			});
	}
	
	public void finishGame( ) {
		if(!gameOver && !isOnePlayer) {
			JOptionPane.showMessageDialog(this,"game Over! your score is : "+this.twoDArrayPanel.getMazeData().getPacMan().getTotalPoints().toString());
			isPlayerdied=true;
		}
		if(gameOver && !isOnePlayer) {
			JOptionPane.showMessageDialog(this,"wait until time end!");
			isPlayerdied=true;
		}
		
		if(!gameOver && !isOnePlayer) {
			JOptionPane.showMessageDialog(this,"wait until time end!");
		}
		if(!gameOver && isOnePlayer || gameOver && isOnePlayer)
		{
			JOptionPane.showMessageDialog(this,"you have finished the game your score is : "+this.twoDArrayPanel.getMazeData().getPacMan().getTotalPoints().toString());
		
		for(Player p: SysData.getInstance().getPlayers()) {
			//	System.out.println("test test test after end game "+p.getPlayerEmail());
				if(p.getPlayerEmail().equals(this.player.getPlayerEmail())) {
					p.addScore(Integer.parseInt(this.lblScoresValue.getText()));
				}
				
				}
		SysData.getInstance().writePlayersJson();	
			this.setVisible(false);
			MenuFrm menu=new MenuFrm();
			menu.setVisible(true);
		}
	}
	public boolean isSugarFinished() {
		for(int i=0;i<Constants.mazeheight;i++) {
			for(int j=0;j<Constants.mazewidth;j++) {
				if(this.twoDArrayPanel.getMazeData().getMazeMatrix()[i][j] instanceof Sugar) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void updateInfo(Object objReturned) {

	if(objReturned instanceof Question) {
		MazeFrm.this.lblContentQuestion.setText(((Question)objReturned).getQuestion());
		MazeFrm.this.lblContentQuestion.setVisible(true);
		if(((Question)objReturned).getAnswers().size()>0) {
		this.lblAnswer1.setText(((Question)objReturned).getAnswers().get(0).toString());
		this.lblAnswer2.setText(((Question)objReturned).getAnswers().get(1).toString());
		this.lblAnswer3.setText(((Question)objReturned).getAnswers().get(2).toString());
		this.lblAnswer4.setText(((Question)objReturned).getAnswers().get(3).toString());
		this.lblAnswer1.setVisible(true);
		this.lblAnswer2.setVisible(true);
		this.lblAnswer3.setVisible(true);
		this.lblAnswer4.setVisible(true);
       }
		for(int i=0;i<twoDArrayPanel.getMazeData().getAnswerGhosts().size();i++){
		  twoDArrayPanel.getMazeData().getAnswerGhosts().get(i).setMazeFrm(MazeFrm.this);
    	  twoDArrayPanel.getMazeData().getAnswerGhosts().get(i).setMazeMatrix(twoDArrayPanel.getMazeData().getMazeMatrix());
		   new Thread(twoDArrayPanel.getMazeData().getAnswerGhosts().get(i)).start();
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
					MazeFrm.this.lblLivesValue.setText(twoDArrayPanel.getMazeData().getPacMan().getLives().toString());
					return;
				}
				else
				{
					gameOver=true;
					
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
						if((Integer.parseInt(MazeFrm.this.lblLivesValue.getText()))>0)
						{
							twoDArrayPanel.getMazeData().getPacMan().takeLife();
							MazeFrm.this.lblLivesValue.setText(twoDArrayPanel.getMazeData().getPacMan().getLives().toString());
							return;
						}
						else
						{

							gameOver=true;							
							return;
						}
						
					}
					else
						if(objReturned.equals(Constants.AnswerStatus.True.toString())) {
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
							lblContentQuestion.setVisible(false);
					        lblAnswer1.setVisible(false);
					        lblAnswer2.setVisible(false);
					        lblAnswer3.setVisible(false);
					        lblAnswer4.setVisible(false);
						}
						else
							if(objReturned.equals(Constants.AnswerStatus.False.toString())) {
								if(level==1) {
									twoDArrayPanel.getMazeData().getPacMan().addPoints(-250);
									if(twoDArrayPanel.getMazeData().getPacMan().getTotalPoints()<0)
									{
										twoDArrayPanel.getMazeData().getPacMan().setTotalPoints(0);
									}
									this.lblScoresValue.setText(twoDArrayPanel.getMazeData().getPacMan().getTotalPoints().toString());
								}
								if(level==2) {
									twoDArrayPanel.getMazeData().getPacMan().addPoints(-100);
									if(twoDArrayPanel.getMazeData().getPacMan().getTotalPoints()<0)
									{
										twoDArrayPanel.getMazeData().getPacMan().setTotalPoints(0);
									}
									this.lblScoresValue.setText(twoDArrayPanel.getMazeData().getPacMan().getTotalPoints().toString());
								}
								if(level==3) {
									twoDArrayPanel.getMazeData().getPacMan().addPoints(-50);
									if(twoDArrayPanel.getMazeData().getPacMan().getTotalPoints()<0)
									{
										twoDArrayPanel.getMazeData().getPacMan().setTotalPoints(0);
									}
									this.lblScoresValue.setText(twoDArrayPanel.getMazeData().getPacMan().getTotalPoints().toString());
								}
								lblContentQuestion.setVisible(false);
						        lblAnswer1.setVisible(false);
						        lblAnswer2.setVisible(false);
						        lblAnswer3.setVisible(false);
						        lblAnswer4.setVisible(false);
							}
	}
	}

	public TwoDArrayPanel getTwoDArrayPanel() {
		return twoDArrayPanel;
	}


	public void setTwoDArrayPanel(TwoDArrayPanel twoDArrayPanel) {
		this.twoDArrayPanel = twoDArrayPanel;
	}
	
}