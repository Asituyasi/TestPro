package algorithms.capter2;

/**
 * desc : 线性时间查找最大子数组,返回两个下标
 * Created by tiantian on 2018/7/19
 */
public class MaximumSubArray {
    
    public static Integer find(Integer[] array) {
        // 当前迭代元素之前的最大子数组之和(不包含当前迭代元素)
        Integer ahead = array[0];
        // 包含当前迭代元素的最大子数组
        Integer containCurent = array[0];

        /**
         * 当前最大子数组有两种种情况:
         * 情况1：不包含当前迭代元素，也就是 array[i].
         * 情况2:包含当前迭代元素,要么最大子数组就是当前迭代元素array[i];
         * 要么最大子数组在在array[0...i]中,在array[0...i]中的话必然和前一个元素相连,
         * 那么，当前元素加上前一个元素包含自身的最大子数组即为当前元素包含自身的最大子数组.
         */
        for (int i = 0; i < array.length; i++) {
            if ((containCurent + array[i]) >= array[i]) {
                containCurent = containCurent + array[i];
            } else {
                containCurent = array[i];
            }
            
            if (containCurent > ahead) {
                ahead = containCurent;
            }
        }
        
        return ahead;
    }

    public static void main(String[] args) {
        Integer[] testArray = {-500,10,5,5,2,-3,-29,-10,-50,22,-23,10,150,1,9,-900,-26,3,99,7};
        for (int i = 0; i < testArray.length; i++) {
            System.out.print(testArray[i] + ",");
        }
        System.out.println("");
        
        Integer max = find(testArray);
        System.out.println(max);
    }
}
// 输出：
// -500,10,5,5,2,-3,-29,-10,-50,22,-23,10,150,1,9,-900,-26,3,99,7,
// 170