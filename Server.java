package javafinalproject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static final int PORT = 8888;
    private static String ServerName_Password = "MyServer_password123";
    private static int maxClient = 2;
    private static int clientCount = 0;
    private static String questionList;
    private static int[][] result;
    private static Object monitor = new Object();
    private static boolean condition = false;
    
    public static void ChangeServerID(String newServerID, int newMaxClient, String questions, int qLength){
        ServerName_Password = newServerID;
        maxClient = newMaxClient;
        questionList = questions;
        result = new int[qLength][10];
    }
    
    public static void stopReceivingClient() {
        maxClient = clientCount;
        setCondition();
        System.out.println("maxClient value changed, current maxClient : " + maxClient);
    }
    
    public static int[][] getResult() {
        return result;
    }
    
    public static String getQuestions() {
        return questionList;
    }
    
    public static int getCurrentClient() {
        return clientCount;
    }

    public static void startServer() {
        System.out.println("Maximum Client = " + maxClient);
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (clientCount < maxClient) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new Thread(() -> handleClient(clientSocket));
                clientThread.start();
                
                System.out.println("Client connected from " + clientSocket.getInetAddress()); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            String serverName_pass = NetworkUtils.receiveString(clientSocket);

            if (serverName_pass.equals(ServerName_Password)) {
                NetworkUtils.sendString(clientSocket, questionList);
                String clientAnswerStr = NetworkUtils.receiveString(clientSocket);
                addToExistingList(clientAnswerStr);
                
                try{
                    waitForCondition(clientSocket);
                }catch(InterruptedException e){
                    System.out.println("Waiting interrupted");
                }
            } else {
                NetworkUtils.sendString(clientSocket, "fail");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static synchronized void addToExistingList(String clientAnswerStr) {
                
        ArrayList<Integer> clientAnswer = splitString(clientAnswerStr);

        int count = 0;
        for(int answer : clientAnswer){
            result[count][answer-1] += 1;
            count += 1;
        }

        clientCount += 1;
        System.out.println("Current Submitted Client : " + clientCount);
        
        if(clientCount >= maxClient){
            setCondition();
        }
    }
    
    public static ArrayList<Integer> splitString(String input) {
        ArrayList<Integer> x = new ArrayList<>();
        
        // Remove the square brackets from the string representation
        String cleanString = input.substring(1, input.length() - 1);
        
        String[] substrings = cleanString.split(", ");
        
        for (String substring : substrings) {
            int number = Integer.parseInt(substring);
            x.add(number);
        }
        
        return x;
    }
    
    public static void waitForCondition(Socket clientSocket) throws InterruptedException {
        synchronized (monitor) {
            while (!condition) {
                monitor.wait();
            }
            // Perform desired actions after condition is met
            System.out.println("Condition met");
            try{
                System.out.println("sending result to client..");
                NetworkUtils.sendString(clientSocket, arrayToString(result));
            }catch(IOException e){
                System.out.println("Error in sending Result to client");
            }
        }
    }

    public static void setCondition() {
        synchronized (monitor) {
            condition = true;
            monitor.notifyAll();
        }
    }
    
    public static String arrayToString(int[][] array) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sb.append(array[i][j]);
                sb.append(" ");
            }
            sb.append("_");
        }

        System.out.println("Final Result String to send to Client :");
        System.out.println(sb.toString());
        return sb.toString();
    }
}
