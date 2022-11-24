package Arrays_data_estructure;
import java.util.*;

public class enterNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arrayNumbers[]= new int[10];
		int lowerNumber=arrayNumbers[0];
		
		Scanner keyboard=new Scanner (System.in) ;
		

		for (int i = 0; i < arrayNumbers.length; i++) {
			
			
			System.out.println("Ingrese la posicion numero " +(i+1) +" :");
			arrayNumbers[i]=keyboard.nextInt();
			
		}
		
		System.out.println("El  ingreso inverso del array es : ");
		
		System.out.println(" ");
		
		for (int j = arrayNumbers.length-1; j>=0 ; j--) {
			
			
			
			System.out.print( arrayNumbers[j] +"  ");
			
			
		}	
		
		System.out.println("  ");
		
		for (int k = 0; k < arrayNumbers.length; k++) {
			
			if(arrayNumbers[k]>lowerNumber) {
				lowerNumber=arrayNumbers[k];
				
			}
			
		}
		
		System.out.println(" ");
		System.out.println("El numero menor es : " +lowerNumber );
		
	}

}
