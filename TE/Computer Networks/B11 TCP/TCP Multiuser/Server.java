import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

class Listener implements Runnable {



    private Socket socket;
    private String string;

    Listener(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Connecting to " + Thread.currentThread().getName());
        Scanner scanner = new Scanner(System.in);

        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            while (true) {
                string = dataInputStream.readUTF();

                System.out.println(Thread.currentThread().getName() + " says : " + string);

                System.out.println("Reply..");
                string = scanner.nextLine();

                if (string.toLowerCase().equals("stop")) {
                    return;
                }

                dataOutputStream.writeUTF(string);

                dataOutputStream.flush();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

public class Server {

    public static void main(String []args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket;

        while (true) {
            socket = serverSocket.accept();
            new Thread(new Listener(socket)).start();
        }

    }

}
