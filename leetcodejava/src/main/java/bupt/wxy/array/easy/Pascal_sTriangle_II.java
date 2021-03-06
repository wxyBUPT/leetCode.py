package bupt.wxy.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 1/13/17.
 119. Pascal's Triangle II

 Difficulty: Easy
 Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?


 */
public class Pascal_sTriangle_II {

    // 87.27%
    public List<Integer> getRow(int rowIndex) {
        int[] res=new int[rowIndex+3];
        // 0层
        res[1]=1;
        for(int i=1;i<=rowIndex;i++){
            // 根据上层的值计算下层
            int pre=0;
            for(int j=1;j<i+2;j++){
                int tmp=res[j];
                res[j]=pre+res[j];
                pre=tmp;
            }
        }
        List<Integer> ret=new ArrayList<>();
        for(int i=1;i<res.length-1;i++){
            ret.add(res[i]);
        }
        return ret;
    }
}
