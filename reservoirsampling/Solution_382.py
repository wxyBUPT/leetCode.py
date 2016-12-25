#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import random

'''
382. Linked List Random Node   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 17468
Total Submissions: 37878
Difficulty: Medium
Contributors: Admin
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
'''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class ListNode(object):

    def __init__(self, x):
        self.val = x
        self.next = None

# 先计算随机数避免了对整个链表的遍历
# 另外一种算法见同一包下的另外一个题目
class Solution(object):

    def __init__(self, head):
        """
        @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node.
        :type head: ListNode
        """
        self.head = head
        node = head
        list_len = 0
        while node:
            list_len += 1
            node = node.next
        self.size = list_len

    def getRandom(self):
        """
        Returns a random node's value.
        :rtype: int
        """
        index = random.randint(0, self.size - 1)
        node = self.head
        while index:
            node = node.next
            index -= 1
        return node.val

# Your Solution object will be instantiated and called as such:
# obj = Solution(head)
# param_1 = obj.getRandom()