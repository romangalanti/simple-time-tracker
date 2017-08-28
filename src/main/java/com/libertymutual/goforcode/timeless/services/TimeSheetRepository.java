package com.libertymutual.goforcode.timeless.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.libertymutual.goforcode.timeless.models.TimeSheet;

@Service
public class TimeSheetRepository {

	public TimeSheetRepository() {

	}

	public void writeUpdateWeekToFile(TimeSheet item) {
		try (FileWriter writer = new FileWriter("updatetimesheet.csv");
	         BufferedWriter buff = new BufferedWriter(writer);
	         CSVPrinter printer = new CSVPrinter(buff, CSVFormat.DEFAULT)) {
			
			 ArrayList<String> weekEntry = new ArrayList<String>();
			 weekEntry.add(item.getDate());
			 weekEntry.add(Double.toString(item.getSundayTime()));
			 weekEntry.add(Double.toString(item.getMondayTime()));
			 weekEntry.add(Double.toString(item.getTuesdayTime()));
			 weekEntry.add(Double.toString(item.getWednesdayTime()));
			 weekEntry.add(Double.toString(item.getThursdayTime()));
			 weekEntry.add(Double.toString(item.getFridayTime()));
			 weekEntry.add(Double.toString(item.getSaturdayTime()));
			 weekEntry.add(Double.toString(item.getSum()));
			 
			 printer.printRecord(weekEntry);
			 
		} catch (FileNotFoundException e) {
           	System.err.println("Could not find file");
   		} catch (IOException e) {
   			System.err.println("Could not read file");
   		} 
	}
	
	public TimeSheet getUpdateFile() {
		 	try (FileReader reader = new FileReader("updatetimesheet.csv");
	        BufferedReader buffy = new BufferedReader(reader)) {
			
			Iterable<CSVRecord> record = CSVFormat.DEFAULT.parse(buffy);
			TimeSheet item = new TimeSheet();
			
			for (CSVRecord current : record) {
				item = new TimeSheet();
				item.setDate(current.get(0));
				item.setSundayTime(Double.valueOf(current.get(1)));
				item.setMondayTime(Double.valueOf(current.get(2)));
				item.setTuesdayTime(Double.valueOf(current.get(3)));
				item.setWednesdayTime(Double.valueOf(current.get(4)));
				item.setThursdayTime(Double.valueOf(current.get(5)));
				item.setFridayTime(Double.valueOf(current.get(6)));
				item.setSaturdayTime(Double.valueOf(current.get(7)));
			}
			return item;
			
		} catch (FileNotFoundException e) {
        	System.err.println("Could not find file");
        	return null;
		} catch (IOException e) {
			System.err.println("Could not read file");
			return null;
		}
	}
	
	public void writeWeekToFile(TimeSheet item) {
		try (FileWriter writer = new FileWriter("timesheet.csv", true);
	         BufferedWriter buffy = new BufferedWriter(writer);
	         CSVPrinter printer = new CSVPrinter(buffy, CSVFormat.DEFAULT)) {
			
			 ArrayList<String> weekEntry = new ArrayList<String>();
			 weekEntry.add(item.getDate());
			 weekEntry.add(Double.toString(item.getSundayTime()));
			 weekEntry.add(Double.toString(item.getMondayTime()));
			 weekEntry.add(Double.toString(item.getTuesdayTime()));
			 weekEntry.add(Double.toString(item.getWednesdayTime()));
			 weekEntry.add(Double.toString(item.getThursdayTime()));
			 weekEntry.add(Double.toString(item.getFridayTime()));
			 weekEntry.add(Double.toString(item.getSaturdayTime()));
			 weekEntry.add(Double.toString(item.getSum()));
			 
			 printer.printRecord(weekEntry);
			 
		} catch (FileNotFoundException e) {
           	System.err.println("Could not find file");
   		} catch (IOException e) {
   			System.err.println("Could not read file");
   		} 
	}
	
	public List<TimeSheet> getFileOfWeeks() {
		try (FileReader reader = new FileReader("timesheet.csv");
	         BufferedReader buffy = new BufferedReader(reader)) {
			
			ArrayList<TimeSheet> reverse = new ArrayList<TimeSheet>();
			Iterable<CSVRecord> record = CSVFormat.DEFAULT.parse(buffy);
			
			for (CSVRecord current : record) {
				TimeSheet item = new TimeSheet();
				item.setDate(current.get(0));
				item.setSundayTime(Double.valueOf(current.get(1)));
				item.setMondayTime(Double.valueOf(current.get(2)));
				item.setTuesdayTime(Double.valueOf(current.get(3)));
				item.setWednesdayTime(Double.valueOf(current.get(4)));
				item.setThursdayTime(Double.valueOf(current.get(5)));
				item.setFridayTime(Double.valueOf(current.get(6)));
				item.setSaturdayTime(Double.valueOf(current.get(7)));
				reverse.add(item);
			}
			reverse = reverseCollection(reverse);
			return reverse;
			
		} catch (FileNotFoundException e) {
        	System.err.println("Could not find file");
			return Collections.emptyList();
		} catch (IOException e) {
			System.err.println("Could not read file");
			return Collections.emptyList();
		}
	}
	
	private ArrayList<TimeSheet> reverseCollection(List<TimeSheet> reverse) {
		ArrayList<TimeSheet> reversedList = new ArrayList<TimeSheet>();
		
		for (int i = (reverse.size()-1); i >= 0; i--) {
			reversedList.add(reverse.get(i));
		}
		return reversedList;
	}
	
}
