import java.util.HashSet;
import java.util.Set;

public class Solution2834 {
    public long minimumPossibleSum(int n, int target) {
        int i = 1;
        Set<Integer> set = new HashSet<>();
        while (set.size() < n) {
            if (!set.contains(target - i)) {
                set.add(i);
            }
            i++;
        }

        long ans = 0;
        for (Integer x : set) {
            ans += x;
        }
        return ans;
    }
}
/*
2834. 找出美丽数组的最小和
https://leetcode.cn/problems/find-the-minimum-possible-sum-of-a-beautiful-array/

第 360 场周赛 T2。

给你两个正整数：n 和 target 。
如果数组 nums 满足下述条件，则称其为 美丽数组 。
- nums.length == n.
- nums 由两两互不相同的正整数组成。
- 在范围 [0, n-1] 内，不存在 两个 不同 下标 i 和 j ，使得 nums[i] + nums[j] == target 。
返回符合条件的美丽数组所可能具备的 最小 和。
提示：
1 <= n <= 10^5
1 <= target <= 10^5

同: 2829. k-avoiding 数组的最小总和
https://leetcode.cn/problems/determine-the-minimum-sum-of-a-k-avoiding-array/
 */