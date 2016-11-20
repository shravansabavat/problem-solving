package uottawa.winter.problems.binarytree;

public class Heaps {

	static int heapSize = -1;

	public static void maxHeapify(Integer[] arr, int index) {
		int leftIndex = 2*index;
		int rightIndex = 2*index + 1;
		int largerIndex = index;
		if (leftIndex < heapSize && arr[largerIndex] < arr[leftIndex]) {
			largerIndex = leftIndex;
		}

		if (rightIndex < heapSize && arr[largerIndex] < arr[rightIndex]) {
			largerIndex = rightIndex;
		}

		if (largerIndex != index) {
			int temp = arr[index];
			arr[index]  = arr[largerIndex];
			arr[largerIndex] = temp;
			maxHeapify(arr, largerIndex);
		}
	}

	public static void minHeapify(Integer[] arr, int index) {
		int leftIndex = 2*index;
		int rightIndex = 2*index + 1;
		int smallerIndex = index;
		if (leftIndex < heapSize && arr[smallerIndex] > arr[leftIndex]) {
			smallerIndex = leftIndex;
		}

		if (rightIndex < heapSize && arr[smallerIndex] > arr[rightIndex]) {
			smallerIndex = rightIndex;
		}

		if (smallerIndex != index) {
			int temp = arr[index];
			arr[index]  = arr[smallerIndex];
			arr[smallerIndex] = temp;
			minHeapify(arr, smallerIndex);
		}
	}

	public static void main(String[] args) {
		Integer[] A = {10, 2, 3, 4, 5, 6, 7, 1, 20, 40, 100, 101};
		heapSize = A.length;

		int heapLeaves = heapSize/2;

		for (int index = heapLeaves; index >= 0; index--) {
			maxHeapify(A, index);
		}

		for(int num : A)
			System.out.print(num + " ");
		
		System.out.println();
		
		for (int index = heapLeaves; index >= 0; index--) {
			minHeapify(A, index);
		}
		
		for(int num : A)
			System.out.print(num + " ");
	}

}
