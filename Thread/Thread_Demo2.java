import java.util.concurrent.TimeUnit;

class Demo extends Thread{
    @Override
    public void run(){
        int i = 0;
        while(i<10){
            System.out.println("[" + i + "] I Love You " + Thread.currentThread().getName());
            i++;
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
public class Thread_Demo2 {
    public static void main(String[] args) {
        Demo demo = new Demo();
        Demo demo2 = new Demo();
        demo.setName("Mehedi");
        demo2.setName("Hasan");
        demo.start();
        demo2.start();

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
