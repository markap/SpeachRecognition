package com.markap.speachrecognition.util;

public class SimpleAnswer {

	public String question;
	public String answer;
	
	public SimpleAnswer(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	
	public SimpleAnswer() {
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getAnswer() {
		return answer;
	}
}
