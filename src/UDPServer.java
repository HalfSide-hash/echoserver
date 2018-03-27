import java.io.*;
import java.net.*;

class UDPServer
{
   public static void main(String args[]) throws Exception
      {
		   DatagramSocket serverSocket = new DatagramSocket(9880);
		   String sentence;
			do{
				byte[] receiveData = new byte[1024];
	            byte[] sendData = new byte[1024];
	                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	                  serverSocket.receive(receivePacket);
	                  sentence = new String( receivePacket.getData());
	                  System.out.println("Received: " + sentence);
	                  InetAddress IPAddress = receivePacket.getAddress();
	                  int port = receivePacket.getPort();
	                  String capitalizedSentence = sentence.toUpperCase();
	                  sendData = capitalizedSentence.getBytes();
	                  DatagramPacket sendPacket =
	                  new DatagramPacket(sendData, sendData.length, IPAddress, port);
	                  serverSocket.send(sendPacket); 
			}while( !sentence.trim().equals("END"));
	   
         
	   }
	   
}