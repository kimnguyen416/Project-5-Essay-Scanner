//subclass of Student
public class GraduateStudent extends Student{
	//Declaration of variables
	String major;
	String advisor;
	
	//Constructors
	public GraduateStudent(){
		//defaults
	}
	public GraduateStudent(String n, int id, String major, String advisor){
		this.name = n;
		this.IDNumber = id;
		this.major = major;
		this.advisor = advisor;
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
	
	public String getAdvisor(){
		return advisor;
		//getter
	}
	public void setAdvisor(String advisor){
		this.advisor = advisor;
		//setter
	}
	
	public String toString(){
		//a method that will print all of the attributes for this object
		String x = "Graduate Student " + super.toString() + "\nMajor: " + major + "\nAdvisor: " + advisor;
		return x;
	}
}
