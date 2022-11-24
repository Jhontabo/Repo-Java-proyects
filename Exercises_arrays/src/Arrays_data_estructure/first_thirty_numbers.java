package Arrays_data_estructure;

import java.util.Iterator;

public class first_thirty_numbers {
	
	private  final static int length=30;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		numberDown();
		
		
		
	}
	
	public static void numberDown(){
		
		int [] arrayNumbers = new int [length];
		
		for (int i = 0; i < arrayNumbers.length; i++) {
			
			arrayNumbers[i]=i+1;
		//System.out.println(arrayNumbers[i]);
		}
		
		for (int j = arrayNumbers.length-1; j >=0; j--) {
			
			
			System.out.print("   "+ arrayNumbers[j]);
		}
		
		
	}
	
}


