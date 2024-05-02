package roster;
/**
 * 
 * @author Varun Shah
 *
 */

/**
 * Extends Student class and includes specific data and operations to resident students.
 *
 */
public class Resident extends Student{

	public Resident(String name, Major major, int credits, Double tuiton) {
		super(name, major);
		
	}

	
	 @Override
	    public boolean equals(Object obj){
	        if(obj instanceof Resident){
	            return super.equals(obj);
	        }else{
	            return false;
	        }
	    }
	 
	 
	@Override 
	public void tuitionDue() {
	}
	
}



