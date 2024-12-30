import java.util.Arrays;

public class Solution2952 {
    public int minimumAddedCoins(int[] coins, int target) {
        int ans = 0;
        Arrays.sort(coins);
        int j = 0, x = 1;
        while (x <= target) {
            if (j < coins.length && coins[j] <= x) {
                x += coins[j];
                j++;
            } else {
                x += x;
                ans++;
            }
        }
        return ans;
    }
}
/*
2952. 需要添加的硬币的最小数量
https://leetcode.cn/problems/minimum-number-of-coins-to-be-added/description/

第 374 场周赛 T2。

给你一个下标从 0 开始的整数数组 coins，表示可用的硬币的面值，以及一个整数 target 。
如果存在某个 coins 的子序列总和为 x，那么整数 x 就是一个 可取得的金额 。
返回需要添加到数组中的 任意面值 硬币的 最小数量 ，使范围 [1, target] 内的每个整数都属于 可取得的金额 。
数组的 子序列 是通过删除原始数组的一些（可能不删除）元素而形成的新的 非空 数组，删除过程不会改变剩余元素的相对位置。
提示：
1 <= target <= 10^5
1 <= coins.length <= 10^5
1 <= coins[i] <= target

贪心。
时间复杂度 O(nlogn + log(target))
相似题目: 330. 按要求补齐数组
https://leetcode.cn/problems/patching-array/description/
 */