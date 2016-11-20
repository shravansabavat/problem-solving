package uottawa.winter.problems.sorting;

public class MergeSort {

	public static int[] mergeSort(int[] list){

		if(list == null){
			return null;
		}
		if(list.length == 1){
			return list;
		}
		int leftSize = list.length/2;
		int rigthSize = -1;
		int rightArrayIndex = 0;
		int middleIndex = list.length/2;
		
		if(list.length % 2 == 0){
			rigthSize = list.length/2;
		}else{
			rigthSize = list.length/2 + 1;
		}
		
		int[] left = new int[leftSize];
		int[] right = new int[rigthSize];

		for(int leftIndex = 0;leftIndex < middleIndex;leftIndex++){
			left[leftIndex] = list[leftIndex];
		}
		for(int rightIndex = middleIndex;rightIndex < list.length;rightIndex++){
			right[rightArrayIndex] = list[rightIndex];
			rightArrayIndex++;
		}
		int[] leftArr = mergeSort(left);
		int[] rightArr = mergeSort(right);
		int[] result = merge(leftArr,rightArr);
		return result;
	}

	public static int[] merge(int[] left, int[] right){
		
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
	
	public int solution(int K, int[] A) {
        // write your code in Java SE 8
        int[] sortedArray = mergeSort(A);
        int arrayLength = sortedArray.length;
        int count = 0;
        for(int index = 0; index < arrayLength; index++){
            int x = sortedArray[index];
            int y = K - x;
            if(find(sortedArray,y)){
                count++;
            }
        }
        return count;
    }
    
    public boolean find(int[] sortedArray, int value){
        int low = 0;
        int high = sortedArray.length - 1;
        int mid = -1;
        while(low <= high){
            mid = (low + high)/2;
            if(sortedArray[mid] == value){
                return true;   
            }
            if(value < sortedArray[mid]){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
               
        }
        return false;
    }


	public static void main(String args[]){
		int[] list = {8, 4, 2, 9, 1, 10, -2, -32768, 2147483647, -2147483648};
		int[] finalList = mergeSort(list);
		for(int index = 0;index < finalList.length;index++){
			System.out.println(finalList[index]);
		}
	}
}
