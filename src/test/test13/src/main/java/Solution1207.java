import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : arr) {
            cnt.merge(v, 1, Integer::sum);
        }
        List<Integer> vals = cnt.values().stream().toList();
        long distinct = vals.stream().distinct().count();
        return distinct == vals.size();
    }
}
/*
1207. 独一无二的出现次数
https://leetcode.cn/problems/unique-number-of-occurrences/description/

给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
提示：
1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000

哈希表 去重。
时间复杂度 O(n)。
 */