package MyComposition;
import MyComposition.Battery;
public class Drone {
    String model;
    Battery battery;

    public Drone(String model) {
        this.model = model;
        this.battery = new Battery(5000); // Battery created inside Drone
    }

    public void fly() {
        System.out.println("Drone Model: " + model);
        battery.showBattery();
        System.out.println("Drone is flying...");
    }
}