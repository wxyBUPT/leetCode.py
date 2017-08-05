package bupt.wxy.binarysearch;

/**
 * Created by xiyuanbupt on 3/1/17.
 35. Search Insert Position
 Difficulty: Easy
 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        int lo=0;
        int hi=nums.length;
        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<target){
                lo=mid+1;
            }else {
                hi=mid;
            }
        }
        return lo;
    }
}
