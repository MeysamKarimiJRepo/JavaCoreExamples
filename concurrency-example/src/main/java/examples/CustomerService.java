package examples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CustomerService {
	
	private ExecutorService executor = Executors.newSingleThreadExecutor();

	public Future<SaveResponse> saveMilionsOfCustomers(final Integer i){
		
		return executor.submit(new Callable<SaveResponse>() {

			public SaveResponse call() throws Exception {
				System.out.println("Thread-"+Thread.currentThread().getId()+": Hey I'm calculating");
				Thread.sleep(6000);
				int r = i * 5;
//				if (r == 40) {
//					System.out.println("Errorr");
//					throw new Exception("40");
//				}
				System.out.println("\nThread-"+Thread.currentThread().getId()+": I'm finished calculating : "+String.valueOf(r));
				return new SaveResponse(r);
			}
		});
		
	}
}
