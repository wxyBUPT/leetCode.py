package main.java.bupt.wxy.binarysearch.easy;

/**
 * Created by xiyuanbupt on 3/1/17.
 278. First Bad Version Add to List
 Description  Submission  Solutions
 Total Accepted: 86232
 Total Submissions: 350650
 Difficulty: Easy
 Contributors: Admin
 You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

 You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.


 */
public class FindBadVersion {

    boolean isBadVersion(int version){
        return true;
    }

    // 67.91%
    public int firstBadVersion(int n) {
        int lo=1,hi=n;
        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            if(!isBadVersion(mid)){
                lo=mid+1;
            }else {
                hi=mid;
            }
        }
        return lo;
    }
}
