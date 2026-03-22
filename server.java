import java.net.*;
import java.io.*;
import java.util.Scanner;

public class server{
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(5000);

        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        Scanner sc = new Scanner((System.in));
        String send = "";
        String receive = "";

        while(!send.equalsIgnoreCase("exit")){
            send = sc.nextLine();
            System.out.println("You: " + send);
            dos.writeUTF(send);

            receive = dis.readUTF();
            System.out.println("Client: " + receive);
        }
        sc.close();
        dis.close();
        dos.close();
        s.close();
        ss.close();
    }
}