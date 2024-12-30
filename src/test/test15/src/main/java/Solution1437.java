import java.util.ArrayList;
import java.util.List;

public class Solution1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        List<Integer> posList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                posList.add(i);
            }
        }
        for (int i = 1; i < posList.size(); i++) {
            if (posList.get(i) - posList.get(i - 1) - 1 < k) {
                return false;
            }
        }
        return true;
    }
}
/*
1437. 是否所有 1 都至少相隔 k 个元素
https://leetcode.cn/problems/check-if-all-1s-are-at-least-length-k-places-away/description/

给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
提示：
1 <= nums.length <= 10^5
0 <= k <= nums.length
nums[i] 的值为 0 或 1

下标分组。
时间复杂度 O(n)。
 */