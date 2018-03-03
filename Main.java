package maman16targil2;

public class Main {

	public static void main(String[] args)
	{

		int x=2;
		int y=3;
		
		
		double z= (double)y/(double)x;
		
		
		System.out.println(z);
		
		
		String _source="Dolar";
		String[] coins= new String [5];  	
	      coins[0]="Shekel";
		  coins[1]="Dolar";
		  coins[2]="Euro";
		  coins[3]="Pound";
		  coins[4]="Hong Kong Dollar";
		  
			if (coins[1].contentEquals(_source))
			{
				System.out.println("yes");
			}
			else
			{
				System.out.println("no");
			}
		  
		  
		
	}

}
