public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String lcp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // 若已经为空串，返回结果
            if (lcp.equals("") || strs[i].equals("")) {
                return "";
            }

            lcp = getLCP(lcp, strs[i]);
        }
        return lcp;
    }

    private String getLCP(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLen; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, minLen);
    }
}
/*
14. 最长公共前缀
https://leetcode.cn/problems/longest-common-prefix/

编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
提示：
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成

查找字符串数组中的最长公共前缀。三种方法：
横向扫描 时间复杂度O(mn) 空间复杂度O(1)
纵向扫描 时间复杂度O(mn) 空间复杂度O(1)
排序后首位元素的公共前缀 复杂度相当于排序的复杂度 O(nlogn)（容易理解但效率不高）
 */