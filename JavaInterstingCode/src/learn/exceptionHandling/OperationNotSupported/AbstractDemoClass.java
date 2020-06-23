package learn.exceptionHandling.OperationNotSupported;

public abstract class AbstractDemoClass implements IPrint {
	@Override
	public void showMessage() {
		System.out.println("inside AbstractDemoClass");
		return ;
		
	}	
}