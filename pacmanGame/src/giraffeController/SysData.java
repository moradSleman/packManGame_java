/**
 * 
 */
package giraffeController;

import java.applet.Applet;
import java.applet.AudioClip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.print.DocFlavor.URL;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.tree.ExpandVetoException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import giraffeModel.Player;
import giraffeModel.Question;
import resourcesFile.*;

import sun.audio.*;


public class SysData {
	
	private static SysData sd;
	/**
	 * saving players details in playing time
	 */
	private static ArrayList<Player> players ;
	/**
	 * saving questions details in playing time
	 */
	private static ArrayList<Question> questions ;
	/**
	 * saving the top ten winners taese have the biggest number of scores in the game
	 */
	private static ArrayList<Player> topTenWinners ;
	
	
	private SysData(){
	//	System.out.println("into sys data ");
		players=new ArrayList<>();
		questions=new ArrayList<>();		
		getPlayersfromJson();
		for(Player p:players) {
			System.out.println(p.getPlayerEmail());
		}
		getQuestions();
		System.out.println(questions);
	/*	for(Question q: questions) {
			System.out.println(q.getQuestion());
		}*/
		topTenWinners=new ArrayList<>();
		topTenWinners=readTopTenWinnerPlayers();
	}
	
	public static SysData getInstance() {
		if(sd==null) {
			sd=new SysData();			
		}
		return sd;
	}
	
    //////////////////Getters and Setters
	/**
	 * 
	 * @return  list of players
	 */
	
	public static ArrayList<Player> getPlayersfromJson() {
		if(players.isEmpty())
		{
			readPlayersHistory();
			return players;
		}
		else
		return players;
	}
	public static ArrayList<Question> getQues(){
		return questions;
	}
	/**
	 * 
	 * @return list of questions
	 */
	public static ArrayList<Question> getQuestions() {
		if(questions.isEmpty())
		{
			readQuestions();
			return questions;
		}
		else {
			readQuestions();
		return questions;
		}
	}
	/**
	 * 
	 * @return list of the top ten winners
	 */
	public static ArrayList<Player> getTopTenWinners() {
		return topTenWinners;
	}
	
	public static void setPlayers(ArrayList<Player> players) {
		SysData.players = players;
	}

	public static void setQuestions(ArrayList<Question> questions) {
		SysData.questions = questions;
	}
	
	/**
	 * 
	 * @return list of questions that read from the Json file which include them
	 */
	@SuppressWarnings("unchecked")
	public static boolean readQuestions(){       
        JSONParser parser = new JSONParser();
        Question q=new Question();
        Object object;
        try{
        	 object = parser.parse(new FileReader(Constants.QUESTIONFILENAME));
        	 JSONObject jo=(JSONObject) object;
        	 JSONArray jArr=(JSONArray) jo.get("questions");
        	 if(jArr!=null) {
        		 for(Object obj:jArr) {
            		 JSONObject jobj=(JSONObject) obj;
            		 q.setQuestion(jobj.get("question").toString());
            		 q.setLevel(Integer.parseInt(String.valueOf( jobj.get("level"))));
            		 q.setCorrectAnswer(Integer.parseInt(String.valueOf(jobj.get("correct_ans"))));
            		 q.setTeam(jobj.get("team").toString());        		 
            		 JSONArray answersArr=(JSONArray) jobj.get("answers");
            		 for(Object s: answersArr) {
            			 q.setAnswers((String) s); 
            		 }
            		// System.out.println(q);
            		 addQuestion(q);        		 
            	 }
            	
            	 return true;
        	 }
        	
        	
        }catch (Exception e) {
			e.printStackTrace();
		}
       return false; 
	}

	/**
	 * this method delete the input q and re write into questions.json
	 * @param q
	 * @return true if the file was changed
	 */
	public static boolean deleteQuestion(Question q) {
		if(questions.contains(q)) {
			questions.remove(q);
		/*	removeFile(Constants.QUESTIONFILENAME);
			writeQuestionsAdmin();*/
			return true;
		}
		return false;
	}
	/**
	 * this method delete the input q and re write into questions.json
	 * @param q
	 * @return true if the file was changed
	 */
	public static void deletePlayer(Player p) {
		//removeFile(Constants.PLAYERSHISTORYFILENAME);
		if(players.contains(p)) {
			players.remove(p);
		}
	}
	 /**
	     * 	write a question into the Questions' json file the 
	     * @param question
	     */	
	@SuppressWarnings("unchecked")
	public static void writeQuestionsAdmin() {
		
		
		 JSONArray jarray=new JSONArray();
		 JSONObject object=new JSONObject();

	        	    //object = parser.parse(new FileReader(Constants.QUESTIONFILENAME));
	            for(Question question: getQuestions())   {
	            	JSONObject obj=new JSONObject();
	    			System.out.println("test" + question+ "  kd" );
	        		obj.put("question",question.getQuestion()); 
	        		JSONArray answers = new JSONArray();
	        		for(String ans:question.getAnswers()) {
	        			answers.add(ans);	        			
	        		}
	        		obj.put("answers", answers);
	        		obj.put("correct_ans", question.getCorrectAnswer());
	        		obj.put("level", question.getLevel());
	        		obj.put("team", question.getTeam());
	        		jarray.add(obj);
		    	}
	            try (FileWriter file = new FileWriter(Constants.QUESTIONFILENAME)) {
  	    			object.put("questions", jarray);
  	    			file.write(object.toJSONString());
  	    			file.flush();
//  	    			System.out.println("done"+obj);
  	    		  } 
  	    		   catch(Exception ex) {
  	    		   }
	            	
	}
	
	@SuppressWarnings("unchecked")
	public static boolean removeFile(String str) {
		 File file=null;
		 JSONObject object=new JSONObject();
		switch(str) {
		case Constants.QUESTIONFILENAME:
			 file=new File(Constants.QUESTIONFILENAME);
			if(file.isFile())
				file.delete();
			 try {
				file.createNewFile();
				try(FileWriter fileWriter=new FileWriter(file)){
					object.put("{}", new JSONArray());
					fileWriter.write(object.toJSONString());
				}catch (Exception e) {
					// TODO: handle exception
				}
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 break;
		case Constants.PLAYERSHISTORYFILENAME:
			 file=new File(Constants.PLAYERSHISTORYFILENAME);
			if(file.isFile())
				file.delete();
			 try {
				file.createNewFile();
				try(FileWriter fileWriter=new FileWriter(file)){
					object.put("{}", new JSONArray());
					fileWriter.write(object.toJSONString());
					return true;
				}catch (Exception e) {
					// TODO: handle exception
				}
				
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 break;
		}
		
		 return false;
	}
	
//	
	/**
	 * reading players history from json file
	 * @return a list of players
	 */
	public static boolean readPlayersHistory(){     
		JSONParser parser = new JSONParser();
        Player player=new Player();
        Object object;
        try {
        	 object = parser.parse(new FileReader(Constants.PLAYERSHISTORYFILENAME));
        	 if(object!=null) {
        		 JSONObject jo=(JSONObject) object;
            	 JSONArray jArr=(JSONArray) jo.get("players");
            	 for(Object obj:jArr) {
            		 JSONObject jobj=(JSONObject) obj;
            		 JSONArray scores=(JSONArray) jobj.get("scores");	
            		 player.setPlayerEmail(jobj.get("Email").toString());            		 
            		 for(Object o:scores) {            			
            			 player.addScore( Integer.parseInt(String.valueOf( o)));
            		 }        	     
            		 player.setPassword(jobj.get("password").toString());  
            		 addNewPlayerHistory(player);
            		 System.out.println(player.getPlayerEmail().toString());
            	 }
            	  return true;
            	 
        	 }        	 
        }catch (Exception e) {
			e.printStackTrace();
		}
       return false; 
	}
	/**
	 * update the scores of the player in the game 
	 * @param player
	 */
	public static void  updatePlayerScores(Player player) {
		if(players.contains(player)){
			deletePlayer(player);
			addNewPlayerHistory(player);
		}
	}
	public static ArrayList<Player> getPlayers(){
		return players;
	}
	/**
	 * write the players into json file for the players history
	 */
	
	@SuppressWarnings("unchecked")
	public static void writePlayersJson() {
		 JSONArray jarray=new JSONArray();
		   
		   JSONObject object=new JSONObject();
	            for(Player p: players)   {  
	            	JSONObject obj=new JSONObject();
	        		obj.put("Email",p.getPlayerEmail());
	        		obj.put("UserName",p.getPlayerUserName());
	        		obj.put("password", p.getPassword());
	        		JSONArray scores = new JSONArray();
	        		for(Integer score:p.getPlayerScores()) {
	        			scores.add(score);        			
	        		}
	        		obj.put("scores",scores);
		        	jarray.add(obj);	
		        	
	            }
	            try (FileWriter file = new FileWriter(Constants.PLAYERSHISTORYFILENAME)) {
	    			object.put("players", jarray);
	    			file.write(object.toJSONString());
	    			file.flush();      			
	    		} 
	    		catch(Exception ex) {
	    			
	    		}  
    }
	/**
	 * adding a new player if not exit into the players and then update the player history json file
	 * @param newPlayer
	 */
	public static boolean addNewPlayerHistory(Player newPlayer) {
		if(newPlayer!=null)
		if(!players.contains(newPlayer)) {
	    	 players.add(newPlayer); 
	    	/* removeFile(Constants.PLAYERSHISTORYFILENAME);
			 writePlayersJson();*/
			 return true;
	    	
		}
		return false;
	}
	
	/**
	 * adding a new player if not exit into the players and then update the player history json file
	 * @param newPlayer
	 */
	public static boolean addPlayer(Player newPlayer) {
		return addNewPlayerHistory(newPlayer);
	    	
	}
	///////////////////////////////////////
	/**
	 * adding a new question this is just the admin can do it
	 * @param q
	 * @return true if the question was added successfully 
	 */
	public static boolean addQuestionAdmin(Question q) {
		if(q!=null) {
			if(!questions.contains(q)) {
				return addQuestion(q);
				
			}
		}
		return false;		
	}
	
	/**
	 * adding a question to player
	 * @param q is a question and @param p is the player
	 * @return true if the question was added to the playersQuestions list else will return false
	 */
	public static boolean addQuestion(Question q){
			if(!questions.contains(q)){
				 questions.add(q);
			/*	 removeFile(Constants.QUESTIONFILENAME);
				 writeQuestionsAdmin();*/
				 return true;
			}
		
		return false;
	}
	/**
	 * update a question this is just the admin can do it
	 * @param q
	 * @return true if the question was updated successfully 
	 */
	public static boolean updateQuestion(Question q) {
		if(q!=null) {
			deleteQuestion(q);
			addQuestion(q);
		/*	removeFile(Constants.QUESTIONFILENAME);
			writeQuestionsAdmin();*/
			return true;
		}
		return false;
	}
	/**
	 * reading the top ten players these scored the top ten scores in the game
	 * @return list of the top ten players
	 */
	public static ArrayList<Player> readTopTenWinnerPlayers(){		
		Collections.sort(getPlayers(), (p, p2) -> p.compareTo(p2) );
		ArrayList<Player> topTenPlayers=new ArrayList<>();
		int i=0;
		while(i<Constants.TOPTEN && players.size()>=10) {
			topTenPlayers.add(getPlayers().get(i++));
		}
		return topTenPlayers;
	}
	/**
	 * This method making an encryption for the password
	 * @return an encrypted password
	 */
    public String encryptionPassword(String str){
    	String key= "Bar12345Bar12345"; 
    	String initVector="RandomInitVector";
    	String value=str;
    	   try {
               Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
               IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));

               SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
               cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

               byte[] encrypted = cipher.doFinal(value.getBytes());

               //System.out.println("encrypted string: "
                 //      + Base64.encodeBase64String(encrypted));

               //return Base64.encodeBase64String(encrypted);
               String s = new String(Base64.getEncoder().encode(encrypted));
               return s;
           } catch (Exception ex) {
               ex.printStackTrace();
           }
           return null;
	}
    /**
     * this method decrypt the encrypted password 
     * @return the decrypted password
     */
    public String decryptionPassword(String str){
    	String key= "Bar12345Bar12345"; 
    	String initVector="RandomInitVector";
    	String value=str;
    	 try {
             IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
             SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

             Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
             cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

             byte[] original = cipher.doFinal(Base64.getDecoder().decode(value));

             return new String(original);
         } catch (Exception ex) {
             ex.printStackTrace();
         }

         return null;
  	}
    Clip clip;
    public void playMusic(int num) {
    	
    	 try
		    {
		        
		        switch(num) {
		    	case 0:
		    		clip = AudioSystem.getClip();
			        clip.open(AudioSystem.getAudioInputStream(new File(Constants.MUSIC_BEGIN)));
			        clip.loop(Clip.LOOP_CONTINUOUSLY);
			        break;
		    	case 1:
                     if(clip.isRunning()){
     		    		System.out.println("is running end loooop music");

                    	 clip.flush();
                    	 clip.stop();
                     }
                      
		    		break;
		        }
		    }
		    catch (Exception exc)
		    {
		        exc.printStackTrace(System.out);
		    }

       }
    
    public ArrayList<Integer> playerScores(String email){
    	return getPlayers().contains(email)? getPlayers().get(getPlayers().indexOf(new Player(email))).getPlayerScores():null;
    }
    
  
    
    
	////// connecting with the entities into model 
}
