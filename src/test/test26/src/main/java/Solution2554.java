import java.util.HashSet;
import java.util.Set;

public class Solution2554 {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> banSet = new HashSet<>();
        for (int x : banned) {
            banSet.add(x);
        }
        int cnt = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (banSet.contains(i)) {
                continue;
            }
            if (sum + i <= maxSum) {
                sum += i;
                cnt++;
            }
        }
        return cnt;
    }
}
/*
2554. 从一个范围内选择最多整数 I
https://leetcode.cn/problems/maximum-number-of-integers-to-choose-from-a-range-i/

第 97 场双周赛 T2。

给你一个整数数组 banned 和两个整数 n 和 maxSum 。你需要按照以下规则选择一些整数：
- 被选择整数的范围是 [1, n] 。
- 每个整数 至多 选择 一次 。
- 被选择整数不能在数组 banned 中。
- 被选择整数的和不超过 maxSum 。
请你返回按照上述规则 最多 可以选择的整数数目。
提示：
1 <= banned.length <= 10^4
1 <= banned[i], n <= 10^4
1 <= maxSum <= 10^9

贪心/集合
由小到大枚举。
相似题目: $2557. 从一个范围内选择最多整数 II
https://leetcode.cn/problems/maximum-number-of-integers-to-choose-from-a-range-ii/description/
 */