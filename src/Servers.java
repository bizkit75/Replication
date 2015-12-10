import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servers {

	public static void Check() throws IOException {
		
		System.out.println("STEP: Check()");
		ServerSocket listener = new ServerSocket(9082);
		listener.setReuseAddress(true);
		Socket sock = listener.accept();
		sock.setReuseAddress(true);
		System.out.println("STEP: Check()");
		Servers.transfert(sock.getInputStream(), new FileOutputStream("src/Dublin/student5.txt"), true);
		listener.close();
		sock.close();
		System.out.println("STEP: END Check()");
		
	}
	
	    public static void Send() throws IOException 
	    { 
	    	
	        Socket sock = new Socket(InetAddress.getLocalHost(),9082);
	        System.out.println("STEP: Send()");
	        Servers.transfert(
	                new FileInputStream("src/Cork/student2.txt"),
	                sock.getOutputStream(),
	                true);
	        sock.close();
	        System.out.println("STEP: END Send()");
	        System.out.println("OUPA");
	   } 
	

	public static void transfert(InputStream in, OutputStream out, boolean closeOnExit) throws IOException {
		byte buf[] = new byte[1024];
		System.out.println("STEP: Trnasfert");
		int n;
		while ((n = in.read(buf)) != -1)
			out.write(buf, 0, n);

		if (closeOnExit) {
			in.close();
			out.close();
		}
	}
}
