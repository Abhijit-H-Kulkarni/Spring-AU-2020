import java.util.Scanner;
public class Exceptionlambdas {

	public static void main(String[] args) {
		// Lambda Function
		float numerator = 0, denominator = 0;
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Enter the numerator :");
			numerator = s.nextFloat();
			System.out.println("Enter the denominator :");
			denominator = s.nextFloat();
		}
		catch(Exception e) {
			System.out.println("Enter proper input. Initialising numerator and denominator to zero.");
		}
		process(numerator, denominator, divideWrapper((num, den) -> System.out.println(num/den)));
	}
	
	
public static interface DivideLambda{
	public void divide(float numerator, float denominator);
}

private static void process(float numerator, float denominator, DivideLambda divider) {
	divider.divide(numerator, denominator);
}

private static DivideLambda divideWrapper(DivideLambda dividelambda) {
	return (numerator,denominator) -> {
		try {
			if(denominator == 0 )
				throw new ArithmeticException();
			System.out.println(numerator/denominator);
		}
		catch(ArithmeticException e) {
			System.out.println("Can't Divide by Zero.");
		}
	};
}
}
