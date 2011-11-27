package com.markap.speachrecognition.action.mail;

import java.util.ArrayList;

import com.markap.speachrecognition.action.AbstractTopAction;
import com.markap.speachrecognition.action.Action;
import com.markap.speachrecognition.util.ContactHandler;

public class MailAction extends AbstractTopAction {

	private String receiver;
	private String subject;
	private ContactHandler contactHandler;
	
	public MailAction(ContactHandler contactHandler) {
		this.contactHandler = contactHandler;
		init();
	}
	
	protected void init() {
		steps = new ArrayList<Action>();
		steps.add(new MailStartAction());
		steps.add(new MailReceiverAction(this, contactHandler));
		
		currentStep = steps.get(0);
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}


	public void insertAction(Action mailReceiverAction) {
		for (int i = 0; i < steps.size(); i++) {
			Action action = steps.get(i);
			if (action == currentStep) {
				steps.add(i + 1, mailReceiverAction);
				break;
			}
		}
	}
}
