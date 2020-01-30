package giraffeModel;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/**
 * 
 * @author Hajar Amara
 * Player Class saving details the player and implementing a comparable 
 *
 */
public class Player implements Comparable<Player>{
	
	//**************************************
	//				Variables
	//**************************************
	// player email
	private String playerEmail;
	private String playerUserName;
	// player Scores while playing
	private int playerScore;
	// player password
	private String pass;
	// current password
	private String currentPass;
        //
    private ArrayList<Integer> scores;
	//
	private int highScore;

	//**************************************
	//				constructor
	//**************************************
	// ******** Default constructor ********
	
	//***********Partial Constructor*******
	public Player(String email) {
		super();
		scores=new ArrayList<>();
		this.playerEmail=email;
		 this.setPlayerUserName(playerEmail);
	}
	//***********Partial Constructor*******
	


	public Player() {
		scores=new ArrayList<>();
	}
	public Player(String playerEmail, String pass) {
		super();
		scores=new ArrayList<>();
		this.playerEmail = playerEmail;
		 this.setPlayerUserName(playerEmail);
		this.pass = pass;
	}
	// ********** Full constructor *********
	
//	public Player(String playerUserName, int playerScore, String pass) {
//		super();
//		this.playerUserName = playerUserName;
//		this.playerScore = playerScore;
//		this.pass = pass;
//	}
	//**************************************
	//				GETTERS
	//**************************************
	public String getPlayerUserName() {
		return this.playerUserName;
	}

	public ArrayList<Integer> getPlayerScores() {
		return this.scores;
	}
	public String getPassword() {
		return this.pass;
	}
	public Integer getHighScore() {
		return this.highScore;
	}
	public String getPlayerEmail() {
		return playerEmail;
	}
	
	//**************************************	
	//				SETTERS
	//**************************************
	private void setPlayerUserName(String playerEmail) {
		String[] splitted = playerEmail.split("[@]");
		this.playerUserName=splitted[0];
	}
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}	
	public void setPassword(String password) {
		this.pass=password;
		this.currentPass=this.pass;
	}
	public void setHighScore() {
		int max=0;
		for(int i=0;i<scores.size();i++) {
			if(scores.get(i)>max)
				max=scores.get(i);
		}
		highScore=max;
	}
	public void setPlayerEmail(String playerEmail) {
		this.playerEmail = playerEmail;
	}

	//**************************************
	//			 Helper functions
	//**************************************	
	
         public void addScore(int score) {
		scores.add(score);
	}

	/* (non-Javadoc)
	 * to compare between two playesr by 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Player o) {
		return this.highScore>o.highScore ?1:-1;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playerEmail == null) ? 0 : playerEmail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (playerEmail == null) {
			if (other.playerEmail != null)
				return false;
		} else if (!playerEmail.equals(other.playerEmail))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Player [playerEmail=" + playerEmail + ", playerUserName=" + playerUserName + ", playerScore="
				+ playerScore + ", pass=" + pass + ", currentPass=" + currentPass + ", scores=" + scores
				+ ", highScore=" + highScore + "]";
	}
}
