package T03.basics;

public class L04ThreadPriority {

	public static void main(String[] args) {
		PriorityThread t1 = new PriorityThread();
		PriorityThread t2 = new PriorityThread();
		PriorityThread t3 = new PriorityThread();
		PriorityThread t4 = new PriorityThread();
		
		//setting prority
		t1.setPriority(1);
		t2.setPriority(5);
		t3.setPriority(10);
		
		t4.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();		

	}

}

class PriorityThread extends Thread{
	
	public void run() {
		System.out.println("This thread name is = "+getName()+" This thread has priority as "+ this.getPriority());
		System.out.println("This thread has priority as "+ getPriority());
		
	};
}