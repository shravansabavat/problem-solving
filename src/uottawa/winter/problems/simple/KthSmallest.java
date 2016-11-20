package uottawa.winter.problems.simple;

public class KthSmallest {
	
	public Integer returnKthSmallest(Integer[] arr, Integer i, Integer j, Integer k){
		
		Integer pivotIndex = partitionArray(arr, i, j);
		if(k == pivotIndex){
			pivotIndex = k;
		}else if(k > pivotIndex){
			pivotIndex = returnKthSmallest(arr, pivotIndex + 1, j, k/2);
		}else{
			pivotIndex = returnKthSmallest(arr, i, pivotIndex - 1, k/2);
		}
		
		return pivotIndex;
	}
	
	public Integer partitionArray(Integer[] arr, int i, int j){
		Integer partition = arr[0];
		while(i < j){
			if(arr[i] > partition && arr[j] < partition){
				arr = swap(i, j, arr);
				i++;
				j--;
			}else if(arr[i] > partition && arr[j] > partition){
				j--;
			}else{
				i++;
				j--;
			}
		}
		i = 0;
		arr = swap(i, j, arr);
		return j;
	}

	private Integer[] swap(Integer i, Integer j, Integer[] arr) {
		Integer temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}
	
	public static void main(String[] args){
		
		KthSmallest smallest = new KthSmallest();
		Integer[] arr = {65,70, 75, 80, 45, 40, 35, 90, 30};
		int k = 2;
		int index = smallest.returnKthSmallest(arr, 1, arr.length-1, k - 1);
		System.out.println(arr[index]);
		
	}

}
