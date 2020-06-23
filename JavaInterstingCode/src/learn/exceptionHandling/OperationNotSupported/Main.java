package learn.exceptionHandling.OperationNotSupported;

import javax.naming.OperationNotSupportedException;

public class Main {

	public static void main(String[] args) {
		try {
		A a = new A();
			a.showMessage();
		}catch(NoSuchMethodError ex) {
			System.out.println("NoSuchMethodError Exception");
		}catch(UnsupportedOperationException ex) {
			System.out.println("OperationNotSupportedException thrown");
		}
	}

}
