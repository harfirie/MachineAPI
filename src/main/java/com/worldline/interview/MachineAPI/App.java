package com.worldline.interview.MachineAPI;

import java.util.Scanner;

/**
 * @author amirul.harfirie
 * @ModifyDate 25-07-2018 21:25:00
 *
 */
public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
    	Scanner input = new Scanner(System.in);
    	int quantity;
    	String fuelType;
    	
    	try {
    		// user input
        	System.out.println("Please enter the quantity: ");
    		quantity = input.nextInt();
    		
    		System.out.println("Type of fuel: ");
    		System.out.println("1. PETROL");
    		System.out.println("2. DIESEL");
    		System.out.println("3. WOOD"); 
    		System.out.println("4. COAL");
    		System.out.println("Please enter type of fuel: ");
    		fuelType = input.next();
    		
    	}
    	catch(Exception e) {
    		// invalid user input
    		e.printStackTrace();
    		throw new IllegalStateException(Constants.INVALID_QUANTITY);
    	}
    	
    	if("PETROL".equalsIgnoreCase(fuelType) || "DIESEL".equalsIgnoreCase(fuelType) 
				|| "WOOD".equalsIgnoreCase(fuelType) || "COAL".equalsIgnoreCase(fuelType)) {
			
    		fuelType = fuelType.toUpperCase();
			WidgetMachine machine = new WidgetMachine();
			String result = machine.produceWidgets(quantity, fuelType);
	    	
	    	System.out.println("Cost of the production: £" + result);
		}
		else {
			throw new IllegalStateException(Constants.INVALID_FUEL_TYPE);
		}

    	input.close();
    }
}
