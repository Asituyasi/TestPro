package algorithms.capter7;

/**
 * desc : 快速排序
 * Created by tiantian on 2018/7/31
 */
public class QuickSort {
    
    public void quickSort(Integer[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q-1);
            quickSort(array, q+1, r);
        }
    }
    
    public int partition(Integer[] array, int p, int r) {
        Integer pivot = array[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (array[j] <= pivot) {
                i++;
                this.exchange(array, i, j);
            }
        }
        this.exchange(array, i+1, r);
        
        return i+1;
    }
    
    public void exchange(Integer[] array, int a, int b) {
        Integer temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        Integer[] testArray = {5,10,25,18,200,3,29,12,50,22,23,8,51,1,9,90,26,3,9,30};
        for (Integer i : testArray) {
            System.out.print(i + ",");
        }
        System.out.println(" ");
        
        QuickSort qs = new QuickSort();
        qs.quickSort(testArray, 0, testArray.length-1);

        System.out.println(" ");
        for (Integer i : testArray) {
            System.out.print(i+" < ");
        }
    }
}
