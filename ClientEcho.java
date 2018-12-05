import java.io.*; 
import java.net.*;


public class ClientEcho 
{ 
  final static int taille = 1024; 
  final static byte buffer[] = new byte[taille];

  public static void main(String argv[]) throws Exception 
    { 
      InetAddress serveur = InetAddress.getByName(argv[0]); 
      int length = argv[1].length(); 
      byte buffer[] = argv[1].getBytes(); 
      DatagramPacket dataSent = new DatagramPacket(buffer,length,serveur,ServeurEcho.port); 
      DatagramSocket socket = new DatagramSocket(); 
  
      socket.send(dataSent); 

      DatagramPacket dataRecieved = new DatagramPacket(new byte[length],length); 
      socket.receive(dataRecieved); 
      System.out.println("Data recieved : " + new String(dataRecieved.getData())); 
      System.out.println("From : " + dataRecieved.getAddress() + ":" + dataRecieved.getPort()); 
    } 
}
