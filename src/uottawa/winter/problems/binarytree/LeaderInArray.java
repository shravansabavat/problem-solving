package uottawa.winter.problems.binarytree;

public class LeaderInArray {
	
	public static int[] arr = {1, 2, 3, 50, 6, 30, 5};
	
	public static void main(String[] args) {
		
		int currMax = arr[arr.length - 1];
		
		for(int index = arr.length - 2; index > 0; index--) {
			if (currMax < arr[index]) {
				currMax = arr[index];
			}
		}
		
		System.out.println(currMax);
		
	}

}
