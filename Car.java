import java.util.ArrayList;
public class Car {
    private final int maxcapacity;
    private int seatsRemaining;
    ArrayList<Passenger> passenger;
    private int ticket;
    Car(int n,Train2 T) {
        this.maxcapacity = n;
        this.passenger = new ArrayList<Passenger>(this.maxcapacity);
        T.addCar(this);
    }

    public int getMaxcapacity() {
        return this.maxcapacity;
    }
    public int getcurrentCapacity() {
        return this.passenger.size();
    }
    public int getSeatsRemaining() {
        this.seatsRemaining = this.maxcapacity - this.passenger.size();
        return this.seatsRemaining;
    }
    public boolean addPassenger(Passenger p){
        if(this.passenger.contains(p)){
            System.out.println("Passenger is already in the car");
            return false;
        }
        if(this.passenger.size() < this.maxcapacity){
            this.passenger.add(p);
            return true;
        }
        else{
            System.out.println("Sorry cannot add " +p+" to this car, it is Full. Try another one");
            return false; }
    }
    public boolean removePassenger(Passenger p){
        if(this.passenger.contains(p))
        {
            this.passenger.remove(p);
            System.out.println("Passenger "+p+ " removed ");
            return true;
        }
        else{
            System.out.println("Passenger not found in this car");
            return false;}
    }
    public void printManifest(){
            if(this.getMaxcapacity()>0){
                for(int i=0; i<this.passenger.size(); i++){
                    ticket=(i+1);
                    System.out.println("Passenger "+(i+1)+" : " +passenger.get(i).toString()+ " has ticket "+ticket);
                }
            }
            else{
                System.out.println("No People available on car");
            }
        }
    }
