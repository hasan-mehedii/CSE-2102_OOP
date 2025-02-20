import java.util.concurrent.TimeUnit;

class MyThread implements Runnable{
    @Override
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("["+i+"] inside runnable " + Thread.currentThread().getName());
            sleepOneSecond();
        }
    }

    private static void sleepOneSecond(){
        try{
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class Thread_Demo3{
    public static void main(String[] args) {
        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();

        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);

        t1.setName("Mehedi");
        t2.setName("Hasan");

        t1.start();
        t2.start();

        for(int i=0; i<10; i++){
            System.out.println("[" + i + "] I Hate You " + Thread.currentThread().getName());
            sleepOneSecond();
        }
    }

    private static void sleepOneSecond(){
        try{
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
