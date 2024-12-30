import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int ar : arr) {
            cntMap.put(ar, cntMap.getOrDefault(ar, 0) + 1);
        }
        List<Integer> cntList = cntMap.values().stream().sorted().toList();
        int size = cntList.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (sum + cntList.get(i) <= k) {
                sum += cntList.get(i);
            } else {
                return size - i;
            }
        }
        return 0;
    }
}
/*
1481. 不同整数的最少数目
https://leetcode.cn/problems/least-number-of-unique-integers-after-k-removals/

给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
提示：
1 <= arr.length <= 10^5
1 <= arr[i] <= 10^9
0 <= k <= arr.length

贪心，优先移除频次低的元素。
 */