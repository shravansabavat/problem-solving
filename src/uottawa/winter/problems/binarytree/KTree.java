package uottawa.winter.problems.binarytree;

public class KTree {
    
    
    public static void main (String[] args) {
        KTreeNode root1 = new KTreeNode(10);
        root1.children = new KTreeNode[3];
        
        KTreeNode child1 = new KTreeNode(20);
        root1.children[0] = child1;
        
        KTreeNode child2 = new KTreeNode(30);
        root1.children[1] = child2;
        
        KTreeNode child3 = new KTreeNode(40);
        root1.children[2] = child3;
        
        KTreeNode child11 = new KTreeNode(50);
        child1.children[0] = child11;
        
        KTreeNode child12 = new KTreeNode(60);
        child1.children[1] = child12;
        
        KTreeNode child13 = new KTreeNode(70);
        child1.children[2] = child13;
        
        
        //second tree
        KTreeNode root2 = new KTreeNode(20);
        root2.children = new KTreeNode[3];
        
        KTreeNode child21 = new KTreeNode(50);
        root2.children[0] = child21;
        
        KTreeNode child22 = new KTreeNode(60);
        root2.children[1] = child22;
        
        KTreeNode child23 = new KTreeNode(70);
        root2.children[2] = child23;
        
        
    }
}

class KTreeNode {
    KTreeNode(int data) {
        this.data = data;
    }
    
    int data;
    KTreeNode[] children;
}
