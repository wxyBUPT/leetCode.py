#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
# Create at $(date +"%Y-%m-%d")


'''
在包含问题的解空间树种，按照深度优先搜索策略，从根节点出发深度探索解空间树
'''
def backtracking():

    while u'有路可走' and u'未达到目标':
        if u'搜索达到叶子节点':
            u'输出结果'
        else:
            while u'a[i] 在不满足约束':
                u'跳到下一个子啊约束空间内的a[i]'
            if u'a[i] 在搜索空间内':
                u'标识a占用的资源情况'
                u'i+=1'
            else:
                u'清理a[i]占用的资源情况'
