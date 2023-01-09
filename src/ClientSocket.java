import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8093;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String reps = in.readLine();
            System.out.println(reps);
            out.println("Марина Веретина");
            reps = in.readLine();
            System.out.println(reps);
            out.println("no");
            reps = in.readLine();
            System.out.println(reps);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
