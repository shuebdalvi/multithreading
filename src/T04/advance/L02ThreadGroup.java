package T04.advance;
/*
 * FAQs
 * 
 * Q. why threadgroup is used?
 * A. we can suspend, resume or interrupt group of threads by a single method call.
 * 
 * Q. pratical use of threadgroup?
 * 
 * 
 */
public class L02ThreadGroup {

	public static void main(String[] args) {
		
		ThreadGroup group = new ThreadGroup("Parent Thread");
		
		Thread t1 = new Thread(group,new GroupedThread(),"Thread one");
		Thread t2 = new Thread(group,new GroupedThread(),"Thread two");
		Thread t3 = new Thread(group,new GroupedThread(),"Thread three");
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("Thread Group Name = "+group.getName());
		group.list();
	}

}

class GroupedThread extends Thread{
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
	};
}