public class Solution2011 {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String operation : operations) {
            if (operation.equals("++X") || operation.equals("X++")) {
                res++;
            } else {
                res--;
            }
        }
        return res;
    }
}
/*
2011. 执行操作后的变量值
https://leetcode.cn/problems/final-value-of-variable-after-performing-operations/

第 259 场周赛 T1。

存在一种仅支持 4 种操作和 1 个变量 X 的编程语言：
- ++X 和 X++ 使变量 X 的值 加 1
- --X 和 X-- 使变量 X 的值 减 1
最初，X 的值是 0
给你一个字符串数组 operations ，这是由操作组成的一个列表，返回执行所有操作后， X 的 最终值 。

模拟。
 */