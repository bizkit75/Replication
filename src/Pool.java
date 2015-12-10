import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Pool {

	static Object Lock = new Object();
	static LinkedList<String> ThreadList = new LinkedList<String>();
	static Semaphore semaphore = new Semaphore(0);
	static Semaphore mutex = new Semaphore(1);

	static class DublinServor extends Thread {
		public void run() {
			System.out.println("Step: DublinServor");
			int counter = 1;
			try {
				while (true) {
					System.out.println("STEP: DublinServor");
				
					Servers Dublin = new Servers();
					Dublin.Check();
					Thread.sleep(0);
				}
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
	}

	static class CorkServor extends Thread {
		public void run() {
			System.out.println("Step: CorkServor");
			try {
				while (true) {

				
					Servers Corck = new Servers();
					Corck.Send();
					Thread.sleep(20 * 1000);
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
