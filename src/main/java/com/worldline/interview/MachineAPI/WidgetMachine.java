package com.worldline.interview.MachineAPI;

import java.text.DecimalFormat;

public class WidgetMachine {
	
//	public void param(FuelType requiredFuelType, int quantity) {
//		produceWidgets(quantity, requiredFuelType);
//	}
	private static DecimalFormat df = new DecimalFormat("#.##");
    private InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.COAL);
//    private SteamEngine engine2 = new SteamEngine(FuelType.WOOD);

    public String produceWidgets(int quantity) {
//		InternalCombustionEngine engine = new InternalCombustionEngine(requiredFuelType);
    	engine.fill(FuelType.COAL, 100);
        engine.start();
        
//        engine2.fill(FuelType.DIESEL, 100);
//        engine2.start();
        
        double cost = 0;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        return df.format(cost);
    }

    private double produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        double costPerBatch = 0;
        int batchSize = 0;

        // the cost per batch
        if (engine.getFuelType() == FuelType.PETROL) {
            costPerBatch = 9;
        } else if (engine.getFuelType() == FuelType.DIESEL) {
            costPerBatch = 12;
        } else if (engine.getFuelType() == FuelType.WOOD) {
        	costPerBatch = 4.35; // (int) Math.round(4.35)
        } else if (engine.getFuelType() == FuelType.COAL) {
        	costPerBatch = 5.65; // (int) Math.round(5.65)
        }
        
        // assign the batch size
        if(engine.getFuelType() == FuelType.PETROL || engine.getFuelType() == FuelType.DIESEL) {
        	batchSize = 8;
        }
        else {
        	batchSize = 2;
        }
        
        while (batch < quantity) {
            batch = batch + batchSize;
            batchCount++;
//        	System.out.println("count: "+ batchCount);
        }
//        System.out.println(batchCount + " x " + costPerBatch);
        return batchCount * costPerBatch;
    }

}
