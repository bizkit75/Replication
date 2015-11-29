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
		System.out.println("ETAPE: 44");
		Socket sock = new ServerSocket(9022).accept();
		
		Servers.transfert(sock.getInputStream(), new FileOutputStream("D:\\test2.jpg"), true);
		System.out.println("ETAPE: 4");
		sock.close();
	}
	
	
	    public static void Send() throws IOException 
	    { 
	        Socket sock = new Socket(InetAddress.getLocalHost(),9022);
	    
	        Servers.transfert(
	                new FileInputStream("D:\\test.jpg"),
	                sock.getOutputStream(),
	                true);
	        System.out.println("ETAPE: 5");
	        sock.close();
	   } 
	

	public static void transfert(InputStream in, OutputStream out, boolean closeOnExit) throws IOException {
		byte buf[] = new byte[1024];

		int n;
		while ((n = in.read(buf)) != -1)
			out.write(buf, 0, n);

		if (closeOnExit) {
			in.close();
			out.close();
		}
	}
}
