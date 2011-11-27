package com.markap.speachrecognition.action.sms;

import java.util.ArrayList;

import com.markap.speachrecognition.action.AbstractTopAction;
import com.markap.speachrecognition.action.Action;
import com.markap.speachrecognition.util.ContactHandler;

public class SmsAction extends AbstractTopAction {
		
	
	private ContactHandler contactHandler;

	public SmsAction(ContactHandler contactHandler) {
		this.contactHandler = contactHandler;
		init();
	}

	@Override
	protected void init() {
		steps = new ArrayList<Action>();
		steps.add(new SmsContactAction(this, contactHandler));
		steps.add(new SmsContentAction(this));
		steps.add(new SmsSendAction(this));
		
		currentStep = steps.get(0);
	}

	
	
	
}
