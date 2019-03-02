package algorithms.chapter10;

/**
 * desc : 链表的实现
 * Created by tiantian on 2018/9/2
 */
public class MyList {
    private Node head = null;

    public void insert(Object obj) {
        if (head == null) {
            head = new Node(obj);
            return;
        }
        
        Node node = new Node(obj);
        node.setNext(head);
        head.setPrev(node);
        head = node;
    }
    
    public Node delete(Object obj) {
        Node cur = head;
        
        Node deleted = null;
        if (head == null) { // 链表为空时
            return null;
        }
        
        if (head.next == null) { //只有一个元素时
            deleted = head;
            head = null;
            return deleted;
        }
        while (cur != null) {
            if (cur.getValue().equals(obj)) {
                deleted = cur;
                
                Node p = cur.getPrev();
                Node n = cur.getNext();
                if (p != null && n != null) { // 从链表中间删除时
                    p.setNext(n);
                    n.setPrev(p);
                } else if (n == null && p != null) { //删除尾部元素时
                    p.setNext(null);
                } else if (n != null && p == null) { //删除头部元素时
                    head = n;
                }
                break;
            }
            cur = cur.getNext();
        }

        cur = null;
        return deleted;
    }
    
    public static class Node {
        private Node prev = null;
        private Node next = null;
        private Object value;

        public Node(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
