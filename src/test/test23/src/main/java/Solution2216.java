public class Solution2216 {
    public int minDeletion(int[] nums) {
        int len = nums.length;

        int idx = 0;
        int cnt = 0;
        while (idx + 1 < len) {
            if (nums[idx] == nums[idx + 1]) {
                idx++;
                cnt++;
            } else {
                idx += 2;
            }
        }
        if (idx == len - 1) {
            return cnt + 1;
        }
        return cnt;
    }
}
/*
2216. 美化数组的最少删除数
https://leetcode.cn/problems/minimum-deletions-to-make-array-beautiful/

第 286 场周赛 T2。

给你一个下标从 0 开始的整数数组 nums ，如果满足下述条件，则认为数组 nums 是一个 美丽数组 ：
- nums.length 为偶数
- 对所有满足 i % 2 == 0 的下标 i ，nums[i] != nums[i + 1] 均成立
注意，空数组同样认为是美丽数组。
你可以从 nums 中删除任意数量的元素。当你删除一个元素时，被删除元素右侧的所有元素将会向左移动一个单位以填补空缺，而左侧的元素将会保持 不变 。
返回使 nums 变为美丽数组所需删除的 最少 元素数目。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5

贪心不会证，想写不敢写？
比赛到40min后，发现T2 2500多人AC了，猜想应该用不到 dp，尝试一下贪心，AC了。。
时间复杂度 O(n)
 */