 public class Passenger {
     /**
      * Attributes
      */
     private  final String name;
     private  final String destination;
     /**
      * Constructor
      * @param name
      * @param destination
      */
     public Passenger(String name, String destination) {
            this.name = name;
            this.destination = destination;
     }
     /**
      * method to add the passenger to a car
      * @param c
      * notifies the user if the passenger was added to the car
      * or if the passenger was not added
      */
     public void boardCar(Car c) {
         if(c.addPassenger(this)){
             System.out.println("Passenger "+this.name+" added to the car");
         } else {
             System.out.println("Passenger not added to the car");
         }
     }
     /**
      * method to remove the passenger from the car
      * @param c
      * notifies the user that the passenger was removed
      */
        public void getOffCar(Car c){
            if(c.removePassenger(this)){
                System.out.println("Passenger removed from the car");
            }
        }
     /**
      * method to get the information of the passenger
      * prints their name and their destination
      */
     public void getpassengerinfo()
     {
         System.out.println();
         System.out.println("Passenger Name: "+this.name+" Destination: "+this.destination);
     }
     public String toString() {
            return this.name;
     }
}
