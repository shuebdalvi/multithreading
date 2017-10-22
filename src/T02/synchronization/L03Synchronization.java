package T02.synchronization;

/*
 * Q.synchronization?
 * A.Synchronization in java is the capability to control the access of 
 * multiple threads to any shared resource
 * 
 * Q. types of snychronization?
 * A. two types -
 * Process Synchronization
 * Thread Synchronization
 * 
 * 
 */

public class L03Synchronization {

	// even using volatile keyword won't help here
	private volatile int counter = 0;

	public static void main(String[] args) {

		L03Synchronization app = new L03Synchronization();
		app.dowork();
	}

	// below method is added to increment the counter. keyword 'synchronized' is
	// used
	// to denote that only one thread can access this method
	private synchronized void incrementCounter() {
		counter++;
	}

	private void dowork() {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					incrementCounter();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					incrementCounter();
				}
			}
		});

		t1.start();
		t2.start();

		// for making this thread to wait for 't1' and 't2' to finish, call join()
		// method on them
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		System.out.println("counter is now: " + counter);

	}

}
