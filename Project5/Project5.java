//Name: Kim Nguyen
//80813737
//Section#:9504
//TA: Val
//Project Number: 5
//Brief Description of File Contents:Auto-grader for Spelling
import java.util.*;
import java.io.*;
public class Project5 {
	public static void main(String[] args){
	//Creates Scanner object
	Scanner input = new Scanner(System.in);
	
	//Declaration of variables
	String fileName = null;
	String studentID = "";
	int spellErrors = 0;//counter for words that were spelled wrong
	boolean x = true;
	boolean y = true;
	ArrayList<String> dictionary = new ArrayList<String>();
	
	while(x){
		//Part 1
		System.out.println("Please specify the name of the file that contains the"
		+ " dictionary information.");
		System.out.println();
		fileName = input.next();
		System.out.println();
		
		//looking for file that contains the dictionary information
		try{
			File file = new File(fileName + ".txt");
			Scanner sc = new Scanner(file);
			while(sc.hasNext()){
			dictionary.add(sc.next());
			}
			
			System.out.println("File opened successfully!");
			System.out.println();
			sc.close();
			x = false;
		} 
		catch(Exception ex){
			System.out.println("File " + fileName + " cannot be found!");
			System.out.println();
			continue;
		}
	}//closes first loop
		
		//Part 2
		while(y){
		System.out.println("Please specify the ID of the student whose essay "
		+ "will be graded.");
		System.out.println();
		studentID = input.next();
		System.out.println();
		
		if (studentID.equalsIgnoreCase("Finished")){
			y = false;
			System.exit(0);
		}
		//Looks for student file
		try{
			File files = new File(studentID + ".txt");
			Scanner i = new Scanner(files);
			String typeS;//type of student
			String name;//student name
			String major;//student major if they have one
			String advisor;//if they have one
			String highS;//high school name
			int id;//student id
			String studentEssay = "";
			
			typeS = i.nextLine();
			//specifically for high school student
			if (typeS.equalsIgnoreCase("HighSchool Student")){
				//reading different parts of the file, deducts -1
				name = i.nextLine();
				studentID = i.nextLine();
				int k = Integer.parseInt(studentID);
				highS = i.nextLine();
				HighSchoolStudent hs = new HighSchoolStudent(name, k, highS);
				while(i.hasNext()){
				studentEssay += i.next() + " ";
				}
				//gets rid of the punctuation and spaces
				studentEssay = studentEssay.replaceAll("[^a-zA-Z0-9']", " ");

				String[] revisedE = studentEssay.split("\\s+");
				
				
				//look for misspelled words
				PrintWriter overwrite = null;
				ArrayList<String> misspelled = new ArrayList<>();
				spellErrors = 0;
				for (int z = 0, j = 0; z < revisedE.length; z++){
					if (dictionary.contains(revisedE[z].toLowerCase())){
			
					}
					else if(!dictionary.contains(revisedE[z].toLowerCase()) && !misspelled.contains(revisedE[z].toLowerCase())){
						misspelled.add(revisedE[z]);
						spellErrors++;
					}
				}
				
				overwrite = new PrintWriter(studentID + "_graded.txt");
				overwrite.println(hs.toString());
				overwrite.println("Received a score of " + (100 - (spellErrors*1)) + " with " + spellErrors + " misspelled words:");
				int v = 1;
				for (int h = 0; h < misspelled.size(); h++){
					overwrite.println("(" + v + ")" + misspelled.get(h).toString());
					v++;
				}
				
				System.out.println("File opened successfully!");
				System.out.println();
				overwrite.close();
						
			}
			//for undergraduate student file
			else if(typeS.equalsIgnoreCase("Undergraduate Student")){
				//reading different parts of the file, deducts -3
				name = i.nextLine();
				studentID = i.nextLine();
				int k = Integer.parseInt(studentID);
				major = i.nextLine();
				UndergraduateStudent us = new UndergraduateStudent(name, k, major);
				while(i.hasNext()){
				studentEssay += i.next() + " ";
				}
				
				//gets rid of the punctuation and spaces
				studentEssay = studentEssay.replaceAll("[^a-zA-Z0-9']", " ");

				String[] revisedE = studentEssay.split("\\s+");
				
				//look for misspelled words
				PrintWriter overwrite = null;
				ArrayList<String> misspelled = new ArrayList<>();
				spellErrors = 0;
				for (int z = 0; z < revisedE.length; z++){
					if (dictionary.contains(revisedE[z].toLowerCase())){
						
					}
					else if(!dictionary.contains(revisedE[z].toLowerCase()) && !misspelled.contains(revisedE[z].toLowerCase())){
						misspelled.add(revisedE[z]);
						spellErrors++;
					}
				}
				overwrite = new PrintWriter(studentID + "_graded.txt");
				overwrite.println(us.toString());
				overwrite.println("Received a score of " + (100 - (spellErrors*3)) + " with " + spellErrors + " misspelled words:");
				int v = 1;
				for (int h = 0; h < misspelled.size(); h++){
					overwrite.println("(" + v + ")" + misspelled.get(h).toString());
					v++;
				}
				
				System.out.println("File opened successfully!");
				System.out.println();
				overwrite.close();
				
			}
			//for graduate student files
			else if(typeS.equalsIgnoreCase("Graduate Student")){
				//reading different parts of the file, deducts -5
				name = i.nextLine();
				studentID = i.nextLine();
				int k = Integer.parseInt(studentID);
				major = i.nextLine();
				advisor = i.nextLine();
				GraduateStudent gs = new GraduateStudent(name, k, major, advisor);
				while(i.hasNext()){
				studentEssay += i.next() + " ";
				}
				
				//gets rid of the punctuation and spaces
				studentEssay = studentEssay.replaceAll("[^a-zA-Z0-9']", " ");

				String[] revisedE = studentEssay.split("\\s+");
				

				//look for misspelled words
				PrintWriter overwrite = null;
				ArrayList<String> misspelled = new ArrayList<>();
				spellErrors = 0;
				for (int z = 0; z < revisedE.length; z++){
					if (dictionary.contains(revisedE[z].toLowerCase())){
						
					}
					else if(!dictionary.contains(revisedE[z].toLowerCase()) && !misspelled.contains(revisedE[z].toLowerCase())){
						misspelled.add(revisedE[z]);
						spellErrors++;
					}
				}
				overwrite = new PrintWriter(studentID + "_graded.txt");
				overwrite.println(gs.toString());
				overwrite.println("Received a score of " + (100 - (spellErrors*5)) + " with " + spellErrors + " misspelled words:");
				int v = 1;
				for (int h = 0; h < misspelled.size(); h++){
					overwrite.println("(" + v + ")" + misspelled.get(h).toString());
					v++;
				}
				
				System.out.println("File opened successfully!");
				System.out.println();
				overwrite.close();
						
			}
		}
		catch(FileNotFoundException ex){
			System.out.println("File " + studentID + " cannot be found!");
			System.out.println();
		}
		
	
		}//closes second loop
	}//main method	
}//closes main class