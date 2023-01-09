import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8090;

        try (Socket clientSocket = new Socket(host,port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
            out.println("mar-r-rinka's server");
            String reps = in.readLine();
            System.out.println(reps);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
