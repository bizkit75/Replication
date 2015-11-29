import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Pool {

	static Object Lock = new Object();
	static LinkedList<String> ThreadList = new LinkedList<String>();
	static Semaphore semaphore = new Semaphore(0);
	static Semaphore mutex = new Semaphore(1);

	static class DublinServor extends Thread {
		public void run() {
			
			int counter = 1;
			try {
				while (true) {

					mutex.release();
					semaphore.release();
					System.out.println("ETAPE: 1");
				Servers Dublin = new Servers();
				
				System.out.println("ETAPE: 11");
				Dublin.Check();
				
				
				
				System.out.println("ETAPE: 3");
					
					Thread.sleep(10000 * 1000);
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
					Servers Corck = new Servers();
					Corck.Send();
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
