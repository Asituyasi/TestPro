package algorithms.capter6.heap;

/**
 * desc : 优先队列
 * Created by tiantian on 2018/7/29
 */
public class PriorityQueue {
    
    public static int heapSize = 0;
    
    
    // 返回集合中最大键元素
    public Integer heapMaximum(Integer[] array) {
        return array[0];
    }
    
    // 去掉并返回集合中最大键元素
    public Integer heapExtractMax(Integer[] array) throws Exception {
        heapSize = array.length;
        if (heapSize < 1) {
            throw  new Exception("heap underflow");
        }
        Integer max = array[0];
        array[0] = array[--heapSize];
        MaxHeap.heapMaxHeapfy(array, 0);
        return max;
    }
    
    // 将元素i的关键字值增加到key
    public  void heapIncreaseKey(Integer[] array, int i, Integer key) throws Exception {
        if (i > key) {
            throw new Exception("key is smaller than current key");
        }
        array[i] = key;
        int parent = MaxHeap.HeapNode.parent(i);
        while (i > 0 && array[parent] < array[i]) {
            MaxHeap.exchange(array, i, parent);
            i = parent;
            parent = MaxHeap.HeapNode.parent(parent);
        }
    }
    
    // 将元素插入到最大堆中
    public Integer[] maxHeapInsert(Integer[] array, Integer key) throws Exception {
        heapSize = array.length + 1;
        Integer[] newArray = new Integer[heapSize];
        System.arraycopy(array, 0, newArray, 0, heapSize-1);
        // 构造堆中最后一个元素为最小元素
        newArray[heapSize-1] = -65535;
        // 将最小元素增加到key即完成插入操作
        heapIncreaseKey(newArray, heapSize-1, key);
        return newArray;
    }
}
