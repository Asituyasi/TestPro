package algorithms.capter6.heap;

/**
 * desc :
 * Created by tiantian on 2018/7/24
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Integer[] testArray = {5,10,25,18,200,3,29,12,50,22,23,8,51,1,9,90,26,3,9,0};
        for (Integer i : testArray) {
            System.out.print(i+",");
        }
        System.out.println(" ");
        // 构建最大堆
        MaxHeap.heapBuiltMaxHeap(testArray);
        for (Integer i : testArray) {
            System.out.print(i+",");
        }
        System.out.println(" ");
        
        PriorityQueue pq = new PriorityQueue();
        System.out.println(pq.heapMaximum(testArray));

        // 删除优先队列最大键元素，并返回
//        try {
//            System.out.println(pq.heapExtractMax(testArray));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // 查看当前最大键元素
//        System.out.println(pq.heapMaximum(testArray));
        
        // 增大某个元素的键
        try {
            pq.heapIncreaseKey(testArray, 18, 222);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 检测增大结果
        for (Integer i : testArray) {
            System.out.print(i+",");
        }
        System.out.println(" ");
        System.out.println(pq.heapMaximum(testArray));
        
        // 插入元素到优先队列
        Integer[] newPQ = pq.maxHeapInsert(testArray, 666);
        
        // 检测
        for (Integer i : newPQ) {
            System.out.print(i+",");
        }


    }
}
