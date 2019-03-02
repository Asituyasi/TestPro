package algorithms.chapter09;

/**
 * Created by tiantian on 2018/8/27
 */
public class RandomSelect {
    
    private static int index = 2;
    private static Integer target = null;

    public static void find(Integer[] array, int p, int r) {
        if (p >= r) {
            return;
        }
        
        Integer pivot = array[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (array[j] <= pivot) {
                i++;
                exchange(array, i, j);
            }
        }
        exchange(array, i+1, r);

        if (i+1 == index) {
            target = array[i+1];
            System.out.println(target);
            return;
        } else if (i+1 > index) {
            find(array, p, i);
        } else {
            find(array, 1,r);
        }
    }

    public static void exchange(Integer[] array, int a, int b) {
        Integer temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        Integer[] array = {5,10,25,18,200,4,29,12,50,22,23,8,51,1,9,90,26,3,9,30};
        
        find(array, 0, array.length-1);
        
    }
}
