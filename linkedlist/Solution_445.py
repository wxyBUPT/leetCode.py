#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
from listNode import ListNode
'''
445. Add Two Numbers II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 4428
Total Submissions: 9978
Difficulty: Medium
Contributors: Admin
You are given two linked lists representing two non-negative numbers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
'''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):

    # 92.38%
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        val_1 = 0
        while l1:
            val_1 = val_1*10 + l1.val
            l1 = l1.next
        val_2 = 0
        while l2:
            val_2 = val_2*10 + l2.val
            l2 = l2.next
        total = val_1 + val_2
        head = ListNode(0)
        while total:
            node = ListNode(total%10)
            node.next = head.next
            head.next = node
            total /= 10
        return head.next or ListNode(0)
