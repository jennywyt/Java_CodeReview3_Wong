package citybike;

import java.util.ArrayList;

public class Station {
    private static int nextstationId = 1;
    int stationId = 1;
    String location;

    ArrayList<Bike> bikes = new ArrayList<>();

    public Station(String location) {
        this.location = location;
        this.stationId = nextstationId;
        nextstationId += 1;

    }

    /**
     * put a bike into a station
     */
    public void addBike(Bike bike) {
        bikes.add(bike);
        System.out.println("Bike added to station!");

    }


    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", location='" + location + '\'' +
                ", bikes=" + bikes +
                '}';
    }

    public Bike rentBike(User user) {
        if (user.getBikeCount() > 1) {
            System.err.println("Rental declined - You rented too many bikes.");
            return null;
        }

        if (bikes.isEmpty()) {
            System.err.println("No Bike available!");
            return null;
        }

        // Unlock a bike
        Bike bike = bikes.remove(0);
        user.rentBike(bike);

        System.out.println(user.name + " " + user.surname + " is now renting bike " + bike.bikeId + " from Station " + stationId);

        System.out.println("Enjoy your ride!");
        return bike;
    }

    public void returnBike(User user, Bike bike) {
        if (user.getBikeCount() < 1) {
            System.err.println("You have not rent any bike!");
            return;
        }

        if (bikes.size() >= 5) {
            System.out.println(user.name + " " + user.surname + " tried to return bike to a full station!");
            System.err.println("The station is full.");
            return;
        }

        user.removeBike(bike);
        addBike(bike);
        System.out.println(user.name + " " + user.surname + " successfully return bike to " + "Station " + stationId);
        System.out.println("Return successful!");

    }

}
