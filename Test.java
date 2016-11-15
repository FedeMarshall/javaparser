
public class Main {

	public static void main(String[] args) {
		
		// crear array
		int[] arr = {10, 15, 35, 100};
		
		// prueba switch
		int i = 3;
		String res = "";
		switch(i){
			case 1: 
				res = "1";
				break;
			case 2:
				res = "2";
				break;
			case 3:
				res = "3";
				break;
		}
		
		double number;
		
		int a, b;
		double d = 1.5;
		a = 2;
		b = 4;
		
		int h = (int) d;
		
		// prueba try
		try{
			number = (a + b) / d;			
		} catch (ArithmeticException e){
			e.printStackTrace();
			throw new ArithmeticException();
		}		
		
		// prueba while
		while (number < 10){
			if (number % 10 == 0)
				break;
			number++;
		}
		
		int j, t, n;
		n = 3;
    	if (n < 2) return;
    	for (int numArr: arr){
    		for (j = i+1; j < n; j++){
    			if (arr[i] > arr[j]){
    				t = arr[i];
    				arr[i] = arr[j];
    				arr[j] = t;
    			}
    			else{
    				
    			}
    		}
    	}
	}

}
