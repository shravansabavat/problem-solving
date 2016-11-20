package uottawa.winter.problems.simple;

import java.util.HashSet;

public class DuplicateNumbersInArray {

	public static void main(String[] args){
		int arr1[] = {1,2,3,6,7,8};
		int arr2[] = {1,2,6,5,4,3};
		HashSet set = new HashSet();
		for(int i = 0; i < arr1.length; i++){
			set.add(arr1[i]);
		}
		for(int i = 0; i < arr1.length; i++){
			if(set.contains(arr2[i])){
				System.out.println(arr2[i]);
			}
		}

	}

}
