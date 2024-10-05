public class Passenger {
    private String name;
    private int ticketid=0;
    private String carboarded;

    Passenger(String name) {
        this.name = name;
    }
    public void boardCar(Car c) {
        if(c.addPassenger(this)){
            System.out.println("Passenger "+this.name+" added to the car");
            ticketid=ticketid+1;
            //carboarded = c.getClass().getName();
        }
        else {
            System.out.println("Passenger not added to the car");
        }
    }
    public void getOffCar(Car c){
        if(c.removePassenger(this)){
            System.out.println("Passenger removed from the car");
        }
    }
    public void getpassengerinfo() {
        System.out.println();
        System.out.println(this.name + " has the ticket 00" + this.ticketid);
    }
    public String toString() {
        System.out.println();
        return this.name;
    }
}
