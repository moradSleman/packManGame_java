package resourcesFile;

/**
 * 
 * @author Hajar Amara
 * Constants is a class to save all Constants these will not change ever and will reuse them
 *
 */
public class Constants {
  	//**************************************
  	//			Files Locations
  	//**************************************
	  public final static  String QUESTIONFILENAME="src\\resourcesFile\\questions.json";
	  public final static  String PLAYERSHISTORYFILENAME="src\\resourcesFile\\playersHistory.json";
	  public final static String MAP1="src\\resourcesFile\\level2.txt";
	  public final static String MUSIC_BEGIN="src\\resource\\pacman_beginning.wav";
    
  	//**************************************
  	//			Static Variables
  	//**************************************
  	// Indicates top ten players with high scores  
  	public final static int TOPTEN=10;
  	
  	// Indicates the start point of pacman on maze
  	public static final int INITIAL_X =  7;
  	public static final int INITIAL_Y =  21;
  	
  	enum Directions {left,right,up,down};
	enum imgShape {openMouse,closeMouse};
	enum AnswerStatus {True,False};
	enum SugarType{YellowSugar,MoneySugar,BadSugar,QuestionSugar, Flashing};
	enum difficulty{Easy,Normal,Hard};
	
	public static int YellowSugarPoints=1;
	public static int MoneySugarPoints=50;
	public static int TrueEasyQuesAns=100;
	public static int TrueNormalQuesAns=200;
	public static int TrueHardQuesAns=500;
	public static int FalseEasyQuesAns=-250;
	public static int FalseNormalQuesAns=-100;
	public static int FalseHardQuesAns=-50;
	

	public static final int mazeHeight=40;
	public static final int mazewidth=35;
	  
	  
	public static final int InitialPacMan_X =  7;
	public static final int InitialPacMan_Y =  7;
	public static final int InitialPacMan_Points=0;
	public static final int InitialPacMan_Lives=3;
	
	public static final int numOfMoneySugars=5;
	public static final int numOfBadSugars=1;
	public static final int numOfQuestionSugars=3;
	public static final int numOfYellowSugars=40;
	
	public static int emptyCellInMaze=0;
	
	enum answerGhostColor{redAnswer,yellowAnswer,greenAnswer,whiteAnswer};
	
	public static int numOfHistScoreToShow=10;
    
	public static int ROUNDS_NUMBER=3;
  	  
}
