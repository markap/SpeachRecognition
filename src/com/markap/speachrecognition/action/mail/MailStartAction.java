package com.markap.speachrecognition.action.mail;

import com.markap.speachrecognition.action.Action;

public class MailStartAction implements Action {

	@Override
	public void execute(String input) {
	}

	@Override
	public boolean isAction(String input) {
		return input.contains("mail");
	}

	@Override
	public String getText(String input) {
		return "Mail schreiben. Bitte Empfänger angeben";
	}

}
