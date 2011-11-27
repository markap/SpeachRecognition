package com.markap.speachrecognition.action.addsimpleanswer;

import com.markap.speachrecognition.action.Action;
import com.markap.speachrecognition.util.ActionHelper;

public class AddSimpleAnswerAnswerCorrectionAction implements Action {
	
	public AddSimpleAnswerAction parentAction;
	
	public AddSimpleAnswerAnswerCorrectionAction(AddSimpleAnswerAction action) {
		this.parentAction = action;
	}

	@Override
	public void execute(String input) {
	}

	@Override
	public boolean isAction(String input) {
		return ActionHelper.isInputNo(input) || ActionHelper.isInputYes(input);
	}

	@Override
	public String getText(String input) {
		if (ActionHelper.isInputYes(input)) {
			return "Frage und Antwort hinzugefügt. Weitere hinzufügen?";
		} 
		
		parentAction.goStepBack();
		return "Bitte gib deine Antwort noch einmal ein.";
	}

}
