package citybike;

import java.time.LocalDateTime;

public class Rent {
    int bikeID;
    LocalDateTime rentStart;
    LocalDateTime rentEnd;

    public Rent(int bikeID) {
        this.bikeID = bikeID;
        rentStart = LocalDateTime.now();
    }

    public void finish() {
        if (rentEnd == null) {
            rentEnd = LocalDateTime.now();
        } else {
            System.err.println("Warning: Rental of bike " + bikeID + " already finished");
        }
    }

    @Override
    public String toString() {
        return "Rent{" +
                "bikeID=" + bikeID +
                ", rentStart=" + rentStart +
                ", rentEnd=" + rentEnd +
                '}';
    }
}
