import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class SharedResource {
    boolean flag = true;
}

// Creating Thread by extending Thread class
class Demo extends Thread {
    private final SharedResource shared;

    public Demo(SharedResource shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (shared) {
                while (!shared.flag) {
                    try {
                        shared.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Love You " + Thread.currentThread().getName());
                sleepOneSecond();
                shared.flag = false;
                shared.notify();
            }
        }
    }

    private static void sleepOneSecond() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Creating Thread by implementing Runnable interface
class Temo implements Runnable {
    private final SharedResource shared;

    public Temo(SharedResource shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (shared) {
                while (shared.flag) {
                    try {
                        shared.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Hate You " + Thread.currentThread().getName());
                sleepOneSecond();
                shared.flag = true;
                shared.notify();
            }
        }
    }

    private static void sleepOneSecond() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Threading_Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SharedResource shared = new SharedResource();

        Demo d1 = new Demo(shared);
        Temo t1 = new Temo(shared);

        Thread th1 = new Thread(t1);

        System.out.print("Enter your Crush: ");
        String name1 = scanner.nextLine();
        d1.setName(name1);

        System.out.print("Enter your Enemy: ");
        String name2 = scanner.nextLine();
        th1.setName(name2);

        d1.start();
        th1.start();

        scanner.close();
    }
}
