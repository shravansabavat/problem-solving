package uottawa.coding;

public class Ranking {
    static RankNode root;

    public static void main(String[] args) {
        if (root == null) {
            root = new RankNode(10);
        }
        root.insert(30);
        root.insert(40);
        root.insert(1);
        root.insert(60);
        root.insert(3);
        root.insert(5);


        System.out.println(root.getRank(1));
        System.out.println(root.getRank(3));
        System.out.println(root.getRank(5));
        System.out.println(root.getRank(30));
        System.out.println(root.getRank(40));
        System.out.println(root.getRank(60));
    }
    public static class RankNode {

        public int leftSize = 0;
        public RankNode left, right;
        public int data;

        public RankNode(int d) {
            this.data = d;
        }

        public void insert(int d) {
            if (d <= data) {
                if (left != null) {
                    left.insert(d);
                } else {
                    left = new RankNode(d);
                }
                leftSize++;
            } else {
                if (right != null) {
                    right.insert(d);
                } else {
                    right = new RankNode(d);
                }
            }
        }

        public int getRank(int d) {
            if (d == data) {
                return leftSize;
            } else if (d < data) {
                if (left == null) {
                    return -1;
                } else {
                    return left.getRank(d);
                }
            } else {
                int rightRank = right == null ? -1 : right.getRank(d);
                if (rightRank == -1) {
                    return rightRank;
                } else {
                    return leftSize + 1 + rightRank;
                }
            }
        }

    }
}
