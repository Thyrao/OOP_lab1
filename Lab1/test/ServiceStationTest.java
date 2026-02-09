import Interface.ICar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Base.ServiceStation;
import Volvo.Volvo240;
import Saab.Saab95;

import java.util.ArrayList;

class ServiceStationTest {
    ServiceStation<Volvo240> volvo240ServiceStation = new ServiceStation<>(20);
    ServiceStation<Saab95> saab95ServiceStation = new ServiceStation<>(10);
    ServiceStation<ICar> carServiceStation = new ServiceStation<>(5);
    Volvo240 volvo1 = new Volvo240();
    Volvo240 volvo2 = new Volvo240();
    Saab95 saab1 = new Saab95();
    Saab95 saab2 = new Saab95();

    @Test
    void fetchCar1() {
        saab95ServiceStation.handInCar(saab1);
        saab95ServiceStation.handInCar(saab2);
        Assertions.assertEquals(saab1, saab95ServiceStation.fetchCar(saab1)); //ATT TESTA
    }

    @Test
    void getAllCarsInService(){
        ArrayList<Volvo240> inService = new ArrayList<>(5);
        inService.add(volvo1);
        inService.add(volvo2);
        volvo240ServiceStation.handInCar(volvo1);
        volvo240ServiceStation.handInCar(volvo2);
        Assertions.assertEquals(inService, volvo240ServiceStation.getAllCarsInService());
    }

    @Test
    void generalService(){
        ArrayList<ICar> inService = new ArrayList<>(5);
        inService.add(volvo1);
        inService.add(saab1);
        carServiceStation.handInCar(volvo1);
        carServiceStation.handInCar(saab1);
        Assertions.assertEquals(inService, carServiceStation.getAllCarsInService());

    }
}