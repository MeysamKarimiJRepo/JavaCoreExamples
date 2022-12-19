package examples;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Application {

	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
		CustomerService service = new CustomerService();
		Future<SaveResponse> future = service.saveMilionsOfCustomers(8);
		SaveResponse response = null;
		System.out.println("System is saving milions of customer, please wait :-) ");
		int x = 1;
		while (!future.isDone()) {
			String anim = "|/-\\";
			String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
			System.out.write(data.getBytes());
			Thread.sleep(999);
			x++;
		}

		response = future.get();
	}
	
}
