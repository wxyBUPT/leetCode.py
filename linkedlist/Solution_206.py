#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
from linkedlist.listNode import ListNode

'''
206. Reverse Linked List   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 171302
Total Submissions: 397055
Difficulty: Easy
Contributors: Admin
Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?

Subscribe to see which companies asked this question
'''


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):

    # 这个算法的执行时间排在最后
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return head
        pre = head
        curr = head.next
        head.next = None
        while curr :
            tmp = curr.next
            curr.next = pre
            pre = curr
            curr = tmp
        return pre

    # 67.47%
    def reverseList2(self, head):
        next = None
        while head:
            head.next, head, next = next, head.next, head
        return next
