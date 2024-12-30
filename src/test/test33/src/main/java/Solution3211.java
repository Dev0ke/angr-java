import java.util.ArrayList;
import java.util.List;

public class Solution3211 {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        for (int mask = 0; mask < 1 << n; mask++) {
            String bin = Integer.toBinaryString(mask);
            bin = "0".repeat(n - bin.length()) + bin;
            if (!bin.contains("00")) {
                ans.add(bin);
            }
        }
        return ans;
    }

    public List<String> validStrings2(int n) {
        List<String> ans = new ArrayList<>();
        int full = (1 << n) - 1;
        for (int mask = 0; mask < 1 << n; mask++) {
            int x = mask ^ full;
            if (((x >> 1) & x) == 0) {
                String bin = Integer.toBinaryString((1 << n) | mask).substring(1);
                ans.add(bin);
            }
        }
        return ans;
    }
}
/*
3211. 生成不含相邻零的二进制字符串
https://leetcode.cn/problems/generate-binary-strings-without-adjacent-zeros/description/

第 405 场周赛 T2。

给你一个正整数 n。
如果一个二进制字符串 x 的所有长度为 2 的 子字符串 中包含 至少 一个 "1"，则称 x 是一个 有效 字符串。
返回所有长度为 n 的 有效 字符串，可以以任意顺序排列。
提示：
1 <= n <= 18

二进制枚举。
时间复杂度 O(2^n)。
 */