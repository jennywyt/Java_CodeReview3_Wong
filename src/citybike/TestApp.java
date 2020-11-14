package citybike;

import java.util.HashMap;

public class TestApp {

    public static void main(String[] args) {
        System.out.println("demo:");
        Bike bike1 = new Bike("red");
        Bike bike2 = new Bike("orange");
        Bike bike3 = new Bike("yellow");
        Bike bike4 = new Bike("green");
        Bike bike5 = new Bike("blue");
        Bike bike6 = new Bike("purple");
        Bike bike7 = new Bike("pink");
        Bike bike8 = new Bike("navy");

        HashMap<Integer, Bike> bikes = new HashMap<>();
        bikes.put(bike1.bikeId, bike1);
        bikes.put(bike2.bikeId, bike2);
        bikes.put(bike3.bikeId, bike3);
        bikes.put(bike4.bikeId, bike4);
        bikes.put(bike5.bikeId, bike5);
        bikes.put(bike6.bikeId, bike6);
        bikes.put(bike7.bikeId, bike7);
        bikes.put(bike8.bikeId, bike8);

        System.out.println(bikes);


        HashMap<Integer, Station> stations = new HashMap<>();
        stations.put(1, new Station("Oper"));
        stations.put(2, new Station("Prater"));
        stations.put(3, new Station("Alte Donau"));

        Station oper = stations.get(1);
        System.out.println(oper);
        oper.addBike(bike7);
        oper.addBike(bike5);
        oper.addBike(bike8);
        System.out.println(oper);

        User harryPotter = new User("Harry", "Potter");
        User williWonka = new User("Willy", "Wonka");
        User tommyAktins = new User("Tommy", "Aktins");
        User heldeGreenbaum = new User("Helde", "Greenbaum");

        System.out.println("\nRental demo:");

        simpleScenario(oper, harryPotter);
        System.out.println("Harry Potter's rental history");
        System.out.println(harryPotter.rentals);

        Station alteDonau = stations.get(3);
        stationFullScenario(bikes, alteDonau, oper, williWonka);

        System.out.println("Willy Wonka's rental history:");
        System.out.println(williWonka.rentals);
    }

    private static void simpleScenario(Station stationWithOneBike, User user) {
        Bike bike = stationWithOneBike.rentBike(user);
        stationWithOneBike.returnBike(user, bike);
    }

    private static void stationFullScenario(HashMap<Integer, Bike> bikes, Station fullStation, Station stationWithOneBike, User user) {

        System.out.println(fullStation);
        fullStation.addBike(bikes.get(1));
        fullStation.addBike(bikes.get(2));
        fullStation.addBike(bikes.get(3));
        fullStation.addBike(bikes.get(4));
        fullStation.addBike(bikes.get(6));
        System.out.println(fullStation);

        Bike bike = stationWithOneBike.rentBike(user);
        fullStation.returnBike(user, bike);
    }
}
