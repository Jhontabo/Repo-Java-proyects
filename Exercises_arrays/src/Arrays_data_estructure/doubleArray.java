package Arrays_data_estructure;

import java.util.Scanner;

public class doubleArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int array1 []=new int [5];
		int array2 []=new int [5];
		int array3 []=new int [10];
		
		System.out.println("Ingrese 5 primeros numeros :");
		
		Scanner keyboard= new Scanner (System.in);
		
		
		for (int i = 0; i < array1.length; i++) {
			
			array1[i]=keyboard.nextInt();
			
			
		}
		
		System.out.println("Ingrese los ultimos 5  numeros :");
		
		for (int i = 0; i < array2.length; i++) {
			
			array2[i]=keyboard.nextInt();
			
		}
		
		for (int i = 0; i < array1.length; i++) {
			
			array3[i]=array1[i];
			
		}
		
		for (int i = 0; i < array2.length; i++) {
			
			array3[array1.length+i]=array2[i];
		}
		
		
		System.out.println("El resultado de lo ingresado es :");
		for (int i = 0; i < array3.length; i++) {
			System.out.print(" "+array3[i]);
		}
		
	}
}


