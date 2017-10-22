package T03.basics;

public class L03NamingThread {

	public static void main(String[] args) {
		NamedThread t1 = new NamedThread();
		t1.setName("Non-Stop Thread");
		System.out.println("Starting thread = "+t1.getName());
		System.out.println("Thread id is = "+t1.getId() );
		
		t1.start();
		System.out.println("Started thread = "+t1.getName());	

	}

}

class NamedThread extends Thread{
	
	@Override
	public void run() {
		super.run();
		System.out.println("i am a named thread");
		System.out.println("my name is "+getName());
	}
}