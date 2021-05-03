import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

class ClientThread extends Thread {
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            Connection connection=DBService.getConnection();
            String request = "start";
            int id=0;
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            while (true) {
                String response;
                if(Server.isServerStopped)
                {
                    response="Server is stopped";
                    out.println(response);
                    break;
                }
                request = in.readLine();
               // System.out.println(request);
                if (request.equals("stop")) {
                    response = "Server has stopped";
                    out.println(response);
                    out.flush();
                    Server.stoppingServer();
                    break;
                }
                if (request.equals("exit")) {
                    break;
                }
                String[] command = request.split("\\s+");
                switch (command[0]){
                    case "register":
                    {
                       id=Commands.register(command[1]);
                        break;
                    }
                    case "login":
                    {
                        if(id==0) {
                            id=Commands.login(command[1]);
                            System.out.println("test");
                            break;
                        }
                    }
                    case "friend":
                    {
                        if(id!=0){
                            for(int i=1;i<command.length;i++){
                                Commands.friend(command[i],id);
                            }
                        }
                        break;
                    }
                    case "send":{
                        if (id != 0) {
                            Commands.sendMessage(command[1],id);
                            break;
                        }
                    }
                    case "read":{
                        if(id!=0){
                           ArrayList<String> messages= Commands.readMessages(id);
                           out.println(messages.size());
                           for(String mess : messages){
                               out.println(mess);
                               out.flush();
                           }
                        }
                        break;
                    }
                    default: {
                        out.println("Incorrect command");
                        out.flush();
                        continue;
                    }

                }

                response = "Server received the request...";
                out.println(response);
                out.flush();
            }
            System.out.println("Exit thread");
        } catch (IOException | SQLException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}

