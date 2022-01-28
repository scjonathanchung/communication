import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        int portNumber = Integer.parseInt(args[0]);
        ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket clientSocket = serverSocket.accept();

        OutputChat ServerOutputThread = new OutputChat(clientSocket);
        InputChat ServerInputThread = new InputChat(clientSocket);
        ServerOutputThread.start();
        ServerInputThread.start();

        while(true){
            if(ServerInputThread.isAlive() == false){
                System.out.println("对方已下线");
                ServerOutputThread.interrupt();
                System.exit(0);//正常退出程序
            }
        }
    }
}
