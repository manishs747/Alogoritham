package designpattern.structural_pattern.composition_pattern;

public class Cashier implements Employee {

	private int id;
	private String name;
	private double salary;

	public Cashier(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	 @Override  
     public void add(Employee employee) {  
         //this is leaf node so this method is not applicable to this class.  
     } 
	 
     @Override  
     public Employee getChild(int i) {  
         //this is leaf node so this method is not applicable to this class.  
         return null;  
     } 
     
     @Override  
     public int getId() {  
         // TODO Auto-generated method stub  
         return id;  
     }  
     
     @Override  
     public String getName() {  
         return name;  
     } 
     
     @Override  
     public double getSalary() {  
         return salary;  
     }  
     
     @Override  
     public void print() {  
         System.out.println("==========================");  
         System.out.println("Id ="+getId());  
         System.out.println("Name ="+getName());  
         System.out.println("Salary ="+getSalary());  
         System.out.println("==========================");  
     } 
     
     @Override  
     public void remove(Employee employee) {  
         //this is leaf node so this method is not applicable to this class.  
     }  
}
