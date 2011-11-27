package com.markap.speachrecognition.action.addsimpleanswer;

import com.markap.speachrecognition.action.Action;
import com.markap.speachrecognition.util.ActionHelper;

public class AddSimpleAnswerStartAction implements Action {

	@Override
	public void execute(String input) {
	}

	@Override
	public boolean isAction(String input) {
		return ActionHelper.isInputYes(input);
	}

	@Override
	public String getText(String input) {
		return "Bitte deine Frage eingeben";
	}

}
