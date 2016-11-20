package uottawa.coding;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotInGrid {
    private static boolean[][] maze = {
        {true,true,false,false},
        {false,true,false,false},
        {false,true,false,false},
        {false,true,true,true}};

    public static void main(String[] args) {
        ArrayList<Point> paths = getPath();
        
        for (Point point : paths) {
            System.out.println("Row::" + point.row +" and Col::" + point.col);
        }
    }

    private static ArrayList<Point> getPath() {
        if (maze == null || maze.length == 0) {
            return null;
        }

        ArrayList<Point> paths = new ArrayList<Point>();
        HashSet<Point> failedPaths = new HashSet<Point>();

        if (getPath(maze, maze.length - 1, maze[0].length - 1, paths, failedPaths)) {
            return paths;
        }
        return null;
    }

    private static boolean getPath(boolean[][] maze2, int row, int col, ArrayList<Point> paths, HashSet<Point> failedPaths) {
        if (row < 0 || col < 0 || !maze[row][col]) {
            return false;
        }
        Point point = new Point(row, col);
        if (failedPaths.contains(point)) {
            return false;
        }
        boolean isOrigin = (row == 0 && col == 0);
        if (isOrigin || getPath(maze2, row - 1, col, paths, failedPaths) || getPath(maze2, row, col - 1, paths, failedPaths)) {
            paths.add(point);
            return true;
        }

        failedPaths.add(point);
        return false;
    }

    public static class Point {
        public int row;
        public int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + col;
            result = prime * result + row;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Point other = (Point) obj;
            if (col != other.col)
                return false;
            if (row != other.row)
                return false;
            return true;
        }


    }

}


