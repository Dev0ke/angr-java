public class Solution1598 {
    public int minOperations(String[] logs) {
        int res = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                res = Math.max(0, res - 1);
            } else if (!log.equals("./")) {
                res++;
            }
        }
        return res;
    }
}
/*
1598. 文件夹操作日志搜集器
https://leetcode.cn/problems/crawler-log-folder/

每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。
下面给出对变更操作的说明：
- "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
- "./" ：继续停留在当前文件夹。
- "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。
文件系统启动时位于主文件夹，然后执行 logs 中的操作。
执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。
提示：
1 <= logs.length <= 10^3
2 <= logs[i].length <= 10
logs[i] 包含小写英文字母，数字，'.' 和 '/'
logs[i] 符合语句中描述的格式
文件夹名称由小写英文字母和数字组成

栈思想。
 */