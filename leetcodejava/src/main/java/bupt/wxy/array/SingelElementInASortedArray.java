package bupt.wxy.array;

/**
 * Created by xiyuanbupt on 8/13/17.
 540. Single Element in a Sorted Array
 DescriptionHintsSubmissionsDiscussSolution
 Discuss Pick One
 Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

 Example 1:
 Input: [1,1,2,3,3,4,4,8,8]
 Output: 2
 Example 2:
 Input: [3,3,7,7,10,11,11]
 Output: 10
 */
public class SingelElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len / 2; i++){
            if(nums[2* i] != nums[2 * i + 1]){
                return nums[2 * i];
            }
        }
        return nums[len - 1];
    }
}
