package algorithms.capter2.sort;

import java.util.Random;

/**
 * Created by tiantian on 2018/7/10.
 */
public class MergeSort {
    
    public static void sort(Integer[] array, int low, int height) {
        if (low == height) {
            return;
        }
        // 分解 
        int middle = (low+height) / 2;
        
        // 解决
        sort(array, low, middle);
        sort(array, middle+1, height);
        
        // 合并
         merge(array, low, middle, height);
    }
    
    public static void merge(Integer[] array, int low, int middle, int height) {
        // 将已有序的两个子数组，存入两个临时数组中
        int len1 = middle - low + 1;
        int len2 = height - middle;
        Integer[] temp1 = new Integer[len1+1];
        Integer[] temp2 = new Integer[len2+1];

        for (int i = 0; i < len1; i++) {
            temp1[i] = array[low+i];
        }
        
        middle++;
        for (int j = 0; j < len2; j++) {
            temp2[j] = array[middle+j];
        }
        
        // 为了保证归并操作完整执行，加入两个哨兵
        temp1[len1] = 1000;
        temp2[len2] =1000;
        
        int m = 0,n = 0;
        // 归并操作
        for (int i = low; i <= height; i++) {
            if (temp1[n] < temp2[m]) {
                array[i] = temp1[n++];
                continue;
            } else {
                array[i] = temp2[m++];
            }
        }
    }

    public static void main(String[] args) {
        Random random =  new Random();
        Integer[] array = new Integer[20];
        
        for (int i = 0; i < 20; i++) {
            Integer number = random.nextInt(100);
            array[i] = number;
            System.out.print(number + ",");
        }

        MergeSort.sort(array, 0, array.length-1);
        System.out.println("");
        System.out.println("");
        for(Integer i : array) {
            System.out.print(i + ",");
        }
        
    }
}
