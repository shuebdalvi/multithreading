package T03.basics;

public class L01SleepingThread {

	public static void main(String[] args) {
		
		// different sleep times 
		SleepThread t1 = new SleepThread(100);
		SleepThread t2 = new SleepThread(500);
		
		t1.start();
		t2.start();		

	}

}

class SleepThread extends Thread{
	
	private int SleepTime;
	
	public SleepThread(int Time) {
		this.SleepTime = Time;
	}
	
	@Override
	public void run() {
	
		super.run();
		for(int i=0;i<10;i++){
			System.out.println("i is now = "+i);
			try {
				Thread.sleep(SleepTime);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
	}
}
