package com.markap.speachrecognition.action;

import java.util.List;

import com.markap.speachrecognition.util.Contact;

abstract public class AbstractTopAction implements TopAction {
	
	protected List<Action> steps;
	
	protected Action currentStep;
	
	protected Contact contact;

	private String content;

	public boolean isAction(String input) {
		return currentStep.isAction(input);
	}


	public String getText(String input) {
		return currentStep.getText(null);
	}


	public String getContent() {
		return content;
	}

	
	public void setContent(String content) {
		this.content = content;
	}

	public void execute(String input) {
		currentStep.execute(input);
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}


	@Override
	public void nextStep() {
		for (int i = 0; i < steps.size(); i++) {
			Action action = steps.get(i);
			if (action == currentStep) {
				currentStep = steps.get((i + 1) % steps.size());
				break;
			}
		}
	}


	@Override
	public void reset() {
		init();
	}
	
	abstract protected void init();


}
