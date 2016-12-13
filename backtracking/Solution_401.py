#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com


'''
401. Binary Watch   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 14940
Total Submissions: 34710
Difficulty: Easy
Contributors: Admin
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
'''

class Solution(object):
    def readBinaryWatch(self, num):
        """
        :type num: int
        :rtype: List[str]
        """
        res = []
        for i in range(0, num+1):
            hours = []
            hour_nums = [8, 4, 2, 1]
            self.backtracking(hour_nums, 0, hours, 0, i, 12)

            minutes = []
            minute_nums = [32, 16, 8, 4, 2, 1]
            self.backtracking(minute_nums, 0, minutes, 0, num - i, 60)
            for h in hours:
                for m in minutes:
                    res.append('%d:%02d' % (h, m))
        return res

    def backtracking(self, nums, index, res, curr, remain, limit):
        '''
        :param nums: 候选者
        :param index: 数组值
        :param res: 结果集合
        :param curr: 当前值
        :param limit: 限定的结果
        :return:
        '''
        # 如果选完了
        if remain == 0 :
            if curr < limit:
                res.append(curr)
            return
        # 如果没有选完，但是已经没有候选者了
        if index == len(nums):
            return

        # 选择index的情况
        self.backtracking(nums, index+1, res, curr + nums[index], remain-1, limit)

        # 不选择index
        self.backtracking(nums, index+1, res, curr, remain, limit)

    def stefanPochmann(self, num):
        return [
            '%d:%02d' % (h, m) for h in range(12) for m in range(60) if (bin(h) + bin(m)).count('1') == num
        ]

'''
对应上述的解法，stefanPochmann Java版本为
public List<String> readBinaryWatch(int num){
    List<String> times = new ArrayList<>();
    for(int h = 0; h<12; h++)
        for(int m = 0; m<60; m++){
            if(Integer.bitCount(h * 64 + m) == num)
                time.add(String.format("%d:%02d", h, m));
    return times;
}
'''

if __name__ == "__main__":
    sl = Solution()
    for res in sl.readBinaryWatch(1):
        print res
