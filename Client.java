package javafinalproject;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    private static final String HOST = "61.228.206.30";
    private static final int PORT = 8888;
    private static Socket socket;
    private static String response;
    private static String answer;
    private static int[][] result;

    public static int connectToServer(String serverName, String password) {
        try {
            socket = new Socket(HOST, PORT);
    
            String name_pass = serverName + "_" + password;
        
            NetworkUtils.sendString(socket, name_pass);
    
            response = NetworkUtils.receiveString(socket);
            
            if(!response.equals("fail"))
               return 1;
            else
                return 0;
        } catch (IOException e) {
            System.out.println("error");
            return 0;
        }
    }
    
    public static String getQuestions() {
        return response;
    }
    
    public static void setResult(String RateResult) {
        answer = RateResult;
        try{
            NetworkUtils.sendString(socket, answer);
        }catch (IOException e){
            System.out.println("Error in sending result!");
        }
    }
    
    public static Boolean getFinalResult() {
        try{
            String FinalResultStr = NetworkUtils.receiveString(socket);
            result = stringToArray(FinalResultStr);
            System.out.println("Result when received by client : ");
            printArray(result);
            return true;
        }catch(IOException e){
            System.out.println("Final result hasn't been received");
            return false;
        }
    }
    
    public static int[][] getResult() {
        return result;
    }
    
    public static int[][] stringToArray(String arrayString) {
        System.out.println("Result String when received by client");
        System.out.println(arrayString);
        String[] lines = arrayString.split("_");
        int rowCount = lines.length;

        // Determine column count by splitting the first line
        String[] elements = lines[0].split(" ");
        int columnCount = elements.length;

        int[][] newArray = new int[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {
            elements = lines[i].split(" ");
            for (int j = 0; j < columnCount; j++) {
                newArray[i][j] = Integer.parseInt(elements[j]);
            }
        }

        return newArray;
    }
    
    
    public static void printArray(int[][] array) {
        for(int[] row : array){
            System.out.println(Arrays.toString(row));
        }
    }
}