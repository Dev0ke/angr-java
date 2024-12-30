import java.util.Arrays;

public class Solution3005 {
    public int maxFrequencyElements(int[] nums) {
        int[] cnt = new int[105];
        for (int v : nums) {
            cnt[v]++;
        }
        int max = Arrays.stream(cnt).max().orElseThrow();
        int c = 0;
        for (int v : cnt) {
            if (v == max) c++;
        }
        return c * max;
    }
}
/*
3005. 最大频率元素计数
https://leetcode.cn/problems/count-elements-with-maximum-frequency/description/

第 380 场周赛 T1。

给你一个由 正整数 组成的数组 nums 。
返回数组 nums 中所有具有 最大 频率的元素的 总频率 。
元素的 频率 是指该元素在数组中出现的次数。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

模拟。
时间复杂度 O(n)。
 */