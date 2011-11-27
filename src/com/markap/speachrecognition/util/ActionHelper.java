package com.markap.speachrecognition.util;

public class ActionHelper {

	
	public static boolean isInputYes(String input) {
		String[] yes = {"Ja", "ok", "yes", "mach es", "jub", "jab", "jap", "jo", "ja ja"};
        

        for (String y : yes) {
        	if (input.equalsIgnoreCase(y)) {
        		return true;
        	}
        }
        return false;
	}
	
	
	public static boolean isInputNo(String input) {
		String[] no = {"Ne", "Nein", "Not", "Cancel", "stop", "abbrechen", "nš", "na", "nicht"};
        

        for (String n : no) {
        	if (input.equalsIgnoreCase(n)) {
        		return true;
        	}
        }
        return false;
	}
}
