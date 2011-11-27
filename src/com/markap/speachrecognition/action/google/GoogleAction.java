package com.markap.speachrecognition.action.google;

import java.util.ArrayList;

import android.app.Activity;

import com.markap.speachrecognition.action.AbstractTopAction;
import com.markap.speachrecognition.action.Action;

public class GoogleAction extends AbstractTopAction {

	private Activity activity;

	public GoogleAction(Activity activity) {
		this.activity = activity;
		init();
	}

	@Override
	protected void init() {
		steps = new ArrayList<Action>();
		steps.add(new GoogleStartAction(this));
		steps.add(new GoogleSearchAction(this, activity));
		
		currentStep = steps.get(0);
	}

}
