package uottawa.winter.problems.simple;

public class SumOfN {
	
	public static int returnSum(int[] n, int index){
		
		if(n.length == 0){
			return -1;
		}
		if(index == 0){
			return n[0];
		}
		return n[index] + returnSum(n, index - 1);
	}
	
	public static void main(String[] args){
		int[] n = {1,2,3,4};
		System.out.println(returnSum(n, n.length - 1));
	}

}
