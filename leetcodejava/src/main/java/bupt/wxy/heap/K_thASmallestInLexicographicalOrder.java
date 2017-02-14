package main.java.bupt.wxy.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringJoiner;

/**
 * Created by xiyuanbupt on 2/6/17.
 Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.

 Note: 1 ≤ k ≤ n ≤ 109.

 Example:

 Input:
 n: 13   k: 2

 Output:
 10

 Explanation:
 The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 */
public class K_thASmallestInLexicographicalOrder {

    // Time Limit Exceeded
    // 所以是一道数学题
    public int findKthNumber(int n, int k) {
        // 应该是一个大顶堆
        PriorityQueue<Integer> heap=new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return String.valueOf(o2).compareTo(String.valueOf(o1));
            }
        });
        for(int i=1;i<=n;i++){
            if(i<=k)heap.offer(i);
            else {
                heap.offer(i);
                heap.poll();
            }
        }
        return heap.poll();
    }

    // 下面代码只是为了看默认是小顶堆还是大顶堆
    public static void main(String[] args){
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for(int i=0;i<3;i++)heap.offer(i);
        while (!heap.isEmpty())System.out.println(heap.poll());
    }
}
