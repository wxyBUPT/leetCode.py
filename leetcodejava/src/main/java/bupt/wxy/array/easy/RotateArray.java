package bupt.wxy.array.easy;

/**
 * Created by xiyuanbupt on 2/28/17.
 189. Rotate Array
 Difficulty: Easy
 Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

 [show hint]

 Related problem: Reverse Words in a String II

 Credits:
 Special thanks to @Freezen for adding this problem and creating all test cases.
 */
public class RotateArray {

    //  4.58%
    // 使用翻转
    public void rotate(int[] nums, int k) {

        k=k%(nums.length);
        reverse(nums,0,nums.length-1-k);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    public void reverse(int[] nums, int i, int j){
        while (i<j){
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
            i++;
            j--;
        }
    }
}