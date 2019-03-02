package algorithms.capter6.heap;

/**
 * desc : 最大堆
 * Created by tiantian on 2018/7/29
 */
public class MaxHeap {
    
    public static int heapSize = 0;
    // 维护最大堆
    public static void heapMaxHeapfy(Integer[] array, int i) {
        heapSize = array.length;
        int l = HeapNode.left(i);
        if (l >= heapSize) { 
            return;
        }
        
        int r = HeapNode.right(i);
        if (r >= heapSize) {
            return;
        }

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
            heapMaxHeapfy(array, largest);
        }
    }

    // 构建最大堆
    public static void heapBuiltMaxHeap(Integer[] array) {
        int i = (array.length)/2;
        while (i >= 0) {
            heapMaxHeapfy(array, i);
            i--;
        }
    }

    public static void exchange(Integer[] array, int a, int b) {
        Integer temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    // 返回堆元素父节点下标，或者左右子节点下标。
    public static class HeapNode {
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
