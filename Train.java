import java.util.ArrayList;
import java.util.Scanner;
public class Train {
    /**
     *Attributes
     **/
    private final Engine engine;
    private ArrayList<Car> cars;
    int maximumCars;
    /**
     * Attribute for the total seats Remaining across all cars
     */
    private int totalseatsRemaining=0;
    private int passengerCapacity;
    /**
     * Constructor
     * @param fuelType takes in the type of the fuel
     * @param fuelCapacity takes in the fuel capacity of the engine
     * @param nCars takes in the maximum number of cars in a train
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, fuelCapacity);
        this.cars=new ArrayList<>(nCars);
        this.maximumCars=nCars;
        this.passengerCapacity=passengerCapacity;
    }
    /**
     * Engine accessor
     * @return the engine information
     */
    public Engine getEngine(){
        System.out.println(this.engine);
        return this.engine;
    }
    /**
     * car accessor
     * @param i takes in the specific index of the car
     * @return the information of the car on the specified index
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
            System.out.println("");
            System.out.println("This is the passenger list for car "+(i+1)+":");
            cars.get(i).printManifest();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FuelType fu;
        double maxfuelCapacity;
        int maxCapacity;
        int nCars;
        System.out.println("Welcome to the train!");
        /*
          Reading the value for the fueltype that the train's engine will use
          try and catch blocks to ask the user to choose a fuel type
          or set the default to fueltype electric
         */
        System.out.print("Choose Fuel Type from STEAM, INTERNAL_COMBUSTION, ELECTRIC, OTHER:");
        String fuelType=in.nextLine();
        String Fuel=fuelType.toUpperCase();
        try {
            for (int i = 0; i < FuelType.values().length; i++) {
                if (FuelType.valueOf(Fuel).equals(FuelType.values()[i])) {
                    System.out.println("The fuel is "+ FuelType.valueOf(Fuel).toString());
                    fu = FuelType.valueOf(Fuel);
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid fuel type");
            System.out.println("Using default fuel type: Electric");
            fu = FuelType.ELECTRIC;
        }
        /*
        Code block to get the value of the maximum fuel capacity
         */
        System.out.print("Enter the engine maximum fuel capacity: ");
        try{
            maxfuelCapacity=in.nextDouble();
            if (maxfuelCapacity<=0){
                System.out.println("Maximum fuel capacity should be greater than 0. Re-enter:");
                maxfuelCapacity=in.nextDouble();
            }
        } catch(Exception e){
            System.out.println("Invalid input type");
            System.out.println("Using default maximum: 500");
            maxfuelCapacity=500;
        }
        /*
        code blocks to get the number of the cars on the train
         */
        System.out.print("Enter the number of cars in this train: ");
        try {
            nCars = in.nextInt();
        }catch (Exception e){
            System.out.println("Invalid input type");
            System.out.println("Using default number of Cars: 7");
            nCars=7;
        }
        /*
        the code blocks to get the maximum passengers that can be on the plan
         */
        System.out.print("Enter the total maximum passengers capacity for this train: ");
        try{
            maxCapacity=in.nextInt();
        }catch(Exception e){
            System.out.println("Invalid input type");
            System.out.println("Using default maximum passengers capacity: 150");
            maxCapacity=150;
        }
        /*
        Calling the train constructor
         */
        Train T1=new Train(FuelType.valueOf(Fuel),maxfuelCapacity,nCars,maxCapacity);
        Car first=new Car(50, T1);
        Car second=new Car(60, T1);
        Car third=new Car(70, T1);
        Passenger P1=new Passenger("Di","Boston");
        Passenger P2=new Passenger("Do","Boston");
        Passenger P3=new Passenger("Me","Boston");
        Passenger P4=new Passenger("Ma","New York");
        Passenger P5=new Passenger("Pe","Hatfield");
        Passenger P6=new Passenger("Pe","Hartford");
        first.addPassenger(P1);
        P1.boardCar(first);
        first.addPassenger(P2);
        first.addPassenger(P3);
        second.addPassenger(P4);
        second.addPassenger(P5);
        third.addPassenger(P6);
        first.addPassenger(P5);
        first.printManifest();
        T1.printManifest();

    }
}


