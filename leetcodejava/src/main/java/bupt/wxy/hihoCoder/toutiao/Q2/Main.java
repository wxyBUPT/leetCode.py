package main.java.bupt.wxy.hihoCoder.toutiao.Q2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by xiyuanbupt on 3/30/17.
 * 本题目创建倒排索引
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt(), M = in.nextInt();
        in.nextLine();
        Map<String,Set<Integer>> index = new HashMap<>();
        String[] lines = new String[N];
        for(int i=0;i<N;i++){
            lines[i] = in.nextLine();
            for(String word:lines[i].split(" ")){
                word = word.toLowerCase();
                if(!index.containsKey(word)){
                    index.put(word, new HashSet<>());
                }
                index.get(word).add(i);
            }
        }

        for(int i=0;i<M;i++){
            // 代表每条句子与这条句子的重复数
            int[] counts = new int[N];
            int maxIndex = 0;
            String search = in.nextLine();
            for(String word:search.split(" ")){
                word = word.toLowerCase();
                if(!index.containsKey(word))continue;
                Set<Integer> integers = index.get(word);
                for(Integer k:integers){
                    counts[k]++;
                    if(counts[k]>counts[maxIndex])maxIndex=k;
                }
            }
            System.out.println(lines[maxIndex]);
        }
    }
}
