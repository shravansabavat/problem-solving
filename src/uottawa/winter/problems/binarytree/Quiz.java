package uottawa.winter.problems.binarytree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;


//Note: anything you can find online in terms of answers to the questions below might not be correct :)

public class Quiz {

	/**
	 * Question 1:
	 * 
	 * Create the hashCode and equals method for the following class.
	 */
	private static class MyObject {

		private String name;
		private Integer quality;
		private final int MAXIMUM = 23;

		@Override
		public boolean equals(Object obj) {
			if((obj == null) || (obj.getClass() != this.getClass())) {
				return false;
			}
			
			if(this == obj) {
				return true;
			}

			MyObject myObject = (MyObject)obj;
			
			return (name == myObject.name || (myObject != null && name.equals(myObject.name))) &&
					(quality == myObject.quality || (myObject != null && quality.equals(myObject.quality)));
		}

		@Override
		public int hashCode() {
			int hash = MAXIMUM;
			hash = 31 * hash + (null == name ? 0 : name.hashCode());
			hash = 31 * hash + (null == quality ? 0 : quality.hashCode());

			return hash;
		}
	}

	/**
	 * Question 2:
	 * 
	 * This method was written for the purpose of removing all nulls from the given list.
	 *
	 * Improve this method as much as possible, while maintaining the method signature and the 
	 * original purpose.
	 * 
	 * Hint: The input list may very, very large.
	 */
	public void clean(LinkedList<Integer> f) {
		if (f == null || f.size() == 0) {
			return;
		}

		Iterator<Integer> itr = f.iterator();
		while (itr.hasNext()) {
			Integer i = itr.next();
			
			if (i == null) {
				itr.remove();
			}
		}
	}

	/**
	 * Question 3:
	 * 
	 * Simplify the 'check' method as much as possible, while maintaining the method signature and current functionality.
	 * Notes: 
	 * 		- x,y,z are always guaranteed to be > 0.
	 */
	public boolean check(int x, int y, int z) {
		return z > 1;
	}
	
	private int w(int x, int z) {
		return x * z;
	}

	/**
	 * Question 4
	 * 
	 * The check method is called by many threads, to perform checks and to keep count of the number of checks performed.
	 * Each thread invokes the check method with its own list of Foo objects, the list and its contents are not shared with other threads.
	 * Each thread invokes the check method with the same Properties instance.
	 * 
	 * Improve the performance of this method, ensuring the status object is updated before proceeding to the next check.
	 * Also, please correct any defects that may be present in the code below.
	 * The signature of the check method cannot be changed.
	 */
	public void check(List<Foo> list, Properties status) {
		final String KEY = "COUNT";
		
		if (list == null) {
			return;
		}
		
		for (Foo foo : list) {
			if (foo.check()) {
				
				synchronized (status) {
					int val = Integer.valueOf(status.getProperty(KEY));
					val += 1;
					status.setProperty(KEY, String.valueOf(val));
				}
			}
		}
	}
	
	private interface Foo {
		public boolean check();
	}

	/**
	 * Question 5
	 * 
	 * This method is supposed to return the number of 'active' employees that live in a city with a given name.
	 * Please correct all issues (both logic and performance issues) with the following method, 
	 * without changing the signature.
	 * 
	 * Notes:
	 * There are two tables used here: EMPLOYEE and CITY.
	 * The columns are:
	 * 		EMPLOYEE.EMP_ID			The employee identifier.  Primary key.
	 * 		EMPLOYEE.CITY_ID		The city where the employee lives.  A foreign key to the CITY table.
	 * 		EMPLOYEE.EMP_ACTIVE		Contains "Y" if and only if the employee is 'active'. 
	 * 		CITY.CITY_ID			Contains the primary key of the city.
	 * 		CITY.CITY_NAME			The name of the city, unique.
	 * 
	 * All columns are separately indexed.
	 * 
	 */
	public int countActiveEmployeesInCity(Connection c, String city) throws SQLException {
		PreparedStatement ps = c.prepareStatement("SELECT EMPLOYEE.EMP_ID FROM EMPLOYEE INNER JOIN CITY ON EMPLOYEE.CITY_ID = CITY.CITY_ID "
				+ "WHERE CITY.CITY_NAME = ? AND EMPLOYEE.EMP_ACTIVE = ?");
		
		ps.setString(1, city);
		ps.setString(2, "Y");
		ResultSet rs = ps.executeQuery();

		int activeEmployeesCount = 0;
		if (rs.last()) {
			activeEmployeesCount = rs.getRow();
			rs.beforeFirst();//set it back for next traversal
		}

		return activeEmployeesCount;
	}

	/**
	 * Question 6
	 * 
	 * Improve the following method as much as possible (without modifying the method signature).  
	 * Ensure that it returns true if and only if both arrays contain the given value.
	 *  
	 * Note: The lists may be null and may contain null values.
	 */
	public boolean isInBoth(String value, String[] arrayA, String[] arrayB) {
		if (arrayA == null || arrayB == null || arrayA.length == 0 || arrayB.length == 0) {
			return false;
		}
		
		List<String> list1 = Arrays.asList(arrayA);
		List<String> list2 = Arrays.asList(arrayB);
		
		return list1.contains(value) && list2.contains(value);
	}
}


