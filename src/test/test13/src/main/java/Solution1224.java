import java.util.HashMap;
import java.util.Map;

public class Solution1224 {
    public int maxEqualFreq(int[] nums) {
        // num, cnt
        Map<Integer, Integer> cntMap = new HashMap<>();
        // cnt, freq
        Map<Integer, Integer> freqMap = new HashMap<>();

        int res = 0;
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            // 旧频次 -1
            int freq = cntMap.getOrDefault(nums[i], 0);
            if (freq > 0) {
                freqMap.put(freq, freqMap.get(freq) - 1);
            }
            // 新频次 +1
            freq++;
            cntMap.put(nums[i], freq);
            maxFreq = Math.max(maxFreq, freq);
            freqMap.put(freq, freqMap.getOrDefault(freq, 0) + 1);

            // case1: 所有数都出现 1 次，随便删一个
            // case2: 最大出现次数 maxFreq = 1，其余均为 maxFreq-1
            // case3: 除了某个数 x，其余均为 maxFreq，x 次数为 1
            if (maxFreq == 1
                    || freqMap.get(maxFreq) * maxFreq + freqMap.get(maxFreq - 1) * (maxFreq - 1) == i + 1 && freqMap.get(maxFreq) == 1
                    || freqMap.get(maxFreq) * maxFreq + 1 == i + 1 && freqMap.get(1) == 1) {
                res = Math.max(res, i + 1);
            }
        }
        return res;
    }
}
/*
1224. 最大相等频率
https://leetcode.cn/problems/maximum-equal-frequency/

给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
- 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。
如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
提示：
2 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

HashMap统计频次，分类讨论
 */