package A1_Questions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class A5_TCP_Client {

    public static void main(String[] args) {

        String fromServer = "";
        String forServer = "";

        Scanner sc = new Scanner(System.in);

        try {
            //Connect with server
            Socket socket = new Socket("localhost", 1024);

            do {
                //Using Stream for IO
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                //Write message to server
                System.out.print("\nEnter message here :: ");
                forServer = sc.nextLine();
                outputStream.writeUTF(forServer);

                // ------------------------ Receive ACK ----------------------
                fromServer = inputStream.readUTF();
                System.out.println("From Server :: " + fromServer);

                //terminate the connection
                if (fromServer.equals("CLOSE"))
                    socket.close();

            } while (!fromServer.equals("CLOSE"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
OUTPUT

Enter message here :: hi
From Server :: hello

Enter message here :: how are you
From Server :: i am fine

Enter message here :: let's end
From Server :: sure

Enter message here :: CLOSE
From Server :: CLOSE


From Client :: hi

Enter message here :: hello
From Client :: how are you

Enter message here :: i am fine
From Client :: let's end

Enter message here :: sure
From Client :: CLOSE

Enter message here :: CLOSE

 */