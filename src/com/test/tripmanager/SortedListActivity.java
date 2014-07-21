package com.test.tripmanager;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

/*
 * SortedListActivity class
 */
public class SortedListActivity extends Activity {
	
	ArrayList<Destination> destinationStepsList;
	ListView sortedListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sortedlist);
	
		Intent i = getIntent(); // get intent object from MainActivity
		destinationStepsList = (ArrayList<Destination>) i.getExtras().get("destinationArray"); // return arrayList of Destination objects
		
		Collections.sort(destinationStepsList); // sort ArrayList in the correct order
		
		// display sorted list on UI
		sortedListView = (ListView) findViewById(R.id.list);
		sortedListView.setAdapter(new CustomListViewAdapter(this, destinationStepsList));
	}
}
