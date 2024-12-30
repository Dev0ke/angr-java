import java.util.ArrayList;
import java.util.List;

public class Solution2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] L = new int[n];
        int[] R = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                L[i] = L[i - 1] + 1;
            }
            if (security[n - i - 1] <= security[n - i]) {
                R[n - i - 1] = R[n - i] + 1;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = time; i + time < n; i++) {
            if (L[i] >= time && R[i] >= time) {
                ans.add(i);
            }
        }
        return ans;
    }
}
/*
2100. 适合打劫银行的日子
https://leetcode.cn/problems/find-good-days-to-rob-the-bank/

第 67 场双周赛 T2。

你和一群强盗准备打劫银行。给你一个下标从 0 开始的整数数组 security ，其中 security[i] 是第 i 天执勤警卫的数量。
日子从 0 开始编号。同时给你一个整数 time 。
如果第 i 天满足以下所有条件，我们称它为一个适合打劫银行的日子：
- 第 i 天前和后都分别至少有 time 天。
- 第 i 天前连续 time 天警卫数目都是非递增的。
- 第 i 天后连续 time 天警卫数目都是非递减的。
更正式的，第 i 天是一个合适打劫银行的日子当且仅当：
security[i - time] >= security[i - time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= security[i + time].
请你返回一个数组，包含 所有 适合打劫银行的日子（下标从 0 开始）。返回的日子可以 任意 顺序排列。
提示：
1 <= security.length <= 10^5
0 <= security[i], time <= 10^5

前后缀分解。
时间复杂度 O(n)。
 */