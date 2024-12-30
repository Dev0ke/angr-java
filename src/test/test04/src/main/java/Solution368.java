import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        // f[i] 表示 num[0,i] 最大的整除子集长度
        int[] f = new int[n];
        int[] from = new int[n];
        Arrays.fill(from, -1);
        int maxI = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (f[i] < f[j]) {
                        f[i] = f[j];
                        from[i] = j;
                    }
                }
            }
            f[i]++;
            if (f[i] > f[maxI]) {
                maxI = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (maxI != -1) {
            ans.add(nums[maxI]);
            maxI = from[maxI];
        }
        Collections.reverse(ans);
        return ans;
    }
}
/*
368. 最大整除子集
https://leetcode.cn/problems/largest-divisible-subset/

给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
- answer[i] % answer[j] == 0 ，或
- answer[j] % answer[i] == 0
如果存在多个有效解子集，返回其中任何一个均可。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 10^9
nums 中的所有整数 互不相同

序列 DP + 记录转移关系 倒推答案
https://leetcode.cn/problems/largest-divisible-subset/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-0a3jc/
时间复杂度 O(n^2)
相似题目: 2901. 最长相邻不相等子序列 II
https://leetcode.cn/problems/longest-unequal-adjacent-groups-subsequence-ii/description/
 */