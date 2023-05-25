package javafinalproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkUtils {
    public static void sendString(Socket socket, String message) throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println(message);
        out.flush();
    }

    public static String receiveString(Socket socket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return in.readLine();
    }
}
