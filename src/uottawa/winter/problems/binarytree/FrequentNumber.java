package uottawa.winter.problems.binarytree;

public class FrequentNumber {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 4, 3, 3, 4, 5, 6, 2, 2};
		
		int max = -1;
		
		for (int num : arr) {
			if (max < num) {
				max = num;
			}
		}
		
		int[] newArr = new int[max + 1];
		for (int num : arr) {
			int val = newArr[num];
			if (val > 0) {
				newArr[num] = val + 1;
			} else {
				newArr[num] = 1;
			}
		}
		
		int rightIndex = -1;
		int frequency = -1;
		int index = 0;
		
		for (int num : newArr) {
			if (frequency < num) {
				frequency = num;
				rightIndex = index;
			}
			index++;
		}
		
		System.out.println("The number is:::" + rightIndex);
		System.out.println("The frequency is:::"+frequency);
		
	}

}
