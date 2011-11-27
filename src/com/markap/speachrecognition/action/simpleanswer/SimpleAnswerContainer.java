package com.markap.speachrecognition.action.simpleanswer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.markap.speachrecognition.util.SimpleAnswer;

public class SimpleAnswerContainer {

	List<SimpleAnswer> list;
	
	
	public SimpleAnswerContainer() {
		list = new ArrayList<SimpleAnswer>();
		list.add(new SimpleAnswer("wie geht es dir", "Wenn es dir gut geht, geht es auch mir gut!"));
		list.add(new SimpleAnswer("wie hei§t du", "Mein Name ist Miri"));
	}
	
	
	public SimpleAnswer getSimpleAnswer(String input) {
		for (SimpleAnswer answer : list) {
			if (input.contains(answer.getQuestion()) 
					|| StringUtils.getLevenshteinDistance(input, answer.getQuestion()) < 3) {
				return answer;
			}
		}
		return null;
	}
	
}
