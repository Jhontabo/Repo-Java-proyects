package Arrays_data_estructure;

public class primeNumbers {

	public static void main(String[] args) {
		
		primeNumbers();
		
	}

	private static void primeNumbers() {
		
		int [] result=new int [30];
		int count=0;
		
		
		for (int i= 0; i <result.length; i++) {
			
			result[i]=i ;
			
			count=0;
			
			for (int j=1; j < result.length; j++) {
				
				if(result[i] % j==0) {
					
					count++;
					
				}
			}
			
			
			if(count==2) {
				
				System.out.print("  "+result[i]);
			}
			
			
			System.out.print("");
		}
	}
}