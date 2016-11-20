package uottawa.winter.problems.simple;

public class MergingSortedArrays {
	
	public int[] mergeArrays(int[] left, int[] right){
		
		int resultLength = left.length+ right.length;
		int leftIndex = 0;
		int rightIndex = 0;
		int resultIndex = 0;
		int[] result = new int[resultLength];
		while(leftIndex < left.length || rightIndex < right.length){
			if(leftIndex < left.length && rightIndex < right.length){
				if(left[leftIndex] < right[rightIndex]){
					result[resultIndex] = left[leftIndex];
					leftIndex++;
					resultIndex++;
				}else{
					result[resultIndex] = right[rightIndex];
					rightIndex++;
					resultIndex++;
				}
				
			}else if(leftIndex < left.length){
				result[resultIndex] = left[leftIndex];
				leftIndex++;
				resultIndex++;
			}else if(rightIndex < right.length){
				result[resultIndex] = right[rightIndex];
				rightIndex++;
				resultIndex++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args){
		int[] arr1 = {5,6,7,8};
		int[] arr2 = {1,2,3,4};
		MergingSortedArrays arrays = new MergingSortedArrays();
		int[] returnArray = arrays.mergeArrays(arr1, arr2);
		System.out.println(returnArray);
	}

}
