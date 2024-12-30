import java.util.TreeMap;

public class Solution1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        if (len % k != 0) {
            return false;
        }
        TreeMap<Integer, Integer> cntTreeMap = new TreeMap<>();
        for (int han : nums) {
            cntTreeMap.put(han, cntTreeMap.getOrDefault(han, 0) + 1);
        }
        while (cntTreeMap.size() > 0) {
            int firstKey = cntTreeMap.firstKey();
            for (int i = firstKey; i < firstKey + k; i++) {
                if (!cntTreeMap.containsKey(i)) {
                    return false;
                }
                int cnt = cntTreeMap.get(i);
                if (cnt == 1) {
                    cntTreeMap.remove(i);
                } else {
                    cntTreeMap.replace(i, cnt - 1);
                }
            }
        }
        return true;
    }
}
/*
1296. 划分数组为连续数字的集合
https://leetcode.cn/problems/divide-array-in-sets-of-k-consecutive-numbers/

第 168 场周赛 T2。

给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
如果可以，请返回 true；否则，返回 false。
提示：
1 <= k <= nums.length <= 10^5
1 <= nums[i] <= 10^9

同: 846. 一手顺子
https://leetcode.cn/problems/hand-of-straights/
 */