package main.java.bupt.wxy.segmenttree;

/**
 * Created by xiyuanbupt on 1/11/17.
 307. Range Sum Query - Mutable   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 25917
 Total Submissions: 140588
 Difficulty: Medium
 Contributors: Admin
 Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 The update(i, val) function modifies nums by updating the element at index i to val.
 Example:
 Given nums = [1, 3, 5]

 sumRange(0, 2) -> 9
 update(1, 2)
 sumRange(0, 2) -> 8
 Note:
 The array is only modifiable by the update function.
 You may assume the number of calls to update and sumRange function is distributed evenly.
 */

/**
 * 还是第一次做segmenttree
 */
public class NumArray {

    class SegmentTreeNode{
        int start,end;
        SegmentTreeNode left,right;
        int sum;

        public SegmentTreeNode(int start, int end){
            this.start=start;
            this.end=end;
            this.left=null;
            this.sum=0;
        }
    }

    SegmentTreeNode root=null;

    public NumArray(int[] nums){
        root=buildTree(nums,0,nums.length-1);
    }

    SegmentTreeNode buildTree(int[] nums, int start, int end){
        if(start>end){
            return null;
        }
        else {
            SegmentTreeNode ret=new SegmentTreeNode(start, end);
            if(start==end){
                ret.sum=nums[start];
            }
            else {
                int mid=start+(end-start)/2;
                ret.left=buildTree(nums,start,mid);
                ret.right=buildTree(nums,mid+1,end);
                ret.sum=ret.left.sum+ret.right.sum;
            }
            return ret;
        }
    }

    void update(int i, int val){
        update(root,i,val);
    }

    void update(SegmentTreeNode root, int pos, int val){
        if(root.start==root.end)root.sum=val;
        else {
            int mid=root.start+(root.end-root.start)/2;
            if(pos<=mid){
                update(root.left,pos,val);
            }else {
                update(root.right,pos,val);
            }
            root.sum=root.left.sum+root.right.sum;
        }
    }

    public int sumRange(SegmentTreeNode root, int start, int end){
        if(root.end==end&&root.start==start){
            return root.sum;
        }

        else {
            int mid=root.start+(root.end-root.start)/2;
            if(end<=mid)return sumRange(root.left,start,end);
            else if(start>=mid+1)return sumRange(root.right,start,end);
            else return sumRange(root.right,mid+1,end)+sumRange(root.left,start,mid);
        }
    }

    public int sumRange(int i, int j){
        return sumRange(root,i,j);
    }
}
