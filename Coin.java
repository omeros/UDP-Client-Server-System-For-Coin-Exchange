package maman16targil2;

import java.awt.FlowLayout;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;



public class Coin extends JFrame //implements Runnable
{
	// public  JCheckBox CoinBox;
    public String[] coins;
	 JTextArea textArea1;
	 JTextArea textArea2;
	 JTextArea textArea3;
	 JTextArea textArea4;
	 JTextArea textArea5;
	 private JButton convert;
	 String first="Shekel";
	 String second="Shekel";
	 JComboBox<String>   CoinBox1 ;
	 JComboBox<String>   CoinBox2;
	 Information f;
	 double result;
	 Controller c;
	 
	 public Coin()
	 {
		 super( " change ");
		 setLayout(new FlowLayout());
		 coins= new String [5];  
		 c= new Controller();
		 
		      coins[0]="Shekel";
			  coins[1]="Dolar";
			  coins[2]="Euro";
			  coins[3]="Pound";
			  coins[4]="Hong Kong Dolla";

			  
		  
		      CoinBox1 = new JComboBox<String>(coins);
		      CoinBox2 = new JComboBox<String>(coins);

		    textArea1 = new JTextArea("From"  ,1, 1);
		    textArea1.setFont(new Font("Arial Black", Font.ITALIC, 11));
		    textArea1.setEditable(false);
		    setVisible(true);
		   
		    
		    textArea2 = new JTextArea(1, 6);
		    textArea2.setFont(new Font("Arial Black", Font.ITALIC, 15));
			textArea2.setEditable(true);
		    setVisible(true);
		    
		    textArea3 = new JTextArea("To"  ,1, 1);
		    textArea3.setFont(new Font("Arial Black", Font.ITALIC, 11));
			textArea3.setEditable(false);
		    setVisible(true);
		    
//		    textArea4 = new JTextArea("                                                          amount for conversion"  ,1, 50);
//		    textArea4.setFont(new Font("Arial Black", Font.ITALIC, 12));
//			textArea4.setEditable(false);
//		    setVisible(true);
		    
		    textArea5 = new JTextArea(1, 15);
		    textArea5.setFont(new Font("Arial Black", Font.ITALIC, 15));
			textArea5.setEditable(false);
		    setVisible(true);
		    
		    
		    convert = new  JButton ( " convert");
			 coinHandler handler = new coinHandler();
			 convert.addActionListener(handler);
			
			 DatListener handler2 = new DatListener();
			    
			    
			 CoinBox1.addItemListener(handler2);
			 CoinBox2.addItemListener(handler2);

			 
		  //  add(textArea4);    
		    add(textArea1);  
		    add(CoinBox1);
		    add(textArea2);  
		    add(textArea3);  
		    add(CoinBox2);
		    add(textArea5);
			 add(convert);

		    

	 }
	 
	 
		/************************ Handler the Convert Button ************************************************************/
		private class coinHandler implements ActionListener
	 /*********************************************************************************************************/
		{
			public void actionPerformed(ActionEvent event)
			{
				if(event.getSource()==convert)           // Press Button convert
				{
					String s= textArea2.getText();
					int amount= Integer.parseInt(s);
					 Random rand = new Random();
					 int  n = rand.nextInt(1000000);
					 f = new Information(first,second,amount,n );


//					 String t=f.toString();
//					 System.out.println(t);
					 c.finished();
				}
			}
		}
		
	

		/******************** Handler the JCombobox ***********************************************************/
		   private  class DatListener implements ItemListener
	    /*****************************************************************************************************/
		    {
		    	public void itemStateChanged (ItemEvent event)
		    	{
		
					if  ( event.getSource()== CoinBox1 )												
					{	
						if(event.getStateChange() == ItemEvent.SELECTED)
		    			{
							  first = (String)event.getItem();
		    			}
					}
					
					if  ( event.getSource()== CoinBox2 )												
					{	
						if(event.getStateChange() == ItemEvent.SELECTED)
		    			{
							  second = (String)event.getItem();
		    			}
					}
					
					
					
					
		    	}
		    }


	 /*******************************************************************************/
		public Information getF() 
		 /*******************************************************************************/
		{
			return f;
		}


		 /*******************************************************************************/
		public void setF(Information f) 
		 /*******************************************************************************/
		{
			this.f = f;
		}


		 /*******************************************************************************/
		public double getResult() 
		 /*******************************************************************************/
		{
			return result;
		}


		 /*******************************************************************************/
		public void setResult(double result)
		 /*******************************************************************************/
		{
			this.result = result;
		}

		public void setAnswer()
		{
			
			double intInstance = (double)(result);    
			Double doubleInstance = intInstance;      
			String numberAsString = doubleInstance.toString();
			textArea5.setText(numberAsString);
		}
		public Controller getController() {
			return c;
		}


		public void setController(Controller c) {
			this.c = c;
		}
}

