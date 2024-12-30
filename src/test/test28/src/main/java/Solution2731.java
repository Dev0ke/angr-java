import java.util.Arrays;

public class Solution2731 {
    private static final int MOD = (int) (1e9 + 7);

    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i] + (s.charAt(i) == 'R' ? d : -d);
        }

        Arrays.sort(arr);
        long ans = 0L;
        for (int i = 1; i < n; i++) {
            long d1 = arr[i] - arr[i - 1];
            ans = (ans + d1 * (i) % MOD * (n - i) % MOD) % MOD;
        }
        return (int) ans;
    }
}
/*
2731. 移动机器人
https://leetcode.cn/problems/movement-of-robots/

第 106 场双周赛 T3。

有一些机器人分布在一条无限长的数轴上，他们初始坐标用一个下标从 0 开始的整数数组 nums 表示。当你给机器人下达命令时，它们以每秒钟一单位的速度开始移动。
给你一个字符串 s ，每个字符按顺序分别表示每个机器人移动的方向。'L' 表示机器人往左或者数轴的负方向移动，'R' 表示机器人往右或者数轴的正方向移动。
当两个机器人相撞时，它们开始沿着原本相反的方向移动。
请你返回指令重复执行 d 秒后，所有机器人之间两两距离之和。由于答案可能很大，请你将答案对 10^9 + 7 取余后返回。
注意：
- 对于坐标在 i 和 j 的两个机器人，(i,j) 和 (j,i) 视为相同的坐标对。也就是说，机器人视为无差别的。
- 当机器人相撞时，它们 立即改变 它们的前进时间，这个过程不消耗任何时间。
- 当两个机器人在同一时刻占据相同的位置时，就会相撞。
  - 例如，如果一个机器人位于位置 0 并往右移动，另一个机器人位于位置 2 并往左移动，下一秒，它们都将占据位置 1，并改变方向。再下一秒钟后，第一个机器人位于位置 0 并往左移动，而另一个机器人位于位置 2 并往右移动。
  - 例如，如果一个机器人位于位置 0 并往右移动，另一个机器人位于位置 1 并往左移动，下一秒，第一个机器人位于位置 0 并往左行驶，而另一个机器人位于位置 1 并往右移动。
提示：
2 <= nums.length <= 10^5
-2 * 10^9 <= nums[i] <= 2 * 10^9
0 <= d <= 10^9
nums.length == s.length 
s 只包含 'L' 和 'R' 。
nums[i] 互不相同。

两个机器人相撞时，可以看成他们彼此擦肩而过，因此直接加 d 即可。
时间复杂度 O(n)
相似题目: 1503. 所有蚂蚁掉下来前的最后一刻
https://leetcode.cn/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 */