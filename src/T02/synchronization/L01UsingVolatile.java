package T02.synchronization;

import java.util.Scanner;

public class L01UsingVolatile {

	public static void main(String[] args) {
		StoppableThread t1 = new StoppableThread();
		System.out.println("Starting run of thread");
		t1.start();
		System.out.println("Started run of thread");

		// to stop the execution by pressing 'enter' in console.
		Scanner in = new Scanner(System.in);
		in.nextLine();
		in.close();
		// call method on thread 
		t1.stopme();
		
		
	}

}

class StoppableThread extends Thread 
{
	// volatile is used to indicate that a variable's value will be modified by different threads.
	// references marked as volatile are fetched everytime from main memory and not from cached thread memory which is used to optimse the performance
	// refer http://www.javamex.com/tutorials/synchronization_volatile.shtml
	// refer http://tutorials.jenkov.com/java-concurrency/volatile.html
	private volatile boolean running = true;

	public void run() {
		System.out.println("print long series");
		while (running) {
			System.out.println("i now is printing...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	public void stopme() {
		running = false;
	};
}