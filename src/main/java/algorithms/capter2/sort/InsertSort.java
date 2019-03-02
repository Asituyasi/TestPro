package algorithms.capter2.sort;

import java.util.Random;

/**
 * Created by tiantian on 2018/7/9.
 */
public class InsertSort {
    
    public static void sort(Integer[] destArray) {
        int len = destArray.length;

        for (int i = 1; i < len; i++) {
            Integer j = i;
            Integer temp = destArray[j];
            while (j > 0 && destArray[j-1] > temp) {
                destArray[j] = destArray[j-1];
                j--;
            }
            destArray[j] = temp;
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
        
        InsertSort.sort(array);
        System.out.println("");
        for(Integer i : array) {
            System.out.print(i + ",");
        }
    }
}
