package com.markap.speachrecognition.action.google;

import com.markap.speachrecognition.action.AbstractTopAction;
import com.markap.speachrecognition.action.Action;

public class GoogleStartAction implements Action {

	
	private AbstractTopAction parentAction;
	
	public GoogleStartAction(AbstractTopAction action) {
		parentAction = action;
	}

	@Override
	public void execute(String input) {
		parentAction.setContent(input);
	}

	@Override
	public boolean isAction(String input) {
		return true;
	}

	@Override
	public String getText(String input) {
		return parentAction.getContent() + " nicht gefunden. Bei Google suchen?";
	}

}
