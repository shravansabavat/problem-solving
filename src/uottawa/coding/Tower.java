package uottawa.coding;

import java.util.Stack;

public class Tower {
    
    public Stack<Integer> disks;
    public int index;
    
    Tower(int stackIndex) {
        disks = new Stack<Integer>();
        index = stackIndex;
    }
    
    public void add (int d) {
        if (!disks.isEmpty() && disks.peek() < d) {
            System.out.println("cannot push disk");
        } else {
            disks.push(d);
        }
    }
    
    public void moveTop(Tower t) {
        int top = disks.pop();
        t.add(top);
    }
    
    public void moveDisks(int n, Tower dest, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, buffer, dest);
            moveTop(dest);
            buffer.moveDisks(n - 1, dest, this);
        }
    }

}
