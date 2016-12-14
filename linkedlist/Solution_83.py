#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
from linkedlist.listNode import ListNode

'''
83. Remove Duplicates from Sorted List   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 153073
Total Submissions: 396107
Difficulty: Easy
Contributors: Admin
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

'''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):

    # 68.25%
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return head

        res = ListNode(head.val)
        curr = res
        curr_val = head.val
        head = head.next
        while head:
            if head.val != curr_val:
                curr.next = ListNode(head.val)
                curr = curr.next
                curr_val = head.val
            head = head.next
        return res

    def recursionDelete(self, head):
        if not head:
            return head
        curr = head.next
        while curr and curr.val == head.val:
            curr = curr.next
        head.next = self.recursionDelete(curr)
        return head

