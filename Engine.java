public class Engine {
    /**
     * Attributes
     */
    private FuelType f;
    private double currentFuelLevel=0;//current fuel starts as 0
    private double maxFuelLevel;
    /**
     * Constructor
     * @param f takes in the fueltype
     * @param maxFuelLevel takes in the maximum fuel level
     * */
    public Engine(FuelType f, double maxFuelLevel) {
        this.f = f;
        this.maxFuelLevel = maxFuelLevel;
    }
    /**FuelType accessor
     * @return f fuelType
     */
    public FuelType getFuelType() {
        return this.f;
    }

    /**
     * CurrentfuelLevel accessor
      * @return currentfuelLevel of the engine
     */
    public double getCurrentFuelLevel() {
        return this.currentFuelLevel;
    }

    /**
     * MaxFuelLevel accessor
     * @return MaxFuelLevel of the engine
     */
    public double getMaxFuelLevel() {
        return this.maxFuelLevel;
    }

    /**
     * refuel method
     * @param additionalFuel takes in the fuel added to refuel
     */

    public void refuel(double additionalFuel) {
        System.out.println("Refueling......");
        int i = 1;
        while (i <= additionalFuel) {
            if (this.currentFuelLevel < this.maxFuelLevel) {
                this.currentFuelLevel += 1;
                i++;
            } else {
                System.out.println("Maximum Fuel capacity cannot be exceeded!");
                break;
            }
        }
        System.out.println("Addition stopped because maximum fuel level was reached");
        System.out.println("Current fuel level: " + this.currentFuelLevel);
    }

    /**
     * go method
     * reduces fuellevel until it is zero
     */
    public void go(){
        while(this.currentFuelLevel >0){
            this.currentFuelLevel -= 1;
            System.out.print("Choo Choo!");

                if (this.currentFuelLevel <=0){
                    System.out.println("");
                    System.out.println("Cannot go without refuel. Please refuel.");
                    break;
                }
        }
        System.out.println("Current fuel level: " + this.currentFuelLevel);
    }
    /**
     * Output formatting
     * @return the organized Engine components rather than its memory location.
     */
    public String toString() {
        System.out.println("");
        return "Engine Fuel: " + f + ", currentFuelLevel= " + currentFuelLevel + " maxFuelLevel= " + maxFuelLevel;
    }
}
