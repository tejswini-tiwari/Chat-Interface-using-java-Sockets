import java.net.*;
import java.io.*;
import java.util.Scanner;


public class client{
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("localhost", 5000);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        Scanner sc = new Scanner((System.in));
        String send = "";
        String receive = "";

        while(!send.equalsIgnoreCase("exit")){
            receive = dis.readUTF();
            System.out.println("Server: " + receive);
            
            send = sc.nextLine();
            System.out.println("You: " + send);
            dos.writeUTF(send);
        }
        sc.close();
        dis.close();
        dos.close();
        s.close();
    }
}