/*
Question

Write and explain
programs to develop chat application programs for a client and a server considering UDP protocol with socket programming
 */

package A1_Questions;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

//UDP Sender
public class A3_UDP_Client {

    public static void main(String[] args) {

        String forServer = "";
        String fromServer = "";

        try {
            //Crate a Socket
            DatagramSocket datagramSocket = new DatagramSocket();

            //Prepare the Data
            int port = 1024;
            InetAddress ip = InetAddress.getByName("localhost");

            do {
                //Get the data from the user
                Scanner sc = new Scanner(System.in);
                System.out.print("\nEnter message here :: ");
                forServer = sc.next();

                //Prepare the packet to send
                byte[] dataToSent = forServer.getBytes();
                DatagramPacket datagramPacket1 = new DatagramPacket(dataToSent, dataToSent.length, ip, port);

                //send the packet
                datagramSocket.send(datagramPacket1);

                //------------------------------------ Receive ACK From Server --------------------------------------------

                //Storage
                byte[] buffer = new byte[1024];

                //get the data in a packet
                DatagramPacket datagramPacket4 = new DatagramPacket(buffer, buffer.length);
                datagramSocket.receive(datagramPacket4);

                //extract data and show on console
                fromServer = new String(datagramPacket4.getData(), 0, datagramPacket4.getLength());
                System.out.println("From Server :: " + fromServer);

                if (forServer.equals("CLOSE"))
                    datagramSocket.close();

            } while (!fromServer.equals("CLOSE"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/*
Enter message here :: Hi
From Server :: Hello

Enter message here :: How are you
From Server :: I

Enter message here :: Let's end ?
From Server :: suer

Enter message here :: CLOSE
From Server :: CLOSE



From Client :: Hi

Enter message here :: Hello
From Client :: How

Enter message here :: I am fine
From Client :: Let's

Enter message here :: suer
From Client :: CLOSE

Enter message here :: CLOSE
 */