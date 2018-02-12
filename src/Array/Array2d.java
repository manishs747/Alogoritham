package Array;

public class Array2d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//getState();
		
		
		int a[][] = {
				{1,  2,  3,  4},
				{12,  13, 14,  5},
				{ 11,  16, 15, 6},
				{10, 9, 8, 7}
		};

		//normalPrint(4, 4, a);
			 
	        spiralPrint(4, 4, a);
			
			
		}
	
	
	public static void spiralPrint(int R,int C,int a[][]){
		 int i, k = 0, l = 0;
		 
		    /*  k - starting row index
		        R - ending row index
		        l - starting column index
		        C - ending column index
		        i - iterator
		    */
	while(k<R&& l<C){
		for ( i=l ;i<C ;i++ ) {
			System.out.print(a[k][i]+" ");
		}
		k=k+1;
		
		for(i=k;i<R;i++){
			System.out.print(a[i][C-1]+" ");
		}
		C--;
		
		for(i=C-1;i>=l;i--){
			System.out.print(a[R-1][i]+" ");
		}
	    R--;
	    
	    for(i=R-1;i>=k;i--){
			System.out.print(a[i][l]+" ");
		}
	    l++;
		
	}
		
	}
	
	
	public static void normalPrint(int R,int C,int a[][]){
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println("");
		}
	}

	public static void getState() {
		String[][] place = { {"Bihar", "Patna"}, {"Karnataka", "Banglore"}, {"Jharkhand", "Rachi"} };


		/*for (int i = 0; i < place.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < place[i].length; j++) {
				if(j==0){
					sb.append("THE Capital of ");
				}else{
					sb.append(" is ");
				}
				
				sb.append(place[i][j]);
			}*/
		
		for (String[] state : place) {
			StringBuilder sb = new StringBuilder();
			for (String capital : state) {
				sb.append(" "+capital);
			}
			System.out.println(sb);
		}
	}

	}

