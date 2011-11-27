package com.markap.speachrecognition.action.call;

import java.util.ArrayList;

import android.app.Activity;

import com.markap.speachrecognition.action.AbstractTopAction;
import com.markap.speachrecognition.action.Action;
import com.markap.speachrecognition.util.ContactHandler;

public class CallAction extends AbstractTopAction {

	
	private ContactHandler contactHandler;
	private Activity activity;

	public CallAction(Activity activity, ContactHandler contactHandler) {
		this.activity = activity;
		this.contactHandler = contactHandler;
		init();
	}

	@Override
	protected void init() {
		steps = new ArrayList<Action>();
		steps.add(new CallFindContactAction(this, contactHandler));
		steps.add(new CallDialAction(this, activity));
		
		currentStep = steps.get(0);
	}
	
	
}
