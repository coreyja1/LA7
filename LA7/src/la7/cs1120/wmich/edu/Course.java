package la7.cs1120.wmich.edu;

public class Course<E> implements ICourse {
	LinkedList<E> students = new LinkedList<E>();
	int max;
	int section;
	String subject;
	
	/**
	 * Constructor
	 * 
	 * @param subject
	 * @param section
	 * @param max
	 */
	Course(String subject, int section, int max) {
		this.subject = subject;
		this.section = section;
		this.max = max;
	}
	
	@Override
	/**
	 * if course is full return false
	 */
	public boolean isFull() {
		// TODO Auto-generated method stub
		if (students.size() == max) {
			return true;
	}
		return false;
	}

	@Override
	/**
	 * add student to course if isFull == false
	 */
	public void addStudent(String name) {
		// TODO Auto-generated method stub
		if (isFull()==false) {
			students.add((E) name);
		}
	}

	@Override
	/**
	 * print the class list
	 */
	public void printClassList() {
		// TODO Auto-generated method stub
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i));
		}
	}

	public int getMax() {
		return max;
	}

	public int getSection() {
		return section;
	}


	public String getSubject() {
		return subject;
	}



}
