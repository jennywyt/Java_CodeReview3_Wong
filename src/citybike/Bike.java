package citybike;

import java.util.HashMap;

public class Bike {
    int bikeId;
    String color;

    public Bike(String color) {
        this.color = color;
        this.bikeId= cityBikeID;
        cityBikeID += 1;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "bikeId=" + bikeId +
                ", color='" + color + '\'' +
                '}';
    }

    private static int cityBikeID = 1;


}
