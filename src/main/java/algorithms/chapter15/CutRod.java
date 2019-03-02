package algorithms.chapter15;

/**
 * Created by tiantian on 2019/3/2
 * 自顶向下递归实现切割钢条问题
 */
public class CutRod {
    
    // index为每段钢条长度，value为价格
    private static final Integer[] prices = {0,1,5,8,9,10,17,17,20,24,30};
    
    // n为钢条总长度
    public static int cutRod(final Integer[] p, int n) {
        if (n == 0) {
            return 0;
        }
        
        int q = -1;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i] + cutRod(p, n-i));
        }
        return q;
    }

    public static void main(String[] args) {
        System.out.println(cutRod(prices, 10));
    }
    
}
