#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
160. Intersection of Two Linked Lists   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 103575
Total Submissions: 345593
Difficulty: Easy
Contributors: Admin
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
'''
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):

    # 两种方法
    def getIntersectionNode(self, headA, headB):
        if not headA or not headB:
            return None

        pa = headA
        pb = headB
        # 相交也是在None的地方相交，走过的距离都是一样的
        while pa is not pb:
            pa = headB if pa is None else pa.next
            pb = headA if pb is None else pb.next
        return pa



    # 但是不是好的方法
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if not headA or not headB:
            return None
        lenA = 0
        lenB = 0
        a = headA
        while a:
            lenA += 1
            a = a.next
        b = headB
        while b:
            lenB += 1
            b = b.next
        a = headA
        b = headB
        while lenB > lenA:
            b = b.next
            lenB -= 1
        while lenA > lenB:
            a = a.next
            lenA -= 1
        while a and b:
            if a == b:
                return a
            a = a.next
            b = b.next
        return None


