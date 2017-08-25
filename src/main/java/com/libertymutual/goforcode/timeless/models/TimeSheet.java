package com.libertymutual.goforcode.timeless.models;

public class TimeSheet {
	
    private String date;
    private double mondayTime;
    private double tuesdayTime;
    private double wednesdayTime;
    private double thursdayTime;
    private double fridayTime;
    private double total;
    
    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getMondayTime() {
		return mondayTime;
	}

	public void setMondayTime(double mondayTime) {
		this.mondayTime = mondayTime;
	}

	public double getTuesdayTime() {
		return tuesdayTime;
	}

	public void setTuesdayTime(double tuesdayTime) {
		this.tuesdayTime = tuesdayTime;
	}

	public double getWednesdayTime() {
		return wednesdayTime;
	}

	public void setWednesdayTime(double wednesdayTime) {
		this.wednesdayTime = wednesdayTime;
	}

	public double getThursdayTime() {
		return thursdayTime;
	}

	public void setThursdayTime(double thursdayTime) {
		this.thursdayTime = thursdayTime;
	}

	public double getFridayTime() {
		return fridayTime;
	}

	public void setFridayTime(double fridayTime) {
		this.fridayTime = fridayTime;
	}

	public double getTotal() {
		total = mondayTime + tuesdayTime + wednesdayTime + thursdayTime + fridayTime;
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
