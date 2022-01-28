import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException{

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        Socket kkSocket = new Socket(hostName, portNumber);

        OutputChat ClientOutputThread = new OutputChat(kkSocket);
        InputChat ClientInputThread = new InputChat(kkSocket);
        ClientOutputThread.start();
        ClientInputThread.start();

        while(true){
            if(ClientInputThread.isAlive() == false){
                System.out.println("对方已下线");
                ClientOutputThread.interrupt();
                System.exit(0);//正常退出程序
            }
        }
    }
}
