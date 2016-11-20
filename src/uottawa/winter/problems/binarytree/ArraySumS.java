package uottawa.winter.problems.binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArraySumS {
	
	public static void main (String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		int S = 10;
		Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
		
		for(int index = 0; index < arr.length; index++) {
			int diff = S - arr[index];
			boolean found = find(arr, diff);
			if (found) {
				System.out.println("Found numbers [" + arr[index] + "], [" + diff + "]");
			}
		}
		
		for(int i : arr) {
			numbers.put(i, S - i);
		}
		
		Set<Entry<Integer, Integer>> entries = numbers.entrySet();
		for (Entry<Integer, Integer> entry : entries) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			
			if (null != numbers.get(value)) {
				System.out.println("Found numbers [" + key + "], [" + value + "]");
			}
		}
		
		
		char[] chars = {'a', 'd', 'g', 'f', 'x', 'z'};
		char ch = 'y';
		
		int indexFound = findRightIndex(chars, ch);
		if (indexFound > 0) {
			System.out.println("Found index [" + indexFound + "]");
		}
		
		String S1 = "shravan";
		String S2 = "raavaa";
	}
	
	private static int findRightIndex(char[] arr, char ch) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		
		while (low <= high) {
			mid = (low + high) / 2;
			int arrCharIntValue = (int)arr[mid];
			int chIntValue = (int)ch;
			if (arrCharIntValue + 1 == chIntValue) {
				return mid + 1;
			}
			
			if (ch < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return -1;
	}

	public static boolean find(int[] arr, int number) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] == number) {
				return true;
			}
			
			if (number < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return false;
	}

}
