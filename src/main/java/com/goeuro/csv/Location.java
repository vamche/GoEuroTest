package com.goeuro.csv;

public class Location {
	
	int _id;
	String name;
	String type;
	double latitude;
	double longitude;

	
	public int get_id() {
		return _id;
	}


	public void set_id(int _id) {
		this._id = _id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public String toString(){
		return this.get_id() + ", " +
			   this.getName() + ", " +
			   this.getType() + ", " +
			   this.getLatitude() + ", " +
			   this.getLongitude() + "";
		
	}
	
	
}
