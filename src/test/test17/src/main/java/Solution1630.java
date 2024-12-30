import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;

        List<Boolean> resList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int len = r[i] - l[i] + 1;

            int[] subArray = new int[len];
            System.arraycopy(nums, l[i], subArray, 0, len);
            resList.add(check(subArray));
        }
        return resList;
    }

    private boolean check(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int diff = nums[1] - nums[0];
        int pre = nums[0];
        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            if (cur - pre != diff) {
                return false;
            }
            pre = cur;
        }
        return true;
    }
}
/*
1630. 等差子数组
https://leetcode.cn/problems/arithmetic-subarrays/

如果一个数列由至少两个元素组成，且每两个连续元素之间的差值都相同，那么这个序列就是 等差数列 。
更正式地，数列 s 是等差数列，只需要满足：对于每个有效的 i ， s[i+1] - s[i] == s[1] - s[0] 都成立。
提示：
n == nums.length
m == l.length
m == r.length
2 <= n <= 500
1 <= m <= 500
0 <= l[i] < r[i] < n
-10^5 <= nums[i] <= 10^5

模拟。
 */