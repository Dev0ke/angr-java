import java.util.List;

public class Solution2835 {
    public int minOperations(List<Integer> nums, int target) {
        int[] cnt = new int[32];
        for (Integer num : nums) {
            int bit = Integer.numberOfTrailingZeros(num);
            cnt[bit]++;
        }

        int ans = 0;
        for (int i = 0; i < 31; i++) {
            // 需要消掉这个 2^i
            if ((target >> i & 1) == 1) {
                if (cnt[i] > 0) {
                    cnt[i]--;
                } else {
                    boolean flag = false;
                    // 低位往高位找第 1 个
                    for (int j = i; j < 31; j++) {
                        if (cnt[j] > 0) {
                            flag = true;

                            ans += j - i;
                            cnt[j]--;
                            for (int k = i; k < j; k++) {
                                cnt[k]++;
                            }
                            break;
                        }
                    }
                    if (!flag) {
                        return -1;
                    }
                }
            }
            // 低位合并到高位
            cnt[i + 1] += cnt[i] / 2;
        }
        return ans;
    }
}
/*
2835. 使子序列的和等于目标的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-form-subsequence-with-target-sum/

第 360 场周赛 T3。

给你一个下标从 0 开始的数组 nums ，它包含 非负 整数，且全部为 2 的幂，同时给你一个整数 target 。
一次操作中，你必须对数组做以下修改：
- 选择数组中一个元素 nums[i] ，满足 nums[i] > 1 。
- 将 nums[i] 从数组中删除。
- 在 nums 的 末尾 添加 两个 数，值都为 nums[i] / 2 。
你的目标是让 nums 的一个 子序列 的元素和等于 target ，请你返回达成这一目标的 最少操作次数 。如果无法得到这样的子序列，请你返回 -1 。
数组中一个 子序列 是通过删除原数组中一些元素，并且不改变剩余元素顺序得到的剩余数组。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 2^30
nums 只包含非负整数，且均为 2 的幂。
1 <= target < 2^31

贪心。从低位开始考虑。
 */