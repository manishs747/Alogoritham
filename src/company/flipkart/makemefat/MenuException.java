package company.flipkart.makemefat;

public class MenuException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	public MenuException(String string) {
		this.message = string; 
	}
	@Override 
	public String getMessage(){
		return message; 
	}

}


