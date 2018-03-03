package maman16targil2;

import java.io.Serializable;

public class Controller  implements Serializable
{
	/*********** Constructor ****************************/
	public Controller()
	/*****************************************/
	{
		
	}
	
	/************ Waking up ! **********************************/
	public synchronized void finished()
	/*******************************************/
	{
		notifyAll();
	}
	/******************** Waiting for Thread to finish his Job**********/
	public synchronized void waitForThread()   
	/*****************************************************************/
	{
		try {
   			wait();
   		}catch (InterruptedException e) {
   			System.out.println( "interrupted while waiting");
   		}
	}
}
