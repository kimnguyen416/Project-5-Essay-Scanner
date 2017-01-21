//This is the superclass/parent class
public class Student {
	//Declaration of variables
	String name;
	int IDNumber;
	
	//Constructors
	public Student(){
		//defaults
	}
	
	public Student(String n, int id){
		this.name = n;
		this.IDNumber = id;
	}
	
	//Methods
	public String getName(){
		return name;
		//getter
	}
	public void setName(String n){
		this.name = n;
		//setter
	}
	
	public int getIDNumber(){
		return IDNumber;
		//getter
	}
	public void setIDNumber(int id){
		this.IDNumber = id;
	}
	
	public String toString(){
		//prints all of the attributes for this object
		String x = name + "\nStudent ID: " + IDNumber; 
		return x;
	}
}
