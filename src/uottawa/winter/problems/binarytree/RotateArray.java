package uottawa.winter.problems.binarytree;


public class RotateArray {

	public static void main(String args[]) throws Exception{
		//Take Input
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String[] numbers = br.readLine().split(" ");
//		int a = Integer.parseInt(numbers[0]);
//		int b = Integer.parseInt(numbers[1]);

		int gcd=find_gcd(3,5);
		System.out.println(gcd);
	}
	
	static  int find_gcd(int a,int b){
		//Write the base condition
		if (b <= 0) {
			return a;
		}
		return find_gcd(b, b%a);
	}
}
