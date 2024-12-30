import java.util.HashMap;
import java.util.Map;

public class Solution3020 {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        // 特判 1
        int c1 = cnt.getOrDefault(1, 0);
        int ans = (c1 - 1) / 2 * 2 + 1;

        for (int v : nums) {
            if (v == 1) continue;
            for (int i = 0; i <= 5; i++) {
                int k = (int) Math.pow(2, i);
                double pow = Math.pow(v, k);
                if (pow > 1e9) {
                    // 不能取到 i
                    ans = Math.max(ans, i * 2 - 1);
                    break;
                }
                int key = (int) pow;
                Integer j = cnt.getOrDefault(key, 0);
                if (j < 2) {
                    if (j == 1) {
                        ans = Math.max(ans, i * 2 + 1);
                    } else {
                        ans = Math.max(ans, i * 2 - 1);
                    }
                    break;
                }
            }
        }
        return ans;
    }
}
/*
3020. 子集中元素的最大数量
https://leetcode.cn/problems/find-the-maximum-number-of-elements-in-subset/description/

第 382 场周赛 T2。

给你一个 正整数 数组 nums 。
你需要从数组中选出一个满足下述条件的
子集：
- 你可以将选中的元素放置在一个下标从 0 开始的数组中，并使其遵循以下模式：[x, x2, x4, ..., xk/2, xk, xk/2, ..., x4, x2, x]（注意，k 可以是任何 非负 的 2 的幂）。例如，[2, 4, 16, 4, 2] 和 [3, 9, 3] 都符合这一模式，而 [2, 4, 8, 4, 2] 则不符合。
返回满足这些条件的子集中，元素数量的 最大值 。
提示：
2 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

暴力枚举。
时间复杂度 O(nlogU)
 */