import java.util.HashMap;
import java.util.Map;

public class SolutionP2107 {
    public int shareCandies(int[] candies, int k) {
        int n = candies.length;
        int cnt_unique = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        // 总的
        for (int v : candies) {
            if (cnt.merge(v, 1, Integer::sum) == 1) cnt_unique++;
        }

        // 减去窗口里的
        for (int i = 0; i < k; i++) {
            if (cnt.merge(candies[i], -1, Integer::sum) == 0) cnt_unique--;
        }
        int ans = cnt_unique;
        for (int i = k; i < n; i++) {
            if (cnt.merge(candies[i], -1, Integer::sum) == 0) cnt_unique--;
            if (cnt.merge(candies[i - k], 1, Integer::sum) == 1) cnt_unique++;
            ans = Math.max(ans, cnt_unique);
        }
        return ans;
    }
}
/*
$2107. 分享 K 个糖果后独特口味的数量
https://leetcode.cn/problems/number-of-unique-flavors-after-sharing-k-candies/description/

您将获得一个 从0开始的 整数数组 candies ，其中 `candies[i]`表示第 i 个糖果的味道。你妈妈想让你和你妹妹分享这些糖果，给她 k 个 连续 的糖果，但你想保留尽可能多的糖果口味。
在与妹妹分享后，返回 最多 可保留的 独特 口味的糖果。
提示:
1 <= candies.length <= 10^5
1 <= candies[i] <= 10^5
0 <= k <= candies.length

定长滑动窗口。
时间复杂度 O(n)。
 */