// Save this file as threaddemo.java

class threaddemo extends Thread {
    // run() method - થ્રેડ શું કામ કરશે એ અહીં લખવું
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread is running: " + i);
            try {
                Thread.sleep(500); // 0.5 second wait
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
class thread{


    // main() method - પ્રોગ્રામની શરૂઆત અહીંથી થાય છે
    public static void main(String[] args) {
        threaddemo t1 = new threaddemo(); // Thread object બનાવ્યો
        t1.start(); // Thread શરૂ કર્યો
    }
}
}

