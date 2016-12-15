#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
141. Linked List Cycle   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 146682
Total Submissions: 408657
Difficulty: Easy
Contributors: Admin
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

Subscribe to see which companies asked this question
'''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):

    # 97.03%
    def hasCycle2(self, head):
        if not head:
            return False
        fast = head
        slow = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        return False


    # 使用快慢指针，如果两个指针能够相遇
    # 85.52%
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        fast = head
        slow = head
        while fast and slow:
            slow = slow.next
            if not slow:
                return False
            if fast.next:
                fast = fast.next.next
            else:
                fast = None
            if fast == slow:
                return True
        return False

    def stefanPochmann(self, head):
        try:
            slow = head
            fast = head.next
            while slow is not fast:
                slow = slow.next
                fast = fast.next.next
            return True
        except:
            return False
