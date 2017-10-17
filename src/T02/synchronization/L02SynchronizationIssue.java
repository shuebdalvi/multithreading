package T02.synchronization;

public class L02SynchronizationIssue {

	// even using volatile keyword won't help here
	private volatile int counter = 0;

	// execute many different times to see the effect
	public static void main(String[] args) {

		L02SynchronizationIssue app = new L02SynchronizationIssue();
		app.dowork();
	}

	private void dowork() {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					counter++;
//					System.out.println("t1 counter:"+counter);
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					counter++;
//					System.out.println("t2 counter:"+counter);
				}
			}
		});

		t1.start();
		t2.start();

		// for making this thread wait for 't1' and 't2' to finish,
		// call join() method on them
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
