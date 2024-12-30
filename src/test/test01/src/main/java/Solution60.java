import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution60 {
    static class V1 {
        public String getPermutation(int n, int k) {
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = i + 1;
            }
            // 9! = 362880
            for (int i = 0; i < k - 1; i++) {
                nextPermutation(ans);
            }
            return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining());
        }

        // solution31 时间复杂度 O(n)
        private void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        private void reverse(int[] nums, int start) {
            int right = nums.length - 1;
            while (start < right) {
                swap(nums, start, right);
                start++;
                right--;
            }
        }
    }

    static class V2 {
        public String getPermutation(int n, int k) {
            int[] factorial = new int[n];
            factorial[0] = 1;
            for (int i = 1; i < n; ++i) {
                factorial[i] = factorial[i - 1] * i;
            }

            --k;
            StringBuilder ans = new StringBuilder();
            int[] valid = new int[n + 1];
            Arrays.fill(valid, 1);
            for (int i = 1; i <= n; ++i) {
                int order = k / factorial[n - i] + 1;
                for (int j = 1; j <= n; ++j) {
                    order -= valid[j];
                    if (order == 0) {
                        ans.append(j);
                        valid[j] = 0;
                        break;
                    }
                }
                k %= factorial[n - i];
            }
            return ans.toString();
        }
    }
}
/*
60. 排列序列
https://leetcode.cn/problems/permutation-sequence/

给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
1."123"
2."132"
3."213"
4."231"
5."312"
6."321"
给定 n 和 k，返回第 k 个排列。
提示：
1 <= n <= 9
1 <= k <= n!

考虑使用 nextPermutation 求解，9! = 362880 < 1e6，可以过。
相似题目: 31. 下一个排列
https://leetcode.cn/problems/next-permutation/
1415. 长度为 n 的开心字符串中字典序第 k 小的字符串
https://leetcode.cn/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/
 */