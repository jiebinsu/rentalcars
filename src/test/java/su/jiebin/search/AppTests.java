package su.jiebin.search;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import su.jiebin.search.entity.Vehicle;

public class AppTests extends TestCase
{

	Vehicle newVehicle = new Vehicle("CDMR","Ford Focus",157.85,"Hertz",8.9);
	
    public AppTests( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTests.class );
    }

    public void testVehicleObject()
    {
        assertEquals(newVehicle.getSipp(),"CDMR");
        assertEquals(newVehicle.getName(),"Ford Focus");
        assertEquals(newVehicle.getPrice(),157.85);
        assertEquals(newVehicle.getSupplier(),"Hertz");
        assertEquals(newVehicle.getRating(),8.9);
    }
    
    public void testVehicleMethods()
    {
    	assertEquals(newVehicle.getCarType(),"Compact");
    	assertEquals(newVehicle.getDoorType(),"5 doors");
    	assertEquals(newVehicle.getTransmissionType(),"Manual");
    	assertEquals(newVehicle.getFuelType(),"Petrol");
    	assertEquals(newVehicle.getACType(),"AC");
    }
    
    public void testVehicleScores()
    {
    	assertTrue(newVehicle.getScore()+newVehicle.getRating()==newVehicle.getTotalScore());
    	assertTrue(newVehicle.getScore()==3);
    }
}