package com.markap.speachrecognition.action.simpleanswer;

import com.markap.speachrecognition.action.TopAction;
import com.markap.speachrecognition.util.SimpleAnswer;

public class SimpleAnswerAction implements TopAction {
	
	SimpleAnswerContainer simpleAnswers;
	SimpleAnswer answer;
	
	public SimpleAnswerAction() {
		simpleAnswers = new SimpleAnswerContainer();
	}

	@Override
	public void execute(String input) {	
	}

	@Override
	public boolean isAction(String input) {
		answer = simpleAnswers.getSimpleAnswer(input);
		return answer != null;
	}

	@Override
	public String getText(String input) {
		return answer.getAnswer();
	}

	@Override
	public void nextStep() {
	}

	@Override
	public void reset() {
	}

}
