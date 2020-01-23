package aspect;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {
	long startTime, endTime;
	@Before("execution(* services.EmployeeService.getEmp(..))")
	public void startTime() {
		System.out.println("Started.");
		this.startTime = System.nanoTime();
	}
	@After("execution(* services.EmployeeService.getEmp(..))")
	public void endTime() {
		this.endTime = System.nanoTime();
		System.out.println("The execution time is : "+(this.endTime-this.startTime));
		System.out.println("Ended.");
	}
}
