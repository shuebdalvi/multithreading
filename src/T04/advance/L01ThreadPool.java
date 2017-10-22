package T04.advance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class L01ThreadPool {

	public static void main(String[] args) {
		
		// pool created only for 5 threads
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		//adding 10 threads to the pool
		for(int i=0;i<10;i++){
			
			Runnable worker = new PooledThread("Thread No."+(i+1));
			
			service.execute(worker);
			
		}

		service.shutdown();
		// waiting for executor service to finish executing all threads
		while(!service.isTerminated()){}
		System.out.println("Finished all threads");
	}

}


class PooledThread extends Thread{
	
	private String message;
	
	public PooledThread(String msg) {
		this.message = msg;
	}
	
	public void run() {
		
		for(int i=0;i<10;i++){
			System.out.println("Thread with message = '"+this.message+"' and iteration = "+i);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	};
}