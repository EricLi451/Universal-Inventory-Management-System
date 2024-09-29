package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Primary.Numbers;
/**
 * Test cases
 * Student Name: Shijun_Li
 * Student Number: 041121986
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Professor:James Mwangi PhD.
 * 
 */
class test {

	private Numbers numbers;                                                       //Define a private variable numbers of type Numbers, which is shared among 
	                                                                               //the test methods of the class.

    @BeforeEach
    public void setUp() {
     numbers = new Numbers(10);                                                    //initail array with 10 value 
    }
    
@Test
    public void testAddValue() {
        numbers.addValue(new java.util.Scanner("5.0"));                            // Add value 5.0
      assertEquals(5.0,numbers.findMax(), "Max value should be 5.0");
        assertEquals(5.0,numbers.findMin(), "Min value should be  5.0");
    }
    @Test
    public void testCalcAverage() {
        numbers.addValue(new java.util.Scanner("2.0"));
      numbers.addValue(new java.util.Scanner("4.0"));
      numbers.addValue(new java.util.Scanner("6.0"));
        assertEquals (4.0,numbers.calcAverage(),"Average should be 4.0");
    }

    
    @Test
    public void testFindMin() {
       
    	
    	numbers.addValue(new java.util.Scanner("2.0"));
        numbers.addValue(new java.util.Scanner("4.0"));
        numbers.addValue(new java.util.Scanner("1.0"));
        assertEquals(1.0,numbers.findMin(),"Minimum value should be 1.0" );
         }
@Test
    public void testFindMax() {
        numbers.addValue(new java.util.Scanner("2.0"));
        numbers.addValue(new java.util.Scanner("4.0"));
        numbers.addValue(new java.util.Scanner("6.0"));
        //assertEquals(6.0,numbers.findMax(), "Maximum value should be 6.0 ");
 }
       @Test
    public void testCalMaxModMin() {
        numbers.addValue(new java.util.Scanner("2.0"));
        numbers.addValue(new java.util.Scanner("4.0"));
        numbers.addValue(new java.util.Scanner("1.0"));
        assertEquals(0.0,numbers.calMaxMinMod(), "Max mod min should be 0.0 ");}

    @Test
   public void testCalcFactorialMin() {
     numbers.addValue(new java.util.Scanner("1.0"));                               // Min value is 1.0
        assertEquals(1, numbers.calcFactorialMin(), "Factorial of min should be 1");
        numbers.addValue(new java.util.Scanner("4.0"));                            
      //assertEquals(24, numbers.calcFactorialMin(), "Factorial of min should be 24");
    }
    @Test
  void testReadValuesFromFile() throws IOException {
        File tempFile = File.createTempFile("testfile", ".txt");
        try (PrintWriter writer = new PrintWriter(tempFile)) {
            writer.println("5");
            writer.println("1.0,2.0,3.0,4.0,5.0");
        }
Numbers numbers = new Numbers();
   numbers.readValuesFromFile(tempFile.getAbsolutePath());
   assertEquals(1.0f, numbers.findMin(), "Minimum value should be 1.0 from file.");
   assertEquals(5.0f, numbers.findMax(), "Maximum value should be 5.0 from file.");
  }

    @Test
    void testSaveValuesToFile() throws IOException {
        Numbers numbers = new Numbers();
        numbers.addValueDirect(1.0f);
        numbers.addValueDirect(2.0f);
        File tempFile = File.createTempFile("testfile", ".txt");
        //numbers.saveValuesToFile(tempFile.getAbsolutePath(), ",");
        
   
  String content = new String(java.nio.file.Files.readAllBytes(tempFile.toPath()));
        assertTrue(content.contains("2"), "File should contain saved values.");
    }

}



