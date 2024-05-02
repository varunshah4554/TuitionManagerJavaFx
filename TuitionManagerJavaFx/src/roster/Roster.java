package roster;

/**
 * 
 * @author Varun Shah
 *
 */
/**
 *  Manages the growable array list data structure with an initial capacity of 4, and automatically grows
(increases) the capacity by 4 whenever it is full. The array list does not decrease in capacity.
 *
 */

public class Roster {
	static int initialCapacity = 4;
	int increaseCapacity = 4;
	private Student[] roster;
	private int size = initialCapacity; // keep track of the number of students in the roster
	static String[] rosterArray = new String[initialCapacity];

	private int find(Student student) {

		for (int i = 0; i < size; i++) {
			if (student.equals(roster[i])) {
				return i;
			}
		}
		return -1;
	}

	private void grow() {
		size = size + increaseCapacity;
		Student[] roster2 = new Student[size];

		for (int i = 0; i < roster.length; i++) { // fills new array
			roster2[i] = roster[i];
		}

		roster = roster2;

	}

	public boolean add(Student student) {

		// Checking profile

		if (student == null) {
			return false;
		}

		// checks is added student is duplicate
		if (find(student) != -1) {
			return false;
		}

		// add the employee and if array is full calls grow()
		for (int i = 0; i < roster.length; i++) {
			if (roster[i] == null) {
				roster[i] = student;
				size++;
				return true;
			}

			if (i == roster.length) {
				grow();
				roster[i + 1] = student;
			}

		}

		return false;
	}

	public boolean remove(Student student) {

		// student not in roster
		int find = find(student);
		if (find == -1) {
			return false;
		}

		roster[find] = null;

		//removes empty NULL spaces
		int prev=find;
		int curr=find+1;
		while(curr<roster.length) {
			 if(roster[curr] != null){
	               roster[prev] = roster[curr];
	               roster[curr] = null;
	               curr++;
	               prev++;
	            } 
			 else {
	                break;
	            }
			
		}
			
			
			
			
			
			
		

		return true;

	}


	// display the list without specifying the order
	public static void print() {
		// if collection is empty, System.out.println("The collection is empty!");
		boolean empty = true;
		for (int i = 0; i < rosterArray.length; i++) {
			if (rosterArray[i] != null) {
				empty = false;
				break;
			}
		}
		if (empty == true) {
			System.out.println("Student roster is empty!");
		}
	}

	// display the list by release date
	public static void printByName() {
		// if collection is empty, System.out.println("The collection is empty!");
		boolean empty = true;
		for (int i = 0; i < rosterArray.length; i++) {
			if (rosterArray[i] != null) {
				empty = false;
				break;
			}
		}
		if (empty == true) {
			System.out.println("Student roster is empty!");
		}
	}

	// display the list by genre
	public static void printByPayment() {
		// if collection is empty, System.out.println("The collection is empty!");
		boolean empty = true;
		for (int i = 0; i < rosterArray.length; i++) {
			if (rosterArray[i] != null) {
				empty = false;
				break;
			}
		}
		if (empty == true) {
			System.out.println("Student roster is empty!");
		}
	}

}




