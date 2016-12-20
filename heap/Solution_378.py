#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import heapq
'''
378. Kth Smallest Element in a Sorted Matrix   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 22279
Total Submissions: 51920
Difficulty: Medium
Contributors: Admin
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
'''

class Solution(object):

    # 使用大小顶堆
    # 67.66%
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        # 本头使用java 解决，
        # 但是好像还有更好的解决办法
        '''
public class Solution_378 {


    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i = 0;i<n;i++){
            pq.offer(new Point(0,i,matrix[0][i]));
        }
        for(int i = 0;i<k-1;i++){
            Point t = pq.poll();
            if(t.x==n-1)continue;
            pq.offer(new Point(t.x+1,t.y,matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }
}
class Point implements Comparable<Point>{
    int x, y, val;

    public Point(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }


    @Override
    public int compareTo(Point o) {
        return this.val - o.val;
    }
}
'''
        pass

    # 53.13%
    def kthSmallest(self, matrix, k):
        return list(heapq.merge(*matrix))[k-1]

    # 传说中这个题目还可以使用二分答案来解决，但是没有理解


