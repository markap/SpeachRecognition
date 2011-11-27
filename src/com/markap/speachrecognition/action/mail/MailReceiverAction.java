package com.markap.speachrecognition.action.mail;

import com.markap.speachrecognition.action.Action;
import com.markap.speachrecognition.util.Contact;
import com.markap.speachrecognition.util.ContactHandler;

public class MailReceiverAction implements Action {
	
	boolean isReceiverSet = false;
	
	private MailAction parentAction;
	private ContactHandler contactHandler;

	public MailReceiverAction(MailAction mailAction, ContactHandler contactHandler) {
		parentAction = mailAction;
		this.contactHandler = contactHandler;
	}

	@Override
	public void execute(String input) {
		if (input.contains("@") || input.contains(" ")) {
			isReceiverSet = true;
			
			String[] mail = input.split("@");
			
			Contact contact = contactHandler.findContact(mail[0]);
			String name = contact.getName().replace(" ", "");
			
			input = name + mail[1];
		}

		parentAction.setReceiver(input);
	}

	@Override
	public boolean isAction(String input) {
		return true;
	}

	@Override
	public String getText(String input) {
		if (!isReceiverSet) {
			parentAction.insertAction(this);
			return "Bitte nochmal Receiver eingeben";
		}
		return "Mail an " + parentAction.getReceiver() + ". Betreff eingeben.";
	}

}
