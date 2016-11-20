package uottawa.winter.problems.binarytree;

public class FindIslands {
	
	public static int shapeStarted = -1;
	public static int shapes = 0;
	
	public static void main(String[] args) {
		int[][] arr = new int[][]{
				  { 1, 0, 1, 0, 0, 0, 0, 1, 1, 0 },
				  { 1, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
				  { 0, 1, 0, 0, 0, 1, 1, 0, 0, 1 },
				  { 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }
				};
		
		System.out.println(GetNumber(arr));
		
	}
	
	public static int GetNumber(int[][] array) {
        int objects = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (findShapes(array, i, j)) {
                    objects++;
                }
            }
        }
        return objects;
    }
	
	public static boolean findShapes(int[][] arr, int x, int y) {
		if (x < 0 || y < 0 || x >= arr.length || y >= arr[x].length) return false;
        if (arr[x][y] == 1) {
        	arr[x][y] = 0;
        	findShapes(arr, x - 1, y);
        	findShapes(arr, x + 1, y);
        	findShapes(arr, x, y - 1);
        	findShapes(arr, x, y + 1);
        	findShapes(arr, x - 1, y - 1);
        	findShapes(arr, x - 1, y + 1);
        	findShapes(arr, x + 1, y - 1);
        	findShapes(arr, x + 1, y + 1);
            return true;
        }
        return false;
	}

}
