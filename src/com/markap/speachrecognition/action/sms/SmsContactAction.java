package com.markap.speachrecognition.action.sms;

import com.markap.speachrecognition.action.Action;
import com.markap.speachrecognition.util.ContactHandler;

public class SmsContactAction implements Action {

	private SmsAction parentAction;
	private ContactHandler contactHandler;

	public SmsContactAction(SmsAction smsAction, ContactHandler contactHandler) {
		this.parentAction = smsAction;
		this.contactHandler = contactHandler;
	}

	@Override
	public void execute(String input) {
		parentAction.setContact(contactHandler.findContact(input));

	}

	@Override
	public boolean isAction(String input) {
		return input.contains("sms");
	}

	@Override
	public String getText(String input) {
		return "Sms an " + parentAction.getContact().getName() + " erstellen. Bitte Inhalt eingeben.";
	}

}
