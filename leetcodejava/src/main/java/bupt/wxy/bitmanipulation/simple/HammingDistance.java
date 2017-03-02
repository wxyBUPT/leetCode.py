package main.java.bupt.wxy.bitmanipulation.simple;

/**
 * Created by xiyuanbupt on 3/2/17.
 461. Hamming Distance Add to List
 Description  Submission  Solutions
 Total Accepted: 36664
 Total Submissions: 51687
 Difficulty: Easy
 Contributors: Samuri
 The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.

 Note:
 0 ≤ x, y < 231.

 Example:

 Input: x = 1, y = 4

 Output: 2

 Explanation:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 The above arrows point to positions where the corresponding bits are different
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int tmp=x^y;
        int dis=0;
        while (tmp!=0){
            dis+=tmp&1;
            tmp=tmp>>>1;
        }
        return dis;
    }
}
