package uottawa.winter.problems.binarytree;

public class SortNearlySortedArray {

	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4, 5, 7, 9, 6, 10, 12, 0};

		int[] newArr = sortNearlySorted(arr, 0);

		for(int i = 0; i < newArr.length; i++) {
			System.out.println(newArr[i] + " ");
		}
		
	}
	
	private static int[] sortNearlySorted(int[] arr, int index) {
		if (index < arr.length - 2) {
			int sortedIndex = -1;
			for(int i = 0; i < arr.length - 1; i++) {
				if (arr[i] < arr[i+1]) {
					sortedIndex++;
					continue;
				}
				
				int rightIndex = findRightIndex(arr, i + 1);
				
				int temp = arr[rightIndex];
				arr[rightIndex] = arr[i + 1];
				arr[i + 1] = temp;
				break;
			}
			
			sortNearlySorted(arr, sortedIndex);
		}
		return arr;
	}
	

	private static int findRightIndex(int[] arr, int findIndex) {
		int elementToPlace = arr[findIndex];
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] > elementToPlace) {
				return i;
			}
		}
		return -1;
	}

}
