package main.java.bupt.wxy.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by xiyuanbupt on 3/11/17.
 378. Kth Smallest Element in a Sorted Matrix
 Difficulty: Medium
 Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.
 Note:
 You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class KthSmallestElementInASortedIMatrix {
    // 58.34%
    // 如果k远远小于 m*n 的时候有较好的时间复杂度
    public int kthSmallestUseHeap(int[][] matrix, int k) {
        PriorityQueue<Tuple> tuples=new PriorityQueue<>(k);
        int n=matrix.length;
        for(int j=0;j<n;j++)tuples.offer(new Tuple(0,j,matrix[0][j]));
        for(int i=0;i<k-1;i++){
            Tuple tuple=tuples.poll();
            // 在这一列已经不能提供更多的值了
            if(tuple.x==n-1)continue;
            tuples.offer(new Tuple(tuple.x+1,tuple.y,matrix[tuple.x+1][tuple.y]));
        }
        return tuples.peek().val;

    }

    // 60.87%
    // 但是没有在第一个正太区间
    public int kthSmallestBad(int[][] matrix, int k) {
        // 使用大顶堆保存结果
        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        for(int[] row:matrix)
            for(int i:row){
                // 需要向队列中添加的情况
                if(heap.size()<k||i<heap.peek())heap.offer(i);
                if(heap.size()>k)heap.poll();
            }
        return heap.peek();
    }
}

class Tuple implements Comparable<Tuple>{
    int x,y,val;

    @Override
    public int compareTo(Tuple o) {
        return val-o.val;
    }

    public Tuple(int x, int y, int val){
        this.x=x;
        this.y=y;
        this.val=val;
    }
}
