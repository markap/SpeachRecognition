package com.markap.speachrecognition.action.sms;

import com.markap.speachrecognition.action.Action;

public class SmsContentAction implements Action {

	private SmsAction parentAction;

	public SmsContentAction(SmsAction smsAction) {
		this.parentAction = smsAction;
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
		return "Sms an " + parentAction.getContact().getName() + "senden?";
	}

}
