public class Solution955 {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int ans = 0;
        boolean[] incr = new boolean[n];
        for (int j = 0; j < m; j++) {
            boolean sorted = true;
            for (int i = 1; i < n; i++) {
                if (!incr[i] && strs[i - 1].charAt(j) > strs[i].charAt(j)) {
                    sorted = false;
                    break;
                }
            }
            if (!sorted) {
                ans++;
                continue;
            }
            for (int i = 1; i < n; i++) {
                if (!incr[i] && strs[i - 1].charAt(j) < strs[i].charAt(j)) {
                    incr[i] = true;
                }
            }
        }
        return ans;
    }
}
/*
955. 删列造序 II
https://leetcode.cn/problems/delete-columns-to-make-sorted-ii/description/

给定由 n 个字符串组成的数组 strs，其中每个字符串长度相等。
选取一个删除索引序列，对于 strs 中的每个字符串，删除对应每个索引处的字符。
比如，有 strs = ["abcdef", "uvwxyz"]，删除索引序列 {0, 2, 3}，删除后 strs 为["bef", "vyz"]。
假设，我们选择了一组删除索引 answer，那么在执行删除操作之后，最终得到的数组的元素是按 字典序（strs[0] <= strs[1] <= strs[2] ... <= strs[n - 1]）排列的，然后请你返回 answer.length 的最小可能值。
提示：
n == strs.length
1 <= n <= 100
1 <= strs[i].length <= 100
strs[i] 由小写英文字母组成

对于每一列：如果保留后结果保持有序，就保留这一列；否则删除它。
https://leetcode.cn/problems/delete-columns-to-make-sorted-ii/solutions/2345954/955-shan-lie-zao-xu-ii-by-stormsunshine-6z9p/
时间复杂度 O(nm)。
 */