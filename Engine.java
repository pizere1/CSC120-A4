public class Engine {
    private FuelType f;
    private double currentFuelLevel=0;//current fuel starts as 0
    private double maxFuelLevel;

    Engine(FuelType f,double maxFuelLevel) {
        this.f = f;
        this.maxFuelLevel = maxFuelLevel;}

    public FuelType getFuelType() { return this.f; }

    public double getCurrentFuelLevel() { return this.currentFuelLevel; }

    public double getMaxFuelLevel() { return this.maxFuelLevel;}

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
       System.out.println("Current fuel level: " + this.currentFuelLevel); }
}
