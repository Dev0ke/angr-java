public class Solution551 {
    public boolean checkRecord(String s) {
        int cntA = 0;
        // 连续 L 最大天数
        int cntL = 0;
        int maxL = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'L') {
                cntL++;
            } else {
                maxL = Math.max(maxL, cntL);
                cntL = 0;
            }
            if (ch == 'A') {
                cntA++;
            }
        }
        maxL = Math.max(maxL, cntL);
        return cntA < 2 && maxL < 3;
    }
}
/*
551. 学生出勤记录 I
https://leetcode.cn/problems/student-attendance-record-i/

给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
- 'A'：Absent，缺勤
- 'L'：Late，迟到
- 'P'：Present，到场
如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
- 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
- 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
提示：
1 <= s.length <= 1000
s[i] 为 'A'、'L' 或 'P'

贪心。一次遍历
 */