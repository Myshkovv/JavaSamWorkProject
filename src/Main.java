import threads.MyThread;

public class Main {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();

        System.out.println(thread.getName());

        Runnable task = () -> {
            System.out.println("Амир дурак");
        };
        var thread1 = new Thread(task);
        thread1.start();


        Thread myThread1 = new Thread(new MyThread(), "thread1");
        myThread1.setPriority(7);

        Runnable rThread = () -> {
            System.out.printf("%s started... \n", Thread.currentThread().getName());
            Thread t = Thread.currentThread();
            System.out.println(t);
            try {
                System.out.println(Thread.currentThread().getName() + "уснул");
                Thread.sleep(100);
            }
            catch (InterruptedException e){
                System.out.println();
            }
        }

    }
}