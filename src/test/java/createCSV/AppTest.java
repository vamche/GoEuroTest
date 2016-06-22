package createCSV;

import java.io.IOException;
import java.nio.file.*;

import com.goeuro.csv.CreateCSV;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	
	
	private static final String filePathString = "././././locations.csv";
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

   
    
    /**
     * Test for creating csv file for invalid input
     * @throws IOException 
     */

    public void testForInValidInput() throws IOException
    {
    	
    	String[] args = {"asdfasdfasdf"} ;    
    	Path path = Paths.get(filePathString);
    	if (Files.exists(path)) {
    		Files.delete(path);   		
	   	}    	
    	CreateCSV.main(args);    	
    	
    	if (Files.exists(path)) {
    		 assertTrue( false );    		
    	}else{
    		 assertTrue( true );    		
    	}
    }
    
    /**
     * Test for creating csv file for invalid input
     * @throws IOException 
     */

    public void testForInValidInputEmptySpace() throws IOException
    {
    	
    	String[] args = {"     "} ;    
    	Path path = Paths.get(filePathString);
    	if (Files.exists(path)) {
    		Files.delete(path);   		
	   	}    	
    	CreateCSV.main(args);    	
    	
    	if (Files.exists(path)) {
    		 assertTrue( false );    		
    	}else{
    		 assertTrue( true );    		
    	}
    }
    
    /**
     * Test for creating csv file with valid input containing space
     * @throws IOException 
     */

    public void testForValidInputWithSpace() throws IOException
    {
    	
    	String[] args = {"New Delhi"} ;    
    	Path path = Paths.get(filePathString);
    	if (Files.exists(path)) {
    		Files.delete(path);   		
	   	}    	
    	CreateCSV.main(args);    	
    	
    	if (Files.exists(path)) {
    		 assertTrue( true );    		
    	}else{
    		 assertTrue( false );    		
    	}
    }
    
    /**
     * Test for creating csv file with valid input
     * @throws IOException 
     */

    public void testForValidInput() throws IOException
    {
    	
    	String[] args = {"Berlin"} ;    
    	Path path = Paths.get(filePathString);
    	if (Files.exists(path)) {
    		Files.delete(path);   		
	   	}    	
    	CreateCSV.main(args);    	
    	
    	if (Files.exists(path)) {
    		 assertTrue( true );    		
    	}else{
    		 assertTrue( false );    		
    	}
    }
    
    
    
}
