package algorithms.chapter12;

public class TreeNode<T extends Comparable> {
    T key;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode<T> parent;

    public TreeNode(T key) {
        this.key = key;
    }

    public TreeNode(T key, TreeNode<T> left, TreeNode<T> right, TreeNode<T> parent) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "key=" + key +
                ", parent=" + parent +
                '}';
    }
}