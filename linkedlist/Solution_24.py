#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
from linkedlist.listNode import ListNode

'''
24. Swap Nodes in Pairs   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 136552
Total Submissions: 369327
Difficulty: Easy
Contributors: Admin
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

Subscribe to see which companies asked this question
'''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):

    # 链表的操作无非就那么几种方法
    # 操作指针，操作值
    # 80.46%
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head

        # 奇数节点
        odd_node = head
        # 偶数节点
        even_node = head.next
        # 创建一个表头

        while even_node:
            tmp = even_node.val
            even_node.val = odd_node.val
            odd_node.val = tmp
            odd_node = even_node.next
            if odd_node:
                even_node = odd_node.next
            else:
                even_node = None
        return head

