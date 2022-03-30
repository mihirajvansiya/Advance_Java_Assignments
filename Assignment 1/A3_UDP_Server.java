/*
Question

Write and explain
programs to develop chat application programs for a client and a server considering UDP protocol with socket programming
 */

package A1_Questions;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

//UDP Receiver
public class A3_UDP_Server {

    public static void main(String[] args) {

        String fromClient = "";
        String forClient = "";

        try {
            //Create Socket
            DatagramSocket datagramSocket = new DatagramSocket(1024);

            //Create buffer as a storage
            byte[] buffer = new byte[1024];

            do {
                //Create a Packet to accept the data coming
                DatagramPacket datagramPacket2 = new DatagramPacket(buffer, buffer.length);

                //Accept the data sent
                datagramSocket.receive(datagramPacket2);

                //Extract the data
                fromClient = new String(datagramPacket2.getData(), 0, datagramPacket2.getLength());
                System.out.println("From Client :: " + fromClient);

                //------------------------------------ Send ACK to Client --------------------------------------------

                //Prepare Data to send
                Scanner sc = new Scanner(System.in);
                System.out.print("\nEnter message here :: ");
                forClient = sc.next();

                byte[] dataToSent = forClient.getBytes();

                //Prepare Packet info
                InetAddress ip = datagramPacket2.getAddress();
                int port = datagramPacket2.getPort();

                DatagramPacket datagramPacket3 = new DatagramPacket(dataToSent, dataToSent.length, ip, port);
                datagramSocket.send(datagramPacket3);

                if (forClient.equals("CLOSE"))
                    datagramSocket.close();

            } while (!forClient.equals("CLOSE"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/*
OUTPUT

From Client :: Hi

Enter message here :: Hello
From Client :: How

Enter message here :: I am fine
From Client :: Let's

Enter message here :: suer
From Client :: CLOSE

Enter message here :: CLOSE



Enter message here :: Hi
From Server :: Hello

Enter message here :: How are you
From Server :: I

Enter message here :: Let's end ?
From Server :: suer

Enter message here :: CLOSE
From Server :: CLOSE

 */