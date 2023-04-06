import com.phone.OS;
import com.phone.OperatingSystemFactory;
import com.phone.Windows;


public class FactoryMain {
    /* Factory Design Pattern
     * Lets say we have an interface and we have multiple implementations of that interface. lets say we have 
     * an interface named, OS and we have the implementations as android OS, windows OS and we have iOS.
     * If you want to create an object or you want to instantiate that OS, we have to use one of these OS, either 
     * we can use android OS or Windows OS or iOS. Now, how to mention that which one we want. So, depending
     * on your requirement, you will create the object of different class, may be android or windows or ios.
     * Now, we want to hide the logic of object creation from the user. In order to that, we can use factory
     * design pattern.
     * Create FactoryMain.java and create an interface called, OS. Every OS would have some features. Now, we
     * have multiple implementations of same OS. 
     */
	public static void main(String a[]) {
		// TODO Auto-generated method stub
		//To create the object of interface, OS
	//	OS obj = new Windows();
		/*we are providing the implementation here itself "new Windows()". In future, if we want to change it 
		 * from Windows to other OS, we have to change this code, we have to recompie it. That means your
		 * client knows which classes you are working with because you are exposing this Windows keyword in
		 * line 20. Now, factory pattern says that instead of creating directly object, we must create a class,
		 * OperatingSystemFactory. So, this is the factory which will give you the object of those OS. Now,
		 * getInstance() method in OperatingSystemFactory would return the object of OS and in argument of
		 * getInstance(), it will take the type of the OS. Depending on the string we pass in the argument of getInstance()
		 * method, it will return the particular object.
		 * So, Factory manufactures the object. This is the class which gives the object. Thats why it is 
		 * called as Factory Design Pattern. Now, if you have an extra class in future, it will not change 
		 * your client application. It will change OperatingSystemFactory class but not the client application. 
		 */
	//	obj.spec();
	OperatingSystemFactory osf = new OperatingSystemFactory();
	OS obj = osf.getInstance("Open");
	obj.spec();
	
	}

}
