package edu.monmouth.lab1;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Lab1Fall2026 {
	public static void main(String[] args) {
		final int EXPECTED_ARGS = 1;  // number of cmd args required
		final int SIZE = 5;		// size of first array
		final int UPPER_AGE = 20;	// limit for age
		final int THREE_SIZE = 3;	// size of array to hold 3 students

		// validate there is 1 and only 1 cmd arg-terminate if not
		if(args.length != 1) {
			System.err.println("Give the name of a log file");
			System.exit(1);
		}
		// redirect stderr & stdout to args[0]
		try {
			PrintStream redirectStream = new PrintStream(args[0]);
			System.setOut(redirectStream);
			System.setErr(redirectStream);
		} catch(FileNotFoundException ioe) {
			System.err.println("Cannot redirect stderr and stdout " + ioe.getMessage());
			ioe.printStackTrace();
			System.exit(2);
		}

		Student student1 = new Student(100,18,"John"); 
		Student student2 = new Student(101,18,"Jane");
		Student student3 = new Student(102,20,"Larry");
		Student student4 = new Student(103,20,"Karen");
		Student student5 = new Student(104,21,"Karl");
		
		// declare an array of references to Student objects (use SIZE)
		// fill array with Student objects declared above
		Student students[] = new Student[SIZE];
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		students[3] = student4;
		students[4] = student5;
		

		// print number of elements in students array
		System.out.println("Number of elements: " + students.length);
		
		// iterate through students array-print each object
		for(Student stu : students) {
			System.out.println(stu);
		}
		
		System.out.println();
		
		// iterate through students array-print only those with age < UPPER_AGE
		for(Student stu : students) {
			if (stu.getAge() < UPPER_AGE) {
				System.out.println(stu);
			}
		}
		
		System.out.println();
		
		Student studentsToAdd[]= { new Student(200, 22, "Rolf"),
				new Student(201, 23, "Dan")};
		
		// invoke addStudents to add studentsToAdd to the existing array
		Student newStudentArray[]; 
		newStudentArray = addStudents(students, studentsToAdd);

		// iterate through newStudentsArray array-print each object
		for(Student stu : newStudentArray) {
			System.out.println(stu);
		}
	}
	
	public static Student[] addStudents(Student[] students, Student[] studentsToAdd) {
		Student[] newStudentArr = new Student[students.length + studentsToAdd.length];
		
		int count = 0;;
		for(int i = 0; i < students.length; i++) {
			newStudentArr[i] = students[i];
			count++;
		}
		
		for(int i = 0; i < studentsToAdd.length; i++) {
			newStudentArr[count] = studentsToAdd[i];
			count++;
		}
		
		return newStudentArr;
	}
}
