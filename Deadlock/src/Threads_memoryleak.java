import java.util.ArrayList;
import java.util.HashSet;



public class Threads_memoryleak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		t1 obj1 = new t1();
		t3 obj3 = new t3();
		t2 obj2 = new t2();
		obj1.start();
		obj3.start();
		obj2.start();
		
	}
	private static class t1 extends Thread{   //Allocation and Deallocation
		public void run(){
			ArrayList<String> list = new ArrayList<String>(); 
			for (int i = 0; i < 10000000; i++) {
				System.out.println("inside for ALLOC DEALLOC");
				for (int j = 0; j < 30; j++) {
					list.add(Integer.toString(i+j));
				}
				for (int j = 30-1; j >= 0; j--) {
					list.remove(j);
				}
			}
		}
	}

	private static class t2 extends Thread{  //Allocation
		public void run(){
			HashSet<String> set = new HashSet<String>();
			for (int i = 0; i < 10000000; i++) {
				System.out.println("inside for ALLOC");
				set.add("Hi...this is the string " +i);
			}
			/*ArrayList<String> list2 = new ArrayList<String>(); 
				System.out.println("inside for ALLOC");
				for (int j = 0; j < 50000; j++) {
					list2.add(Integer.toString(i+j));
				}*/
			
		}
	}
	
	private static class t3 extends Thread{  //Sleep
		public void run(){
			try {
				System.out.println("in sleep mode");
				Thread.sleep(300000);  //5 min
				System.out.println("out of sleep mode");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
