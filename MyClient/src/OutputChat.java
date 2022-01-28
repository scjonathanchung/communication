import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class OutputChat extends Thread{
    private Socket socket;
    private PrintWriter out;
    private BufferedReader stdIn;
    private String OutputLine;

    public OutputChat(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new PrintWriter(this.socket.getOutputStream(), true);
        this.stdIn = new BufferedReader(new InputStreamReader(System.in));
        out.println("在线");
    }

    public void run(){
        while(true) {
            try {
                OutputLine = stdIn.readLine();
                out.println(OutputLine);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
