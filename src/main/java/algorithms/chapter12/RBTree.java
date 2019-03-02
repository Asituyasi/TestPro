package algorithms.chapter12;

/**
 * desc : 红黑树
 * Created by tiantian on 2018/9/26
 */
public class RBTree<V,T extends Comparable> {
    private Node<V,T> root;
    public void insert(Node z) {
        Node y = null;
        Node x = root;
        while (x != null) {
            y = x;
            if (z.key.compareTo(x.key) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.p = y;
        if (y == null) {
            root = z;
        } else if (z.key.compareTo(y.key) < 0) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.color = Color.RED;
        fixupOfInsert(z);
    }
    
    public void delete(Node x) {
        
    }
    
    public void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.p = x;
        }
        y.p = x.p;
        if (x.p == null) {
            this.root = y;
        } else if (x == x.p.left) {
            x.p.left = y;
        } else {
            x.p.right = y;
        }
        y.left = x;
        x.p = y;
    }
    
    public void rightRotate(Node y) {
        Node x = y.left;
        x.right = y.left;
        if (x.right != null) {
            x.right.p = y;
        }
        x.p = y.p;
        if (y.p == null) {
            this.root = y;
        } else if (y == y.p.left) {
            y.p.left = x;
        } else {
            y.p.right = x;
        }
        x.right = y;
        y.p = x;
    }
    
    public void fixupOfInsert(Node z) {
        
    }

    public void fixupOfDelete(Node z) {

    }
    
    final class Node<T,V extends Comparable> {
        private T item = null;
        private V key = null;
        private Color color = null;
        private Node p = null;
        private Node<T,V> left = null;
        private Node<T,V> right = null;

        public Node(V key) {
            this.key = key;
            this.right = null;
        }
    }
    
    enum Color {
        RED,BLACK
    }
}
