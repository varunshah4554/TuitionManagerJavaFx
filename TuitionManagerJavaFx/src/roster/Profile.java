package roster;
/**
 * 
 * @author Varun Shah
 *
 */

/**
 * Define the profile of a student, including name and major. A student profile uniquely identifies a
 * student in the student roster.
 */
public class Profile {
	
private String name;
private Major major; //5 majors 2 chars each: CS,IT,BA,EE,ME
public Profile(String name2, Major major2, int credits2) {
	this.major=major2;
	this.name=name2;

}




@Override
public String toString() { //Doe,Jane::CS::7/1/2020
    return name + "::" + major;
}



@Override
public boolean equals(Object obj) {
	return false;
}
	
	public String returnName() {
		return name;
	}

	public Major returnMajor() {
		return major;
	}
}


