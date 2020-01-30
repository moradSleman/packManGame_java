package giraffeModel;

import giraffeController.ControllerLogic;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class MazeData {
	Scanner fileReader;
	char[][] lineList = new char[22][46];
	private PacMan pacMan;
	private Player player;
	private ArrayList<RegularGhost> regularGhosts;
	private ArrayList<RegularGhost> answerGhosts;
	private ArrayList<Sugar> sugars;
	private Object[][] mazeMatrix;
	private Question question;
	private String difficulty;
	private List<Question> quesToChooseFrom;
	public MazeData(Player player,Constants.difficulty difficulty,ArrayList<Question> quesToChooseFrom,
			String mapFile) {
		sugars=new ArrayList<Sugar>();
		regularGhosts=new ArrayList<RegularGhost>();
		answerGhosts=new ArrayList<RegularGhost>();
		this.player=player;
		this.difficulty=difficulty.toString();
		this.quesToChooseFrom=quesToChooseFrom;
		initializeLineList(mapFile);
		initializePacMan();
		initializeRegularGhosts();
		initializeSugars();
		setMazeMatrix();
	}
	public void initializeLineList(String mapFile) {
		 try {
			 
	            fileReader = new Scanner(new File(mapFile));
	            
	            int lineNum=0;
	            while  (true){
	            	
	                String line = null;

	                try {
	                    line = fileReader.nextLine();
	                } catch (Exception eof) {

	                    // throw new A5FatalException("Could not read resource");
	                }

	                if (line == null) {
	                    break;
	                }

	                for(int i=0 ;i<line.length();i++) {
	                	lineList[lineNum][i]=line.toCharArray()[i];
	                }
	                lineNum++;
	            
	            }
		 }
		 catch (FileNotFoundException e) {
	            System.out.println("Maze map file not found");
	        }
	}
	public Object[][] getMazeMatrix() {
		return mazeMatrix;
	}
	
	public void setMazeMatrix() {
		mazeMatrix=new Object[Constants.mazeheight][Constants.mazewidth];
		mazeMatrix[pacMan.getX()][pacMan.getY()]=pacMan;
		for(int i=0 ;i<regularGhosts.size();i++) {
			mazeMatrix[regularGhosts.get(i).getX()][regularGhosts.get(i).getY()]=regularGhosts.get(i);
		}
		for(int i=0;i<sugars.size();i++) {
			mazeMatrix[sugars.get(i).getX()][sugars.get(i).getY()]=sugars.get(i);
		}
		for(int i = 0; i < lineList.length; i++) {
			  for(int j = 0; j < lineList[i].length; j++) {
				  if(lineList[i][j]=='*')
					  mazeMatrix[i][j]=new String("*");
			  }
		}
	}
	public void initializePacMan() {
		for(int i = 0; i < lineList.length; i++) {
			  for(int j = 0; j < lineList[i].length; j++) {
				  if(lineList[i][j]=='p')
					  pacMan=new PacMan(i,j,0,Constants.lives,Constants.Directions.up);
			  }
		}
	}
	public void initializeSugars() {
		for(int i = 0; i < lineList.length; i++) {
			  for(int j = 0; j < lineList[i].length; j++) {
				  if(lineList[i][j]=='e')
					   sugars.add(new Sugar(i,j,Constants.SugarType.YellowSugar));
				  else if(lineList[i][j]=='b')
					  sugars.add(new Sugar(i,j,Constants.SugarType.BadSugar));
				  else if(lineList[i][j]=='q')
					  sugars.add(new Sugar(i,j,Constants.SugarType.QuestionSugar));
				  else if(lineList[i][j]=='m')
					  sugars.add(new Sugar(i,j,Constants.SugarType.MoneySugar));
			  }
			}
		return;
	}
	public void initializeRegularGhosts() {
		for(int i = 0; i < lineList.length; i++) {
			  for(int j = 0; j < lineList[i].length; j++) {
				 if(lineList[i][j]=='g') {
					 RegularGhost rGhost=new RegularGhost(i,j);
					 rGhost.setImage();
					 regularGhosts.add(rGhost); 
				 }
			  }
			}
		return;
		
	}
	
	public void initializeAnswerGhosts(int numOfCorrectAnswer) {
		RegularGhost answerGhost1=null;
		RegularGhost answerGhost2=null;
		RegularGhost answerGhost3=null;
		RegularGhost answerGhost4=null;
		
		//initialize the appropriate true answer ghost by numOfCorrectAnswer input
		for(int i=0;i<Constants.mazeheight;i++) {
			for(int j=0;j<Constants.mazewidth;j++) {
				if(i>3 && i<Constants.mazeheight-3 && j>3 && j<Constants.mazewidth-3 && 
						!(mazeMatrix[i][j] instanceof PacMan) && !(mazeMatrix[i][j] instanceof Sugar) 
								&& !(mazeMatrix[i][j] instanceof RegularGhost) && !(mazeMatrix[i][j] instanceof AnswerGhost)) {
					if(answerGhost1==null)
						{
						answerGhost1=new AnswerGhost(i,j,Constants.AnswerStatus.False);
						((AnswerGhost)answerGhost1).setAnswerGhostImg(0);
						answerGhosts.add(answerGhost1);
						mazeMatrix[i][j]=null;
						mazeMatrix[i][j]=answerGhost1;
						continue;
						}
					else
						if(answerGhost2==null)
							{
							answerGhost2=new AnswerGhost(i,j,Constants.AnswerStatus.False);
							((AnswerGhost)answerGhost2).setAnswerGhostImg(1);
							answerGhosts.add(answerGhost2);
							mazeMatrix[i][j]=null;
							mazeMatrix[i][j]=answerGhost2;
							continue;
							}
						else
							if(answerGhost3==null)
								{
								answerGhost3=new AnswerGhost(i,j,Constants.AnswerStatus.False);
								((AnswerGhost)answerGhost3).setAnswerGhostImg(2);
								answerGhosts.add(answerGhost3);
								mazeMatrix[i][j]=null;
								mazeMatrix[i][j]=answerGhost3;
								continue;
								}
							else
								if(answerGhost4==null)
									{
									answerGhost4=new AnswerGhost(i,j,Constants.AnswerStatus.False);
									((AnswerGhost)answerGhost4).setAnswerGhostImg(3);
									answerGhosts.add(answerGhost4);
									mazeMatrix[i][j]=null;
									mazeMatrix[i][j]=answerGhost4;
							
									break;
									}
				}
									if(answerGhost1!=null && numOfCorrectAnswer==1)
										((AnswerGhost)answerGhosts.get(0)).setAnswerStatus(Constants.AnswerStatus.True);
									else
										if(answerGhost2!=null && numOfCorrectAnswer==2)
											((AnswerGhost)answerGhosts.get(1)).setAnswerStatus(Constants.AnswerStatus.True);
										else
											if(answerGhost3!=null && numOfCorrectAnswer==3)
												((AnswerGhost)answerGhosts.get(2)).setAnswerStatus(Constants.AnswerStatus.True);
											else
												if(answerGhost4!=null && numOfCorrectAnswer==4)
													((AnswerGhost)answerGhosts.get(3)).setAnswerStatus(Constants.AnswerStatus.True);
				}
			}
		}
		
		
	
	public void initializeQuestion(String question, int correctAnswer,
			int level, String team) {
		this.question=new Question(question,correctAnswer,level,team);
	//	initializeAnswerGhosts(correctAnswer);
	}
	public void setAnswerGhostOnMaze() {
		for(int i=0;i<answerGhosts.size();i++) {
			mazeMatrix[answerGhosts.get(i).getX()][answerGhosts.get(i).getY()]=answerGhosts.get(i);
		}
	}
	
	public void removeAllAnswerGhosts() {
		for(int i=0;i<answerGhosts.size();i++) {
			if(answerGhosts.get(i)!=null) {
				this.getAnswerGhosts().get(i).setStopFlag(true);
			
			}
		}
		answerGhosts.clear();
	}
	
		
		
		public Object movePackManUp() {
			int chooseQues=0;
				if(mazeMatrix[pacMan.getX()-1][pacMan.getY()] instanceof Sugar)
			    {
					if(!((Sugar)mazeMatrix[pacMan.getX()-1][pacMan.getY()]).getSugType().equals(
							Constants.SugarType.QuestionSugar)){
						
						String sugType=((Sugar)mazeMatrix[pacMan.getX()-1][pacMan.getY()]).getSugType().toString();
					setPacManAtUp();
					pacMan.setPacManImg(Constants.Directions.up);
					return sugType;
					}
					else
					{
						if(this.getAnswerGhosts().size()>0) {
							return null;
						}
						else
						{
						Random random=new Random();
						if(quesToChooseFrom.size()>0) {
						   chooseQues=random.nextInt(quesToChooseFrom.size());
						   question=quesToChooseFrom.get(chooseQues);
						}
						setPacManAtUp();
						pacMan.setPacManImg(Constants.Directions.up);
						if(question!=null) {
						initializeAnswerGhosts(question.getCorrectAnswer());
						return question;
						}
						}
					}
				}
				if(mazeMatrix[pacMan.getX()-1][pacMan.getY()] instanceof RegularGhost
						&& !(mazeMatrix[pacMan.getX()-1][pacMan.getY()] instanceof AnswerGhost)) 
					{
				
					setPacManAtUp();
					pacMan.setPacManImg(Constants.Directions.up);
					return new String("RegularGhost");
				}
				if(mazeMatrix[pacMan.getX()-1][pacMan.getY()] instanceof RegularGhost
						&& mazeMatrix[pacMan.getX()-1][pacMan.getY()] instanceof AnswerGhost)
					{
					
					String answerStatus=((AnswerGhost)mazeMatrix[pacMan.getX()-1][pacMan.getY()]).getAnswerStatus().toString();
						setPacManAtUp();
						pacMan.setPacManImg(Constants.Directions.up);
						removeAllAnswerGhosts();
						return answerStatus;
					}
				if(mazeMatrix[pacMan.getX()-1][pacMan.getY()]==null) {
					setPacManAtUp();
					pacMan.setPacManImg(Constants.Directions.up);
					return null;
				}
				else
					return null;
				
				}
		
		public Object movePackManDown() {
			int chooseQues=0;
			if(mazeMatrix[pacMan.getX()+1][pacMan.getY()] instanceof Sugar)
		    {
				if(!((Sugar)mazeMatrix[pacMan.getX()+1][pacMan.getY()]).getSugType().equals(
						Constants.SugarType.QuestionSugar)){
					String sugType=((Sugar)mazeMatrix[pacMan.getX()+1][pacMan.getY()]).getSugType().toString();
				setPacManAtDown();
				pacMan.setPacManImg(Constants.Directions.down);
				return sugType;
				}
				else
				{

					if(this.getAnswerGhosts().size()>0) {
						return null;
					}
					else
					{
					Random random=new Random();
					if(quesToChooseFrom.size()>0) {

					   chooseQues=random.nextInt(quesToChooseFrom.size());
					   question=quesToChooseFrom.get(chooseQues);
					}
					setPacManAtDown();
					pacMan.setPacManImg(Constants.Directions.down);
					if(question!=null) {
					initializeAnswerGhosts(question.getCorrectAnswer());
					return question;
					}
				}
			}
		    }
			if(mazeMatrix[pacMan.getX()+1][pacMan.getY()] instanceof RegularGhost
					&& !(mazeMatrix[pacMan.getX()+1][pacMan.getY()] instanceof AnswerGhost)) 
			{
				setPacManAtDown();
				pacMan.setPacManImg(Constants.Directions.down);
				return new String("RegularGhost");
			}
			if(mazeMatrix[pacMan.getX()+1][pacMan.getY()] instanceof RegularGhost
					&& mazeMatrix[pacMan.getX()+1][pacMan.getY()] instanceof AnswerGhost) 
		
			{
				String answerStatus=((AnswerGhost)mazeMatrix[pacMan.getX()+1][pacMan.getY()]).getAnswerStatus().toString();
				setPacManAtDown();
				pacMan.setPacManImg(Constants.Directions.down);
				removeAllAnswerGhosts();
				return answerStatus;
				}
			if(mazeMatrix[pacMan.getX()+1][pacMan.getY()]==null) {
				setPacManAtDown();
				pacMan.setPacManImg(Constants.Directions.down);
				return null;
			}
			else
			{
				return null;
			}
			
			}
			
			
			
		public Object movePackManRight() {
			int chooseQues=0;
			if(mazeMatrix[pacMan.getX()][pacMan.getY()+1] instanceof Sugar)
		    {
				if(!((Sugar)mazeMatrix[pacMan.getX()][pacMan.getY()+1]).getSugType().equals(
						Constants.SugarType.QuestionSugar)){
					String sugType=((Sugar)mazeMatrix[pacMan.getX()][pacMan.getY()+1]).getSugType().toString();
				setPacManAtRight();
				pacMan.setPacManImg(Constants.Directions.right);
				return sugType;
				}
				else
				{

					if(this.getAnswerGhosts().size()>0) {
						return null;
					}
					else
					{
					Random random=new Random();
					if(quesToChooseFrom.size()>0) {
						System.out.println("llll");
					   chooseQues=random.nextInt(quesToChooseFrom.size());
					   question=quesToChooseFrom.get(chooseQues);
					}
					setPacManAtRight();
					pacMan.setPacManImg(Constants.Directions.right);
					if(question!=null) {
						System.out.println("llll");
					initializeAnswerGhosts(question.getCorrectAnswer());
					return question;
					}
				}
				}
			}
			
			if(mazeMatrix[pacMan.getX()][pacMan.getY()+1] instanceof RegularGhost
					&& !(mazeMatrix[pacMan.getX()][pacMan.getY()+1] instanceof AnswerGhost)) {
				setPacManAtRight();
				pacMan.setPacManImg(Constants.Directions.right);
				return new String("RegularGhost");
			}
			if(mazeMatrix[pacMan.getX()][pacMan.getY()+1] instanceof RegularGhost
					&& (mazeMatrix[pacMan.getX()][pacMan.getY()+1] instanceof AnswerGhost) )
			
			{
				String answerStatus=((AnswerGhost)mazeMatrix[pacMan.getX()][pacMan.getY()+1]).getAnswerStatus().toString();
				setPacManAtRight();
				pacMan.setPacManImg(Constants.Directions.right);
					removeAllAnswerGhosts();
					return answerStatus;
				}
			if(mazeMatrix[pacMan.getX()][pacMan.getY()+1]==null) {
				setPacManAtRight();
				pacMan.setPacManImg(Constants.Directions.right);
				return null;
				
			}
			else
			{
				return null;
			}
		
	}
		
		public Object movePackManLeft(){
			int chooseQues=0;
			if(mazeMatrix[pacMan.getX()][pacMan.getY()-1] instanceof Sugar)
		    {
				if(!((Sugar)mazeMatrix[pacMan.getX()][pacMan.getY()-1]).getSugType().equals(
						Constants.SugarType.QuestionSugar)){
					String sugType=((Sugar)mazeMatrix[pacMan.getX()][pacMan.getY()-1]).getSugType().toString();
					setPacManAtLeft();
					pacMan.setPacManImg(Constants.Directions.left);
				return sugType;
				}
				else
				{

					if(this.getAnswerGhosts().size()>0) {
						return null;
					}
					else
					{
					Random random=new Random();
					if(quesToChooseFrom.size()>0) {
						System.out.println("llll");
					   chooseQues=random.nextInt(quesToChooseFrom.size());
					   question=quesToChooseFrom.get(chooseQues);
					}
					setPacManAtLeft();
					pacMan.setPacManImg(Constants.Directions.left);
					if(question!=null) 	{
						System.out.println("llll");
					initializeAnswerGhosts(question.getCorrectAnswer());
					return question;
					}
					}
				}
			}
				if(mazeMatrix[pacMan.getX()][pacMan.getY()-1] instanceof RegularGhost
					&& !(mazeMatrix[pacMan.getX()][pacMan.getY()-1] instanceof AnswerGhost)) {
				setPacManAtLeft();
				pacMan.setPacManImg(Constants.Directions.left);
				return new String("RegularGhost");
			}
				if(mazeMatrix[pacMan.getX()][pacMan.getY()-1] instanceof RegularGhost
						&& mazeMatrix[pacMan.getX()][pacMan.getY()-1] instanceof AnswerGhost) 
					
			{
				String answerStatus=((AnswerGhost)mazeMatrix[pacMan.getX()][pacMan.getY()-1]).getAnswerStatus().toString();
				setPacManAtLeft();
				pacMan.setPacManImg(Constants.Directions.left);
				removeAllAnswerGhosts();
				return answerStatus;
				}
			if(mazeMatrix[pacMan.getX()][pacMan.getY()-1]==null) {
				setPacManAtLeft();
				pacMan.setPacManImg(Constants.Directions.right);
				return null;
			}
			else
			{
				return null;
			}
			
				
	}
		
	public void setPacManAtUp() {
		mazeMatrix[pacMan.getX()][pacMan.getY()]=null;
		if(!(mazeMatrix[pacMan.getX()-1][pacMan.getY()] instanceof RegularGhost))
		{
			mazeMatrix[pacMan.getX()-1][pacMan.getY()]=null;
		}
		pacMan.moveUp();
		mazeMatrix[pacMan.getX()][pacMan.getY()]=pacMan;
	}
	
	public void setPacManAtDown() {
		mazeMatrix[pacMan.getX()][pacMan.getY()]=null;
		if(!(mazeMatrix[pacMan.getX()+1][pacMan.getY()] instanceof RegularGhost))
		{
			mazeMatrix[pacMan.getX()+1][pacMan.getY()]=null;
		}
		pacMan.moveDown();
		mazeMatrix[pacMan.getX()][pacMan.getY()]=pacMan;
	}
	
	public void setPacManAtLeft() {
		mazeMatrix[pacMan.getX()][pacMan.getY()]=null;
		if(!(mazeMatrix[pacMan.getX()][pacMan.getY()-1] instanceof RegularGhost))
		{
			mazeMatrix[pacMan.getX()][pacMan.getY()-1]=null;
		}
		pacMan.moveLeft();
		mazeMatrix[pacMan.getX()][pacMan.getY()]=pacMan;
	
	}
	
	public void setPacManAtRight() {
		mazeMatrix[pacMan.getX()][pacMan.getY()]=null;
		if(!(mazeMatrix[pacMan.getX()][pacMan.getY()+1] instanceof RegularGhost))
		{
			mazeMatrix[pacMan.getX()][pacMan.getY()+1]=null;
		}
		pacMan.moveRight();
		mazeMatrix[pacMan.getX()][pacMan.getY()]=pacMan;
	}
	
	
	public PacMan getPacMan() {
		return pacMan;
	}
	public void setPacMan(PacMan pacMan) {
		this.pacMan = pacMan;
	}
	public ArrayList<RegularGhost> getRegularGhosts() {
		return regularGhosts;
	}
	public void setRegularGhosts(ArrayList<RegularGhost> regularGhosts) {
		this.regularGhosts = regularGhosts;
	}
	public ArrayList<RegularGhost> getAnswerGhosts() {
		return answerGhosts;
	}
	public void setAnswerGhosts(ArrayList<RegularGhost> answerGhosts) {
		this.answerGhosts = answerGhosts;
	}
	public ArrayList<Sugar> getSugars() {
		return sugars;
	}
	public void setSugars(ArrayList<Sugar> sugars) {
		this.sugars = sugars;
	}
	
	
}
