import java.util.ArrayList;
public class Train {
    /**
     *Attributes
     **/
    private final Engine engine;
    private ArrayList<Car> cars;
    int maximumCars;
    /**
     * Attribute for the total seats Remaining accross all cars
     */
    private int totalseatsRemaining=0;
    private int passengerCapacity;
    /**
     * Constructor
     * @param fuelType
     * @param fuelCapacity
     * @param nCars
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, fuelCapacity);
        this.cars=new ArrayList<>(nCars);
        this.maximumCars=nCars;
        this.passengerCapacity=passengerCapacity;
    }
    /**
     * Engine accessor
     * @return
     */
    public Engine getEngine(){
        System.out.println(this.engine);
        return this.engine;
    }
    /**
     * car accessor
     * @param i
     * @return
     */
    public Car getCar(int i){
        return this.cars.get(i);
    }

    /**
     * maximum capacity accessor
     * @return total maximum capacity of the cars in the train
     */
    public int getMaxCapacity() {
        for (Car car : cars) {
            passengerCapacity = passengerCapacity+ car.getCapacity();
        }
        return passengerCapacity;
    }
    /**
     * method to return the remaining unoccupied seats in the cars
     * @return total seats remaining across the train
     */
    public int seatsRemaining(){
        for (Car car : cars){
            totalseatsRemaining=totalseatsRemaining+car.SeatsRemaining();
        }
        return totalseatsRemaining;
    }
    /**
     * method to add a car to the train
     * notifies the user is the car was added to the train or not
     */
    public void addCar(Car car){
        if (cars.contains(car)){
            System.out.println("Car already exists");
        }
        if(this.cars.size() < this.maximumCars){
            this.cars.add(car);
        } else {
            System.out.println("Sorry cannot add " + car + " to this train, it is Full. Try another Train");
        }
    }
    /**
     * the method to print a roster of the passengers in the train
     * calls the car's method print manifest to do this
     */
    public void printManifest() {
        for (int i=0;i<cars.size();i++) {
            System.out.println("This is the passenger list for car "+(i+1)+":");
            cars.get(i).printManifest();
        }
    }
}
