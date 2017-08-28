package com.libertymutual.goforcode.timeless.models;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TimeSheetTests {
	
	private TimeSheet command;
	private ArrayList<Double> testTimeSheet;
	private String date;
    private double sundayTime;
    private double mondayTime;
    private double tuesdayTime;
    private double wednesdayTime;
    private double thursdayTime;
    private double fridayTime;
    private double saturdayTime;
    private double totalHours;
    private ArrayList<Double> hours;
    
    @Test
	public void test_sunday_hours() {
    	//Arrange
    		//done in @before
		
		// Act
		sundayTime = command.getSundayTime();
		
		// Assert
		assertThat(sundayTime).isEqualTo(1.0);		
	}
    
    @Test
	public void test_monday_hours() {
    	//Arrange
    		//done in @before
		
		// Act
		mondayTime = command.getMondayTime();
		
		// Assert
		assertThat(mondayTime).isEqualTo(2.0);		
	}
    
    @Test
	public void test_tuesday_hours() {
    	//Arrange
    		//done in @before
		
		// Act
		tuesdayTime = command.getTuesdayTime();
		
		// Assert
		assertThat(tuesdayTime).isEqualTo(3.0);		
	}
    
    @Test
	public void test_wednesday_hours() {
    	//Arrange
    		//done in @before
		
		// Act
		wednesdayTime = command.getWednesdayTime();
		
		// Assert
		assertThat(wednesdayTime).isEqualTo(4.0);		
	}
    
    @Test
	public void test_thursday_hours() {
    	//Arrange
    		//done in @before
		
		// Act
		thursdayTime = command.getThursdayTime();
		
		// Assert
		assertThat(thursdayTime).isEqualTo(5.0);		
	}
    
    @Test
	public void test_friday_hours() {
    	//Arrange
    		//done in @before
		
		// Act
		fridayTime = command.getFridayTime();
		
		// Assert
		assertThat(fridayTime).isEqualTo(6.0);		
	}
    
    @Test
	public void test_saturday_hours() {
    	//Arrange
    		//done in @before
		
		// Act
		saturdayTime = command.getSaturdayTime();
		
		// Assert
		assertThat(saturdayTime).isEqualTo(7.0);		
	}
    
    @Test
    public void test_get_date() {
    	//Arrange
    		//done in @before
    	
    	//Act
    	date = command.getDate();
    	
    	//Assert
    	assertThat(date).isEqualTo("06/10/1992");
    }
    
    @Test
    public void test_get_sum() {
    	//Arrange
    		//done in @before
    	
    	//Act
    	totalHours = command.getSum();
    	
    	//Assert
    	assertThat(totalHours).isEqualTo(28);
    }
    
    @Test
    public void test_total_Hours_For_Week_array_list() {
    	//Arrange
		ArrayList<Double> totalHoursForWeek = new ArrayList<Double>();
		totalHoursForWeek.add(sundayTime);
		totalHoursForWeek.add(mondayTime);
		totalHoursForWeek.add(tuesdayTime);
		totalHoursForWeek.add(wednesdayTime);
		totalHoursForWeek.add(thursdayTime);
		totalHoursForWeek.add(fridayTime);
		totalHoursForWeek.add(saturdayTime);
		
		//Act
		hours = command.getAllHours();
		
		//Assert
		assertThat(hours).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0);
		
	}
	
	@Before
	public void setUp() {
		//Construct test time sheet array list with values
		testTimeSheet = new ArrayList<Double>();
		testTimeSheet.add(1.0);
		testTimeSheet.add(2.0);
		testTimeSheet.add(3.0);
		testTimeSheet.add(4.0);
		testTimeSheet.add(5.0);
		testTimeSheet.add(6.0);
		testTimeSheet.add(7.0);
		
		//instantiate TimeSheet and set date and hours.
		command = new TimeSheet();
		command.setDate("06/10/1992");
		command.setSundayTime(1.0);
		command.setMondayTime(2.0);
		command.setTuesdayTime(3.0);
		command.setWednesdayTime(4.0);
		command.setThursdayTime(5.0);
		command.setFridayTime(6.0);
		command.setSaturdayTime(7.0);
	}

}
