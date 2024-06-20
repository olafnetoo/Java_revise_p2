package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client implements Runnable {
    Socket socket;

    private BufferedReader reader;
    private PrintWriter writer;

    public Client() throws IOException {
//        this.socket = new Socket("own_ip", 2137);
        this.socket = new Socket("localhost", 2137);
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = reader.readLine())!= null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void send(String message) {
        this.writer.println(message);
    }
}
/* CLIENT od srever
package org.example;
import java.io.*;
import java.net.Socket;

public class Client implements Runnable{

    private Server server;
    private BufferedReader reader;
    private PrintWriter writer;
    private String login;
    private Socket socket;

    public Client(Server server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }

    private void parseMessage(String message){
        if(message.equals("/online")){
            send(server.serverUsersLogins().toString());
        }
        else {
            server.broadcast(String.format("<%s> %s", getLogin(), message));
        }
    }

    @Override
    public void run() {
        String message;
        try {
            this.authenticate();
            while ((message = reader.readLine())!= null) {
                parseMessage(message);
            }
            this.leave();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void send(String message) {
        this.writer.println(message);
    }

    private void authenticate() throws IOException {
        login = reader.readLine();
        server.clientLogged(this);
    }

    public String getLogin() {
        return login;
    }
    private void leave() throws IOException {
        socket.close();
        server.clientLeft(this);
    }
}
 */
