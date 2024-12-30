import java.util.ArrayList;
import java.util.List;

public class Solution1239 {
    private List<Integer> maskList;
    private int ans;

    public int maxLength(List<String> arr) {
        maskList = new ArrayList<>();
        for (String s : arr) {
            int mask = 0;
            for (char c : s.toCharArray()) {
                if ((mask >> (c - 'a') & 1) == 1) {
                    mask = 0;
                    break;
                }
                mask |= 1 << (c - 'a');
            }
            if (mask != 0) maskList.add(mask);
        }
        ans = 0;
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int mask) {
        if (i == maskList.size()) {
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        dfs(i + 1, mask); // 不选
        if ((mask & maskList.get(i)) == 0) {
            dfs(i + 1, mask | maskList.get(i)); // 选
        }
    }
}
/*
1239. 串联字符串的最大长度
https://leetcode.cn/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/

给定一个字符串数组 arr，字符串 s 是将 arr 的含有 不同字母 的 子序列 字符串 连接 所得的字符串。
请返回所有可行解 s 中最长长度。
子序列 是一种可以从另一个数组派生而来的数组，通过删除某些元素或不删除元素而不改变其余元素的顺序。
提示：
1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] 中只含有小写英文字母

回溯 + 位运算。
时间复杂度 O(26 + 2^n)。
 */