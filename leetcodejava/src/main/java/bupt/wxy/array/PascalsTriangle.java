package main.java.bupt.wxy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 2/27/17.
 118. Pascal's Triangle Add to List
 Description  Submission  Solutions
 Total Accepted: 118174
 Total Submissions: 318248
 Difficulty: Easy
 Contributors: Admin
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class PascalsTriangle {

    // 4.02%
    // 用数组能快一点
    public List<List<Integer>> generate(int numRows) {
        if(numRows<=0)return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>(numRows);

        List<Integer> first=new ArrayList<>(1);
        first.add(1);
        res.add(first);

        for(int i=1;i<numRows;i++){
            List<Integer> upper=res.get(i-1);

            List<Integer> curr=new ArrayList<>(upper);
            curr.add(0);
            for(int j=0 , len=upper.size();j<len;j++){

                curr.set(j+1,curr.get(j+1)+upper.get(j));
            }

            res.add(curr);
        }
        return res;
    }
}
