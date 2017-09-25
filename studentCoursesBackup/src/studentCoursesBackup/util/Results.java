package studentCoursesBackup.util;

//Header to import supporting classes.
import java.io.PrintWriter;

/*
* Results class.
* Created by Aravind Venkit for cs542 - Design patterns.
* Results class to process results of the test case.
* Implements FileDisplayInterface and StdoutDisplayInterface interfaces.
*/
public class Results implements FileDisplayInterface, StdoutDisplayInterface{
	private String[] resultArray = new String[12];// string array to store results.
	private PrintWriter writer;// writer object to write to file.
	/*
	* Results constructor to intialize Results class.
	* Calls intializeArray.
	*/
	public Results(){
		intializeArray();
	}
	/*
	* intializeArray method.
	* intializes resultArray with empty string.
	*/
	private void intializeArray(){
		for(int i=0; i < resultArray.length; i++){
			resultArray[i] = "";
		}
	}
	/*
	* storeNewResult method.
	* Requires 2 arguments 1 -> index, 2 -> value.
	* Stores the given value in given index.
	*/
	public void storeNewResult(int index, String value){
		resultArray[index] = value;
	}
	/*
	* printAll method.
	* prints all the values in resultArray to command line.
	*/
	public void printAll(){
		for(int i = 0; i < resultArray.length; i++){
			writeToStdout(resultArray[i]);
		}
	}
	/*
	* writeAll method.
	* writes all the values in resultArray to output file.
	*/
	public void writeAll(PrintWriter writer_in){
		writer = writer_in;
		for(int i = 0; i < resultArray.length; i++){
			writeToFile(resultArray[i]);
		}
	}
	/*
	* writeToStdout method.
	* Implements StdoutDisplayInterface writeToStdout method.
	* gets String s as argument.
	* prints the given string to command line.
	*/
	public void writeToStdout(String s){
		System.out.println(s);
	}
	/*
	* writeToFile method.
	* Implements FileDisplayInterface writeToFile method.
	* gets String s as argument.
	* writes the given string to output file.
	*/
	public void writeToFile(String s){
			writer.println(s);
	}
}