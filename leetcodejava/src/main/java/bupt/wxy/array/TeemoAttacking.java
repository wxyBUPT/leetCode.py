package main.java.bupt.wxy.array;

/**
 * Created by xiyuanbupt on 2/6/17.
 495. Teemo Attacking
 Difficulty: Medium

 In LLP world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition. Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking, you need to output the total time that Ashe is in poisoned condition.

 You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned condition immediately.

 Example 1:
 Input: [1,4], 2
 Output: 4
 Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned immediately.
 This poisoned status will last 2 seconds until the end of time point 2.
 And at time point 4, Teemo attacks Ashe again, and causes Ashe to be in poisoned status for another 2 seconds.
 So you finally need to output 4.
 Example 2:
 Input: [1,2], 2
 Output: 3
 Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned.
 This poisoned status will last 2 seconds until the end of time point 2.
 However, at the beginning of time point 2, Teemo attacks Ashe again who is already in poisoned status.
 Since the poisoned status won't add up together, though the second poisoning attack will still work at time point 2, it will stop at the end of time point 3.
 So you finally need to output 3.
 Note:
 You may assume the length of given time series array won't exceed 10000.
 You may assume the numbers in the Teemo's attacking time series and his poisoning time duration per attacking are non-negative integers, which won't exceed 10,000,000.
 */
public class TeemoAttacking {

    // 42.65%
    // 不是很难
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int max=0;
        int res=0;
        for(int time:timeSeries){
            if(time>max){
                res+=duration;
                max=time+duration;
            }
            else if(time+duration>max){
                res+=time+duration-max;
                max=duration+time;
            }
        }
        return res;
    }

    // 下面的函数本来打算使用二分查找来求解的
    /**
     * Binary search for the right insert index for target in arr.
     * @param arr
     * @param target
     * @param lo
     * @param hi
     * @return
     */
    /**
    static int bisect_right(int[] arr, int target, int lo, int hi){
        int mid;
        while (lo<hi){
            mid=lo+(hi-lo)/2;
            if(target>=arr[mid])lo=mid+1;
            else hi=mid;
        }
        return lo;
    }
     **/
}
