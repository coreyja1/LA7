package la7.cs1120.wmich.edu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller implements IController {
	private PriorityQueue<Request> requestQueue;
	private LinkedList courses;
	BufferedReader fileIn;
	BufferedReader fileIn1;
	String courseDept;
	String courseSection;
	int maxSize;
	
	/**
	 * constructor
	 * 
	 * @param requestQueue
	 * @param courses
	 * @param fileIn
	 * @param fileIn1
	 */
	public Controller(PriorityQueue<Request> requestQueue, LinkedList<Course> courses,
			BufferedReader fileIn, BufferedReader fileIn1) {
		this.requestQueue = requestQueue;
		this.courses = courses;
		this.fileIn = fileIn;
		this.fileIn1 = fileIn1;
		
	}

	@Override
	/**
	 *  Read courses from input file and add each course to a LinkedList of courses. Close file.
	 */
	public void readCourseFile() {
		// TODO Auto-generated method stub
		try {
			File file = new File("course.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
			String [] lines = sc.nextLine().split(",");
			courseDept = lines[0];
			courseSection = lines[1];
			maxSize = Integer.parseInt(lines[2]);
			Course c1 = new Course(lines[0], Integer.parseInt(lines[1]), Integer.parseInt(lines[2]));
			courses.add(c1);
			}
	
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("This file was not found...");
		}
	}

	@Override
	/**
	 * Read each request from the request input file and use it to create a Request object.
	 */
	public void readRequestFile() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Beginning of queue");
			double[][] gpa = new double[4][2];
			File file = new File("request.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
			int cred = 6;
			int grade = 5;
			String [] lines = sc.nextLine().split(",");
			for (int i = 0; i<gpa.length; i++) {
				gpa[i][0] = Double.parseDouble((lines[cred]));
				gpa[i][1] = Double.parseDouble(lines[grade]);
				cred = cred + 2;
				grade = grade + 2;
			}
			Request r1 = new Request(lines[0], lines[2], lines[1], lines[3], Integer.parseInt(lines[4]), gpa);
			addRequest(r1);
		}
			
			sc.close();
		}catch (FileNotFoundException e) {
			System.out.println("This file was not found...");
		}
	}
	

	@Override
	/**
	 * Store the request object in the requests priority queue.
	 */
	public void addRequest(Request req) {
		// TODO Auto-generated method stub
		requestQueue.enqueue(req);
	}

	@Override
	/**
	 * process all the requests as follows: if request can be granted, update the relevant classlist, 
	 * update the class/course capacity, print out a message that the student who made that 
	 * request has been successfully registered for that course. Else, print out a message that 
	 * student could not be registered.
	 */
	public void processRequests() {
		// TODO Auto-generated method stub
        System.out.println("End of queue");
        System.out.println();
		while (requestQueue.isEmpty() == false) {
			Request tempRequest = requestQueue.dequeue();
			if (getCourse(tempRequest.getCourseDept(), tempRequest.getCourseNumber()).isFull() == false) {
				System.out.println(tempRequest.getStudentName() + "  has been added to " + tempRequest.getCourseDept() + " " + tempRequest.getCourseNumber());
				getCourse(tempRequest.getCourseDept(), tempRequest.getCourseNumber()).addStudent(tempRequest.getStudentName());
			}
			else {
				System.out.println(tempRequest.getStudentName() + "  cannot be added to " + tempRequest.getCourseDept() + " " + tempRequest.getCourseNumber());				
			}
		}
		System.out.println();
		requestQueue.Qprint();
	}

	@Override
	/**
	 * Return the course object with data values that match the parameters received.
	 */
	public Course getCourse(String courseDept, int courseNumber) {
		// TODO Auto-generated method stub
		for (int i = 0; i<courses.size(); i++) {
			Course cDept = (Course) courses.get(i);
			String subj = cDept.getSubject();
			int section = cDept.getSection();
			if (subj.equalsIgnoreCase(courseDept) && section == courseNumber) {
				return cDept;
			}
		}
			return null;
		
	}
	

	@Override
	/**
	 * Print classlists for all courses.
	 */
	public void printClassList() {
		// TODO Auto-generated method stub
		
		System.out.println();
		Course c1 = (Course) courses.get(0);
		Course c2 = (Course) courses.get(1);
		System.out.println("Class List for CS 1040:");
		c1.printClassList();
		System.out.println();
		System.out.println("Class List for CS 1060:");
		c2.printClassList();
	}
}
