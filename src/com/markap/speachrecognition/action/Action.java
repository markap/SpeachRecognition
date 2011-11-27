package com.markap.speachrecognition.action;

public interface Action {

	
	public void execute(String input);
	
	public boolean isAction(String input);
	
	public String getText(String input);
}
