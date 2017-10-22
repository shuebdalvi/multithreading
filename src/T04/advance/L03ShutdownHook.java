package T04.advance;
/*
 * FAQs
 * 
 * Q. why use shutdown hook ?
 * A. The shutdown hook can be used to perform cleanup resource or save 
 * the state when JVM shuts down normally or abruptly. Performing clean resource means closing log file, 
 * sending some alerts or something else. So if you want to execute some code before JVM shuts down, use shutdown hook.
 * 
 * Q. The shutdown sequence can be stopped by invoking the halt(int) method of Runtime class. what does this means?
 * A.
 */
public class L03ShutdownHook {

	public static void main(String[] args) {

		/*
		 * The addShutdownHook() method of Runtime class is used to register the thread with the Virtual Machine.
		 * The object of Runtime class can be obtained by calling the static factory method getRuntime().
		 */
		Runtime r = Runtime.getRuntime();
		
		r.addShutdownHook(new ShutdownHookThread());
		System.out.println("Sleeping for some time");
		try {
			Thread.sleep(2000);//2 sec
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * Note: The shutdown sequence can be stopped by invoking the halt(int) method of Runtime class.
		 */
		System.out.println("Program is finished");

	}

}

class ShutdownHookThread extends Thread{
	
	public void run() {
		System.out.println("Shutdown hook executed successfully");
	};
}