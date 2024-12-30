import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2121 {
    // 时间复杂度 O(n)
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        // val -> [idx]
        Map<Integer, List<Integer>> idsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idsMap.computeIfAbsent(arr[i], key -> new ArrayList<>()).add(i);
        }

        long[] res = new long[n];
        for (List<Integer> idList : idsMap.values()) {
            int sz = idList.size();
            // 从左到右
            long[] leftRes = new long[sz];
            for (int i = 1; i < sz; i++) {
                leftRes[i] = (long) (idList.get(i) - idList.get(i - 1)) * i + leftRes[i - 1];
            }
            // 从右到左
            long[] rightRes = new long[sz];
            for (int i = sz - 2; i >= 0; i--) {
                rightRes[i] = (long) (idList.get(i + 1) - idList.get(i)) * (sz - 1 - i) + rightRes[i + 1];
            }
            // 合并
            for (int i = 0; i < sz; i++) {
                int id = idList.get(i);
                res[id] = leftRes[i] + rightRes[i];
            }
        }
        return res;
    }

    // 时间复杂度 O(n^2)
    public long[] getDistances2(int[] arr) {
        Map<Integer, List<Integer>> idxListMap = new HashMap<>();
        // n == arr.length
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            List<Integer> idxList = idxListMap.getOrDefault(arr[i], new ArrayList<>());
            idxList.add(i);
            idxListMap.put(arr[i], idxList);
        }

        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            long sum = 0L;
            List<Integer> idxList = idxListMap.get(arr[i]);
            for (int idx : idxList) {
                sum += Math.abs(i - idx);
            }
            res[i] = sum;
        }
        return res;
    }
}
/*
2121. 相同元素的间隔之和
https://leetcode.cn/problems/intervals-between-identical-elements/

第 273 场周赛 T3。

给你一个下标从 0 开始、由 n 个整数组成的数组 arr 。
arr 中两个元素的 间隔 定义为它们下标之间的 绝对差 。更正式地，arr[i] 和 arr[j] 之间的间隔是 |i - j| 。
返回一个长度为 n 的数组 intervals ，其中 intervals[i] 是 arr[i] 和 arr 中每个相同元素（与 arr[i] 的值相同）的 间隔之和 。
注意：|x| 是 x 的绝对值。
提示：
n == arr.length
1 <= n <= 10^5

范围 10^5
双循环时间复杂度 O(n^2) 的暴力方法显然超时。
需要优化，本题采用前缀和思路。时间复杂度优化到 O(n)
假设某个元素在 arr[] 中对应的下标数组为 idx[]
其值记为: idx[0], idx[1], idx[2], idx[3], idx[4], idx[5]
左=>右 idx[i] 左侧结果记为 leftRes[i]
leftRes[2] = (idx[2] - idx[1]) + (idx[2] - idx[0])
leftRes[3] = (idx[3] - idx[2]) + (idx[3] - idx[1]) + (idx[3] - idx[0])
           = (idx[3] - idx[2]) + ((idx[3] - idx[2]) + (idx[2] - idx[1])) + ((idx[3] - idx[2]) + (idx[2] - idx[0]))
           = (idx[3] - idx[2]) * 3 + leftRes[2]
通项
leftRes[i] = (idx[i] - idx[i-1]) * i + leftRes[i-1]
右=>左 idx[i] 右侧结果记为 rightRes[i]
rightRes[3] = (idx[5] - idx[3]) + (idx[4] - idx[3])
rightRes[2] = (idx[5] - idx[2]) + (idx[4] - idx[2]) + (idx[3] - idx[2])
            = (idx[5] - idx[3] + idx[3] - idx[2]) + (idx[4] - idx[3] + idx[3] - idx[2]) + (idx[3] - idx[2])
            = (idx[4] - idx[3] + idx[3] - idx[2]) + (idx[3] - idx[2])
            = (idx[3] - idx[2]) * 3 + rightRes[3]
通项
rightRes[i] = (idx[i+1] - idx[i]) * (len-1-i) + rightRes[i+1]
合并
res[idx[i]] = leftRes[i] + rightRes[i]
相似题目: 2063. 所有子字符串中的元音
https://leetcode.cn/problems/vowels-of-all-substrings/
 */