package giraffeModel;

import java.util.ArrayList;
import java.util.List;

public class Question {

	private String question;
	private List<String> answers;
	private int correct_ans;
	private int level;
	private String team;
	/**
	 * A Full Constructor 
	 * @param question 
	 * @param answers
	 * @param correctAnswer
	 * @param level
	 * @param team
	 */
	public Question(String question, int correctAnswer, int level, String team) {
		super();
		this.question = question;
		this.answers = new ArrayList<>();
		this.correct_ans = correctAnswer;
		this.level = level;
		this.team = team;
	}
	public Question(String question) {
		super();
		this.question = question;
		this.answers = new ArrayList<>();
	}
	
	public Question() {
		super();
		this.answers = new ArrayList<>();
	}
	
	
	
	////// Gettters and Setters 
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(String ans) {
		if(this.answers !=null && this.answers.size()<4) {
			addAnswer(ans);
		}
	}
	public int getCorrectAnswer() {
		return correct_ans;
	}
	public void setCorrectAnswer(int correctAnswer) {
		this.correct_ans = correctAnswer;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public boolean addAnswer(String ans) {
		return answers.add(ans);
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
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
		Question other = (Question) obj;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Question [question=" + question + ", answers=" + answers + ", correctAnswer=" + correct_ans
				+ ", level=" + level + ", team=" + team + "]";
	}
	
	
	
	

}
