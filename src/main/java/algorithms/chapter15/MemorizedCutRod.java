package algorithms.chapter15;

/**
 * Created by tiantian on 2019/3/2
 * 自顶向下带备忘（缓存）的切割钢条问题递归实现 
 */
public class MemorizedCutRod {

    // index为每段钢条长度，value为价格
    private static final Integer[] prices = {0,1,5,8,9,10,17,17,20,24,30};
    
    // 备忘数组
    private static final Integer[] array = new Integer[11];
    
    // n为锯条长度
    public static int memorizedCutRod(Integer[] p, Integer n) {
        if (array[n] != null) {
            return array[n];
        }

        Integer q = -1;
        if (n == 0) {
            q = 0;
        } else {
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, p[i] + memorizedCutRod(p, n-i));
            }
        }
        // 缓存结果
        array[n] = q;
        
        return q;
    }

    public static void main(String[] args) {
        System.out.println(memorizedCutRod(prices, 1));
    }
}
