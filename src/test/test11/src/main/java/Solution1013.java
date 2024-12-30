import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution1013 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int len = arr.length;

        int sum = 0;
        Map<Integer, LinkedList<Integer>> preSumIdxListMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            sum += arr[i];
            preSumIdxListMap.computeIfAbsent(sum, key -> new LinkedList<>()).add(i);
        }

        if (sum % 3 != 0) {
            return false;
        }
        // 特判 0 [0,0,0,0] [1,-1,1,-1]
        if (sum == 0 && preSumIdxListMap.get(sum).size() < 3) {
            return false;
        }
        int partitionSum = sum / 3;
        if (!preSumIdxListMap.containsKey(partitionSum) || !preSumIdxListMap.containsKey(partitionSum * 2)) {
            return false;
        }
        int i = preSumIdxListMap.get(partitionSum).getFirst();
        int j = preSumIdxListMap.get(partitionSum * 2).getLast();
        return i < j;
    }
}
/*
1013. 将数组分成和相等的三个部分
https://leetcode.cn/problems/partition-array-into-three-parts-with-equal-sum/

给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。
形式上，如果可以找出索引 i + 1 < j 且满足
(arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1]) 就可以将数组三等分。
提示：
3 <= arr.length <= 5 * 10^4
-10^4 <= arr[i] <= 10^4

前缀和 + 哈希表
 */