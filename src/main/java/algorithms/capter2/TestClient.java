package algorithms.capter2;

import java.util.Map;

/**
 * desc : 最大子数组测试客户端
 * Created by tiantian on 2018/7/19
 */
public class TestClient {

    public static void main(String[] args) {
        Integer[] testArray = {-500,10,5,5,2,-3,-29,-10,-50,22,-23,10,150,1,9,-900,-26,3,99,7};
        for (int i = 0; i < testArray.length; i++) {
            System.out.print(testArray[i] + ",");
        }
        
//        int mid = length/2;
//        Map map = findMaxCrossingSubArray(testArray, 0, mid, length-1);
//        System.out.println(map.get("sum"));
//        map.forEach((k,v) -> System.out.println("k:"+v));

        int length = testArray.length;
        Map map = FindMaximumSubArray.findMaximumSubArray(testArray, 0, length-1);
        System.out.println("左下标：" + map.get("low"));
        System.out.println("右下标：" + map.get("height"));
        System.out.println("最大和：" + map.get("max"));
    }
}
