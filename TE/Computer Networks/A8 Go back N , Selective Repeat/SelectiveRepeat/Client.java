//package selectiverepeat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class Client {

    static ArrayList<Integer> receiverFrames;

    public static void main(String args[]) throws IOException {


        int noOfFrames,errorFrameIndex=-1;
        receiverFrames=new ArrayList<>();

        Socket socket=new Socket("localhost",6969);
        DataInputStream din=new DataInputStream(socket.getInputStream());
        DataOutputStream dout=new DataOutputStream(socket.getOutputStream());

        noOfFrames=din.read();
        for(int i=0;i<noOfFrames;i++){
            receiverFrames.add(din.read());
        }

        Random ran = new Random();
        int rand = ran.nextInt(receiverFrames.size()-1);
        receiverFrames.set(rand,-1);            //random no to generate error at any position

        for(int i=0;i<noOfFrames;i++){
            if(receiverFrames.get(i)==-1)
                errorFrameIndex=i;
        }

        System.out.println("Complete frame after recieving: ");
        for(int i=0;i<receiverFrames.size();i++){
            System.out.print(receiverFrames.get(i)+"\t");
        }

        System.out.println("\nRequesting for frame no "+(errorFrameIndex+1));
        dout.write(errorFrameIndex);
        receiverFrames.set(errorFrameIndex,din.read());

        System.out.println("Complete frame after retransmitting: ");
        for(int i=0;i<receiverFrames.size();i++){
            System.out.print(receiverFrames.get(i)+"\t");
        }

    }
}
