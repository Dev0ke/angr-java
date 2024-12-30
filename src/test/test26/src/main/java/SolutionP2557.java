import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionP2557 {
    public int maxCount(int[] banned, int n, long maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int num : banned) {
            set.add(num);
        }
        List<Integer> ban = new ArrayList<>();
        ban.add(0);
        ban.addAll(set);
        ban.add(n + 1);
        Collections.sort(ban);

        int ans = 0;
        for (int j = 1; j < ban.size(); j++) {
            long first = ban.get(j - 1) + 1;
            int cnt = ban.get(j) - ban.get(j - 1) - 1;
            long sm = first * cnt + cnt * (cnt - 1L) / 2;
            if (sm < maxSum) {
                maxSum -= sm;
                ans += cnt;
            } else {
                return ans + (int) (0.5 - first + Math.sqrt(first * (first - 1) + 2 * maxSum + 0.25));
            }
        }
        return ans;
    }
}
/*
$2557. 从一个范围内选择最多整数 II
https://leetcode.cn/problems/maximum-number-of-integers-to-choose-from-a-range-ii/description/

给你一个整数数组 banned 和两个整数 n 和 maxSum 。你需要按照以下规则选择一些整数：
- 被选择整数的范围是 [1, n] 。
- 每个整数 至多 选择 一次 。
- 被选择整数不能在数组 banned 中。
- 被选择整数的和不超过 maxSum 。
请你返回按照上述规则 最多 可以选择的整数数目。
提示：
1 <= banned.length <= 10^5
1 <= banned[i] <= n <= 10^9
1 <= maxSum <= 10^15

不用二分猜答案的做法，借助二次方程求根公式。
https://leetcode.cn/problems/maximum-number-of-integers-to-choose-from-a-range-ii/solutions/2112386/bu-yong-er-fen-cai-da-an-de-zuo-fa-jie-z-upuq/
相似题目: 2554. 从一个范围内选择最多整数 I
https://leetcode.cn/problems/maximum-number-of-integers-to-choose-from-a-range-i/
 */