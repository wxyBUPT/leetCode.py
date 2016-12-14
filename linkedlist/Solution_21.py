#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
from linkedlist.listNode import ListNode

'''
21. Merge Two Sorted Lists   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 176842
Total Submissions: 469031
Difficulty: Easy
Contributors: Admin
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Subscribe to see which companies asked this question
'''


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):

    # 48.89%
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        pre = ListNode(0)
        curr = pre
        while l1 and l2:
            if l1.val < l2.val:
                curr.next = l1
                curr = l1
                l1 = l1.next

            else:
                curr.next = l2
                curr = l2
                l2 = l2.next

        while l1:
            curr.next = l1
            curr = l1
            l1 = l1.next

        while l2:
            curr.next = l2
            curr = l2
            l2 = l2.next

        return pre.next

    def recursive(self, l1, l2):

        if not l1:
            return l2

        if not l2:
            return l1

        if l1.val < l2.val:
            l1.next = self.recursive(l1.next, l2)
            return l1

        else:
            l2.next = self.recursive(l1, l2.next)



