package giraffeModel;

public class Constants {
	public enum Directions {left,right,up,down};
	public enum imgShape {openMouse,closeMouse};
	public enum AnswerStatus {True,False};
	public enum SugarType{YellowSugar,MoneySugar,BadSugar,QuestionSugar,Flashing};
	public enum difficulty{Easy,Normal,Hard};
	
	public static int YellowSugarPoints=1;
	public static int MoneySugarPoints=50;
	public static int TrueEasyQuesAns=100;
	public static int TrueNormalQuesAns=200;
	public static int TrueHardQuesAns=500;
	public static int FalseEasyQuesAns=-250;
	public static int FalseNormalQuesAns=-100;
	public static int FalseHardQuesAns=-50;
	public static int mazewidth=46;
	public static int mazeheight=22;

	 public final static  String QUESTIONFILENAME="src\\resourcesFile\\questions.json";
	  public final static  String PLAYERSHISTORYFILENAME="src\\resourcesFile\\playersHistory.json";
	
	  
	public static final int InitialPacMan_X =  7;
	public static final int InitialPacMan_Y =  7;
	public static final int InitialPacMan_Points=0;
	public static final int InitialPacMan_Lives=3;
	
	public static final int numOfMoneySugars=5;
	public static final int numOfBadSugars=1;
	public static final int numOfQuestionSugars=3;
	public static final int numOfYellowSugars=40;
	
	enum answerGhostColor{redAnswer,yellowAnswer,greenAnswer,whiteAnswer};
	
	public static int numOfHistScoreToShow=10;
	
	public static int lives=3;
}
