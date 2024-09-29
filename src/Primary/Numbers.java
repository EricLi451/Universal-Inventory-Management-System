package Primary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.InputMismatchException;


/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Shijun_Li
 * Student Number: 041121986
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Professor:James Mwangi PhD.
 * 
 */
public class Numbers {
	/**
	 * Stores Float values.
	 */
	private Float [] numbers;
	
	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems;

	/**
	 * Default Constructor
	 */
	public Numbers() {
		// TODO Write code here to initialize a "default" array since this is the default constructor
	this.numbers = new Float[5];                                    //initial size as 5
	this.numItems = 0;                                              //now in array theres no values yet
	}

	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		this.numbers = new Float[size];                             //allows fluent size of array
		this.numItems = 0;
		// TODO Write code here to initialize the numbers array of max 'size'
	}
	
	/**
	 * Adds a value in the array
	 * @param keyboard - Scanner object to use for input
	 */
	public void addValue(Scanner keyboard) {                        //Add a floating point value to the numbers array
		// TODO Write code here to add the values in the array
		if (numItems< numbers.length) {                             //check its theres no value stored
			System.out.print("enter value:");
			float value = keyboard.nextFloat();
			numbers[numItems]= value;                               //add value in the index
			numItems++;                                             //add in the array
		}
		else {
			System.out.println("Array full");
		
	}}
	
	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		// TODO Write code to return the average of the values in the array
		if(numItems == 0) {
			System.out.println("no values to calculat avg ");
			return 0;
		}
		float sum= 0;                                              //inital sum
	for (int i=0 ;i<numItems;i++) {                                //loop through the items
		sum +=numbers[i];
	}
	return sum/numItems;
		
	}
	/**
	 * find the max and minimun value in array
	 * @return
	 */
	public float findMin() {
	    if (numItems == 0) {                                     // Prevent the array from being empty
	        return 0;
	    }
	    float min = numbers[0];
	    for (int i = 1; i < numItems; i++) {                        // Start from index 1
	        if (numbers[i] < min) {
	            min = numbers[i];
	        }
	    }
	    return min;
	}

	public float findMax() {
	    if (numItems == 0) {
	        return 0;
	    }
	    float max = numbers[0];
	    for (int i = 1; i < numItems; i++) {
	        if (numbers[i] > max) {
	            max = numbers[i]; 
	        }
	    }
	    return max;
	}
	/**
	 * calculate the mad and min mod
	 * @return
	 */
	public float calMaxMinMod() {
	float min = findMin();
	 float max= findMax();
	 if (min ==0) {                                               //prevent devide by 0;
		 return 0;
	 }
	 return max%min;                                              //get mod
	}
	
	public long calcFactorialMin() {
		float fm = findMin();
		if(fm<=0) {                                              //factorial dosent applyfor negative
			return 1;                                            // 0 s factorial is 1
		}
		int minInt = (int) fm;                                   //to make valuse as int 
		long factorial =1;                                       //need to be long type beause factorial may be large
		for(int i =2;i<=minInt;i++) {
			factorial *=i;
		}
		return factorial;
	}
	

	
	public void displayValues() {
		if (numItems == 0) {
			System.out.println("Numbers are :");
		}
		else {                                                    //if there are valuse in array then print
			System.out.println("numbers are:");
			for (int i =0;i<numItems; i++) {
				System.out.println(numbers[i]);
			}
		}
	}
	/**
	 * save the values from file
	 * @param fileName
	 * @param delimiter
	 */
	public void saveValuesToFile(String fileName,String delimiter) throws IOException{
		try ( BufferedWriter br = new BufferedWriter ( new FileWriter(fileName))){
			br.write(String.valueOf(numItems));
			br.newLine();
			
			for (int i =0;i<numItems;i++) {
				br.write(String.valueOf(numbers[i]));
				if (i<numItems-1 ) {
					br.write(delimiter);
				}
			}
		}}
	/**
	 * read the values from the file
	 * @param fileName
	 * @throws IOException
	 */
	public void readValuesFromFile(String fileName) throws IOException {
	    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	    	reader.readLine();
	        String line = reader.readLine();
	        if (line != null) {
	            String[] values = line.split(",");
	            for (String value : values) {
	                try (Scanner scanner = new Scanner(value.trim())) {
	                    addValue(scanner);
	                } catch (InputMismatchException e) {
	                    System.out.println("Invalid data format in file.");
	                }
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("File not found: " + fileName);
	        throw e;
	    }
	}
	
	
	
	
	public void resizeArray(int newSize) {
		if (newSize>numbers.length) {
			Float[] newArray= new Float[newSize];
			System.arraycopy(numbers, 0, newArray, 0, numItems);
			numbers = newArray;
		}
	}
/**
 * allow user input multiple values and stroe
 * @param keyboard
 */
		public void addMultipleValues(Scanner keyboard) {
			System.out.print("how many values do you want add");
			int count;
			try {
				count = keyboard.nextInt();
				keyboard.nextLine();
				
				if (count<=0) {
					System.out.println("numbers must be positive");
					return;
				}
				for (int i = 0;i<count;i++) {
					System.out.print("enter value :");
					addValue(keyboard);
				}
			} catch(InputMismatchException e) {
				System.out.println("invalid input please enter integer");
			}
		}
		/**
		 * supervise array size ,indicate user
		 * @param value
		 */
		public void addValueDirect(float value) {
			if (numItems< numbers.length) {
				numbers[numItems]=value;//it represents the next available space.
				numItems++;
			}
			else {
				System.out.println("Array is full");
			}
		
		}
		
		public int getCapacity() {
		    return numbers.length;
		}

		public int getNumItems() {
		    return numItems;
		}
	
	
	
	
	

	@Override
	public String toString() {
		// TODO Write code for an appropriate toString method
		float average = calcAverage();
		float min= findMin();
		float max = findMax();
		float maxMinMod= calMaxMinMod();
		long factorialMin= calcFactorialMin();
		return String.format("Average is : %.2f, Minimum value is : %.1f, Maximum value is : %.1f, " +
                "max mod min is: %.2f, Factorial of Min is: %d",
                average, min, max, maxMinMod, factorialMin);
	}
	
}
