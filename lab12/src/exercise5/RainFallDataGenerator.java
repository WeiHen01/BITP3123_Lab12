package exercise5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/*
 * Lab 12 - Programming using Java I/O Streams
 * Exercise 5: Processing Daily Rainfall Data A Station
 * 
 * Task B
 * 
 * This program genereates data for 6 days reading of daily rainfall
 * from station Simpang Ampat in Alor Gajah district
 * and write these data into a certain output file named "RainFall.txt"
 * with the help of DataOutputStream.
 * 
 * @author Ng Wei Hen (B032110201)
 * 
 */

public class RainFallDataGenerator {

	public static void main (String [] args)
	{
		// 1. Declare output file
		String outFile = "RainFall.txt";
		
		try
		{
			// 2. Create an output stream between this program and the output file, outFile
			DataOutputStream dosOutput = new DataOutputStream(new FileOutputStream(outFile));
			
			// 3. Write the 6 days reading of daily rainfall (from 31 May 2023 to 5 June 2023)
			// from station Simpang Ampat in Alor Gajah district into the output file
			dosOutput.write(5);
			dosOutput.write(0);
			dosOutput.write(0);
			dosOutput.write(4);
			dosOutput.write(1);
			dosOutput.write(0);
			
			// 4. Clear the stream
			dosOutput.flush();
			
			// 5. Close the stream
			dosOutput.close(); 
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		// Indicate end of program - Could be successful
		System.out.println("End of program. Check out " + outFile); 
	}
}
