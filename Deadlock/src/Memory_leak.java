import java.util.ArrayList;
import java.util.HashSet;


public class Memory_leak {
	private String large = new String(new char[100000]);

	ArrayList<String> list = new ArrayList<String>();
	HashSet<Integer> hashset = new HashSet<Integer>();
	public String getSubString() {
	    return this.large.substring(0,2);
	  }
	public void fun(int a, int b){  //memory leak......
		 /*ArrayList subStrings = new ArrayList();
		    for (int i = 0; i < 1000000; i++) {
		      Memory_leak testGC = new Memory_leak();
		      subStrings.add(testGC.getSubString());
		    }
		*/
		
		
		for (int i = 0; i < a; i++) {
			Memory_leak ml1 = new Memory_leak();
			
			System.out.println("inside for");
			for (int j = 0; j < b; j++) {
				list.add(Integer.toString(i+j));
			}
			for (int j = b-1; j > 0; j--) {
				list.remove(j);
			}
		}
	}
	public void fun2(int c){ 
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < c; i++) {
			System.out.println("........");
			set.add("Hi...this is the string " +i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Memory_leak ml = new Memory_leak();
		ml.fun(1000, 30);
		ml.fun2(50000);
		System.out.println("hiiii");
	}

}
