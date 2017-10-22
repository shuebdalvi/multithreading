package T03.basics;

public class L02JoiningThreads {

	public static void main(String[] args) {

		JoinThread t1 = new JoinThread();
		JoinThread t2 = new JoinThread();
		JoinThread t3 = new JoinThread();
		
		System.out.println("starting t1");
		t1.start();
		try {
			// this thread execution waits for 't1' to finish
			t1.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Starting others");
		t2.start();
		t3.start();
		
	}

}

class JoinThread extends Thread {

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("i is now"+i);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	};
}