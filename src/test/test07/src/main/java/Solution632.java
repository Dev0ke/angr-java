import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int M = nums.size();

        // nums[i][j] => i[]
        TreeMap<Integer, List<Integer>> idxTreeMap = new TreeMap<>();
        for (int i = 0; i < M; i++) {
            for (int num : nums.get(i)) {
                idxTreeMap.computeIfAbsent(num, key -> new ArrayList<>()).add(i);
            }
        }
        // 最大最小
        int min = idxTreeMap.firstKey();
        int max = idxTreeMap.lastKey();

        // 滑动窗口
        Integer left = min;
        Integer right = min - 1;

        int[] cntIdx = new int[M];
        int cnt = 0;

        int ansLeft = min;
        int ansRight = max;
        while (right < max) {
            // 右指针右移
            right = idxTreeMap.higherKey(right);
            if (right == null) {
                break;
            }
            for (int idx : idxTreeMap.get(right)) {
                cntIdx[idx]++;
                if (cntIdx[idx] == 1) {
                    cnt++;
                }
            }

            while (cnt == M) {
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }
                for (int idx : idxTreeMap.get(left)) {
                    cntIdx[idx]--;
                    if (cntIdx[idx] == 0) {
                        cnt--;
                    }
                }
                // 左指针右移
                left = idxTreeMap.higherKey(left);
                if (left == null) {
                    return new int[]{ansLeft, ansRight};
                }
            }
        }
        return new int[]{ansLeft, ansRight};
    }
}
/*
632. 最小区间
https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/

你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
提示：
nums.length == k
1 <= k <= 3500
1 <= nums[i].length <= 50
-10^5 <= nums[i][j] <= 10^5
nums[i] 按非递减顺序排列

滑动窗口
注意值域是离散的，使用 TreeMap 使其升序排序，并且用 higherKey 模拟离散化跳跃到下一个节点。
时间复杂度 O(nklogk)
空间复杂度 O(k)
相似题目: 76. 最小覆盖子串
https://leetcode.cn/problems/minimum-window-substring/
 */