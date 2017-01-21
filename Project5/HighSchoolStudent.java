//subclass of Student
public class HighSchoolStudent extends Student{
	//Declaration of Variables
	String nameOfSchool;
	
	//Constructors
	public HighSchoolStudent(){
		//defaults
	}
	
	public HighSchoolStudent(String n, int id, String schoolName){
		this.name = n;
		this.IDNumber = id;
		this.nameOfSchool = schoolName;
	}
	
	//Methods
	public String getNameOfSchool(){
		return nameOfSchool;
		//getter
	}
	public void setNameOfSchool(String schoolName){
		this.nameOfSchool = schoolName;
		//setter
	}
	
	public String toString(){
		//method that will print all of the attributes for this object
		String x = "High School Student " + super.toString() + "\nName of School: " + nameOfSchool;
		return x;
	}
}
