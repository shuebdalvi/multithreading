package T03.basics;

public class L05DaemonThread {

	public static void main(String[] args) {

		DaemonThread t1 = new DaemonThread();
		DaemonThread t2 = new DaemonThread();
		DaemonThread t3 = new DaemonThread();

		// set as daemon thread
		// Note: If you want to make a user thread as Daemon, it must not be
		// started otherwise it will throw IllegalThreadStateException.
		t1.setDaemon(true);

		
		t2.start();
		t1.start();
		t3.start();
	}

}

class DaemonThread extends Thread {

	public void run() {
		// NOTE : how reference to current thread is obtained.
		// this is important since there could be different objects which may
		// try to access the current thread
		if (Thread.currentThread().isDaemon()) {
			System.out.println("This thread is Daemon thread");

		} else {
			System.out.println("This thread is User thread");

		}
	};
}