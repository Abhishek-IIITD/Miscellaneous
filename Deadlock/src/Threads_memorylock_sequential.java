import java.util.ArrayList;
import java.util.HashSet;



public class Threads_memorylock_sequential {
	public static Object lock1 = new Object();

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		t1 obj1 = new t1();
		t2 obj2 = new t2();
		t3 obj3 = new t3();
		obj1.start();
		obj2.start();
		obj3.start();
	}

	private static class t1 extends Thread{  //slowly leaking
		 public void run() {
	         synchronized (lock1) {
	            System.out.println("Thread 1: Holding lock 1...");
	        	ArrayList<String> list = new ArrayList<String>(); 
				for (int i = 0; i < 100000; i++) {
					System.out.println("inside for ALLOC DEALLOC");
					for (int j = 0; j < 30; j++) {
						list.add(Integer.toString(i+j));
					}
					for (int j = 30-1; j > 0; j--) {
						list.remove(j);
					}
				}
			
	         }
	      }
	}
	private static class t2 extends Thread{
		  public void run() {
		         synchronized (lock1) {
		            System.out.println("Thread 2");
		            
		        	System.out.println("in sleep mode");
					try {
						Thread.sleep(300000);  
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
					System.out.println("out of sleep mode");
				
		         }
		      }
	}
	private static class t3 extends Thread{  //no leak
		  public void run() {
		         synchronized (lock1) {
		            System.out.println("Thread 3");
		            HashSet<String> set = new HashSet<String>();
					for (int i = 0; i < 100000; i++) {
						 // HashSet<String> set = new HashSet<String>();
							
						System.out.println("inside for ALLOC");
						set.add("Hi...this is the string " +i);
					}
		         }
		      }
	}

}
