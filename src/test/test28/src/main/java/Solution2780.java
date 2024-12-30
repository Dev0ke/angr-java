import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2780 {
    public int minimumIndex(List<Integer> nums) {
        // 找出支配元素 x, 数据保证它含有一个支配元素
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (Integer x : nums) {
            cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
        }
        int maxFreq = 0, x = -1;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int k = entry.getKey(), freq = entry.getValue();
            if (maxFreq < freq) {
                maxFreq = freq;
                x = k;
            }
        }

        // 前缀和
        int n = nums.size();
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + (nums.get(i) == x ? 1 : 0);
        }

        // 枚举分割点 [0,i] [i+1,n-1]
        for (int i = 0; i < n; i++) {
            int leftFreq = preSum[i + 1];
            int rightFreq = preSum[n] - preSum[i + 1];
            int leftLen = i + 1;
            int rightLen = n - leftLen;
            if (leftFreq * 2 > leftLen && rightFreq * 2 > rightLen) {
                return i;
            }
        }
        return -1;
    }
}
/*
2780. 合法分割的最小下标
https://leetcode.cn/problems/minimum-index-of-a-valid-split/

第 354 场周赛 T3。

如果元素 x 在长度为 m 的整数数组 arr 中满足 freq(x) * 2 > m ，那么我们称 x 是 支配元素 。其中 freq(x) 是 x 在数组 arr 中出现的次数。注意，根据这个定义，数组 arr 最多 只会有 一个 支配元素。
给你一个下标从 0 开始长度为 n 的整数数组 nums ，数据保证它含有一个支配元素。
你需要在下标 i 处将 nums 分割成两个数组 nums[0, ..., i] 和 nums[i + 1, ..., n - 1] ，如果一个分割满足以下条件，我们称它是 合法 的：
- 0 <= i < n - 1
- nums[0, ..., i] 和 nums[i + 1, ..., n - 1] 的支配元素相同。
这里， nums[i, ..., j] 表示 nums 的一个子数组，它开始于下标 i ，结束于下标 j ，两个端点都包含在子数组内。特别地，如果 j < i ，那么 nums[i, ..., j] 表示一个空数组。
请你返回一个 合法分割 的 最小 下标。如果合法分割不存在，返回 -1 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
nums 有且只有一个支配元素。

模拟。枚举。
先 找出支配元素 x
然后结合前缀和枚举分割点
时间复杂度 O(n)
 */