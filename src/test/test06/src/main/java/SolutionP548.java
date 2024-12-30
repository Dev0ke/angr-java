import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionP548 {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for (int j = 3; j < n - 3; j++) {
            Set<Integer> has = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                int s1 = preSum[i];
                int s2 = preSum[j] - preSum[i + 1];
                if (s1 == s2) {
                    has.add(s1);
                }
            }
            if (has.isEmpty()) {
                continue;
            }
            for (int k = j + 2; k < n - 1; k++) {
                int s3 = preSum[k] - preSum[j + 1];
                int s4 = preSum[n] - preSum[k + 1];
                if (s3 == s4 && has.contains(s3)) {
                    return true;
                }
            }
        }
        return false;
    }

    // hqztrue meet in the middle 法
    // 时间复杂度 O(n^2)
    public boolean splitArray2(int[] nums) {
        int n = nums.length;
        if (n < 7) return false;
        Map<Long, Integer> map = new HashMap<>();
        int[] s = nums.clone();
        for (int i = 1; i < n; i++) s[i] += s[i - 1];
        for (int i = 1; i <= n - 2; i++) map.put(mp(s[n - 1] - s[i], nums[i]), i);
        int minv = Arrays.stream(nums).min().orElseThrow();
        int maxv = Arrays.stream(nums).max().orElseThrow();
        int mins = (s[n - 1] - 3 * maxv) / 4, maxs = (s[n - 1] - 3 * minv) / 4;
        for (int i = 1; i < n - 5; ++i) {
            int s1 = s[i - 1];
            // 上下界剪枝
            if (s1 < mins || s1 > maxs) continue;
            for (int j = i + 2; j < n - 3; ++j) {
                int s2 = s[j - 1] - s[i];
                if (s1 != s2 || s2 < mins || s2 > maxs) continue;
                int it = map.getOrDefault(mp(s1, s[n - 1] - s[j] - s1 * 2), -1);
                if (it >= j + 2) return true;
            }
        }
        return false;
    }

    private long mp(long x, long y) {
        return (x << 32) + y;
    }
}
/*
$548. 将数组分割成和相等的子数组
https://leetcode.cn/problems/split-array-with-equal-sum/

给定一个有 n 个整数的数组 nums ，如果能找到满足以下条件的三元组  (i, j, k)  则返回 true ：
1. 0 < i, i + 1 < j, j + 1 < k < n - 1
2. 子数组 (0, i - 1) ， (i + 1, j - 1) ， (j + 1, k - 1) ， (k + 1, n - 1) 的和应该相等。
这里我们定义子数组 (l, r) 表示原数组从索引为 l 的元素开始至索引为 r 的元素。
提示:
n == nums.length
1 <= n <= 2000
-10^6 <= nums[i] <= 10^6

前缀和 + 哈希表
时间复杂度 O(n^2)
 */