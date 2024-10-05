import java.util.ArrayList;
public class Car {
    private int maxcapacity;
    private int Capacity = 0;
    private int seatsRemaining;
    ArrayList<Passenger> passenger;

    Car(int n) {
        this.maxcapacity = n;
        this.passenger = new ArrayList<Passenger>(this.maxcapacity);
    }

    public int getCapacity() {
        return this.maxcapacity;
    }

    public int getSeatsRemaining() {
        this.seatsRemaining = this.maxcapacity - this.Capacity;
        return this.seatsRemaining;
    }
    public boolean addPassenger(Passenger p){
        if(this.passenger.contains(p)){
            System.out.println("Passenger is already in the car");
            return false;
        }
        if(this.passenger.size() < this.maxcapacity){
            this.Capacity+=1;
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
            this.Capacity-=1;
            System.out.println("Passenger "+p+ " removed ");
            return true;
        }
        else{
            System.out.println("Passenger not found in this car");
            return false;}
    }
    public void printManifest(){
            if(this.getCapacity()>0){
                System.out.println("");
                System.out.println("This is the passengers list");
                for(int i=0; i<this.passenger.size(); i++){
                    System.out.print("Passenger "+(i+1)+" : ");
                    System.out.println(passenger.get(i).toString());
                }
            }
            else{
                System.out.println("No People available on car");
            }
        }
    }
