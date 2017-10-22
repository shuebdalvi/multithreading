package T01.startingthreads;

public class L02ImplementingRunnable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new RunMe2());
		t1.start();
		
		Thread t2 = new Thread(new RunMe2());
		t2.start();
		
	}
}

class RunMe2 implements Runnable {
	public void run() {
		System.out.println("print long series");
		for(int i=0;i<10;i++){
			System.out.println("i now is "+i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}