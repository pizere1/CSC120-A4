public class Passenger {
    private  final String name;
    private  final String destination;

    Passenger(String name, String destination) {
        this.name = name;
        this.destination = destination;
    }
    public void boardCar(Car c) {
        if(c.addPassenger(this)){
            System.out.println("Passenger "+this.name+" added to the car");

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
        System.out.println("Passenger Name: "+this.name+" Destination: "+this.destination);
    }
    public String toString() {
        return this.name;
    }
}
