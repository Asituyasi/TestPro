/**
 * Created by tiantian on 2019/2/20
 */
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
        Integer[] array = {2,1,9,5,6,7,24,11,44,22};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array, 0, array.length-1);

        for (Integer a : array) {
            System.out.println(a);
        }
    }
}

