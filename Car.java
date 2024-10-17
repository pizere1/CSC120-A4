 import java.util.ArrayList;
    public class Car {
        /**
         * Attributes
         */
        private final int maxcapacity;
        private int seatsRemaining;
        private ArrayList<Passenger> passenger;
        private int ticket;

        /**
         * Constructor
         * @param n maximum capacity of the car
         * @param T Train which holds the car
         */
        public Car(int n,Train T) {
            this.maxcapacity = n;
            this.passenger = new ArrayList<Passenger>(this.maxcapacity);
            T.addCar(this);
        }
        /**
         * maximum Capacity getter
         * @return maxcapacity
         */
        public int getCapacity() {
            return this.maxcapacity;
        }

        /**
         * current Capacity accessor
         * @return current size of the passenger arraylist
         */
        public int getcurrentCapacity() {
            return this.passenger.size();
        }

        /**
         * Seats remaining accessor
         * @return the seatsRemaing unoccupied
         */
        public int SeatsRemaining() {
            this.seatsRemaining = this.maxcapacity - this.passenger.size();
            return this.seatsRemaining;
        }

        /**
         * method to add passenger to the car
         * @param p
         * @return true if the passenger is not on board hence added or
         * false if the passenger is already in the car or the car is full
         */
        public boolean addPassenger(Passenger p){
            if(this.passenger.contains(p)){
                System.out.println("Passenger is already in the car");
                return false;
            }
            if(this.passenger.size() < this.maxcapacity){
                this.passenger.add(p);
                return true;
            } else{
                System.out.println("Sorry cannot add " +p+" to this car, it is Full. Try another one");
                return false; }
        }

        /**
         * method to remove the passengers
         * @param p
         * @return true if the passenger was successfully removed from the car
         * or false if the passenger was on the car or the car was empty
         */
        public boolean removePassenger(Passenger p){
            if(this.passenger.contains(p))
            {
                this.passenger.remove(p);
                System.out.println("Passenger "+p+ " removed ");
                return true;
            } else {
                System.out.println("Passenger not found in this car");
                return false;
            }
        }

        /**
         * method to print the list of passengers on board
         * or notifies the user that there are no people in that car
         */
        public void printManifest(){
            if(this.getCapacity()>0){
                for(int i=0; i<this.passenger.size(); i++){
                    ticket=(i+1);
                    System.out.println("Passenger "+(i+1)+" : " +passenger.get(i).toString()+ " has ticket "+ticket);
                }
            } else{
                System.out.println("No People available on car");
            }
        }
    }
