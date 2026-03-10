package MyComposition;
public class Battery {
    int capacity;

    public Battery(int capacity) {
        this.capacity = capacity;
    }

    public void showBattery() {
        System.out.println("Battery Capacity: " + capacity + " mAh");
    }
}