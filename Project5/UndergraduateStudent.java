//subclass of Student
public class UndergraduateStudent extends Student{
	//Declaration of Variables
	String major;
	
	//Constructors
	public UndergraduateStudent(){
		//defaults
	}
	public UndergraduateStudent(String n, int id, String major){
		this.name = n;
		this.IDNumber = id;
		this.major = major;
	}
	
	//Methods
	public String getMajor(){
		return major;
		//getter
	}
	public void setMajor(String major){
		this.major = major;
		//setter
	}
	
	public String toString(){
		//method that will print all of the attributes for this object
		String x = "Undergraduate Student " + super.toString() + "\nMajor: " + major;
		return x;
	}
}
