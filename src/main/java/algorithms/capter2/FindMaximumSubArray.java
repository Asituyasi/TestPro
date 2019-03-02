package algorithms.capter2;

import java.util.HashMap;
import java.util.Map;

/**
 * desc : 分治法求解最大子数组
 * Created by tiantian on 2018/7/18.
 */
public class FindMaximumSubArray {
    
    public static Map findMaximumSubArray(Integer[] array, int low, int height) {
        Map<String, Integer> map = new HashMap();
        if (low == height) {
            map.put("low", low);
            map.put("height", height);
            map.put("max",array[low]);
            return map;
        }
        
        int mid = (low+height)/2;
        Map<String, Integer> left = findMaximumSubArray(array, low, mid);
        Map<String, Integer> right = findMaximumSubArray(array, mid+1, height);
        Map<String, Integer> midMap = findMaxCrossingSubArray(array, low, mid, height);
        
        Map retMap = new HashMap();
        if (left.get("max") >= right.get("max") && left.get("max") >= midMap.get("max")) {
            retMap.put("low", left.get("low"));
            retMap.put("height", left.get("height"));
            retMap.put("max", left.get("max"));
        } else if (right.get("max") >= left.get("max") && right.get("max") >= midMap.get("max")) {
            retMap.put("low", right.get("low"));
            retMap.put("height", right.get("height"));
            retMap.put("max", right.get("max"));
        } else {
            retMap.put("low", midMap.get("low"));
            retMap.put("height", midMap.get("height"));
            retMap.put("max", midMap.get("max"));
        }
        
        return retMap;
    }
    
    /**
     * desc:求横穿中间点的最大子数组
     */
    public static Map findMaxCrossingSubArray(Integer[] array, int low, int mid, int height) {
        int leftSum = -65535;
        int maxLeft  = 0;
        int tempSum = 0;
        for (int i = mid; i >= low; i--) {
            tempSum = tempSum + array[i];
            if (tempSum > leftSum) {
                leftSum = tempSum;
                maxLeft = i;
            }
        }
        
        tempSum = 0;
        int rightSum = -65535;
        int maxRight = 0;
        for (int j = mid+1; j <= height; j++) {
            tempSum = tempSum + array[j];
            if (tempSum > rightSum) {
                rightSum = tempSum;
                maxRight = j;
            }
        }
        
        Map<String, Integer> map = new HashMap();
        map.put("low", maxLeft);
        map.put("height", maxRight);
        map.put("max", leftSum+rightSum);
        return map;
    }
}
