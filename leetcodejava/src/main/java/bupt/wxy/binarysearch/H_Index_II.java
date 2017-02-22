package main.java.bupt.wxy.binarysearch;

/**
 * Created by xiyuanbupt on 1/3/17.
 275. H-Index II
 Difficulty: Medium

 Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 */
public class H_Index_II {
    public int hIndex(int[] citations) {
        int len=citations.length;
        int h=len;
        while(h>0&&citations[len-h]<h){
            h--;
        }
        return h;
    }
}
