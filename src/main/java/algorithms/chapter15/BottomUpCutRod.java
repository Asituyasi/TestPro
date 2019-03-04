package algorithms.chapter15;

/**
 * Created by tiantian on 2019/3/2
 * 自底向上钢条切割问题实现
 */
public class BottomUpCutRod {
    // index为每段钢条长度，value为价格
    private static final Integer[] prices = {0,1,5,8,9,10,17,17,20,24,30};

    // 备忘数组
    private static final Integer[] array = new Integer[11];

    // n为锯条长度
    public static int bottomUpCutRod(Integer[] p, Integer n) {
        array[0] = 0; 
        for (int j = 1; j <= n; j++) {
            int q = -1;
            for (int i = 1; i <= j; i++) {
                q = Math.max(q, p[i] + array[j-i]);
            }
            array[j] = q;
        }
        
        return array[n];
    }
    
    public static void main(String[] args) {
        System.out.println(bottomUpCutRod(prices, 10));
    }
}
