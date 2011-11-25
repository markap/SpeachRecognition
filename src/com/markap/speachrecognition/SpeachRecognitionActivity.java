package com.markap.speachrecognition;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SpeachRecognitionActivity extends Activity {
    private static final int VOICE_RECOGNITION_REQUEST_CODE = 0;
	private ContactHandler contactHandler;
	private TextView talkTextView;
	
	private ActionInterface action = null;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        contactHandler = new ContactHandler(this);
        
        talkTextView = (TextView) findViewById(R.id.textview_talk);
        
        Button speakButton = (Button) findViewById(R.id.button_speak);
        speakButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startVoiceRecognitionActivity();
				
			}
		});
    }
    
    
    
    private void startVoiceRecognitionActivity() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Bitte sprechen");
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 5);

        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
    }
    
    private void findContact(String searchTerm) {
    	Contact contact = contactHandler.findContact(searchTerm);
            
        talk("Willst du " + contact.getName() + " (" + contact.getPhone() + " ) anrufen?");
        
        action = new CallAction(this, contact);
     
    }
    

    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {
            // Fill the list view with the strings the recognizer thought it could have heard
            ArrayList<String> matches = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            
            String[] yes = {"Ja", "ok", "yes", "mach es"};
            String[] no = {"Nein", "nš", "ne", "na"};
            
            String topResult = matches.get(0);
            
            if (action != null) {
                for (String y : yes) {
                	if (topResult.equalsIgnoreCase(y)) {
                		action.execute();
                		action = null;
                		return;
                	}
                }
                
                for (String n : no) {
                	if (topResult.equalsIgnoreCase(n)) {
                		action = null;
                		return;
                	}
                }
            }
            
            
            
            LinearLayout layout = (LinearLayout) findViewById(R.id.ll_result);
            
            for (String m : matches) {
            	System.out.println(m);
            	TextView t = new TextView(this);
            	t.setText(m);
            	layout.addView(t);
            	
            }
            
            
            if (matches.get(0).contains("anrufen")) {
            	findContact(matches.get(0).replace("anrufen", ""));
            } else {
            	talk(matches.get(0));
            }
            
            
        } 
        super.onActivityResult(requestCode, resultCode, data);
    }
    
    
    private void talk(String text) {
    	talkTextView.setText(text);
    	
    	String t = URLEncoder.encode(text);
    	Uri myUri = Uri.parse("http://translate.google.de/translate_tts?ie=UTF-8&q=" + t + "&tl=de");
    	MediaPlayer mediaPlayer = new MediaPlayer();
    	mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    	try {
			mediaPlayer.setDataSource(getApplicationContext(), myUri);
			mediaPlayer.prepare();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				startVoiceRecognitionActivity();
				
			}
		});
    	mediaPlayer.start();
    }

}