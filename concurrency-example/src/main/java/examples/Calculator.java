package examples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Calculator {
	
	private ExecutorService executor = Executors.newSingleThreadExecutor();

	public Future<CalculationResult> calculate(final Integer i){
		
		return executor.submit(new Callable<CalculationResult>() {

			public CalculationResult call() throws Exception {
				System.out.println("Thread-"+Thread.currentThread().getId()+": Hey I'm calculating");
				Thread.sleep(6000);
				int r = i * 5;
				System.out.println("Thread-"+Thread.currentThread().getId()+": I'm finished calculating : "+String.valueOf(r));
				return new CalculationResult(r);
			}
		});
		
	}
}
