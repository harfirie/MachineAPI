package com.worldline.interview.MachineAPI;

import java.text.DecimalFormat;

/**
 * @author amirul.harfirie
 * @ModifyDate 25-07-2018 21:25:00
 *
 */
public class WidgetMachine {

	private static DecimalFormat df = new DecimalFormat(Constants.COST_FORMAT);
//    private InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.COAL);

    public String produceWidgets(int quantity, String fuelType) {
    	final FuelType fuel = FuelType.valueOf(fuelType);
		InternalCombustionEngine engine = new InternalCombustionEngine(fuel);
		
    	engine.fill(fuel, 100); 
        engine.start();
        
        double cost = 0;

        if (engine.isRunning()) {
            cost = produce(quantity, engine);
        }

        engine.stop();

        return df.format(cost);
    }

    private double produce(int quantity, InternalCombustionEngine engine) {
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
        	batchSize = Constants.COMBUSTION_BATCH_SIZE;
        }
        else {
        	batchSize = Constants.STEAM_BATCH_SIZE;
        }
        
        while (batch < quantity) {
            batch = batch + batchSize;
            batchCount++;
        }
        
        return batchCount * costPerBatch;
    }

}
