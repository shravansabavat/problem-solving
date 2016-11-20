package uottawa.winter.problems.binarytree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestRemoLinkedList {
	
	public static boolean isInBoth(String value, String[] arrayA, String[] arrayB) {
		if (arrayA == null || arrayB == null || arrayA.length == 0 || arrayB.length == 0) {
			return false;
		}
		
		List<String> list1 = Arrays.asList(arrayA);
		List<String> list2 = Arrays.asList(arrayB);
		
		return list1.contains(value) && list2.contains(value);
	}

	public static void main(String[] args) {
//		LinkedList<Integer> list = new LinkedList<Integer>();
//		for (int i = 0; i < 1000000; i++) {
//			list.add(null);
//		}
//		
//		clean(list);
		
		String[] arr1 = {null, "test"};
		String[] arr2 = {null, "test"};
		
		//System.out.println(String.valueOf("1" + 1));
		
		//System.out.println(isInBoth("test", arr1, arr2));
		System.out.println(check1(100, 1, 2));
		System.out.println(check2(100, 1, 2));
	}

	public static void clean(LinkedList<Integer> f) {
		if (f == null) {
			return;
		}
		
		Iterator<Integer> itr = f.iterator();
		while (itr.hasNext()) {
		    Integer i = itr.next();
		    itr.remove();
		}
	}
	
	public static boolean check1(int x, int y, int z) {
		return z > 1 && y != z;
	}

	public static boolean check2(int x, int y, int z) {
		if (x < w(x,z) && y < z || x < w(x,z) && y > z && z < y) {
			return true;
		}
		return false;
	}
	private static int w(int x, int z) {
		int f = 0;
		for (int i = 0; i < z; i++) {
			f += x;
		}
		return f;
	}

}
