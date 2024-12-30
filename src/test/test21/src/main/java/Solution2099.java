import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        // 记录数值对应下标
        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            List<Integer> idxList = idxMap.getOrDefault(nums[i], new ArrayList<>());
            idxList.add(i);
            idxMap.put(nums[i], idxList);
        }
        // 排序
        int[] copyNums = nums.clone();
        Arrays.sort(copyNums);
        // 最大 k 个数
        int idx = copyNums.length - 1;
        // 每个数多少次
        Map<Integer, Integer> timesMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int num = copyNums[idx--];
            timesMap.put(num, timesMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> idxList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : timesMap.entrySet()) {
            idxList.addAll(idxMap.get(entry.getKey()).subList(0, entry.getValue()));
        }
        Collections.sort(idxList);
        // 转数组
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[idxList.get(i)];
        }
        return res;
    }
}
/*
2099. 找到和最大的长度为 K 的子序列
https://leetcode.cn/problems/find-subsequence-of-length-k-with-the-largest-sum/

第 67 场双周赛 T1。

给你一个整数数组 nums 和一个整数 k 。你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的 和最大 。
请你返回 任意 一个长度为 k 的整数子序列。
子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。

范围 10^3
时间复杂度 O(nlogn)
排序后取前 k 大的数
 */