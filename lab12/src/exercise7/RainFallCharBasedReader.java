package exercise7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * This class read the daily rainfall readings from selected station from a certain source file
 * using suitable subclasses of Reader.
 * 
 * This class is recreated based on RainFallDataReader.java in package exercise5
 * 
 * In this case, BufferedReader is used.
 * @author Ng Wei Hen
 */
public class RainFallCharBasedReader {

	public static void main (String [] args)
	{
		// 1. Declare output file 
		String sourceFile = "RainfallCharBased.txt";
		
		// display the sentence for reading data
		System.out.println("Reading data from " + sourceFile + "\n");
		try
		{
			
			
			// 2. Construct the Reader object
			BufferedReader brInput = new BufferedReader(new FileReader(sourceFile));
			
			// 3. Read values from the stream
			// variables to handle data read from the source file
			
			// receive daily rainfall reading
			String dailyRainfall = "";
			
			// variables to count number of daily reading in the source file
			int noOfRecords = 0;
			
			// variable to calculate total daily rainfall
			double totalRainfall = 0.0;
			
			// Read values from the stream
			
			
			// 3. Read the data
			dailyRainfall = brInput.readLine();
			while (dailyRainfall != null) {
				
				// Display each daily rainfall reading
				System.out.println(dailyRainfall);
				
				// Calculate total daily rainfall
				totalRainfall = totalRainfall + Double.parseDouble(dailyRainfall);
				
				// Auto update current number of records read from the source file
				noOfRecords ++;
				
				// Read next value for the daily rainfall reading
				dailyRainfall = brInput.readLine();
			}
			
			// Display total number of records for the daily rainffall readings from the source file
			System.out.println("\nTotal Records: " + noOfRecords);
			
			// Display total daily rainfall
			System.out.println("Total Daily Rainfall: " + totalRainfall);
			
			// Calculate average daily rainfall
			double averageRainfall = totalRainfall / Double.valueOf(noOfRecords);
			
			
			String formattedAverage = String.format("%.1f", averageRainfall);
			System.out.print("\nAverage rainfall for " + noOfRecords 
					+ " days from station Simpang Ampat in Alor Gajah district: " + formattedAverage);
						
			// 4. Close the Reader
			brInput.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
					
	}
	
	
}
