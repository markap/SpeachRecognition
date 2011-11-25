package com.markap.speachrecognition;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class CallAction implements ActionInterface {
	
	private Activity activity;
	private Contact contact;

	public CallAction(Activity activity, Contact contact) {
		this.activity = activity;
		this.contact = contact;
	}

	@Override
	public void execute() {
		activity.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contact.getPhone())));	
	}

}
