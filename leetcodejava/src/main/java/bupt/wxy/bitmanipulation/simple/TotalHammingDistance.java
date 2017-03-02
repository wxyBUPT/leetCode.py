package main.java.bupt.wxy.bitmanipulation.simple;

/**
 * Created by xiyuanbupt on 3/2/17.
 477. Total Hamming Distance Add to List

 The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Now your job is to find the total Hamming distance between all pairs of the given numbers.

 Example:
 Input: 4, 14, 2

 Output: 6

 Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 showing the four bits relevant in this case). So the answer will be:
 HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 */
public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        int dist=0;
        int n=nums.length;
        for(int i=0;i<32;i++){
            // m代表最后一位为1的个数
            int m=0;
            for(int j=0;j<n;j++){
                m+=nums[j]&1;
                nums[j]=nums[j]>>>1;
            }
            dist+=m*(n-m);
        }
        return dist;
    }
}
