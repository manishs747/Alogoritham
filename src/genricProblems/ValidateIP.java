package genricProblems;

public class ValidateIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      //System.out.println(isValidIp("128.0.0.1"));
     // System.out.println(isValidIp("125.16.100.1"));
     System.out.println(isValidIp("125.512.100.1"));
    // System.out.println(isValidIp("125.512.100.abc"));
	}
	
	
	public static Boolean isValidIp(String ip){
	    
		 String[] indexArr = ip.split("\\.");
		// System.out.println(indexArr.length);
		 if(indexArr.length!=4){return false;}
		 for (String str : indexArr) {
			 try  
			  {  
				int num = Integer.parseInt(str);  
				if(num < 0 || num > 255){
					return false;
				}
			  }  
			  catch(NumberFormatException nfe)  
			  {  
			    return false;  
			  }  
		}
		
		
		return true;
	}

}
