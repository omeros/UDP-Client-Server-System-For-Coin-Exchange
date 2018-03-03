package maman16targil2;



import java.io.*;

import java.net.*;
import java.util.*;

import ServerClient.ObjectForTransfer;

/*********  Server for coin exchange ( with UDP Connection ) *********************/
public class CoinServer 
/********************************************************************************/
{
    private DatagramSocket socket = null;
    private boolean moreClients = true;
    private String dString;
    private String[] coins;
    private double [] values;
    String _source;
	String _target;
	int _amount;
	int s;
	int k;
    double t;
    
    
    
    public CoinServer()
    {
    	try {
    		 socket = new DatagramSocket(4444);
    		 System.out.println("server ready ");
    	}catch(SocketException e)
    	{
    		e.printStackTrace();
    		System.exit(1);
    	}
    	
	   	  coins= new String [5];  	
	      coins[0]="Shekel";
		  coins[1]="Dolar";
		  coins[2]="Euro";
		  coins[3]="Pound";
		  coins[4]="Hong Kong Dollar";
		  
		  values= new double [5];  	
		  values[0]=3.52;
		  values[1]=1;
		  values[2]=0.82;
		  values[3]=0.72;
		  values[4]=7.82;
    }
	
    /***************************************************************************/
    public void start()
    /**************************************************************************/
    {
    	DatagramPacket packet;
    	while (moreClients)
    	{
    		try {
    			
    			byte[] buf = new byte[256];
    			
    			//            receive request
    			packet = new DatagramPacket(buf,buf.length);
    			socket.receive(packet);
    			
    			
    			ByteArrayInputStream in = new ByteArrayInputStream(buf);
    			ObjectInputStream is = new ObjectInputStream(in);
    		
    			Information fr= (Information) is.readObject();
    			
    			System.out.println("details from object  : " + fr.toString());
				
    			
    			
    			
    			_source=(String)fr.get_source();
    			_target=fr.get_target();
    			_amount=fr.get_amount();
    			

    			
    			int i;
    			for (i=0;i<5;i++)
    			{
    				if (coins[i].contentEquals(_source))
    				{
    					s=i;
    				}
    			}
    			
    			int j;
    			for (j=0;j<5;j++)
    			{
    				if (coins[j].contentEquals(_target))
    				{
    					k=j;
    				}
    			}
    			
    			
    			double temp;
    			temp=((double)1/ (double)values[s]) ;
    			t = temp *  (double)values[k];
    			int amount = fr.get_amount();
    			t = t*amount;
    			
    			System.out.println(t);
    			
    			int ver= fr.get_verification();
    			ReturnAnswer ans = new ReturnAnswer(t,ver);
    			
    			//              send the response to "address" and "port:
    			InetAddress address = packet.getAddress();
    			int port = packet.getPort();
    			
    			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    			ObjectOutputStream os = new ObjectOutputStream(outputStream);
    			os.writeObject(ans);
    			

    			
    			 buf =  outputStream.toByteArray();
    			packet = new DatagramPacket(buf,buf.length, address, port);

     			socket.send(packet);
     			System.out.println("Message sent from server");
    			
    		}catch(IOException e) {
    			e.printStackTrace();
    			moreClients = false;
    			

    			
    			
    			
    		} catch (ClassNotFoundException e) {

    			e.printStackTrace();
			}
    	}
    	socket.close();
    }
	
    
    public static void main(String[] args)
    {

		CoinServer server = new CoinServer();
    	server.start();
    }
	
}
