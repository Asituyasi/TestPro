package algorithms.chapter8;

/**
 * desc :
 * Created by tiantian on 2018/8/8
 */
public class CountingSort {
    
    public Integer[] sort(Integer[] a) {
        int k = a.length;
        Integer[] c = new Integer[k];
        for (int i = 0; i <= k-1; i++) {
            c[i] = 0;
        }

        for (int j = 1; j <= k-1; j++) {
            c[a[j]] = c[a[j]] + 1;
        }

        for (int p = 1; p <= 12; p++) {
            c[p] = c[p] + c[p-1];
        }

        Integer[] b = new Integer[k];
        for (int q = k-1; q >= 1 ; q--) {
            Integer m = a[q];
            Integer n = c[m];
            b[n] = a[q];
            c[m] = c[m] - 1;
        }
        
        return b;
    }

    public static void main(String[] args) {
        Integer[] array = {11,2,3,6,4,9,7,0,2,5,7,3,12,5,8,6,4,7,10,1};
        CountingSort cSort = new CountingSort();
        Integer[] b = cSort.sort(array);
        for (Integer i : b) {
            System.out.print(" < "+i);
        }
        System.out.println(" ");
        System.out.println(array.length == b.length);
    }
}
