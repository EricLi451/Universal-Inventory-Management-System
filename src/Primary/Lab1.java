package Primary;
import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;
/**
 * CET - CS Academic Level 3
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Shijun_Li
 * Student Number:  041121986
 * Course: CST8130 - Data Structures
 * Professor:James Mwangi PhD.
 * 
 */
public class Lab1 {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);                           //initial scanner;
		Numbers nb =null ;                                             //initial numbers 

		
	while (true) {
		 System.out.println("Please select one of the following:");
         System.out.println("1: Initialize a default array");
         System.out.println("2: To specify the max size of the array");
         System.out.println("3: Add value to the array");
         System.out.println("4: Display values in the array");
         System.out.println("5: Display average of the values, minimum value, maximum value, max mod min, factorial min");
         System.out.println("6: Enter multiple values");
         System.out.println("7: Read values from file");
          System.out.println("8: Save values to file");
          System.out.println("9: Exit");
          System.out.print("> ");
         
         try {
         int ch = sc.nextInt();
         
         switch(ch) {
         case 1:
         nb = new Numbers();                                           //initail array
         System.out.println("defult array initailized ");
         break;
         
         case 2:
        	 System.out.println("enter the maximun number");
        	 int size =sc.nextInt();  
        	 nb = new Numbers(size);                                    //specify the size
        	 System.out.println("array initialed with size of "+size);
        	 break;
        	 
         case 3 :
        	 if (nb==null) {
        		 //System.out.println("Please initialize the array first.");
        		 nb = new Numbers(); 
        	 }
        	 
        		nb.addValue(sc);                                    //accept users input and store
        	 
        	 break;
        	 
     
        	 
         case 4:
        	 if (nb != null) {                                         //check if not null call toString directly
        		 nb.displayValues();
        	 }
        	 else {
        		 System.out.println("Numbers are :");
        		
        	 }
        	 break;
        	 
         case 5:
        	 if (nb !=null) {
        		 System.out.println(nb);
        	 }else {
        		 System.out.println("Average is: 0.0, Minimum value is 0.0, "
        		 		+ "Maximum value is 0.0 , max mod min, factorialMax");            
        	 }
        	 break;
        	 
         case 6:
                if (nb == null) {
                          nb = new Numbers(); 
                    }

                        System.out.print("How many values do you wish to add? ");
                        int count = 0;

                  try {
               count = sc.nextInt(); 
                     sc.nextLine(); 
         if (count <= 0) {
              System.out.println("The number of values must be positive.");
                  break;
           }

         if (nb.getCapacity() - nb.getNumItems() < count) {
             System.out.println("No room in array to add all values.");
                 break;
                  }

             for (int i = 0; i < count; i++) {
               System.out.print("Enter value: ");
               float value = sc.nextFloat(); 
                nb.addValueDirect(value); 
}

} 
                  catch (InputMismatchException e) {

                	  System.out.println("Invalid input. Please enter a valid integer for the number of values.");
 
                	  sc.next(); 
}
break;
        		    
         case 7:
        	 if (nb == null) {
 	            nb = new Numbers(); 
 	            System.out.println("Default array initialized.");
 	        }
        	 
        	 try {
     	        System.out.println("Enter the filename to read from:");
     	        sc.nextLine();
     	        String fileName = sc.nextLine();
     	        
     	       nb.readValuesFromFile(fileName);
   	        System.out.println("Values read from file.");
   	        }
        	 catch  (IOException e) {
 	            System.out.println("Error reading from file."+ e.getMessage());
 	        }
        	 
        	 break;
        	 
         case 8:
        	 sc.nextLine();
 	        System.out.println("Enter the filename to save to:");
 	        String saveFileName = sc.nextLine();
 	        //System.out.println("Enter the delimiter to use:");
 	        String saveDelimiter = ",";
 	        
 	        
 	        try {
	            nb.saveValuesToFile(saveFileName,saveDelimiter); 
	            System.out.println("Values saved to file.");
	        } catch (IOException e) {
	            System.out.println("Error saving to file.");
	        }
	        break;
	        
         case 9:
             System.out.println("Exiting");
             sc.close();
             return;
        		    
        		    
         
        	
        	
        	 
        	 default :
        		 System.out.println("invalid choice please choose again");
        	 
         }}
         catch (InputMismatchException e) {
             System.out.println("Invalid input, please use a number.");
             sc.next();}
	}
	}

}
