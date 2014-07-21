package com.test.tripmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/*
 * MainActivity class
 */
public class MainActivity extends Activity {
	
	ArrayList<Destination> destinationStepsList;
	ListView stepslistView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	

		initializeDestinationSteps(); // initialize ArrayList of Destination objects
		mixUpArrayList(destinationStepsList); // randomize elements order of the ArrayList
		
		stepslistView = (ListView) findViewById(R.id.list);	
		stepslistView.setAdapter(new CustomListViewAdapter(this, destinationStepsList));		
		
		Button sortListButton = (Button) findViewById(R.id.sortlist_button);	
		
		//Button event to send ArrayList of Destination objects to the SortedListActivy
		sortListButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, SortedListActivity.class);
				i.putExtra("destinationArray", destinationStepsList);
				startActivity(i);			
			}
		});
		

	}	
	
	/*
	 * Initialize destination steps
	 */
	private void initializeDestinationSteps() {
		destinationStepsList = new ArrayList<Destination>();
		
		Destination step1 = new Destination();
		step1.setDestinationDescription("Take train 78A from Madrid to Barcelona.");		
		step1.setDestinationAdditionalInformation("Set in seat.");
		step1.setSeatID("seat 45B");
		step1.setDestinationStepNumber(1);
		
		Destination step2 = new Destination();
		step2.setDestinationDescription("Take the airport bus from Barcelona to Gerona Airport");		
		step2.setDestinationAdditionalInformation("No seat assignment.");
		step2.setSeatID("");
		step2.setDestinationStepNumber(2);
		
		Destination step3 = new Destination();
		step3.setDestinationDescription("From Gerona Airport, take flight SK455 to London.");		
		step3.setDestinationAdditionalInformation("Gate 45B. Baggage drop at ticket counter 344.");
		step3.setSeatID("seat 3A");
		step3.setDestinationStepNumber(3);
		
		Destination step4 = new Destination();
		step4.setDestinationDescription("From London, take flight SK22 to New York JFK.");		
		step4.setDestinationAdditionalInformation("Gate 22. Baggage will we automatically transferred from your last leg.");	
		step4.setSeatID("seat 7B");
		step4.setDestinationStepNumber(4);
		
		destinationStepsList.add(step1);
		destinationStepsList.add(step2);
		destinationStepsList.add(step3);
		destinationStepsList.add(step4);
	}

	/*
	 * Randomize ArrayList
	 */
	private void mixUpArrayList(ArrayList<Destination> arrayList) {
		long seed = System.nanoTime();
		Collections.shuffle(arrayList, new Random(seed));		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
