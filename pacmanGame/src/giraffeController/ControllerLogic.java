package giraffeController;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;


import resourcesFile.*;
import giraffeModel.*;
import giraffeModel.Constants;
import giraffeView.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerLogic {
SysData sysDataInstance;
private LogInFrm logIn;
private SignUpFrm signUp;
private MenuFrm menu;
private SettingFrm setting;
private AdminQuestionFrm adminQuestion;
private MazeFrm mazeFirstPlayer;
private MazeFrm mazeSecondPlayer;
private ScoresHistoryPerPlayerFrm scoresPerPlayer;
private HighScoresFrm highScores;
private UpdateQuestionFrm updateQuestion;
private AddQuestionFrm addQuestion;
private DeleteQuestionFrm deleteQuestion;
private String difficulty;
private Player firstPlayer;
private Player secondPlayer;
private ArrayList<Question> questionsForThisGame;
private boolean lastRound;
private boolean isOnePlayer;
private Integer roundNumber=1;
private Timer time;
private int level=2;
private scoreOfTwoPlayersFrm scoreFrm;
String[] levelList=new String[] {"Hard","Normal","Easy"};
private static final String EMAIL_PATTERN = 
"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

@SuppressWarnings("static-access")
public ControllerLogic(SysData sysDataInstance) {
	setSysDataInstance(sysDataInstance);
	 scoreFrm=new scoreOfTwoPlayersFrm();
	difficulty=Constants.difficulty.Normal.toString();
	questionsForThisGame=new ArrayList<Question>();
	questionsForThisGame=sysDataInstance.getQuestions();
	System.out.println(questionsForThisGame);
	
	logIn=new LogInFrm();
	signUp=new SignUpFrm();
	menu=new MenuFrm();
	setting=new SettingFrm();
	adminQuestion=new AdminQuestionFrm();
	addQuestion=new AddQuestionFrm();
	updateQuestion=new UpdateQuestionFrm();
	deleteQuestion=new DeleteQuestionFrm();
	scoresPerPlayer=new ScoresHistoryPerPlayerFrm();
	highScores=new HighScoresFrm();
	lastRound=false;
	addAllActionListeners();
//	System.out.println(SysData.getInstance().getQuestions());
	menu.setVisible(true);
	sysDataInstance.playMusic(0);
	
	
}


public void runMaze() {
	
time= new Timer(40000,new ActionListener() {
		
		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(roundNumber==1) {
				mazeFirstPlayer.setVisible(true);
			}
			if(mazeFirstPlayer.isActive()) {
				
				roundNumber++;
				
				if(roundNumber==2){
					lastRound=true;
				}
				mazeFirstPlayer.setVisible(false);
				mazeSecondPlayer.setVisible(true);
				countDownTimer(mazeSecondPlayer);
				
					time.stop();
					if(!mazeSecondPlayer.getTwoDArrayPanel().getMazeData().getRegularGhosts().get(0).isAlive())
					{
						mazeSecondPlayer.runGhosts();
					}
					
					runMaze();
					countDownTimer(mazeSecondPlayer);			
				
			}
			else
			{
				if(lastRound!=true) {
				//JOptionPane.showMessageDialog(mazeSecondPlayer,"Finish your round now | FirstPlayer round");				
				roundNumber++;
				mazeSecondPlayer.setVisible(false);
				mazeFirstPlayer.setVisible(true);
				int result=JOptionPane.showConfirmDialog(mazeFirstPlayer,"Click Play to start your game");
				if(result==JOptionPane.OK_OPTION) {
					time.stop();
					if(!mazeFirstPlayer.getTwoDArrayPanel().getMazeData().getRegularGhosts().get(0).isAlive())
					{
					 mazeFirstPlayer.runGhosts();
					}
					runMaze();
					countDownTimer(mazeFirstPlayer);
				}
				
				}
				else {
					int n=JOptionPane.showConfirmDialog(mazeSecondPlayer,"finish Game!");
					if(n==JOptionPane.OK_OPTION) {
						time.stop();
						
						for(Player p: sysDataInstance.getPlayers()) {
						//	System.out.println("test test test after end game "+p.getPlayerEmail());
							if(p.getPlayerEmail().equals(firstPlayer.getPlayerEmail())) {
								p.addScore(Integer.parseInt(mazeFirstPlayer.lblScoresValue.getText()));
							}
							if(p.getPlayerEmail().equals(secondPlayer.getPlayerEmail())) {
								p.addScore(Integer.parseInt(mazeSecondPlayer.lblScoresValue.getText()));
							 }
							}
						sysDataInstance.writePlayersJson();	
						mazeFirstPlayer.setVisible(false);
						mazeSecondPlayer.setVisible(false);
						
						scoreFrm.lblFirstplayer.setText(firstPlayer.getPlayerEmail()+" score :");
						scoreFrm.textField_2.setText(mazeFirstPlayer.getTwoDArrayPanel().getMazeData().getPacMan().getTotalPoints().toString());
						scoreFrm.lblSecondplayer.setText(secondPlayer.getPlayerEmail()+" score :");
						scoreFrm.textField_1.setText(mazeSecondPlayer.getTwoDArrayPanel().getMazeData().getPacMan().getTotalPoints().toString());
						if(mazeFirstPlayer.getTwoDArrayPanel().getMazeData().getPacMan().getTotalPoints() >
						mazeSecondPlayer.getTwoDArrayPanel().getMazeData().getPacMan().getTotalPoints()) {
							scoreFrm.textField.setText(firstPlayer.getPlayerEmail());
						}
						if(mazeFirstPlayer.getTwoDArrayPanel().getMazeData().getPacMan().getTotalPoints() <
						mazeSecondPlayer.getTwoDArrayPanel().getMazeData().getPacMan().getTotalPoints()) {
						
							scoreFrm.textField.setText(secondPlayer.getPlayerEmail());
						}
						scoreFrm.setVisible(true);
					}
					
				}
			}
			
		}		
	});
	time.start();
}


///
public SysData getSysDataInstance() {
	return sysDataInstance;
}

public void setSysDataInstance(SysData sysDataInstance) {
	this.sysDataInstance = sysDataInstance;
}

private void countDownTimer(MazeFrm mazePlayerTimer) {
	
    Thread thread = new Thread(new Runnable () {

        @Override
        public void run() {
            // Calculate total seconds to count down
            Integer countdownSeconds =40 ;

            // Count down to 0 and print it on the console
            for (Integer i = countdownSeconds ; i >= 0; i--) {
            	mazePlayerTimer.lbl_time_val.setText(i.toString());
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e) {}

            }
        }
    });
    // Start the Thread
    thread.start();
}

public void actionOnClose(WindowEvent e) {
	sysDataInstance.removeFile(Constants.QUESTIONFILENAME);
	sysDataInstance.writeQuestionsAdmin();
	
	System.out.println(sysDataInstance.getPlayers());
	sysDataInstance.removeFile(Constants.PLAYERSHISTORYFILENAME);
	sysDataInstance.writePlayersJson();
	sysDataInstance.playMusic(1);
	e.getWindow().dispose();
}

@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
public void addAllActionListeners() {
	menu.addWindowListener(new WindowAdapter()
    {
        @Override
        public void windowClosing(WindowEvent e)
        {
        	
        	actionOnClose(e);
        }
    });
	setting.addWindowListener(new WindowAdapter()
    {
        @Override
        public void windowClosing(WindowEvent e)
        {
        	actionOnClose(e);
        }
    });
	logIn.addWindowListener(new WindowAdapter()
    {
        @Override
        public void windowClosing(WindowEvent e)
        {
        	actionOnClose(e);
        }
    });
	
	if(mazeFirstPlayer!=null) {
		mazeFirstPlayer.addWindowListener(new WindowAdapter()
    {
        @Override
        public void windowClosing(WindowEvent e)
        {
        	actionOnClose(e);
        }
    });
	}
	if(mazeSecondPlayer!=null)
	mazeSecondPlayer.addWindowListener(new WindowAdapter()
    {
        @Override
        public void windowClosing(WindowEvent e)
        {
        	actionOnClose(e);
        }
    });
	
	/* after click on login from loginFrm check if Player exist in sysData
 *  if true show ManuFrm and set firstPlayer field in ControlerLogin else show massage dialog */
	logIn.btnLogIn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
				Player player=new Player();
				//// admin check 
				if(logIn.textField.getText().equals("admin@admin.com")) {
					String str="";
	                for(char c :logIn.passwordField.getPassword()) {
	             	  str+=c;
	                }
	                if(str.equals("adminPass")) {
	                	adminQuestion.setVisible(true);
	                	menu.btnEditQuestions.setVisible(true);
	                }else {
	                	JOptionPane.showInputDialog("Incorrect Password");
	                }
				}else {
	            	menu.btnEditQuestions.setVisible(false);
				}
				//// players check			
				//System.out.println(" boooolean value "+isOnePlayer);

					if(sysDataInstance.getPlayers()!=null) {
						System.out.println(sysDataInstance.getPlayers());
						int ind=sysDataInstance.getPlayers().indexOf(new Player(logIn.textField.getText().toString()));
					//	System.out.println(ind);
						if(ind > -1)
						player=sysDataInstance.getPlayers().get(ind);
					//	System.out.println(player.toString());
						if(player!=null && player.getPlayerEmail()!=null ) {
							if(player.getPlayerEmail().equals(logIn.textField.getText())) {
								String str="";
			                     for(char c :logIn.passwordField.getPassword()) {
			                  	  str+=c;
			                     }
			              //    	  System.out.println(str);
								if(player.getPassword().equals(str)){
									if(firstPlayer!=null && secondPlayer==null && !isOnePlayer) { 
										secondPlayer=new Player(logIn.textField.getText().toString(),str);
										mazeSecondPlayer=new MazeFrm(false,isOnePlayer,secondPlayer,Constants.difficulty.Normal,questionsForThisGame,3,0,level,"src/giraffeModel/2DArray.txt");								    
									}
									if(firstPlayer==null) {
										firstPlayer=new Player(logIn.textField.getText().toString(),str);
										mazeFirstPlayer=new MazeFrm(false,isOnePlayer,firstPlayer,Constants.difficulty.Normal,questionsForThisGame,3,0,level,"src/giraffeModel/2DArray.txt");
								        
								        logIn.setVisible(false);
								        logIn.textField.setText("");
										logIn.passwordField.setText("");
										if(!isOnePlayer) {
									        menu.setVisible(true);
									        JOptionPane.showMessageDialog(menu, "please second player logIn to start the game");
										}
									}
									
									if(isOnePlayer && firstPlayer!=null) {
//									System.out.println(firstPlayer.getPlayerUserName().toString() +"  space ");
										mazeFirstPlayer.lbl_time.setVisible(false);
										mazeFirstPlayer.lbl_time_val.setVisible(false);
										mazeFirstPlayer.setVisible(true);
										Object[] play = {"PLAY"};
										int result= JOptionPane.showOptionDialog(mazeFirstPlayer,//parent container of JOptionPane
											    "Would you like to start the game ",
											    "",
											    JOptionPane.OK_OPTION,
											    JOptionPane.QUESTION_MESSAGE,
											    null,//do not use a custom Icon
											    play,//the titles of buttons
											    play[0]);//default button title
										if(result==JOptionPane.OK_OPTION) {															
											 mazeFirstPlayer.runGhosts();
								//			 countDownTimer(mazeFirstPlayer);
										}
										return;
								    }
									if(!isOnePlayer && firstPlayer!=null && secondPlayer!=null) {
										mazeFirstPlayer.lbl_time.setVisible(true);
										mazeFirstPlayer.lbl_time_val.setVisible(true);	
										mazeFirstPlayer.setVisible(true);									
										Object[] play = {"PLAY"};
										int result= JOptionPane.showOptionDialog(mazeFirstPlayer,//parent container of JOptionPane
											    "Would you like to start the game ",
											    "",
											    JOptionPane.OK_OPTION,
											    JOptionPane.QUESTION_MESSAGE,
											    null,//do not use a custom Icon
											    play,//the titles of buttons
											    play[0]);//default button title
										if(result==JOptionPane.OK_OPTION) {															
											 mazeFirstPlayer.runGhosts();
											runMaze();
											countDownTimer(mazeFirstPlayer);		
										}
									}
								 
							}else {
								JOptionPane.showMessageDialog(logIn, "Incorrect password");
								return;
						  }
						}else {
							JOptionPane.showMessageDialog(logIn, "Invalid User Email !!!!");
							return;
					   }
					}
							
						
					}
					
				}
				
			
	});
	
	menu.btnJoinSecondPlayer.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(secondPlayer==null) {
				menu.setVisible(false);	
				logIn.textField.setText("");
				logIn.passwordField.setText("");
				logIn.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(menu,"You cann't logIn second player is in !!");
			}
			
		}
	});
	
	menu.btnLogAsAdmin.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			menu.setVisible(false);
			logIn.setVisible(true);			
		}
	});
	
	
	/*after click on sign up from loginFrm show signUp page*/
	logIn.btnSignUp.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			logIn.setVisible(false);
			logIn.textField.setText("");
			logIn.passwordField.setText("");
			signUp.setVisible(true);			
		}		
		});
	logIn.btnBack.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			logIn.setVisible(false);
			logIn.textField.setText("");
			logIn.passwordField.setText("");
			menu.setVisible(true);
			
		}
	});
//	logIn.btnHighScores.addActionListener(new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			logIn.setVisible(false);
//			highScores.setVisible(true);
//			
//		}
//		
//	});
	/* after click on sign up from signUpFrm check if player doesnot exist in sysData
	 * if true then add Player and show ManuFrm else show massage dialog*/
	signUp.btnSignUp.addActionListener(new ActionListener() {

		@SuppressWarnings({ "static-access" })
		@Override
		public void actionPerformed(ActionEvent e) {
			if(sysDataInstance.getPlayers()!=null) {
				for(Player p : sysDataInstance.getPlayers()) {
					if( p.getPlayerEmail().toString().equals(signUp.txtEmail.getText().toString())) {
						JOptionPane.showMessageDialog(signUp, "user name exist!");
						return;
					}
				}
				 Pattern pattern = Pattern.compile(EMAIL_PATTERN);
				 Matcher matcher = pattern.matcher(signUp.txtEmail.getText());
				 
				if(!matcher.matches()) {
					JOptionPane.showMessageDialog(signUp, "fill user name, you need to fill like aaaa@bbbb.com!");
					return;
				}
				String strPassword1="";
	            for(char c: signUp.passwordField.getPassword()) {
	         	  strPassword1+=c;
	         	  }
	         	  
	         	 String strPassword2="";
	             for(char c: signUp.passwordField.getPassword()) {
	          	  strPassword2+=c;
	             }
	          	  
				if(strPassword1.equals("") || strPassword2.equals("")) {
					JOptionPane.showMessageDialog(signUp, "fill password input");
					return;
				}
			
				if(!strPassword1.equals(strPassword2)) {
					JOptionPane.showMessageDialog(signUp, "wrong confirm password input! fill again");
					return;
				}
				sysDataInstance.addPlayer(new Player(signUp.txtEmail.getText().toString(),strPassword1));
				System.out.println("ssss");
							
				JOptionPane.showMessageDialog(signUp, "good job you signed up!");
				
				return;
			}
		}
	});
	
	signUp.btnBack.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			signUp.setVisible(false);
			logIn.setVisible(true);
			
		}
		
	});
	signUp.btnLogIn.addActionListener(new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
			signUp.setVisible(false);
			logIn.setVisible(true);			
		} 		
	});
	
	/* after click on edit question in manufrm check if this is admin if true then show 
	 * EditQuestionFrm else show message dialog*/
	menu.btnEditQuestions.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				logIn.setVisible(false);
				adminQuestion.setVisible(true);			
//				JOptionPane.showMessageDialog(logIn, "you are not the admin, only admin can edit a question");
		}
			
	});
	
		menu.btnStartGame.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object[] options = {"One Player", "Two Players :) "};
			int n= JOptionPane.showOptionDialog(mazeFirstPlayer,//parent container of JOptionPane
				    "Choose number of players ",
				    "",
				    JOptionPane.YES_NO_OPTION,
				    JOptionPane.QUESTION_MESSAGE,
				    null,//do not use a custom Icon
				    options,//the titles of buttons
				    options[0]);//default button title
			
			if(n==JOptionPane.YES_OPTION) {
				menu.setVisible(false);
				logIn.setVisible(true);
				isOnePlayer=true;
			}
			if(n==JOptionPane.NO_OPTION) {
				menu.setVisible(false);
				logIn.setVisible(true);
				isOnePlayer=false;
			}
			
			//			if(mazeSecondPlayer==null) {
//				//isOnePlayer=true;
//				//menu.setVisible(false);
//				mazeFirstPlayer.setVisible(true);
//				mazeFirstPlayer.runGhosts();
//			}
//			else
//				{
//				isOnePlayer=false;
//				mazeFirstPlayer.setVisible(true);
//				Object[] play = {"PLAY"};
//				int result= JOptionPane.showOptionDialog(mazeFirstPlayer,//parent container of JOptionPane
//					    "Would you like to start the game ",
//					    "",
//					    JOptionPane.OK_OPTION,
//					    JOptionPane.QUESTION_MESSAGE,
//					    null,//do not use a custom Icon
//					    play,//the titles of buttons
//					    play[0]);//default button title
//				if(result==JOptionPane.YES_OPTION) {
//					mazeFirstPlayer.runGhosts();
//					runMaze();
//					countDownTimer(mazeFirstPlayer);
//				}
		}
	});
		
		
		
		
	 /*after click on comboBox in EditQuestionFrm show all questions from sysData 
	  * and after click on one question show the answers also down*/
	
	
	adminQuestion.btnAddBackTo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			adminQuestion.setVisible(false);
			logIn.setVisible(false);
			menu.setVisible(true);
	}
		});
	
	
	adminQuestion.btnEditQues.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<String> strs=new ArrayList<>();
			for(Question q:questionsForThisGame) {
				  strs.add(q.getQuestion());
				  System.out.println(" into edit button "+q.getQuestion());
			}
			updateQuestion.questioncomboBox.removeAll();
			updateQuestion.questioncomboBox.setModel(new DefaultComboBoxModel(strs.toArray()));
			updateQuestion.questioncomboBox.insertItemAt("", 0);
			updateQuestion.questioncomboBox.setSelectedIndex(0);
			
			updateQuestion.levelCombox.setSelectedIndex(0);
			updateQuestion.answerComboBox.setSelectedIndex(0);
			
			adminQuestion.setVisible(false);
			menu.setVisible(false);
			updateQuestion.setVisible(true);
		}
	});
	
	
	adminQuestion.btnAddquestion.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			addQuestion.levelCombox.removeAll();
			addQuestion.levelCombox.setModel(new DefaultComboBoxModel(levelList));
			addQuestion.levelCombox.insertItemAt("", 0);
			addQuestion.levelCombox.setSelectedIndex(-1);
			
			Integer[] listInts=new Integer[] {1,2,3,4};
			addQuestion.answerQuestionCombox.removeAll();
			addQuestion.answerQuestionCombox.setModel(new DefaultComboBoxModel(listInts));
			addQuestion.answerQuestionCombox.insertItemAt("", 0);
			addQuestion.answerQuestionCombox.setSelectedIndex(0);
			
			adminQuestion.setVisible(false);
			addQuestion.setVisible(true);
			
		}
	});
	
	
	
	adminQuestion.btnDeleteQues.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<String> questionsList=new ArrayList<>();
			questionsList.removeAll(questionsList);
			for(Question q:questionsForThisGame) {
					if(!questionsList.contains(q)) 
						questionsList.add(q.getQuestion());
					System.out.println("test  "+ q.getQuestion()+ " "+q.getTeam() );
			}
			deleteQuestion.questionComboBox.removeAll();
			deleteQuestion.questionComboBox.setModel(new DefaultComboBoxModel(questionsList.toArray()));
			deleteQuestion.questionComboBox.insertItemAt("", 0);
			deleteQuestion.questionComboBox.setSelectedIndex(0);
			
			adminQuestion.setVisible(false);
			deleteQuestion.setVisible(true);
			
		}
	});
	adminQuestion.btnAddBackTo.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			adminQuestion.setVisible(false);
			menu.setVisible(true);			
		}
	});
	
	
	// /*after select question show them in answers txt fields*/
	updateQuestion.questioncomboBox.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Integer[] answerList=new Integer[] {1,2,3,4};
			updateQuestion.answerComboBox.removeAll();
			updateQuestion.answerComboBox.setModel(new DefaultComboBoxModel(answerList));	
			updateQuestion.answerComboBox.insertItemAt("", 0);
			
			updateQuestion.levelCombox.removeAll();
			updateQuestion.levelCombox.setModel(new DefaultComboBoxModel(levelList));
			updateQuestion.levelCombox.insertItemAt("", 0);
			
			System.out.println(updateQuestion.questioncomboBox.getSelectedItem().toString());
			if(questionsForThisGame.contains
					(new Question(updateQuestion.questioncomboBox.getSelectedItem().toString()))) {
				Question q=new Question(updateQuestion.questioncomboBox.getSelectedItem().toString());
				int index=questionsForThisGame.indexOf(q);
				q=questionsForThisGame.get(index);
				//// fill the question on update view
				for(int k=0;k<q.getAnswers().size();k++) {
					switch(k) {
					case 0:updateQuestion.answer1_txt.setText(q.getAnswers().get(k)); break;
					case 1:updateQuestion.answer2_txt.setText(q.getAnswers().get(k)); break;
					case 2:updateQuestion.answer3_txt.setText(q.getAnswers().get(k)); break;
					case 3:updateQuestion.answer4_txt.setText(q.getAnswers().get(k)); break;
					}
				}
				switch(q.getLevel()) {
				case 1: updateQuestion.levelCombox.setSelectedItem("Easy");
				        break;
				case 2: updateQuestion.levelCombox.setSelectedItem("Normal");
		        break;
				case 3: updateQuestion.levelCombox.setSelectedItem("Hard");
		        break;
				        
				}
				updateQuestion.teamTxt.setText(q.getTeam());
				switch(q.getCorrectAnswer()) {
				case 1: updateQuestion.answerComboBox.setSelectedItem("1");
				        break;
				case 2: updateQuestion.answerComboBox.setSelectedItem("2");
		        break;
				case 3: updateQuestion.answerComboBox.setSelectedItem("3");
		        break;
				case 4: updateQuestion.answerComboBox.setSelectedItem("4");
		        break;
			}
		}
		}
		
	});
	
	updateQuestion.backbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			updateQuestion.setVisible(false);
			adminQuestion.setVisible(true);
			
		}
	});
	
	updateQuestion.edit_button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(questionsForThisGame.contains
					(new Question(updateQuestion.questioncomboBox.getSelectedItem().toString()))) {
				Question q=new Question(updateQuestion.questioncomboBox.getSelectedItem().toString());
				int index=questionsForThisGame.indexOf(q);
				q=questionsForThisGame.get(index);
				
			///// end the assigment from the old values 
			
						///update the answers into the arraylist
						if(!updateQuestion.answer1_txt.equals(""))
							q.setAnswers(updateQuestion.answer1_txt.getText());
						if(!updateQuestion.answer2_txt.equals(""))
							q.setAnswers(updateQuestion.answer2_txt.getText());
						if(!updateQuestion.answer3_txt.equals(""))
							q.setAnswers(updateQuestion.answer3_txt.getText());
						if(!updateQuestion.answer4_txt.equals(""))
							q.setAnswers(updateQuestion.answer4_txt.getText());
						//// update team name
						if(!updateQuestion.teamTxt.equals(""))
							q.setTeam(updateQuestion.teamTxt.getText());
						/// set question level
						if(!updateQuestion.levelCombox.getSelectedItem().equals(""))
							switch(updateQuestion.levelCombox.getSelectedItem().toString()) {
							case "Hard":q.setLevel(3);
								break;
							case "Normal":q.setLevel(2);
							break;
							case "Easy":q.setLevel(1);
							break;
							}
						   if(!updateQuestion.levelCombox.getSelectedItem().equals("")) {
							 try {
									q.setLevel(Integer.parseInt(String.valueOf(updateQuestion.levelCombox.getSelectedItem().toString())));
								  }
								  catch (NumberFormatException ex ) {
								     q.setLevel(1);
								  }
						    }
						if(!updateQuestion.answerComboBox.getSelectedItem().equals("")) {
							q.setCorrectAnswer(Integer.parseInt(String.valueOf(updateQuestion.answerComboBox.getSelectedItem().toString())));
						}
						sysDataInstance.updateQuestion(q);
						questionsForThisGame=sysDataInstance.getQuestions();
						
					}
			
			
		}
	});
	 /*delete selected question from sysData*/
	deleteQuestion.deleteQuestion.addActionListener(new ActionListener() {
		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			for(Question q:questionsForThisGame) {
				if(q.getQuestion().equals(deleteQuestion.questionComboBox.getSelectedItem().toString())) {
					System.out.println(q.getQuestion()+"   "+ q.getCorrectAnswer());
					sysDataInstance.deleteQuestion(q);
					questionsForThisGame=sysDataInstance.getQuestions();
					break;
				 }
				}
			return;
			
		}
		
	});
	
	deleteQuestion.btnBack.addActionListener(new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
			deleteQuestion.setVisible(false);
			adminQuestion.setVisible(true);
			
		}
	});
	
	
	
		

	/* add the question to sysData*/
	addQuestion.btnAdd.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int counter=0,j=0;
			//int i=0;
			       Question q=new Question();
			       if(!addQuestion.questionText.getText().equals("")) {
			    	   q.setQuestion(addQuestion.questionText.getText());
			    		///add the answers into the arraylist						
						if(!addQuestion.answertxt1.equals("")) {
							q.setAnswers(addQuestion.answertxt1.getText());
						}
						if(!addQuestion.answertxt2.equals("")) {
					    	q.setAnswers(addQuestion.answertxt2.getText());
						}
						if(!addQuestion.answertxt3.equals("")){
					    	q.setAnswers(addQuestion.answertxt3.getText());		
						}
						if(!addQuestion.answertxt4.equals("")){
					    	q.setAnswers(addQuestion.answertxt4.getText());
						}				
					
						if(!addQuestion.answerQuestionCombox.getSelectedItem().equals("")) {
							q.setCorrectAnswer(Integer.parseInt(
									addQuestion.answerQuestionCombox.getSelectedItem().toString()));
						}
						//// update team name
						if(!addQuestion.teamTxt.equals(""))
							q.setTeam(addQuestion.teamTxt.getText());
						/// set question level
						if(!addQuestion.levelCombox.getSelectedItem().equals(""))
							switch(addQuestion.levelCombox.getSelectedItem().toString()) {
							case "Hard":q.setLevel(3);
								break;
							case "Normal":q.setLevel(2);
							break;
							case "Easy":q.setLevel(1);
							break;
							}
//						
						sysDataInstance.addQuestionAdmin(q);
						questionsForThisGame=sysDataInstance.getQuestions();
						
						
						
			       }		

		}
		
	});
	
	addQuestion.btnBack.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			addQuestion.setVisible(false);
			adminQuestion.setVisible(true);
		}
	});
	
	/*show settings page*/
	menu.btnSetting.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			menu.setVisible(false);
			setting.setVisible(true);
			return;
		}
		
	});
	
	menu.btnEditQuestions.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			menu.setVisible(false);
			logIn.setVisible(true);
			return;
		}
		
	});

	
	setting.rdbtnOff.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			sysDataInstance.playMusic(1);
		}
	});
	
	setting.rdbtnOn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			sysDataInstance.playMusic(0);			
		}
	});
	
	setting.btnBackToMenu.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setting.setVisible(false);
			menu.setVisible(true);
			
		}
		
	});
	/* after click on andd another player check if only one player exist then show loginFrm again after Login return to menu
	 * and set SecondPlayer field in ControllerLogic*/
//	menu.btnJoinPlayer.addActionListener(new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			if (secondPlayer==null) {
//				menu.setVisible(false);
//				logIn.setVisible(true);
//			}
//			else
//				JOptionPane.showMessageDialog(logIn, "cannot add another player!");
//			
//		}	});
	
	menu.btnTop10.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			menu.setVisible(false);
			highScores.setVisible(true);
			
		}
	});
	
	/* set FirstPlayer and Second Player  and dificulty and questionsForThisGame to nul and return to loginFrm*/
	menu.btnLogOut.addActionListener(new ActionListener() {
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			difficulty="";
			firstPlayer=null;
			secondPlayer=null;
			logIn.textField.setText("");
			logIn.passwordField.setText("");
			menu.btnEditQuestions.setVisible(false);
			for(int i=0;i<questionsForThisGame.size();i++) {
				questionsForThisGame.remove(i);
			}
			menu.setVisible(false);
			logIn.setVisible(true);
		}
		
	});
	
	

//   /* show scoresHistoryFrm only for firstPlayer if there is 2 players in*/
//	menu.btnShow.addActionListener(new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			menu.setVisible(false);
//			scoresPerPlayer.setVisible(true);
//		}
//		
//	});
	
	menu.btnShowPerPlayer.addActionListener(new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
			menu.setVisible(false);
			ArrayList<String> emails=new ArrayList<>();
			for(Player player1:sysDataInstance.getPlayers()) {
				emails.add(player1.getPlayerEmail());
			}
			scoresPerPlayer.playerComboBox.setModel(new DefaultComboBoxModel(emails.toArray()));
			
			scoresPerPlayer.setVisible(true);
			
		}
	});
	
	scoresPerPlayer.playerComboBox.addActionListener(new ActionListener() {
		
		@SuppressWarnings("unlikely-arg-type")
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!scoresPerPlayer.playerComboBox.getSelectedItem().equals("")){
//				.setText(((Integer)firstPlayer.getHighScore()).toString());
				if(sysDataInstance.getPlayers().indexOf(scoresPerPlayer.playerComboBox.getSelectedItem())!=-1){
					 try{
						 DefaultTableModel model;
						   model=( DefaultTableModel)scoresPerPlayer.table.getModel();
				            ArrayList<Integer> scoresPlayer = sysDataInstance.playerScores(scoresPerPlayer.playerComboBox.getSelectedItem().toString());
				            if(scoresPlayer != null && scoresPlayer.size() != 0){
				                for(Integer score :scoresPlayer){
				                    model.insertRow(model.getRowCount(),new Object[]{score});
				                } 
				            }
				        }
				        catch(Exception ex){
				            JOptionPane.showMessageDialog(null,"No scores were found!!");

				        }
					}
				
				
				}		
			
		}
	});
	
	
	scoresPerPlayer.btnBack.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			scoresPerPlayer.setVisible(false);
			menu.setVisible(true);			
		}
		
	});
	
	scoresPerPlayer.btnBack.addActionListener(new ActionListener () {
		@Override
		public void actionPerformed(ActionEvent e) {
			scoresPerPlayer.setVisible(false);
			menu.setVisible(true);
			
		}
		
	});
	menu.btnTop10.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			menu.setVisible(false);
			 try{
				 DefaultTableModel model;
				   model=( DefaultTableModel)highScores.table.getModel();
		            ArrayList<Player> topTenPlayers = sysDataInstance.getTopTenWinners();
		            if(topTenPlayers != null && topTenPlayers.size() != 0){
		                for(Player p : topTenPlayers){
		                    model.insertRow(model.getRowCount(),new Object[]{p.getPlayerEmail(),p.getHighScore()});
		                } 
		            }
		        }
		        catch(Exception ex){
		            JOptionPane.showMessageDialog(null,"No scores were found!!");

		        }
			highScores.setVisible(true);			
		}
	});
	
	highScores.btnBack.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			highScores.setVisible(false);
			menu.setVisible(true);
			
		}
		
	});
	

	
	adminQuestion.btnAddBackTo.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			adminQuestion.setVisible(false);
			menu.setVisible(true);
		}
		
	});

	setting.rdbtnEasy.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			level=1;
			difficulty=Constants.difficulty.Easy.toString();
			for(int i=0;i<sysDataInstance.getQuestions().size();i++) {
				if(sysDataInstance.getQuestions().get(i).getLevel()==level) {
					questionsForThisGame.add(sysDataInstance.getQuestions().get(i));
				}
			}
			
		}
		
	});
	
	setting.rdbtnNormal.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			level=2;
			difficulty=Constants.difficulty.Normal.toString();
			for(int i=0;i<sysDataInstance.getQuestions().size();i++) {
				if(sysDataInstance.getQuestions().get(i).getLevel()==level) {
					questionsForThisGame.add(sysDataInstance.getQuestions().get(i));
				}
			}
			
		}
		
	});
	
	setting.rdbtnHard.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			level=3;
			difficulty=Constants.difficulty.Hard.toString();
			for(int i=0;i<sysDataInstance.getQuestions().size();i++) {
				if(sysDataInstance.getQuestions().get(i).getLevel()==level) {
					questionsForThisGame.add(sysDataInstance.getQuestions().get(i));
				}
			}
			
		}
		
	});
	
	scoreFrm.btnMenu.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			scoreFrm.setVisible(false);
			menu.setVisible(true);
			
		}
		
	});
	}
}



