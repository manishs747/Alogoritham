package designpattern.structural_pattern.adapter_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BankCustomer extends BankDetails implements CreditCard {

	@Override
	public void giveBankDetails() {
		
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter the account holder name :");  
			String customername=br.readLine();  
			System.out.print("\n"); 
			System.out.print("Enter the account number:");  
			long accno=Long.parseLong(br.readLine());  
			System.out.print("\n"); 
			System.out.print("Enter the bank name :");  
			String bankname=br.readLine(); 
			setAccHolderName(customername);  
			setAccNumber(accno);  
			setBankName(bankname);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public String getCreditCard() {
		long accno=getAccNumber();  
		   String accholdername=getAccHolderName();  
		   String bname=getBankName();  
		          
		   return ("The Account number "+accno+" of "+accholdername+" in "+bname+  
		                    "bank is valid and authenticated for issuing the credit card. "); 
	}
	
	
	

}
