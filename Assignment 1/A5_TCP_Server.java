/*
Write and explain  programs to develop chat application programs for a client and a server considering TCP protocol with socket programming
 */
package A1_Questions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class A5_TCP_Server {

    public static void main(String[] args) {

        String fromClient = "";
        String forClient = "";

        Scanner sc = new Scanner(System.in);

        try {
            //Create Sever Socket and Client Socket
            ServerSocket serverSocket = new ServerSocket(1024);
            Socket socket = serverSocket.accept();

            do {
                //Using Stream for IO
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                //Extract data and show on console
                fromClient = inputStream.readUTF();
                System.out.println("From Client :: " + fromClient);

                // ------------------- ACK ----------------------------

                System.out.print("\nEnter message here :: ");
                forClient = sc.nextLine();
                outputStream.writeUTF(forClient);

                //Terminate the connection
                if (fromClient.equals("CLOSE")) {
                    socket.close();
                    serverSocket.close();
                }

            } while (!fromClient.equals("CLOSE"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/*
OUTPUT

From Client :: hi

Enter message here :: hello
From Client :: how are you

Enter message here :: i am fine
From Client :: let's end

Enter message here :: sure
From Client :: CLOSE

Enter message here :: CLOSE



Enter message here :: hi
From Server :: hello

Enter message here :: how are you
From Server :: i am fine

Enter message here :: let's end
From Server :: sure

Enter message here :: CLOSE
From Server :: CLOSE



 */