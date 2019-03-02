package algorithms.chapter12;


public class Test {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode(10, null, null, null);
        BinarySearchTree<Integer> bsTree = new BinarySearchTree(root);
        
        bsTree.insert(new TreeNode(12));
        bsTree.insert(new TreeNode(8));
        bsTree.insert(new TreeNode(4));
        bsTree.insert(new TreeNode(3));
        bsTree.insert(new TreeNode(9));
        bsTree.insert(new TreeNode(11));
        bsTree.insert(new TreeNode(12));
        

        bsTree.postOrder(bsTree.root);
        System.out.println(bsTree.find(bsTree.root, 3).toString());
    }
}
