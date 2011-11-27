package com.markap.speachrecognition.action.call;

import com.markap.speachrecognition.action.Action;
import com.markap.speachrecognition.util.ContactHandler;

public class CallFindContactAction implements Action {


	private ContactHandler contactHandler;
	private CallAction parentAction;
	
	public CallFindContactAction(CallAction callAction, ContactHandler contactHandler) {
		this.parentAction = callAction;
		this.contactHandler = contactHandler;
	}

	@Override
	public void execute(String input) {
		parentAction.setContact(contactHandler.findContact(input));
		
	}

	@Override
	public boolean isAction(String input) {
		return input.contains("anrufen");
	}

	@Override
	public String getText(String input) {
		return "Willst du " + parentAction.getContact().getName() + " (" + parentAction.getContact().getPhone() + " ) anrufen?";
	}

}
