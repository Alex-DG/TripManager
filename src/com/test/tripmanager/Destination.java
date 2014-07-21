package com.test.tripmanager;

import android.os.Parcel;
import android.os.Parcelable;

/*
 * Destination destinations to arrive to your destination
 * 
 */
public class Destination implements Parcelable, Comparable<Destination> {
	
	/*
	 * destination private attributes
	 */
	private String _destinationDescription;
	private String _destinationAdditionalInformation;
	private String _seatID;
	private int _destinationStepNumber;
	
	/*
	 * destination constructor
	 */
	public Destination(){}

	public String getDestinationDescription() {
		return _destinationDescription;
	}

	public void setDestinationDescription(String destinationDescription) {
		this._destinationDescription = destinationDescription;
	}

	public int getDestinationStepNumber() {
		return _destinationStepNumber;
	}

	public void setDestinationStepNumber(int destinationStepNumber) {
		this._destinationStepNumber = destinationStepNumber;
	}

	public String getDestinationAdditionalInformation() {
		return _destinationAdditionalInformation;
	}

	public void setDestinationAdditionalInformation(
			String destinationAdditionalInformation) {
		this._destinationAdditionalInformation = destinationAdditionalInformation;
	}

	public String getSeatID() {
		return _seatID;
	}

	public void setSeatID(String seatID) {
		this._seatID = seatID;
	}
	
	

	/******************************
	 * Parcelable implementation  *
	 ******************************/
	
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel pc, int flags) {
		pc.writeString(_destinationDescription);
		pc.writeString(_destinationAdditionalInformation);
		pc.writeString(_seatID);
		pc.writeInt(_destinationStepNumber);	
	}
	
	public static final Parcelable.Creator<Destination> CREATOR
    = new Parcelable.Creator<Destination>() {

		public Destination createFromParcel(Parcel in) {
		    return new Destination(in);
	}

	public Destination[] newArray(int size) {
		    return new Destination[size];
		}
	};
	
	private Destination(Parcel in) {
		_destinationDescription = in.readString();
		_destinationAdditionalInformation = in.readString();
		_seatID = in.readString();
		_destinationStepNumber = in.readInt();
	}
	
	
	
	/******************************
	 * Comparable implementation  *
	 ******************************/

	@Override
	public int compareTo(Destination compareDestination) {
		
		int compareStepNumber = ((Destination) compareDestination).getDestinationStepNumber();
		
		//ascending order
		return this._destinationStepNumber - compareStepNumber;
	}

}
