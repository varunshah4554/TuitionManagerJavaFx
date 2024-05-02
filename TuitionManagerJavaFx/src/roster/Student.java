package roster;
/**
 * 
 * @author Varun Shah
 *
 */

/**
 *  Defines the common data items and operations for all student instances
 *
 */
public class Student {

	// make major enum?
	public Student(String name, Major major) {
		new Profile(name, major, 0);
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public boolean equals(Object obj) {

		return false;
	}

	public void tuitionDue() {
	}

	public void setTuition(double tuition) {
	}

}
