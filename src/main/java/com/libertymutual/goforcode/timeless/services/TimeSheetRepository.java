package com.libertymutual.goforcode.timeless.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.libertymutual.goforcode.timeless.models.TimeSheet;

@Service
public class TimeSheetRepository {

	private ArrayList<TimeSheet> timeList;

	public TimeSheetRepository() {

	}

	/**
	 * Get all the items from the file.
	 * 
	 * @return A list of the items. If no items exist, returns an empty list.
	 */
	public List<TimeSheet> getAll() {

		try (FileReader reader = new FileReader("timesheet.csv");
				CSVParser parser = new CSVParser(reader, CSVFormat.RFC4180);) {

			List<CSVRecord> record = CSVFormat.DEFAULT.parse(reader).getRecords();
			timeList = new ArrayList<TimeSheet>();

			for (CSVRecord current : record) {
				TimeSheet item = new TimeSheet();
				item.setDate((current.get(0)));
				item.setMondayTime(Double.parseDouble(current.get(1)));
				item.setTuesdayTime(Double.parseDouble(current.get(2)));
				item.setWednesdayTime(Double.parseDouble(current.get(3)));
				item.setThursdayTime(Double.parseDouble(current.get(4)));
				item.setFridayTime(Double.parseDouble(current.get(5)));
				item.setTotal(Double.parseDouble(current.get(6)));
				timeList.add(item);
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("Could not find file.");
		} catch (IOException ioe) {
			System.err.println("Could not read file.");
		}

		if (timeList.size() == 0) {
			return Collections.emptyList();
		}

		return timeList;

	}

	/**
	 * Assigns a new id to the ToDoItem and saves it to the file.
	 * 
	 * @param item
	 *            The to-do item to save to the file.
	 */
	public void create(TimeSheet item) {
		
		try (FileWriter writer = new FileWriter("timesheet.csv", true);
				CSVPrinter printer = new CSVPrinter(writer, CSVFormat.RFC4180)) {
			String[] record = { item.getDate(), Double.toString(item.getMondayTime()), Double.toString(item.getTuesdayTime()), Double.toString(item.getWednesdayTime()),
					Double.toString(item.getThursdayTime()), Double.toString(item.getFridayTime()), Double.toString(item.getTotal()) };
			printer.printRecord(record);
		} catch (FileNotFoundException fnfe) {
			System.err.println("Could not find file.");
		} catch (IOException ioe) {
			System.err.println("Could not read file.");
		}
	}

}
