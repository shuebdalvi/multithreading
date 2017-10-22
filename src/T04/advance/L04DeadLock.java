package T04.advance;

public class L04DeadLock {

	public static void main(String[] args) {
		final String resource1 = "Resource ONe";
		final String resource2 = "Resource Two";

		Thread t1 = new Thread() {
			@Override
			public void run() {
				super.run();
				synchronized(resource1){
					System.out.println("Thread one locking resource1");
					try {
						sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				
				synchronized(resource2){
					System.out.println("Thread one locking resource2");
					try {
						sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				super.run();
				synchronized(resource2){
					System.out.println("Thread two locking resource2");
					try {
						sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				
				synchronized(resource1){
					System.out.println("Thread two locking resource1");
					try {
						sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		};
		
		t1.start();
		t2.start();
		
	}

}
