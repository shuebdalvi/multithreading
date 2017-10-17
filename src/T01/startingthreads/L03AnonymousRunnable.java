package T01.startingthreads;

public class L03AnonymousRunnable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("print long series");
				for(int i=0;i<10;i++){
					System.out.println("i now is "+i);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
				
						e.printStackTrace();
					}
				}
				
			}
		});
		System.out.println("GOing to start thread");		
		t1.start();
		System.out.println("Started the thread");
		
	}

}
