package tutorial;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * This program demonstrate writing byte-based data using DataOuputStream.
 * The data is written in its original type into the stream.  
 * 
 * The data represents bed utilization for COVID-19 cases in several states of Malaysia.
 * 
 * @author emalianakasmuri
 *
 */
public class PrimitiveDataGenerator {

	public static void main(String[] args) {
		
		
		// 1. Declare output file 
		String outFile = "bedUtilization1.txt";
		
		// Data declaration
		String states[] = {"Kelantan", "Perlis", "Terengganu", "Melaka", "Johor", 
				"Kedah", "Perak", "Pulau Pinang"};
		double utilizations[] = {79.0, 75.0, 75.0, 74.0, 73.1, 72.6, 70.6, 69.2};
		
		try {
			
			// 2. Create stream to read data
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
			
			// Process data
			for (int index = 0; index < states.length; index++) {
				
				// 3. Write data into data stream
				dos.writeUTF(states[index]);
				dos.writeDouble(utilizations[index]);
				
				// 4. Flush for each writing
				dos.flush();
			}
			
			// 5. Close stream
			dos.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		// Indicate end of program - Could be successful
		System.out.println("End of program. Check out " + outFile); 
	}

}
