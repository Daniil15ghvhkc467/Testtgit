import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
public static void main(String[] args) throws IOException {
    int count =1;
    ServerSocket serverSocket = new ServerSocket(8000);
while(true){
    Socket clientSocket = serverSocket.accept();

    System.out.println("Connected to " + (count++));
    clientSocket.getOutputStream().write(64);
    OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(
              clientSocket.getInputStream()));
    
    writer.write(
        "HTTP/1.0 200 OK\n"+
        "Content-Type: text/html\n"+
        "\n"+
        "<h1>Java</h1>\n");
    
    writer.flush();
    writer.close();
    reader.close();
    clientSocket.close();
}
   // serverSocket.close();
}

    


}