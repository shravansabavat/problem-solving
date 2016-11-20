package uottawa.winter.problems.simple;

public class PartitionArray {
	
	public int[] partitionArray(int[] arr){
		int i = 1, j = arr.length - 1, partition = arr[0];
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
		return arr;
	}

	private int[] swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

	public static void main(String[] args){
		PartitionArray pa = new PartitionArray();
		int[] arr = {65,70, 75, 80, 45, 40, 35, 90, 30};
		int[] returnArray = pa.partitionArray(arr);
		
	}
}
