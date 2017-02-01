package main.java.bupt.wxy.heap;

import java.util.*;

/**
 * Created by xiyuanbupt on 12/31/16.
 451. Sort Characters By Frequency
 Total Accepted: 11191
 Total Submissions: 22049
 Difficulty: Medium
 Contributors: stickypens
 Given a string, sort it in decreasing order based on the frequency of characters.

 Example 1:

 Input:
 "tree"

 Output:
 "eert"

 Explanation:
 'e' appears twice while 'r' and 't' both appear once.
 So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 Example 2:

 Input:
 "cccaaa"

 Output:
 "cccaaa"

 Explanation:
 Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 Note that "cacaca" is incorrect, as the same characters must be together.
 Example 3:

 Input:
 "Aabb"

 Output:
 "bbAa"

 Explanation:
 "bbaA" is also a valid answer, but "Aabb" is incorrect.
 Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency {
    // 有两种算法,一种是使用桶排序,一种是使用堆排序
    // 有一种体验,使用java实现桶排序这类的算法好慢
    // 69.09%
    public String bucketSort(String s){
        Map<Character, Integer> count = new HashMap<>();
        for(char c:s.toCharArray()){
            count.put(c,count.getOrDefault(c,0)+1);
        }

        List<Character>[] bucket = new List[s.length()+1];
        for(char key:count.keySet()){
            int freq = count.get(key);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for(int pos=bucket.length-1;pos>=0;pos--){
            if(bucket[pos]!=null){
                for(char num:bucket[pos]){
                    for(int j=0;j<pos;j++){
                        sb.append(num);
                    }
                }
            }
        }
        return sb.toString();
    }
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> heap = new PriorityQueue<>(
                new Comparator<Map.Entry<Character,Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                }
        );
        StringBuilder sb = new StringBuilder();
        heap.addAll(map.entrySet());
        while (!heap.isEmpty()){
            Map.Entry<Character,Integer> e = heap.poll();
            char c = e.getKey();
            for(int i =0;i<e.getValue();i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        SortCharactersByFrequency sl = new SortCharactersByFrequency();
        System.out.println(sl.frequencySort("ccca"));
    }
}
