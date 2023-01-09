import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int port = 8093;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    System.out.printf("New connection accepted.Port: %d%n", clientSocket.getPort());
                    out.println(String.format("Hi, your port is %d. Write your name", clientSocket.getPort()));
                    final String name = in.readLine();
                    out.println("Are you child? (yes/no)");
                    String word = in.readLine();
                    if (word.equals("yes")) {
                        out.println("Welcome to the kids area, " + name + " ! Let's play!");
                    } else {
                        out.println("Welcome to the adult zone, " + name + " ! Have a good rest, or a good working day!");
                    }
                    out.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}