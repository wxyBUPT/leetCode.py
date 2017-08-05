package main.java.bupt.wxy.hashtable;

import java.util.*;

/**
 * Created by xiyuanbupt on 5/7/17.
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int pre = 0;
        for(int i = 0;i<nums.length;i++){
            pre = pre + nums[i];
            if(!map.containsKey(pre)){
                map.put(pre, new ArrayList<>());
            }
            map.get(pre).add(i);
        }
        int res = 0;
        pre = 0;
        for(int i = 0; i<nums.length; i++){
            int target = pre + k;
            List<Integer> tmp = map.get(target);
            if(tmp==null)continue;
            for(int j:tmp){
                if(j>=i)res ++;
            }
            pre += nums[i];
        }
        return res;
    }
}
