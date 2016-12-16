#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
from linkedlist.listNode import ListNode

'''
203. Remove Linked List Elements   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 91339
Total Submissions: 296609
Difficulty: Easy
Contributors: Admin
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
'''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):

    # 题目很简单，但是下面的算法 22.21%
    # 算法总是在低端，一时找不到好的方法
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        if not head:
            return head
        head_pre = ListNode(0)
        head_pre.next = head
        pre = head_pre
        curr = head
        while curr:
            if curr.val != val:
                pre = curr
            else:
                pre.next = curr.next
            curr = curr.next
        return head_pre.next

    # 这种方法应该是可行的，但是对于python来说会有maximum recursion depth exceeded
    def removeElementsrecursive(self, head, val):
        if not head:
            return head
        head.next = self.removeElementsrecursive(head.next, val)
        return head if head.val != val else head.next


