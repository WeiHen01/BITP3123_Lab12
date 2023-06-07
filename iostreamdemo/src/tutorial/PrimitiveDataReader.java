package tutorial;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * This program demonstrate reading byte-based data as it intended type 
 * it is using DataInputStream.
 * 
 * The data represents bed utilization for COVID-19 cases in several states of Malaysia.
 * 
 * The program calculates the average bed utilization and display it on the console.
 * 
 * @author emalianakasmuri
 *
 */
public class PrimitiveDataReader {

	public static void main(String[] args) {

		// 1. Declare output file 
		String sourceFile = "bedUtilization1.txt";
		System.out.println("Reading data from " + sourceFile + "\n");

		try {

			// 2. Create stream to read data
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));

			// Variables for processing byte-based data
			double utlization = 0;
			double totalUtilization = 0;
			int noOfRecords = 0;
			String state = "";
			
			// 3. Process data until end-of-file
			while(dis.available() > 0) {
				
				// Read data
				state = dis.readUTF();
				utlization = dis.readDouble();
				System.out.println( state + "\t" + utlization);
				
				// Calculate total utilization
				totalUtilization += utlization;
				noOfRecords ++;
			}
			
			// 4. Close stream
			dis.close();
			
			// Calculate average utlization
			double averageUtlization = totalUtilization / noOfRecords;
			String formattedAverage = String.format("%.1f", averageUtlization);
			System.out.print("\nAverage utlization for " + noOfRecords 
					+ " states: " + formattedAverage + "%");
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");
		

	}

}
