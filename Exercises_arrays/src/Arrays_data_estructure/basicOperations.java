package Arrays_data_estructure;

import java.util.Scanner;

public class basicOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arrayNumbers[]= new int[10];
		Scanner keyboard=new Scanner (System.in) ;
		
		int sum=0;
		int subtract=0;
		int multiplication=1;
		int division=1;
		

		for (int i = 0; i < arrayNumbers.length; i++) {
			
			
			System.out.println("Ingrese la posicion numero " +(i+1) +" :");
			arrayNumbers[i]=keyboard.nextInt();
			
		}
		
		System.out.println("operaciones basicas : ");
		
	
		
		for (int j = 0; j<arrayNumbers.length ; j++) {
			
			sum=sum+arrayNumbers[j];
			subtract=subtract-arrayNumbers[j];
			multiplication=multiplication*arrayNumbers[j];
			division=division/arrayNumbers[j];
			
		}	
		
	
		System.out.println("El resultado de la suma es : " + sum );
		System.out.println("El resultado de la resta es : " + subtract);
		System.out.println("El resultado de la multiplicacion  es :"+ multiplication);
		System.out.println("El resultado de la division es :" + division);
		
		
		
	
	}
}
