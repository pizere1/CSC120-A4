import java.util.ArrayList;
import java.util.Scanner;
public class Train2 {
    private final Engine engine;
    private int totalpassengers=0;
    int maxpassengerCapacity=0;
    private int totalseatsRemaining=0;
    int maximumCars;
    ArrayList<Car>cars;

    public Train2(FuelType fuelType, double maxfuelCapacity, int nCars){
      this.engine = new Engine(fuelType, maxfuelCapacity);
      this.cars=new ArrayList<>(nCars);
      this.maximumCars=nCars;
    }
    public Engine getEngine(){
        System.out.println(this.engine);
        return this.engine;}

    public Car getCar(int i){
        return this.cars.get(i);}

    public int getMaxCapacity() {
        for (Car car : cars) {
            maxpassengerCapacity =maxpassengerCapacity+ car.getMaxcapacity();
        }
        return maxpassengerCapacity;
    }
    public int getseatsRemaining(){
        for (Car car : cars){
            totalseatsRemaining=totalseatsRemaining+car.getSeatsRemaining();
        }
        return totalseatsRemaining;
    }
    public int getcurrentpassengers(){
      for (Car car : cars){
          totalpassengers=totalpassengers+car.getcurrentCapacity();
      }
      return totalpassengers;
    }
    public void addCar(Car car){
        if (cars.contains(car)){
            System.out.println("Car already exists");
        }
        if(this.cars.size() < this.maximumCars){
            this.cars.add(car);
        }
        else {
            System.out.println("Sorry cannot add " + car + " to this train, it is Full. Try another Train");
        }
    }
    public void printManifest() {
        for (int i=0;i<cars.size();i++) {
            System.out.println("This is the passenger list for car "+(i+1)+":");
            cars.get(i).printManifest();
        }
    }
}
