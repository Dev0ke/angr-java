import java.util.Arrays;

public class Solution1648 {
    private static final int MOD = (int) (1e9 + 7);

    public int maxProfit(int[] inventory, int orders) {
        int len = inventory.length;
        Arrays.sort(inventory);

        long sum = 0;
        // 贪心 数目多到少
        for (int i = len - 1; i >= 0; i--) {
            // 宽度（每次+1）
            long width = len - i;
            // 高度差
            long height = (i - 1 >= 0) ? (inventory[i] - inventory[i - 1]) : inventory[i];
            if (inventory[i] > 0) {
                // 可消耗掉的高度
                long costHeight = Math.min(height, orders / width);
                if (costHeight > 0) {
                    // 等差数列求和 (首项+末项)*项数/2
                    long total = ((inventory[i] + (inventory[i] - costHeight + 1)) * costHeight / 2) * width % MOD;
                    sum = (sum + total) % MOD;
                    // 消耗掉的总数
                    orders -= costHeight * width;
                    inventory[i] -= costHeight;
                }
                // 处理余数
                if (orders / width < 1) {
                    sum = (sum + (long) inventory[i] * orders % MOD) % MOD;
                    break;
                }
            } else {
                break;
            }
        }
        return (int) sum;
    }

    static class V2 {
        private static final int MOD = (int) (1e9 + 7);

        public int maxProfit(int[] inventory, int orders) {
            long tot = 0;
            for (int v : inventory) {
                tot += f(v);
            }
            long remain = tot;

            reverseSort(inventory);
            for (int i = 0; ; i++) {
                int j = i + 1;
                long v = inventory[i], c = j * (v - (j == inventory.length ? 0 : inventory[j]));
                remain -= f(v);
                if (c < orders) {
                    orders -= c;
                    continue;
                }
                v -= orders / j;
                remain += (orders % j) * f(v - 1) + (j - orders % j) * f(v);
                long ans = (tot - remain) % MOD;
                return (int) ans;
            }
        }

        // 等差数列求和 (首项+末项)*项数/2
        private long f(long x) {
            return x * (x + 1) / 2;
        }

        private void reverseSort(int[] nums) {
            Arrays.sort(nums);
            for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
    }
}
/*
1648. 销售价值减少的颜色球
https://leetcode.cn/problems/sell-diminishing-valued-colored-balls/

你有一些球的库存 inventory ，里面包含着不同颜色的球。一个顾客想要 任意颜色 总数为 orders 的球。
这位顾客有一种特殊的方式衡量球的价值：每个球的价值是目前剩下的 同色球 的数目。比方说还剩下 6 个黄球，那么顾客买第一个黄球的时候该黄球的价值为 6 。
这笔交易以后，只剩下 5 个黄球了，所以下一个黄球的价值为 5 （也就是球的价值随着顾客购买同色球是递减的）
给你整数数组 inventory ，其中 inventory[i] 表示第 i 种颜色球一开始的数目。同时给你整数 orders ，表示顾客总共想买的球数目。你可以按照 任意顺序 卖球。
请你返回卖了 orders 个球以后 最大 总价值之和。由于答案可能会很大，请你返回答案对 10^9 + 7 取余数 的结果。
提示：
1 <= inventory.length <= 10^5
1 <= inventory[i] <= 10^9
1 <= orders <= min(sum(inventory[i]), 10^9)

贪心。排序后模拟。
时间复杂度 O(nlogn)
空间复杂度 O(1)
相似题目: 2333. 最小差值平方和
https://leetcode.cn/problems/minimum-sum-of-squared-difference/
 */