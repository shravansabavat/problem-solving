package uottawa.coding;

import java.util.Arrays;

public class FillColors {
    static Color[][] colorBoard = {
            {Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE},
            {Color.BLUE, Color.BLACK, Color.BLACK, Color.BLUE},
            {Color.BLUE, Color.BLACK, Color.BLACK, Color.BLUE},
            {Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE}
    };
    
    public static void main(String[] args) {
        paintFill(colorBoard, 1, 2, Color.RED);
        
        System.out.println(Arrays.deepToString(colorBoard));
    }
    
    private static boolean paintFill(Color[][] colorBoard, int row, int col, Color chosenColor) {
        if (colorBoard[row][col] == chosenColor) {
            return false;
        }
        
        return paintFill(colorBoard, row, col, colorBoard[row][col], chosenColor);
        
    }

    private static boolean paintFill(Color[][] colorBoard, int row, int col, Color currentColor, Color chosenColor) {
        if (row < 0 || col < 0 || row > colorBoard.length - 1 || col > colorBoard[0].length - 1) {
            return false;
        }
        
        if (colorBoard[row][col] == currentColor) {
            colorBoard[row][col] = chosenColor;
            
            paintFill(colorBoard, row - 1, col, currentColor, chosenColor);
            paintFill(colorBoard, row + 1, col, currentColor, chosenColor);
            paintFill(colorBoard, row, col - 1, currentColor, chosenColor);
            paintFill(colorBoard, row, col + 1, currentColor, chosenColor);
        }
        return true;
    }

    public enum Color {BLACK, RED, BLUE}

}
