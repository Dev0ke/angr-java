import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2007 {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) {
            return new int[0];
        }

        Arrays.sort(changed);
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int x : changed) {
            cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
        }

        List<Integer> resList = new ArrayList<>();
        for (int x : changed) {
            // cntX = 0
            if (!cntMap.containsKey(x)) {
                continue;
            } else if (cntMap.get(x) > cntMap.getOrDefault(x * 2, 0)) {
                return new int[0];
            }

            int cntX = cntMap.get(x);
            // 特判 0
            if (x == 0) {
                if (cntX % 2 == 1) {
                    return new int[0];
                }
                for (int i = 0; i < cntX / 2; i++) {
                    resList.add(x);
                }
                cntMap.remove(x);
                continue;
            }

            for (int i = 0; i < cntX; i++) {
                resList.add(x);
            }
            // cntX2 剩余
            int cntX2 = cntMap.get(x * 2) - cntX;
            cntMap.remove(x);
            if (cntX2 == 0) {
                cntMap.remove(x * 2);
            } else {
                cntMap.put(x * 2, cntX2);
            }
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
2007. 从双倍数组中还原原数组
https://leetcode.cn/problems/find-original-array-from-doubled-array/

第 61 场双周赛 T2。

一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱 。
给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 任意 顺序返回。
提示：
1 <= changed.length <= 10^5
0 <= changed[i] <= 10^5

排序后，从最小的数开始，除 0 外，最小的数必然不是双倍数。
时间复杂度 O(nlogn)
 */