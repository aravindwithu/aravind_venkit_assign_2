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
		// Object declared for TreeBuilder class.
	    TreeBuilder treeBuilder;
	    // Object declared for Results class.
	    Results results;
	    // Object declared for FileProcessor class.
	    FileProcessor file;
	    // Object declared for PrintWriter class.
	    PrintWriter writer;

	    try{
	    	// command line validation for input file and output file respectively.
	    	String inputFile = "", deleteFile = "", output1File = "", output2File = "", output3File = "";
		    if(5 == args.length){// validates given arguments array length to 2.
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

			treeBuilder = new TreeBuilder();
		    /*
		    treeBuilder.insertNode(1234, "A");
		    treeBuilder.insertNode(1200, "A");
		    treeBuilder.insertNode(1250, "A");
		    treeBuilder.insertNode(1277, "A");
		    treeBuilder.insertNode(1212, "A");*/

		    // Object intialized for FileProcessor with respective input file.
			file = new FileProcessor(inputFile);
			// The input values are read from file and stored in my array list.
			String line;
		    while ((line = file.readLine(true)) != null)
		    {
		    	String[] lineValues = line.split(":");
		    	int keyValue = 0;
		    	try{
		    		keyValue =  Integer.parseInt(lineValues[0]);
		    	}
		    	catch(Exception ex){// To catch the in parse invalid error.
		    		throw new Exception("Invalid value: "+ line +", Please provide numbers in the range 0-10000.");
		    	}

		    	String nameValue = lineValues[1];
		    	treeBuilder.insertNode(keyValue, nameValue);
		    }
		    file.readLine(false);

			/*System.out.println("in order");
		    treeBuilder.inOrderTraverseTree();
		    System.out.println("pre order");
		    treeBuilder.preOrderTraverseTree();
		    System.out.println("post order");
		    treeBuilder.postOrderTraverseTree();*/

		    file =  null;
		    file = new FileProcessor(deleteFile);
			// The input values are read from file and stored in my array list.
			line = "";
		    while ((line = file.readLine(true)) != null)
		    {
		    	String[] lineValues = line.split(":");
		    	int keyValue = 0;
		    	try{
		    		keyValue =  Integer.parseInt(lineValues[0]);
		    	}
		    	catch(Exception ex){// To catch the in parse invalid error.
		    		throw new Exception("Invalid value: "+ line +", Please provide numbers in the range 0-10000.");
		    	}

		    	String nameValue = lineValues[1];
		    	treeBuilder.deleteNode(keyValue);
		    }
		    file.readLine(false);

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