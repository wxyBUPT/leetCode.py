package main.java.bupt.wxy.greedy;

import java.util.Stack;

/**
 * Created by xiyuanbupt on 1/12/17.
 316. Remove Duplicate Letters

 Total Accepted: 24881
 Total Submissions: 87100
 Difficulty: Hard
 Contributors: Admin
 Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once.
 You must make sure your result is the smallest in lexicographical order among all possible results.

 Example:
 Given "bcabc"
 Return "abc"

 Given "cbacdcbc"
 Return "acdb"
 */
public class RemoveDuplicateLetters {

    // 90.78%
    public String removeDuplicateLettersUseStack(String s) {
        Stack<Character> st=new Stack<>();
        int[] cnt=new int[26];
        boolean[] visited=new boolean[26];
        for(char c:s.toCharArray())cnt[c-'a']++;
        for(char c:s.toCharArray()){
            int index=c-'a';
            cnt[index]--;
            if(visited[index])continue;
            while (!st.isEmpty()&&st.peek()>c&&cnt[st.peek()-'a']>0){
                visited[st.pop()-'a']=false;
            }
            st.push(c);
            visited[index]=true;
        }
        StringBuilder sb=new StringBuilder();
        while (!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }


    // 29.07% 使用递归. 没有使用stack效果好
    public String removeDuplicateLetters(String s) {

        int[] cnt=new int[26];
        int pos=0;
        for(int i=0;i<s.length();i++)cnt[s.charAt(i)-'a']++;
        // 下面代码有点难懂, 可以理解为: 当前面的所有字母出现超过一次的时候, 并且当前的字母比所有前面出现的字母自然序小
        // 那么这个字母可以为开头

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<s.charAt(pos))pos=i;
            if(--cnt[s.charAt(i)-'a']==0)break;
        }
        return s.length()==0?"":s.charAt(pos)+removeDuplicateLetters(s.substring(pos+1).replaceAll(""+s.charAt(pos),""));
    }
}
