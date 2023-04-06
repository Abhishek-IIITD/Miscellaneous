
public class thread_prog {
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		t1 obj1 = new t1();
		t2 obj2 = new t2();
		obj1.start();
		obj2.start();
	}
	private static class t1 extends Thread{
		 public void run() {
	         synchronized (lock1) {
	            System.out.println("Thread 1: Holding lock 1...");
	            
	            try { Thread.sleep(10); }
	            catch (InterruptedException e) {}
	            System.out.println("Thread 1: Waiting for lock 2...");
	            
	            synchronized (lock2) {
	               System.out.println("Thread 1: Holding lock 1 & 2...");
	            }
	         }
	      }
	}
	private static class t2 extends Thread{
		  public void run() {
		         synchronized (lock1) {
		            System.out.println("Thread 2: Holding lock 2...");
		            
		            try { Thread.sleep(10); }
		            catch (InterruptedException e) {}
		            System.out.println("Thread 2: Waiting for lock 1...");
		            
		            synchronized (lock2) {
		               System.out.println("Thread 2: Holding lock 1 & 2...");
		            }
		         }
		      }
	}
	
}
