public class Solution667 {
    public int[] constructArray(int n, int k) {
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i + 1;
        }
        for (int i = 1; i < k; i++) {
            swap(p, i, n - 1);
        }
        return p;
    }

    private void swap(int[] nums, int l, int r) {
        int len = r - l + 1;
        for (int i = 0; i < len / 2; i++) {
            int tmp = nums[l + i];
            nums[l + i] = nums[l + len - 1 - i];
            nums[l + len - 1 - i] = tmp;
        }
    }
}
/*
667. 优美的排列 II
https://leetcode.cn/problems/beautiful-arrangement-ii/

给你两个整数 n 和 k ，请你构造一个答案列表 answer ，该列表应当包含从 1 到 n 的 n 个不同正整数，并同时满足下述条件：
- 假设该列表是 answer = [a1, a2, a3, ... , an] ，那么列表 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数。
返回列表 answer 。如果存在多种答案，只需返回其中 任意一种 。
提示：
1 <= k < n <= 10^4

constructive algorithms
如果一个不换，那就只有 1 个不同整数
如果翻转 [1,n-1] 子数组，将有 2 个不同整数。
 */