//package gobackn;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    static ArrayList<Integer> senderFrames;


    public static void initializeFrames(){
        senderFrames=new ArrayList<>();
        senderFrames.add(36);
        senderFrames.add(69);
        senderFrames.add(96);
        senderFrames.add(51);
        senderFrames.add(7);
        senderFrames.add(48);
    }

    public static void main(String args[]) throws Exception {

        initializeFrames();

        ServerSocket serverSocket=new ServerSocket(6969);
        Socket socket=serverSocket.accept();
        DataInputStream din=new DataInputStream(socket.getInputStream());
        DataOutputStream dout=new DataOutputStream(socket.getOutputStream());

        dout.write(senderFrames.size());  //sending the no of frames
        System.out.println("Sending frames to client");

        for (Integer senderFrame : senderFrames) {
            dout.write(senderFrame);
        }

        int errorFrameIndex=din.read();
        System.out.println("Retransmitting from frame  "+(errorFrameIndex+1));

        for(int i=errorFrameIndex;i<senderFrames.size();i++)
            dout.write(senderFrames.get(i));
    }
}
