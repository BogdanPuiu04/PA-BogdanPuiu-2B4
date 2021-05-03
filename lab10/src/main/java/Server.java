import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static boolean isServerStopped = false;

    public Server() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(999);
            while (true) {
                if (isServerStopped) {
                    System.out.println("Server stopped");
                    break;
                }
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    public static void stoppingServer() {
        isServerStopped = true;
    }



}

