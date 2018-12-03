package la7.cs1120.wmich.edu;

public class Request implements Comparable<Request> {
	private String studentName;
	private String studentDept;
	private String studentLevel;
	private String courseDept;
	private int courseNumber;
	private double[][] GPA_Array;
	private double gpa;
	private double grade;
	private double credits;

	/**
	 * Constructor of the Request Class
	 * 
	 * @param studentName
	 * @param studentDept
	 * @param studentLevel
	 * @param courseDept
	 * @param courseNumber
	 * @param GPA_Array
	 */
	public Request(String studentName, String studentDept, String studentLevel, String courseDept, int courseNumber,
			double[][] GPA_Array) {
		this.studentName = studentName;
		this.studentDept = studentDept;
		this.studentLevel = studentLevel;
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
		this.GPA_Array = GPA_Array;
	}

	@Override
	/**
	 * Compares two Request objects based on a certain set of priorities
	 * 
	 * @param other   The other Request object
	 */
	public int compareTo(Request other) {
		/*
		 * if the students have the same dept as the class proceed to next in priority,
		 * else return either 1 or -1 depending on who is in the dept
		 */
		if (studentDept.equals(courseDept) && (other.getStudentDept().equals(courseDept))) {
		} else if (studentDept.equals(courseDept)) {
			return 1;
		} else if (other.getStudentDept().equals(courseDept)) {
			return -1;
		}
		// if student is closer to graduation than other student
		if (yearsFromGraduation(studentLevel) < other.yearsFromGraduation(other.getStudentLevel())) {
			return 1;
		} else if (yearsFromGraduation(studentLevel) > other.yearsFromGraduation(other.getStudentLevel())) {
			return -1;
		}
		// student with the best GPA
		if (GPA_Cal(GPA_Array) > other.GPA_Cal(other.GPA_Array)) {
			return 1;
		} else if (GPA_Cal(GPA_Array) < other.GPA_Cal(other.GPA_Array)) {
			return -1;
		}
		// if everything is the same resort to original wins
		return 0;
	}

	/** Returns number of years to graduation (0 for seniors, 1 for juniors etc.).
	 This is determined from the
	 studentfs level senior, junior, etc.
	* @param level 
	*/
	public int yearsFromGraduation(String level) {
		if (level.equalsIgnoreCase("senior")) {
			return 0;
		} else if (level.equalsIgnoreCase("junior")) {
			return 1;
		} else if (level.equalsIgnoreCase("sophomore")) {
			return 2;
		} else if (level.equalsIgnoreCase("freshman")) {
			return 3;
		}
		// if it does not work properly return -1
		return -1;
	}

/**
 * calculates the gpa of the student
 * 
 * @param GPA_Array
 * @return gpa   the total gpa
 */
	private double GPA_Cal(double[][] GPA_Array) {
		for (int i = 0; i < GPA_Array.length; i++) {
			for (int j = 0; j < 2; j++) {
				credits += GPA_Array[i][0];
				grade += GPA_Array[i][0];
			}
		}
		gpa = (grade * credits) / credits;
		return gpa;
	}

	/**
	 * toString method
	 * @return result
	 */
	public String toString() {
		String result = studentName + " successfully registered  " + courseDept + " " + courseNumber;
		return result;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentDept() {
		return studentDept;
	}

	public String getStudentLevel() {
		return studentLevel;
	}

	public String getCourseDept() {
		return courseDept;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

}
