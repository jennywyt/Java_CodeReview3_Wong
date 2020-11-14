package citybike;

import java.util.ArrayList;

public class User {
    private static int newerID = 1;
    int userID = 1;
    String name;
    String surname;
    private Bike rentedBike;

    ArrayList<Rent> rentals = new ArrayList<>();
    private Rent currentRental;


    public User(String name, String surname) {
        this.userID = newerID;
        newerID += 1;
        this.name = name;
        this.surname = surname;
    }

    public void rentBike(Bike bike) {
        if (rentedBike != null) {
            System.err.println("Warning! I have a bike already!");
        }
        rentedBike = bike;
        currentRental = new Rent(bike.bikeId);
        rentals.add(currentRental);
    }

    public int getBikeCount() {
        if (rentedBike == null) {
            return 0;
        } else {
            return 1;
        }
    }

    public void removeBike(Bike bike) {
        if (rentedBike == bike) {
            rentedBike = null;
            currentRental.finish();
            currentRental = null;
        } else {
            System.err.println(name + surname + " I have not rented this bike! ");
        }
    }
}

