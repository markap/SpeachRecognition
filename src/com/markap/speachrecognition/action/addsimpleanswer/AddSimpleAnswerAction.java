package com.markap.speachrecognition.action.addsimpleanswer;

import java.util.ArrayList;

import com.markap.speachrecognition.action.AbstractTopAction;
import com.markap.speachrecognition.action.Action;
import com.markap.speachrecognition.util.SimpleAnswer;

public class AddSimpleAnswerAction extends AbstractTopAction {
	
	private SimpleAnswer simpleAnswer;
	

	public AddSimpleAnswerAction() {
		init();
	}

	@Override
	protected void init() {
		steps = new ArrayList<Action>();
		steps.add(new AddSimpleAnswerStartAction());
		steps.add(new AddSimpleAnswerAddQuestionAction(this));
		steps.add(new AddSimpleAnswerQuestionCorrectionAction(this));
		steps.add(new AddSimpleAnswerAddAnswerAction(this));
		steps.add(new AddSimpleAnswerAnswerCorrectionAction(this));
		
		simpleAnswer = new SimpleAnswer();
		
		currentStep = steps.get(0);
	}

	
	public SimpleAnswer getSimpleAnswer() {
		return simpleAnswer;
	}


	public void goStepBack() {
		for (int i = 0; i < steps.size(); i++) {
			Action action = steps.get(i);
			if (action == currentStep) {
				currentStep = steps.get(i - 2);
				break;
			}
		}
	}
}
