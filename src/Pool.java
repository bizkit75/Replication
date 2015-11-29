import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Pool {

	static Object Lock = new Object();
	static LinkedList<String> ThreadList = new LinkedList<String>();

	// Semaphore maintains a set of permits.
	// Each acquire blocks if necessary until a permit is available, and then
	// takes it.
	// Each release adds a permit, potentially releasing a blocking acquirer.
	static Semaphore semaphore = new Semaphore(0);
	static Semaphore mutex = new Semaphore(1);

	static class DublinServor extends Thread {
		public void run() {

			int counter = 1;
			try {
				while (true) {

					mutex.release();
					semaphore.release();
					Thread.sleep(180 * 1000);
				}
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
	}

	static class CorkServor extends Thread {
		public void run() {

			try {
				while (true) {

					semaphore.acquire();
					mutex.acquire();

					mutex.release();
					Thread.sleep(180 * 1000);

				}
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
	}
	
	static class Client extends Thread {
		public void run() {

			try {
				while (true) {

					semaphore.acquire();
					mutex.acquire();

					mutex.release();
					Thread.sleep(180 * 1000);

				}
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
	}
}
