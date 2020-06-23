package learn.exceptionHandling.OperationNotSupported;

public class A extends AbstractDemoClass{
	public void display(String input) {
		System.out.println("Hello"+input);
	}
	 public void showMessage() {
		throw new UnsupportedOperationException();
	 }

}
