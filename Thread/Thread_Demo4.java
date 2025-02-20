import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Watch implements Runnable{
    @Override
    public void run(){
        while(true){
            printCurrentTime();
            sleepOneSecond();
        }
    }

    private void sleepOneSecond(){
        try{
            Thread.sleep(1000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void printCurrentTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:s a");
        String formattedCurrentTime = LocalDateTime.now().format(formatter);

        System.out.println(formattedCurrentTime);
    }
}
public class Thread_Demo4 {
    public static void main(String[] args) {
        Thread watchThread = new Thread(new Watch());
        watchThread.start();
    }
}
