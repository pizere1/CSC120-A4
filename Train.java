import java.util.ArrayList;
public class Train2 {
    private Engine engine;
    private int totalpassengers=0;
    private int seatsRemaining=0;
  ArrayList<Car>cars;
  public Train2(FuelType fuelType, double maxfuelCapacity, int nCars, int passengerCapacity){
      this.engine = new Engine(fuelType, maxfuelCapacity);
      this.cars=new ArrayList<>(nCars);
  }
    public Engine getEngine(){
      return this.engine;
    }
    public void addCar(Car car){
      if (cars.contains(car)){
          System.out.println("Car already exists");
        }
      else{
          cars.add(car);
      }
    }
    public Car getCar(int i){
      return this.cars.get(i);
    }
}
