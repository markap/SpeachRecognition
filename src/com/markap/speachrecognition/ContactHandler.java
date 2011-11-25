package com.markap.speachrecognition;

import org.apache.commons.lang3.StringUtils;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts.People;

public class ContactHandler {
	
	private Activity activity;


	public ContactHandler(Activity activity) {
		this.activity = activity;
	}

	
	public Contact findContact(String searchTerm) {
    	// Form an array specifying which columns to return. 
    	String[] projection = new String[] {
    	                             People._ID,
    	                             People.NAME,
    	                             People.NUMBER
    	                          };

    	// Get the base URI for the People table in the Contacts content provider.
    	Uri contacts =  People.CONTENT_URI;

    	// Make the query. 
    	Cursor managedCursor = activity.managedQuery(contacts,
    	                         projection, // Which columns to return 
    	                         null,       // Which rows to return (all rows)
    	                         null,       // Selection arguments (none)
    	                         // Put the results in ascending order by name
    	                         People.NAME + " ASC");
    	
    	int levenstein = 100000;
    	String cName = "";
    	String cPhone = "";
    	
    	if (managedCursor.moveToFirst()) {

            String name; 
            String phoneNumber; 
            int nameColumn = managedCursor.getColumnIndex(People.NAME); 
            int phoneColumn = managedCursor.getColumnIndex(People.NUMBER); 
        
            do {
                // Get the field values
                name = managedCursor.getString(nameColumn);
                phoneNumber = managedCursor.getString(phoneColumn);
                if (name != null && phoneNumber != null) {
                	 int l = StringUtils.getLevenshteinDistance(searchTerm, name);
                	 if (l < levenstein) {
                		 levenstein = l;
                		 cName = name;
                		 cPhone = phoneNumber;
                	 }
                }
                
                               
                // Do something with the values. 
              

            } while (managedCursor.moveToNext());
            
            
            

        }
    	return new Contact(cName, cPhone);
    }
}
