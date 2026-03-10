class OddThread extends Thread {
    public void run() {
        try {
            for (int i = 1; i <= 100; i++) {
                if (i % 2 != 0) { 
                    System.out.println("OddThread: " + i);
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class PrimeThread implements Runnable {

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public void run() {
        try {
            for (int i = 1; i <= 100; i++) {
                if (isPrime(i)) { 
                    System.out.println("PrimeThread: " + i);
                    Thread.sleep(1000); 
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}


public class MultiThreadExample {
    public static void main(String[] args) {
        OddThread oddThread = new OddThread(); 
        PrimeThread primeRunnable = new PrimeThread(); 
        Thread primeThread = new Thread(primeRunnable); 

        oddThread.start();
        primeThread.start();
    }
}
