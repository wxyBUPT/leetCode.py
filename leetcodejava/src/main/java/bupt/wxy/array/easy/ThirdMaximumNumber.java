package bupt.wxy.array.easy;

/**
 * Created by xiyuanbupt on 1/15/17.
 * 414. Third Maximum Number   Add to List QuestionEditorial Solution  My Submissions
 * <p>
 * Difficulty: Easy
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * <p>
 * Example 1:
 * Input: [3, 2, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * <p>
 * Output: 2
 * <p>
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        // 相当于插入排序
        boolean containsMin = false;
        int[] maxs = new int[3];
        for (int i = 0; i < 3; i++) maxs[i] = Integer.MIN_VALUE;
        for (int num : nums) {
            // 找到插入点
            int index = 3;
            while (index > 0 && maxs[index - 1] <= num) {
                index--;
            }
            if (num == Integer.MIN_VALUE) containsMin = true;
            if (index < 3 && maxs[index] == num) index = 3;
            for (int i = 2; i > index; i--) {
                maxs[i] = maxs[i - 1];
            }
            if (index < 3)
                maxs[index] = num;
        }
        if (maxs[2] == Integer.MIN_VALUE && !containsMin || maxs[2] == maxs[1]) return maxs[0];
        return maxs[2];
    }
}
