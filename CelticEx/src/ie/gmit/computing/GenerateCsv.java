package ie.gmit.computing;

import java.io.FileWriter;
import java.io.IOException;

public class GenerateCsv {
	/**
	 * export data or writing data into a CSV file
	 * @param args
	 */
	public static void main(String [] args)
	   {
		   generateCsvFile("c:\\test.csv"); 
	   }
	 
	
	   private static void generateCsvFile(String sFileName)
	   {
		try
		{
		    FileWriter writer = new FileWriter(sFileName);
	 
		    writer.append("scientist");
		    writer.append(',');
		    writer.append("Age");
		    writer.append('\n');
	 
		    writer.append("ship");
		    writer.append(',');
		    writer.append("26");
	        writer.append('\n');
	 
		    writer.append("email");
		    writer.append(',');
		    writer.append("29");
		    writer.append('\n');
	 
		    //generate whatever data you want
	 
		    writer.flush();
		    writer.close();
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		} 
	    }

}
