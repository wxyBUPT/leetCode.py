package bupt.wxy.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 1/16/17.
 131. Palindrome Partitioning
 Difficulty: Medium

 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]

 */
public class PalindromePartitioning {

    List<List<String>> res;
    List<String> curr;

    // 95.88%
    public List<List<String>> partition(String s) {
        res=new ArrayList<>();
        curr=new ArrayList<>();
        backTrack(s,0);
        return res;
    }

    void backTrack(String s, int l){
        if(curr.size()>0&&l>=s.length()){
            res.add(new ArrayList<>(curr));
        }
        for(int i=l;i<s.length();i++){
            if(isPalindrome(s,l,i)){
                if(l==i)curr.add(Character.toString(s.charAt(i)));
                else curr.add(s.substring(l,i+1));
                backTrack(s,i+1);
                curr.remove(curr.size()-1);
            }
        }
    }

    boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}
