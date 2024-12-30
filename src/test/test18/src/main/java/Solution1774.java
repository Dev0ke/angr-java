import java.util.Arrays;

public class Solution1774 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int min = Arrays.stream(baseCosts).min().orElseThrow();
        if (min >= target) {
            return min;
        }

        boolean[] can = new boolean[target + 1];
        int res = 2 * target - min;
        for (int base : baseCosts) {
            if (base <= target) {
                can[base] = true;
            } else {
                res = Math.min(res, base);
            }
        }

        // 0-1 背包
        for (int topping : toppingCosts) {
            // 最多选 2 次
            for (int count = 0; count < 2; count++) {
                for (int i = target; i > 0; i--) {
                    if (can[i] && i + topping > target) {
                        res = Math.min(res, i + topping);
                    }
                    if (i - topping > 0) {
                        can[i] = can[i] | can[i - topping];
                    }
                }
            }
        }
        for (int i = 0; i <= res - target; i++) {
            if (can[target - i]) {
                return target - i;
            }
        }
        return res;
    }
}
/*
1774. 最接近目标价格的甜点成本
https://leetcode.cn/problems/closest-dessert-cost/

你打算做甜点，现在需要购买配料。目前共有 n 种冰激凌基料和 m 种配料可供选购。而制作甜点需要遵循以下几条规则：
- 必须选择 一种 冰激凌基料。
- 可以添加 一种或多种 配料，也可以不添加任何配料。
- 每种类型的配料 最多两份 。
给你以下三个输入：
- baseCosts ，一个长度为 n 的整数数组，其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格。
- toppingCosts，一个长度为 m 的整数数组，其中每个 toppingCosts[i] 表示 一份 第 i 种冰激凌配料的价格。
- target ，一个整数，表示你制作甜点的目标价格。
你希望自己做的甜点总成本尽可能接近目标价格 target 。
返回最接近 target 的甜点成本。如果有多种方案，返回 成本相对较低 的一种。
提示：
n == baseCosts.length
m == toppingCosts.length
1 <= n, m <= 10
1 <= baseCosts[i], toppingCosts[i] <= 10^4
1 <= target <= 10^4

动态规划。0-1 背包
时间复杂度 O(target * m)
空间复杂度 O(target)
 */