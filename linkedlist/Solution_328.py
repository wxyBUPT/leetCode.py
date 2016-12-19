#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
from listNode import ListNode

'''
328. Odd Even Linked List   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 52541
Total Submissions: 126527
Difficulty: Medium
Contributors: Admin
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
'''

 # Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):

    # 41.61%
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        odd_curr = ListNode(0)
        even_curr = ListNode(0)
        odd_pre = odd_curr
        even_pre = even_curr
        odd = True
        while head:
            if odd:
                odd = not odd
                odd_curr.next = head
                odd_curr = head
            else:
                odd = not odd
                even_curr.next = head
                even_curr = head
            head = head.next
        odd_curr.next = even_pre.next
        even_curr.next = None
        return odd_pre.next

