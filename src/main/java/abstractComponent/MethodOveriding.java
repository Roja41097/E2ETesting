package abstractComponent;

public class MethodOveriding extends Anotherclass {

	public static void main(String[] args) {
	/*	int k=1;
      for (int i = 1; i < 5; i++) {
    	  for(int j=0;j<i;j++) {
    		  System.out.print(k+"  ");
    		  k++;
    	  }
		System.out.print("\n");
	}*/
		 for (int i = 1; i < 5; i++) {
	    	  for(int j=1;j<i+1;j++) {
	    		  System.out.print(j+"  ");
	    		 // k++;
	    	  }
			System.out.print("\n");
		 }
	}
}
