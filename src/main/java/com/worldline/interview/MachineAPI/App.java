package com.worldline.interview.MachineAPI;

import java.util.Scanner;

/**
 * @author amirul.harfirie
 *
 */
public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
    	Scanner input = new Scanner(System.in);
    	int quantity;
    	System.out.println("Please enter the quantity: ");
    	
    	try {
    		// user input
    		quantity = input.nextInt();
    	}
    	catch(Exception e) {
    		// invalid user input
    		e.printStackTrace();
    		throw new IllegalStateException("Invalid parameter. Quantity must be integer number!");
    	}

		WidgetMachine machine = new WidgetMachine();
		String result = machine.produceWidgets(quantity);
    	
    	System.out.println("Cost of the production: £" + result);
    	
//    	System.out.println("Please enter your fuel type (CAPITAL LETTER): ");
//    	String fuelType = input.next();
    	
    	input.close();
    }
}
