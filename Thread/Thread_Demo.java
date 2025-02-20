import java.lang.Thread;

class Demo extends Thread{
    @Override
    public void run(){
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("Thread name: "+currentThreadName);
    }
}
public class Thread_Demo {
    public static void main(String[] args) {
        Demo d1 = new Demo();
        d1.setName("Mehedi");
        d1.start();
    }
}
