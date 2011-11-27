package com.markap.speachrecognition.action.addsimpleanswer;

import com.markap.speachrecognition.action.Action;

public class AddSimpleAnswerAddAnswerAction implements Action {

	public AddSimpleAnswerAction parentAction;
	
	public AddSimpleAnswerAddAnswerAction(AddSimpleAnswerAction action) {
		this.parentAction = action;
	}

	@Override
	public void execute(String input) {
		parentAction.getSimpleAnswer().setAnswer(input);
	}

	@Override
	public boolean isAction(String input) {
		return true;
	}

	@Override
	public String getText(String input) {
		return "Ist " + parentAction.getSimpleAnswer().getAnswer() + " richtig?";
	}

}
