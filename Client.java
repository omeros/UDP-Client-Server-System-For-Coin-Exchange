package maman16targil2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;



public class Client 
{

	public static void main(String[] args)
	{
		int sentVer;
		Coin coin = new Coin();     
		coin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		coin.setSize(700, 200); 
		coin.setVisible(true); 
		
		
		Controller c = coin.getController();
		c.waitForThread();
		Information f=coin.getF();
		sentVer= f.get_verification();
		 String t=f.toString();
		 System.out.println(t);
		

		String host = "localhost";
		if(args.length>0)
		{
			host=args[0];
		}
		
		try {
			DatagramSocket socket = new DatagramSocket();
			
			
			//           sending the message
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(outputStream);
			os.writeObject(f);
			
			byte[] buf =  outputStream.toByteArray();
			InetAddress address = InetAddress.getByName(host);
			DatagramPacket packet = new DatagramPacket(buf, buf.length, address,4444);
			socket.send(packet);
			
			Thread.sleep(5000);
			
			
			//           getting the answer
			byte[] buf2 = new byte[256];
			DatagramPacket incomingPacket = new DatagramPacket(buf2, buf2.length);
			socket.receive(incomingPacket); 
			byte[] data = incomingPacket.getData();
			ByteArrayInputStream in = new ByteArrayInputStream(data);
			ObjectInputStream is = new ObjectInputStream(in);
		
			ReturnAnswer ans= (ReturnAnswer) is.readObject();
			
			int BackVer= ans.get_verificationl();
			if ( BackVer==sentVer)
			{
					double fr= ans.get_answer();
					System.out.print(" the result is : " + fr);
					coin.setResult(fr);
					coin.setAnswer();
			}
			else {
				System.out.print(" there is a problem with the server  ");
			}
			
		}catch(SocketException e) { e.printStackTrace();
		}catch(UnknownHostException e) { e.printStackTrace();
	    }catch(IOException e) {
	    	e.printStackTrace ();
	    } catch (ClassNotFoundException e) {

	    	e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		
	}

}
