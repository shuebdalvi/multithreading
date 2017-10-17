package T02.synchronization;

public class L03Synchronization {

	// even using volatile keyword won't help heres
	private volatile int counter = 0;

	public static void main(String[] args) {

		L03Synchronization app = new L03Synchronization();
		app.dowork();
	}

	// below method is added to increment the counter. keyword 'sunchronized' is
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

		// for making this thread wait for 't1' and 't2' to finish call join()
		// method on them
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("counter is now: " + counter);

	}

}
