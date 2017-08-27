package com.libertymutual.goforcode.timeless.models;

import java.util.ArrayList;

public class TimeSheet {
	
    private String date;
    private double sundayTime;
    private double mondayTime;
    private double tuesdayTime;
    private double wednesdayTime;
    private double thursdayTime;
    private double fridayTime;
    private double saturdayTime;
    
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

	public double getSum() {
		return this.sundayTime + this.mondayTime + this.tuesdayTime + this.wednesdayTime + this.thursdayTime + this.fridayTime + this.saturdayTime;
	}

	public ArrayList<Double> getAllHours()
	{
		ArrayList<Double> totalHoursForWeek = new ArrayList<Double>();
		totalHoursForWeek.add(sundayTime);
		totalHoursForWeek.add(mondayTime);
		totalHoursForWeek.add(tuesdayTime);
		totalHoursForWeek.add(wednesdayTime);
		totalHoursForWeek.add(thursdayTime);
		totalHoursForWeek.add(fridayTime);
		totalHoursForWeek.add(saturdayTime);
		return totalHoursForWeek;
	}

	public double getSundayTime() {
		return sundayTime;
	}

	public void setSundayTime(double sundayTime) {
		this.sundayTime = sundayTime;
	}

	public double getSaturdayTime() {
		return saturdayTime;
	}

	public void setSaturdayTime(double saturdayTime) {
		this.saturdayTime = saturdayTime;
	}
	
}
