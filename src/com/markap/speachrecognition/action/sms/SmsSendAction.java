package com.markap.speachrecognition.action.sms;

import android.telephony.SmsManager;

import com.markap.speachrecognition.action.Action;
import com.markap.speachrecognition.util.ActionHelper;

public class SmsSendAction implements Action {
	
	private SmsAction parentAction;

	public SmsSendAction(SmsAction parentAction) {
		this.parentAction = parentAction;
	}

	@Override
	public void execute(String input) {
		SmsManager sm = SmsManager.getDefault();
		sm.sendTextMessage(parentAction.getContact().getPhone(), null, parentAction.getContent(), null, null);  	
	}

	@Override
	public boolean isAction(String input) {
		return ActionHelper.isInputYes(input);
	}

	@Override
	public String getText(String input) {
		
		return "Sms gesendet";
	}

}
