package eight;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOfList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<PaymentGroup> items = new ArrayList<>();
	
		ArrayList<String> walletlist = new ArrayList<String>();
		walletlist.addAll(Arrays.asList("paytm","mobikwick","freecharge"));
		
		ArrayList<String> banklist = new ArrayList<String>();
		banklist.addAll(Arrays.asList("axis","sbi","hdfc"));
		
		ArrayList<String> codlist = new ArrayList<String>();
		codlist.addAll(Arrays.asList("cod","cod2"));
		
		items.add(new PaymentGroup("wallet",walletlist));
		items.add(new PaymentGroup("cod",codlist));
		items.add(new PaymentGroup("banklist",banklist));
		
		/* PaymentGroup PG = items.stream().
		.filter(pg->pg.name.equals("cod"))
		.findAny()									// If 'findAny' then return found
	    .orElse(null);;
		
	    PG.methods.stream().filter(pm->pm.contains("cod"));  */
		
		 // PaymentGroup test = items.stream().filter(x -> x.name.equals("cod")).findAny().orElse(null);	
		          
	     // String method = test.methods.stream().filter(y->y.equals("cod2")).findAny().orElse(null);
		
	/*	PaymentGroup test = items.stream().filter(x -> x.name.equals("cod")).findFirst().filter(y->y.);	
        
	      String method = test.methods.stream().filter(y->y.equals("cod2")).findAny().orElse(null);
	      System.out.println(method);  */
	      
	      
	      
	   /*   
	      private void setAssuredCodTextOld(PaymentResponse paymentResponse, String assuredCodtext) {
	          for (PaymentGroup group : paymentResponse.getPaymentGroupList()) {
	              if(group.getGroupName().equalsIgnoreCase(COD)){
	                  for (PaymentMethod method : group.getPaymentMethodList()) {

	                      if( method.getName().equalsIgnoreCase(COD)){
	                          if(method.getMeta()!= null){
	                              method.getMeta().put(COD_ASSURED_KEY,assuredCodtext);
	                          }else{
	                              Map<String, Object> meta = new HashedMap();
	                              meta.put(COD_ASSURED_KEY,assuredCodtext);
	                              method.setMeta(meta);
	                          }

	                      }
	                      break;
	                  }
	                  break;
	              }
	          }
	      }  */

}
				
				

	

}
