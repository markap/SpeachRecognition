package com.markap.speachrecognition.action.call;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.markap.speachrecognition.action.Action;
import com.markap.speachrecognition.util.ActionHelper;

public class CallDialAction implements Action {
	
	private Activity activity;
	private CallAction parentAction;

	public CallDialAction(CallAction parentAction, Activity activity) {
		this.activity = activity;
		this.parentAction = parentAction;
	}

	@Override
	public void execute(String input) {
		activity.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + parentAction.getContact().getPhone())));	
	}

	@Override
	public boolean isAction(String input) {
		 return ActionHelper.isInputYes(input);
	}

	@Override
	public String getText(String input) {
		return "Angerufen";
	}



}
