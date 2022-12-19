package examples;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Application {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Calculator calculator = new Calculator();
		Future<CalculationResult> future = calculator.calculate(8);
		
		if (future.isDone()) {
			future.get();
		}else {
			System.out.println("I do some other tasks while the calculator is calculating :-) ");
		}
	}

}
