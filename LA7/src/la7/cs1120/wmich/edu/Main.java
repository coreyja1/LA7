package la7.cs1120.wmich.edu;

import java.io.IOException;

public class Main {

	public static void main(String[] args)throws IOException {
		//test code, will need to be removed before submission

		double [][] gpa2 = new double[3][1];
		for (int i=0; i<gpa2.length; i++) {
			gpa2[i][0] = 7;
		}
		
		PriorityQueue<Request> requestQueue = new PriorityQueue<Request>();
		Request R1 = new Request("Tom", "CS", "freshman", "CS", 1120, gpa2);
		Request R2 = new Request("Bill", "CS", "Senior", "CS", 1120, gpa2);
		Request R3 = new Request("Bob", "ECE", "Junior", "CS", 1120, gpa2);
		

		System.out.println(R1.compareTo(R2));
		
		requestQueue.enqueue(R1);
		requestQueue.enqueue(R2);
		requestQueue.enqueue(R3);
		requestQueue.Qprint();
		System.out.println();
		requestQueue.dequeue();
		requestQueue.Qprint();
		
		
		
		/*PriorityQueue<Request> requestQueue = new PriorityQueue<Request>();
	    LinkedList<Course> courses = new LinkedList<Course>();
		BufferedReader fileIn = new BufferedReader(new FileReader("course.txt"));
		BufferedReader fileIn1 = new BufferedReader(new FileReader("request.txt"));
		IController control = new Controller(requestQueue, courses, fileIn, fileIn1);
		control.readCourseFile();
		control.readRequestFile();
		control.processRequests();
		control.printClassList(); {
		*/
		// TODO Auto-generated method stub

	}


}

