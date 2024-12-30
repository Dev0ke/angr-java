import java.util.ArrayList;
import java.util.List;

public class Solution2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> resList = new ArrayList<>();
        if (finalSum % 2 == 1) {
            return resList;
        }
        for (long i = 2; i < finalSum; i += 2) {
            if (finalSum - i > i) {
                resList.add(i);
                finalSum -= i;
            } else {
                break;
            }
        }
        resList.add(finalSum);
        return resList;
    }
}
/*
2178. 拆分成最多数目的偶整数之和
https://leetcode.cn/problems/maximum-split-of-positive-even-integers/

第 72 场双周赛 T3。

给你一个整数 finalSum 。请你将它拆分成若干个 互不相同 的偶整数之和，且拆分出来的偶整数数目 最多 。
- 比方说，给你 finalSum = 12 ，那么这些拆分是 符合要求 的（互不相同的偶整数且和为 finalSum）：(2 + 10) ，(2 + 4 + 6) 和 (4 + 8) 。
它们中，(2 + 4 + 6) 包含最多数目的整数。注意 finalSum 不能拆分成 (2 + 2 + 4 + 4) ，因为拆分出来的整数必须互不相同。
请你返回一个整数数组，表示将整数拆分成 最多 数目的偶整数数组。如果没有办法将 finalSum 进行拆分，请你返回一个 空 数组。你可以按 任意 顺序返回这些整数。
提示：
1 <= finalSum <= 10^10

贪心，从最小的偶数开始尝试拆分。
 */