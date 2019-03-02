package algorithms.capter7;

import java.util.Random;

/**
 * desc : 随机化的快速排序
 * Created by tiantian on 2018/8/2
 */
public class RandomizedQuickSort {
    
    public void randomizedQuickSort(Integer[] array, int p, int r) {
        if (p < r) {
            int q = randomizedPartition(array, p, r);
            this.randomizedQuickSort(array, p, q-1);
            this.randomizedQuickSort(array, q+1, r);
        }
    }
    
    public int randomizedPartition(Integer[] array, int p, int r) {
        int random = this.randomNum(p, r);
        this.exchange(array, random, r);
        Integer pivot = array[r];
        int i = p-1;
        for (int j = p; j < r; j++) {
            if (array[j] <= pivot) {
                i++;
                this.exchange(array, i, j);
            }
        }
        this.exchange(array,i+1, r);
        return i+1;
    }
    
    public void exchange(Integer[] array, int a, int b) {
        Integer temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
    
    public int randomNum(int i, int j) {
        Random random = new Random();
        return random.nextInt(j-i) + i;
    }

    public static void main(String[] args) {
        Integer[] testArray = new Integer[100000];
        int len = testArray.length;
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            testArray[i] = random.nextInt(100000);
        }

        for (int i = 0; i < len; i++) {
//            System.out.print(testArray[i] + " ");
        }


        long start = System.currentTimeMillis();
        
        RandomizedQuickSort qs = new RandomizedQuickSort();
        qs.randomizedQuickSort(testArray, 0, testArray.length-1);
        long end = System.currentTimeMillis();

        System.out.println("排序结果");
//        for (Integer i : testArray) {
//            System.err.print(i+" <");
//        }

        long time = end - start;
        System.out.print("排序耗时：" + String.valueOf(time));
    }
}
