package com.test.tripmanager;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/*
 * CustomListViewAdapter Class
 */
public class CustomListViewAdapter extends BaseAdapter {
    
	private ArrayList<?> listData;
    private Activity activity;
    private static LayoutInflater inflater = null;
    
    /*
     * CustomListViewAdapter Contructor
     */
    public CustomListViewAdapter(Activity activity, ArrayList<?> listData) {
    	this.activity = activity;
        this.listData = listData;
        inflater = LayoutInflater.from(this.activity);
    }

    public int getCount() {
        return listData.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        
        if(convertView==null)
        	convertView = inflater.inflate(R.layout.list_row, null);

        TextView transport_description = (TextView) convertView.findViewById(R.id.transport_description);
        TextView additional_information = (TextView) convertView.findViewById(R.id.additional_information);
        TextView seat_id = (TextView) convertView.findViewById(R.id.seat_id);
        
        Destination destination = (Destination) listData.get(position);
        
        if(destination != null){        	
        	transport_description.setText(destination.getDestinationDescription());        	
        	additional_information.setText(destination.getDestinationAdditionalInformation());
        	seat_id.setText(destination.getSeatID()); 
        }
        
        return convertView;
    }
}
