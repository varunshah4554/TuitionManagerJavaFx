package roster;
import java.util.Calendar;

/**
 * 
 * @author Varun Shah
 *
 */

/**
 * Verifies valid date
 *
 */
public class Date implements Comparable<Date> {
	private int year;
	private int month;
	private int day;

	public Date(String date) {
		String[] date1 = date.split("/");
		year = Integer.parseInt(date1[2]);
		month = Integer.parseInt(date1[0]);
		day = Integer.parseInt(date1[1]);
	} // take “mm/dd/yyyy” and create a Date object

	public Date() {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.getTime();
	} // create an object with today’s date (see Calendar class)

	public boolean isValid() {
		final int TWENTYTWENTYONE = 2021;
		if (this.year < TWENTYTWENTYONE) {
			return false;
		}
		if ((this.year == Calendar.getInstance().get(Calendar.YEAR))
				&& (this.month > Calendar.getInstance().get(Calendar.MONTH) + 1)) {
			return false;
		}
		if ((this.year == Calendar.getInstance().get(Calendar.YEAR))
				&& (this.month == Calendar.getInstance().get(Calendar.MONTH) + 1)
				&& (this.day > Calendar.getInstance().get(Calendar.DATE))) {
			return false;
		}
		if (this.year > Calendar.getInstance().get(Calendar.YEAR)) {
			return false;
		}
		// checks if leapyear
		boolean leapyear = true;
		final int QUADRENNIAL = 4;
		final int CENTENNIAL = 100;
		final int QUATERCENTENNIAL = 400;

		if (this.year % QUADRENNIAL != 0) {
			leapyear = false;
		}
		if (this.year % CENTENNIAL != 0 && leapyear == true) {
			leapyear = false;
		}
		if (this.year % QUATERCENTENNIAL != 0 && leapyear == true) {
			leapyear = false;
		}
		// ensures the number of days does not exceed the max days in month
		final int JAN = 1;
		final int FEB = 2;
		final int MAR = 3;
		final int APR = 4;
		final int MAY = 5;
		final int JUN = 6;
		final int JUL = 7;
		final int AUG = 8;
		final int SEP = 9;
		final int OCT = 10;
		final int NOV = 11;
		final int DEC = 12;
		final int mindaysinmonth = 1;
		final int maxdaysin31daymonth = 31;
		final int maxdaysin30daymonth = 30;
		final int maxdaysinfebwithleapyear = 29;
		final int maxdaysinfebwithoutleapyear = 28;
		if ((month > DEC) || (month < JAN) || (day < mindaysinmonth)) {
			return false;
		}
		if (month == FEB && leapyear == false) {
			if (day > maxdaysinfebwithoutleapyear) {
				return false;
			}
		}
		if (month == FEB && leapyear == true) {
			if (day > maxdaysinfebwithleapyear) {
				return false;
			}
		}
		if (month == APR || month == JUN || month == SEP || month == NOV) {
			if (day > maxdaysin30daymonth) {
				return false;
			}
		}
		if (month == JAN || month == FEB || month == MAR || month == MAY || month == JUL || month == AUG || month == OCT
				|| month == DEC) {
			if (day > maxdaysin31daymonth) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int compareTo(Date date) {
		return day;

		// needed to sort by release date
	}
	public static boolean runValid(String str) {
		Date date = new Date(str);
		boolean result = date.isValid();
		if (result == false) {
			return false;
		} else {
			return true;
		}
	}
}
