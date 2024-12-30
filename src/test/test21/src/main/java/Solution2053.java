import java.util.HashMap;
import java.util.Map;

public class Solution2053 {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> cntMap = new HashMap<>();
        for (String str : arr) {
            cntMap.put(str, cntMap.getOrDefault(str, 0) + 1);
        }
        int cnt = 0;
        for (String str : arr) {
            if (cntMap.get(str) == 1) {
                cnt++;
            }
            if (cnt == k) {
                return str;
            }
        }
        return "";
    }
}
/*
2053. 数组中第 K 个独一无二的字符串
https://leetcode.cn/problems/kth-distinct-string-in-an-array/

独一无二的字符串 指的是在一个数组中只出现过 一次 的字符串。
给你一个字符串数组 arr 和一个整数 k ，请你返回 arr 中第 k 个 独一无二的字符串 。如果 少于 k 个独一无二的字符串，那么返回 空字符串 "" 。
注意，按照字符串在原数组中的 顺序 找到第 k 个独一无二字符串。

第 64 场双周赛 T1。
相似题目: 136. 只出现一次的数字
https://leetcode.cn/problems/single-number/
HashMap 统计频次即可。
 */