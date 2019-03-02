package algorithms.chapter12;

/**
 * desc : 二叉搜索树
 * Created by tiantian on 2018/9/12
 */
public class BinarySearchTree<T extends  Comparable> {
    
    public TreeNode<T> root;

    public BinarySearchTree(TreeNode<T> root) {
        this.root = root;
    }
    
    public void insert(TreeNode<T> treeNode) {
        if (root == null) {
            root = treeNode;
        }
        
        TreeNode<T> curNode = root;
        while (curNode != null) {
            int cmp = treeNode.key.compareTo(curNode.key);
            
            if (cmp >= 0) {
                if (curNode.right == null) {
                    curNode.right = treeNode;
                    treeNode.parent = curNode;
                    break;
                } else {
                    curNode = curNode.right;
                }
            } else {
                if (curNode.left == null) {
                    curNode.left = treeNode;
                    treeNode.parent = curNode;
                    break;
                } else {
                    curNode = curNode.left;
                }
            }
        }
    }
    
    public void inOrder(TreeNode<T> treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.left);
            System.out.println(treeNode.key);
            inOrder(treeNode.right);
        }
    }
    
    public void preOrder(TreeNode<T> treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.key);
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }
    }
    
    public void postOrder(TreeNode<T> treeNode) {
        if (treeNode != null) {
            postOrder(treeNode.left);
            postOrder(treeNode.right);
            System.out.println(treeNode.key);
        }
    }
    
    public TreeNode<T> find(TreeNode<T> x, T k) {
        if (x.key.compareTo(k) == 0 || x == null) {
            return x;
        }

        if (k.compareTo(x.key) < 0) {
            return find(x.left, k);
        } else {
            return find(x.right, k);
        }
    }
    
    // 一颗子树替换另一颗子树并成为其双亲孩子节点(v.left和v.right并无更新)
    public void transPlant(BinarySearchTree<T> tree, TreeNode<T> u, TreeNode<T> v) {
        if (u.parent == null) {
            tree.root = v;
        } else if (u.equals(u.parent.left)) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }

        if (v != null) {
            v.parent = u.parent;
        }
    }

    public TreeNode<T> minimum(TreeNode<T> x) {
        while (x != null) {
            x = x.left;
        }
        
        return x;
    }

    public TreeNode<T> maximum(TreeNode<T> x) {
        while (x != null) {
            x = x.right;
        }

        return x;
    }
    
    public void delete(BinarySearchTree<T> bsTree, TreeNode<T> z) {
        if (z.left == null) {
            this.transPlant(bsTree, z, z.right);
        } else if (z.right == null) {
            this.transPlant(bsTree, z, z.left);
        } else {
            TreeNode<T> y = z.parent;
            if (!y.parent.equals(z)) {
                this.transPlant(bsTree, y, y.right);// y的右孩子替换y
                y.right = z.right;
                y.right.parent = y;
            }
            this.transPlant(bsTree, z, y); // y替换z
            y.left = z.left;
            y.left.parent = y;
        }
    }
    
    // 查找x节点的后继节点
    public TreeNode<T> successor(TreeNode<T> x) {
        if (x.right != null) {
            return this.minimum(x.right);
        }
        
        TreeNode<T> y = x.parent;
        while (y != null && x.equals(y.right)) {
            x = y;
            y = y.parent;
        }
        
        return y;
    }
 
}
