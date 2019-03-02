package algorithms.capter6.heap;

/**
 * desc : 堆排序
 * Created by tiantian on 2018/7/24
 */
public class HeapSort {
    
    public static int heapSize = 0;
    // 维护最大堆
    public static void maxHeapfy(Integer[] array, int i) {
        int l = Node.left(i);
        int r = Node.right(i);
        
        int largest;
        if (l <= heapSize && array[l] > array[i]) {
            largest = l;
        } else {
            largest = i;
        }
        
        if (r <= heapSize && array[r] > array[largest]) {
            largest = r;
        }
        
        if (largest != i) {
            exchange(array, i, largest);
            maxHeapfy(array, largest);
        }
    }
    
    // 构建最大堆
    public static void builtMaxHeap(Integer[] array) {
        int i = (array.length)/2;
        while (i >= 0) {
            maxHeapfy(array, i);
            i--;
        }
    }
    
    // 排序
    public static void sort(Integer[] array) {
        heapSize = array.length-1;
        builtMaxHeap(array);
        int len = array.length;
        for (int i = len-1; i >= 0 ; i--) {
            exchange(array, 0, i);
            heapSize = heapSize - 1;
            maxHeapfy(array,0);
        }
    }
    
    public static void exchange(Integer[] array, int a, int b) {
        Integer temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
    // 返回堆元素父节点，或者左右子节点。
    public static class Node {
        public static int parent(int i) {
            if (i == 2) {
                return 0;
            }
            return i/2;
        } 
        
        public static int left(int i) {
            return 2*i+1;
        }
        
        public static int right(int i) {
            return 2 * i + 2;
        }
    }
}
