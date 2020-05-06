package hackerrank;

public class SampleDempo implements Runnable {

	public Thread t;
	private String threadName;
	
	public SampleDempo(String threadName) {
		// TODO Auto-generated constructor stub
		this.threadName = threadName;
	}
	
	public void run(){
		while(true){
			System.out.println(threadName);
		}
	}
	
	public void start(){
		if(t==null){
			t = new Thread(this,threadName);
			t.start();
		}
	}
	
	public static void main(String[] args) {
		SampleDempo A = new SampleDempo("A");
		SampleDempo B = new SampleDempo("B");
		B.start();
		A.start();
	}
		
}
