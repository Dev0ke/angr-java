import java.util.Arrays;

public class Solution2974 {
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i += 2) {
            int tmp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = tmp;
        }
        return nums;
    }
}
/*
2974. 最小数字游戏
https://leetcode.cn/problems/minimum-number-game/description/

第 377 场周赛 T1。

你有一个下标从 0 开始、长度为 偶数 的整数数组 nums ，同时还有一个空数组 arr 。Alice 和 Bob 决定玩一个游戏，游戏中每一轮 Alice 和 Bob 都会各自执行一次操作。游戏规则如下：
- 每一轮，Alice 先从 nums 中移除一个 最小 元素，然后 Bob 执行同样的操作。
- 接着，Bob 会将移除的元素添加到数组 arr 中，然后 Alice 也执行同样的操作。
- 游戏持续进行，直到 nums 变为空。
返回结果数组 arr 。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100
nums.length % 2 == 0

模拟。排序 + 枚举。
时间复杂度 O(nlogn)
 */