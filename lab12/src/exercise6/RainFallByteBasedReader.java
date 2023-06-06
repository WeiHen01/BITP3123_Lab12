package exercise6;

import java.io.DataInputStream;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * This program enables Processing Daily Rainfall Data from Selected Station using Byte-Based Stream
 * The data is read in byte-based using DataInputStream class. 
 * The data represents station id, station name, name of district and 6-days reading of daily rainfall.
 * 
 * @author Ng Wei Hen
 *
 */
public class RainFallByteBasedReader {

	public static void main(String[] args) {

		// 1. Declare source file 
		String sourceFile = "RainfallByteBased.txt";
		System.out.println("Reading data from " + sourceFile + "\n");
		
		try {

			// 2. Create input stream to read data
			DataInputStream disIn = new DataInputStream(new FileInputStream(sourceFile));

			// Variables for processing byte-based data
			// Station Id
			int id = 0;
			
			// Station Name and District
			String station = " ", district = " ";
			
			// Daily rainfall readings from 1 June 2023 to 6 June 2023
			double readings1 = 0.0, readings2 = 0.0, readings3 = 0.0;
			double readings4 = 0.0, readings5 = 0.0, readings6 = 0.0;
			
			// Variable declaration for calculation
			// Total number of records read from the source file
			int noOfRecords = 0;
			
			// Total daily rainfall readings for each station
			double sum = 0.0;
			// Declaration of Arraylist to store the each total daily rainfall readings
			ArrayList <Double> totalRainfall = new ArrayList<Double>();
			
			// ArrayList to store stations for calculation purpose
			ArrayList<String> stations = new ArrayList<String>();
						
			// HashSet to store distinct district for calculation purpose
			HashSet<String> districtCount = new HashSet<String>();
			
			
			// 3. Process data until end-of-file
			while(disIn.available() > 0) {
				
				// Read data
				
				// station id
				id = disIn.readInt();
				
				// station name
				station = disIn.readUTF();
				
				// district
				district = disIn.readUTF();
				
				// daily rainfall readings for 1 June 2023
				readings1 = disIn.readDouble();
				
				// daily rainfall readings for 2 June 2023
				readings2 = disIn.readDouble();
				
				// daily rainfall readings for 3 June 2023
				readings3 = disIn.readDouble();
				
				// daily rainfall readings for 4 June 2023
				readings4 = disIn.readDouble();
				
				// daily rainfall readings for 5 June 2023
				readings5 = disIn.readDouble();
				
				// daily rainfall readings for 6 June 2023
				readings6 = disIn.readDouble();
				
				System.out.println( id + "\t" + station + "\t" + district
						+ "\t" + readings1 + "\t" + readings2 + "\t" + readings3 
						+ "\t" + readings4 + "\t" + readings5 + "\t" + readings6 );
				
				// calculate total daily rainfall readings for each station
				sum = readings1 + readings2 + readings3 + readings4 + readings5 + readings6;
				
				// save the sum into the arraylist, totalRainfall
				totalRainfall.add(sum);
				
				// save the station names into the arraylist, stations
				stations.add(station);
				
				// save the distinct district into hashSet, districtCount
				districtCount.add(district);
				
				// Auto update for current number of records
				noOfRecords ++;
			}
			
			System.out.println("\n");
			
			// Calculation for average daily rainfall readings in each station
			for(int index = 0; index < stations.size(); index++)
			{
				// Calculation for average daily rainfall readings in each station
				double average = totalRainfall.get(index) / noOfRecords;
				
				// format the average in one decimal places
				String formattedAverage = String.format("%.1f", average);
				
				// display the total daily rainfall readings in each station and its correspond average
				System.out.println("The total daily rainfall readings in " + stations.get(index) + " : " 
						+ totalRainfall.get(index) );
				System.out.println("The average daily rainfall readings in " + stations.get(index) + " : " 
						+ formattedAverage + "\n");
			}
			
			System.out.println("There are " + stations.size() + " stations and "
						+ districtCount.size() + " districts in Melaka.");
			
			// 4. Close stream
			disIn.close();
	
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");
	}
}
