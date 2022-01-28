import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class InputChat extends Thread{
    private Socket socket;
    private BufferedReader in;
    private String InputLine;

    public InputChat(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

    public void run(){
        while(true){
            try {
                InputLine = in.readLine();
                System.out.println(InputLine);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
