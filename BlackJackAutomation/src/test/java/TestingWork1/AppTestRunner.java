package TestingWork1;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import junit.framework.TestSuite;


public class AppTestRunner {
	   public static void main(String[] args) {
		   
		   
		   
		      Result result = JUnitCore.runClasses(AppTestSuite.class);
		      // Create object called result which is the full
		      // output of the JUnit tests. It will know what has failed and passed.
		      
		      
		     // result.createListener()

		      for (Failure failure : result.getFailures()) { //Stores failures into an array
		         System.out.println(failure.toString());
		         // This converts the array into a toString and then can write an automated report if errors are found
		      }
				
		      System.out.println(result.wasSuccessful());
		      //Tells you if all tests were passed/all results were successful
		   }
}


