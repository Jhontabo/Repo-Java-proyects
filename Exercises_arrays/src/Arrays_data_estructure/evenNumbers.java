package Arrays_data_estructure;

public class evenNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		evenNumbers();
		
		}

		private static void evenNumbers() {
			
			int [] result=new int [30];

			for (int i= 0; i <result.length; i++) {
				
				result[i]=i ;
				
			
			}
			
			for (int j=0; j < result.length; j++) {
				
				if(result[j] % 2==0) {
					
					System.out.print(" "+result[j]);
				}
			}
			
		}
	}