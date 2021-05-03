import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 999;
        try (
                Socket socket = new Socket(serverAddress, 999);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))) {
            String command = "start";
            while (!command.equals("exit") && !command.equals("stop") && !Server.isServerStopped) {
                System.out.println("Introduce a command: ");
                Scanner scanner = new Scanner(System.in);
                command = scanner.nextLine();
                out.println(command);
                if(command.equals("read")){
                    String num=in.readLine();
                    int number=Integer.parseInt(num);
                    int index=0;
                    while (index<number){
                        String mess=in.readLine();
                        System.out.println(mess);
                        index++;
                    }
                }
                String response = in.readLine();
                System.out.println(response);
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }

}
