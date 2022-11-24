package Arrays_data_estructure;

import java.util.Scanner;

public class inverseNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arrayNumbers []= new int [10];
		
		Scanner keyboard=new Scanner(System.in);
		
		
		for (int i = 0; i < arrayNumbers.length; i++) {
			
			System.out.println("Ingrese el numero de la posicion "+ (i+1)+" :");
			
			arrayNumbers[i]=keyboard.nextInt();
		}
		
		System.out.println(" ");
		System.out.println("El orden inverso al ingresado es :");
		for (int i = arrayNumbers.length-1; i >=0 ; i--) {
			
			System.out.println(arrayNumbers[i]);
		}
	}
}
