
public class InsertionSort {
	
	public static void main(String args[ ]) {
		
		int[] vet = {9,8,7,5,4,6,1,2,3,0};
		
		insertionSort(vet);
		
		 System.out.println("=====> Insertion Sort <======="); 
		
		for (int i = 0; i < vet.length; i++) {
			
			 System.out.println(vet[i]); 
				
		}
		 System.out.println("=============================="); 
	}

	
	public static int[] insertionSort(int[] array)   
    {  
          for (int i = 1; i < array.length; i++) {
        	  
        	  int a = array[i];
        	  int j;
        	  for ( j = i-1; j >= 0 && array[j] > a ; j--) 
        	  {
				  array[j + 1] = array[j];
        		  array[j] = a;
			}
        	  
			
		}
           
           return array;
           
   } 
	
}
