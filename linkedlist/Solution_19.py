#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
from linkedlist.listNode import ListNode
'''
19. Remove Nth Node From End of List   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 148436
Total Submissions: 464765
Difficulty: Easy
Contributors: Admin
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
'''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):

    # 使用双指针
    # 快慢指针被人同样被称为快慢指针
    # 31.01%
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        tail = head
        head_pre = ListNode(0)
        head_pre.next = head
        pre = head_pre
        n -= 1
        while n > 0:
            tail = tail.next
            n -= 1
        while tail.next:
            pre = pre.next
            tail = tail.next
        # 删除pre下一个节点
        pre.next = pre.next.next
        return head_pre.next

    def stefanPochmann(self, head, n):
        '''

        :param head:
        :param n:
        :return:
        '''
