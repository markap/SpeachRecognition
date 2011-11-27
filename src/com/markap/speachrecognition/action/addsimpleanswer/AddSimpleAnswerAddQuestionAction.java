package com.markap.speachrecognition.action.addsimpleanswer;

import com.markap.speachrecognition.action.Action;

public class AddSimpleAnswerAddQuestionAction implements Action {
	
	public AddSimpleAnswerAction parentAction;
	
	public AddSimpleAnswerAddQuestionAction(AddSimpleAnswerAction action) {
		this.parentAction = action;
	}

	@Override
	public void execute(String input) {
		parentAction.getSimpleAnswer().setQuestion(input);
	}

	@Override
	public boolean isAction(String input) {
		return true;
	}

	@Override
	public String getText(String input) {
		return "Ist " + parentAction.getSimpleAnswer().getQuestion() + " richtig?";
	}

}
