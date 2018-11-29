package la7.cs1120.wmich.edu;

public class Request<T> implements Comparable<T> {
	private String studentName;
	private String studentDept;
	private String studentLevel;
	private String courseDept;
	private int courseNumber;
	private double[][] GPA_Array;
	private double gpa;
	private double grade;
	private double credits; 
	
	// Constructor
	public Request(String studentName, String studentDept, String studentLevel,
				String courseDept, int courseNumber, double[][] GPA_Array) {
		this.studentName = studentName;
		this.studentDept = studentDept;
		this.studentLevel = studentLevel;
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
		this.GPA_Array = GPA_Array;
	}
	
	@Override
	//need to write method for
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// Returns number of years to graduation (0 for seniors, 1 for juniors etc.). This is determined from the 
	// studentÅfs level senior, junior, etc.
	public int yearsFromGraduation(String level) {
		if (studentLevel.equalsIgnoreCase("senior")) {
			return 0;
		}
		else if (studentLevel.equalsIgnoreCase("junior")) {
			return 1; 
		}
		else if (studentLevel.equalsIgnoreCase("sophomore")) {
			return 2;
		}
		else if (studentLevel.equalsIgnoreCase("freshman")) {
			return 3;
		}
		//if it does not work properly return -1
		return -1;
	}

	// Calculate the GPA for a particular student.
	//might work, depends on what we pass for the GPA_Array
	private double GPA_Cal(double[][] GPA_Array) {
		for (int i=0; i<GPA_Array.length; i++) {
			for (int j=0; j<2; j++) {
				credits += GPA_Array[i][0];
				grade += GPA_Array[i][1];
			}
		}
		gpa = (grade*credits)/credits;
		return gpa;
	}
	
	public String toString() {
		return "";
		
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentDept() {
		return studentDept;
	}

	public String getCourseDept() {
		return courseDept;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

}
