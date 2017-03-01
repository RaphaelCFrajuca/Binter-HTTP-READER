import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class httpreader {

	public static void main(String[] args) {
		System.out.println("Binter HTTP READER\n");
		// TODO Auto-generated method stub
			try {
				String ip = args[0];
				int porta = Integer.parseInt(args[1]);
				String payload = args[2];
				request(ip, porta, payload);
			} catch (Exception e) {
				System.err.println("Erro: " + e.getMessage());
			}
	}

	private static void request(String url, int port, String payload) throws Exception {
		System.out.println("Abrindo Socket...");
		Socket socket = null;
		socket = new Socket ();
		socket.setTcpNoDelay(true);
		socket.setPerformancePreferences(1,0,0);
		System.out.println("Conectando...");
		socket.connect(new InetSocketAddress(url,port), 2000); 
		
		OutputStream outstream = socket.getOutputStream(); 
		PrintWriter out = new PrintWriter(outstream);
		payload = payload.replace("[host]", url)
				.replace("[host_port]", url + ":" + port)
				.replace("[protocol]", "HTTP/1.1")
				.replace("[netData]", "CONNECT " + url + ":" + port + " HTTP/1.1")
				.replace("[cr]", "\r")
				.replace("[lf]", "\n")
				.replace("[crlf]", "\r\n")
				.replace("[lfcr]", "\n\r");
		System.out.println("Enviando Requisição:\n" + payload);
		
		out.print(payload);
		
		boolean ok = out.checkError();
				if (ok != false) {
					System.err.println("Erro ao enviar a requisição...");
				}
				System.out.println("Recebendo resposta...\n");
				  BufferedReader bis = new BufferedReader(new 
						  InputStreamReader(socket.getInputStream()));
						  String inputLine;
						  while ((inputLine = bis.readLine()) != null)
						  {
						      System.out.println(inputLine);
						  }
				out.close();
				
		socket.close ();

	}
}
