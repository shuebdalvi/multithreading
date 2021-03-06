package T01.startingthreads;

public class L01ExtendingThread {

    public static void main(String[] args) {

        Thread t1 = new RunMe();
        // if t1.run() is called, then the method will execute in this same thread immediately
        System.out.println("Going to start thread t1");
        t1.setName("ThreadName01");
        t1.start();
        System.out.println("Started the thread t1");
        // starting it again gives illegelStateException
//		t1.start();
        try {
            Thread.sleep(75);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new RunMe();
        System.out.println("Going to start thread t2");
        t2.setName("ThreadName02");
        t2.start();
        System.out.println("Started the thread t2");

    }

}

class RunMe extends Thread {
    @Override
    public void run() {

        super.run();
        System.out.println("print long series");
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("For Thread %s , i now is %d", Thread.currentThread().getName(), i));
            try {
                Thread.sleep(25 * i);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}