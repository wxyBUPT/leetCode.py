package main.java.bupt.wxy.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 2/28/17.
 89. Gray Code Add to List
 Difficulty: Medium

 The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

 Subscribe to see which companies asked this question.
 */
public class GrayCode {

    // 本题目解决方法很多
    // 10.69%
    // 两个之间有相邻关系的可以利用前面已经有的结果
    public List<Integer> grayCode(int n) {
        List<Integer> res=new LinkedList<>();
        res.add(0);
        for(int i=0;i<n;i++){
            int index=res.size();
            while (index>0){
                index--;
                int next=res.get(index);
                next+=1<<i;
                res.add(next);
            }
        }
        return res;
    }

}
