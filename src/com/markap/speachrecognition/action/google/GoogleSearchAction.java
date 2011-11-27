package com.markap.speachrecognition.action.google;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;

import com.markap.speachrecognition.action.AbstractTopAction;
import com.markap.speachrecognition.action.Action;
import com.markap.speachrecognition.util.ActionHelper;

public class GoogleSearchAction implements Action {
	
	
	private AbstractTopAction parentAction;
	private Activity activity;
	
	public GoogleSearchAction(AbstractTopAction action, Activity activity) {
		parentAction = action;
		this.activity = activity;
	}

	@Override
	public void execute(String input) {

		Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
		intent.putExtra(SearchManager.QUERY, parentAction.getContent());
		activity.startActivity(intent);
	}

	@Override
	public boolean isAction(String input) {
		return ActionHelper.isInputYes(input);
	}

	@Override
	public String getText(String input) {
		return "Bei google gesucht";
	}

}
