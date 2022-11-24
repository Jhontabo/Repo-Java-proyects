package Arrays_data_estructure;

import java.util.Scanner;

public class arrayMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int array1[]= new int [5];
		int array2[]= new int [5];
		int multiplication=1;
		
		Scanner keyboard = new Scanner(System.in);
		
		
		for (int i = 0; i < array1.length; i++) {
			
			System.out.println("ingrese el numero de la posicion "+(i+1)+" :");	
			
			array1[i]= keyboard.nextInt();
			
		}
		
		System.out.println("El resultado de la multiplicacion es :");
		for (int i = 0; i < array1.length; i++) {
			array2[i]=1*array1[i];
			multiplication=multiplication*array2[i];
			
		}
		
		System.out.println(multiplication);
	}

}
