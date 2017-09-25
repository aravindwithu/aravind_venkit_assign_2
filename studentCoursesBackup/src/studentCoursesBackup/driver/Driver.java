package studentCoursesBackup.driver;

//Header to import supporting classes.
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.FileProcessor;
import java.io.PrintWriter;

/*
* Driver class contains main method.
* Created by Aravind Venkit for cs542 - Design patterns, Assignment 2.
*/
public class Driver 
{
	public static void main(String[] args) 
	{

	    try{
	    	// command line validation for input file and output file respectively.
	    	String inputFile = "", deleteFile = "", output1File = "", output2File = "", output3File = "";
		    if(2 == args.length){// validates given arguments array length to 2.
		    	if(!args[0].equals("${arg0}")){// validates 1st input file argument value.
		    		inputFile = args[0];
		    	}
		    	else{
		    		throw new Exception("Please provide input file.");
		    	}

		    	if(!args[1].equals("${arg1}")){// validates 2nd delete file argument value.
					deleteFile = args[1];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}

		    	if(!args[2].equals("${arg2}")){// validates 3rd output1 file argument value.
					output1File = args[2];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}

		    	if(!args[3].equals("${arg3}")){// validates 4th output2 file argument value.
					output2File = args[3];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}

		    	if(!args[4].equals("${arg4}")){// validates 5th output3 file argument value.
					output3File = args[4];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}
		    }
		    else{
		    	throw new Exception("Please pass exactly 5 arguments one for input and another for output files.");
		    }
	    }
	    catch(Exception ex){
	    	System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
	    }
	    finally{// Clears all the objects created.
	
	    }
	}
}