package bupt.wxy.dfs.wonderful;

/**
 * Created by xiyuanbupt on 1/6/17.
 109. Convert Sorted List to Binary Search Tree
 Difficulty: Medium

 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedListToBinarySearchTree {

    // 还有一种特别聪明的办法
    ListNode curr;
    public TreeNode sortedListToBST(ListNode node){
        int len=0;
        curr=node;
        while (node!=null){
            node=node.next;
            len++;
        }
        return inorderHelper(0, len-1);
    }

    // 参数范围, 规定能从链表中取多少个元素
    TreeNode inorderHelper(int start, int end){
        if(start>end)return null;
        int mid=start+(end-start)/2;
        TreeNode left=inorderHelper(start,mid-1);
        TreeNode treeNode=new TreeNode(curr.val);
        treeNode.left=left;
        curr=curr.next;

        treeNode.right=inorderHelper(mid+1,end);
        return treeNode;
    }

    // 下面是自己想出的算法,但是题目为什么不问ArrayList TO binaryTree?
    // 9.46%
    public TreeNode sortedListToBSTbad(ListNode head) {
        int len=0;
        ListNode curr=head;
        while (curr!=null){
            len++;
            curr=curr.next;
        }
        int[] nums=new int[len];
        curr=head;
        int i=0;
        while (curr!=null){
            nums[i++]=curr.val;
            curr=curr.next;
        }
        return build(nums, 0, nums.length);
    }

    TreeNode build(int[] nums, int start, int end){
        if(start>=end)return null;
        int mid=start+(end-start)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=build(nums,start,mid);
        node.right=build(nums,mid+1,end);
        return node;
    }

    public TreeNode sortedListToBSTuseList(ListNode head){
        if(head==null)return null;
        return build(head, null);
    }

    // 50.86%
    TreeNode build(ListNode head, ListNode tail){
        if(head==tail)return null;
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=tail&&fast.next!=tail){
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode node=new TreeNode(slow.val);
        node.left=build(head,slow);
        node.right=build(slow.next,tail);
        return node;
    }


}
