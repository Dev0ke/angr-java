public class SolutionP555 {
    // https://leetcode.cn/problems/split-concatenated-strings/solution/fen-ge-lian-jie-zi-fu-chuan-by-leetcode-solution/
    // O(n^2)
    public String splitLoopedString(String[] strs) {
        int len = strs.length;
        // 如果翻转后比原来 字典序更大，先翻转
        for (int i = 0; i < len; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            if (strs[i].compareTo(rev) < 0) {
                strs[i] = rev;
            }
        }

        // 再枚举所有可能的循环起点
        String res = "";
        for (int i = 0; i < len; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            StringBuilder other = new StringBuilder();
            for (int j = i + 1; j < len; j++) {
                other.append(strs[j]);
            }
            for (int j = 0; j < i; j++) {
                other.append(strs[j]);
            }

            for (int j = 0; j < strs[i].length(); j++) {
                String cur = strs[i].substring(j) + other + strs[i].substring(0, j);
                if (res.compareTo(cur) < 0) {
                    res = cur;
                }
            }
            for (int j = 0; j < strs[i].length(); j++) {
                String cur = rev.substring(j) + other + rev.substring(0, j);
                if (res.compareTo(cur) < 0) {
                    res = cur;
                }
            }
        }
        return res;
    }
}
/*
$555. 分割连接字符串
https://leetcode.cn/problems/split-concatenated-strings/

给定一个字符串列表 strs，你可以将这些字符串连接成一个循环字符串，对于每个字符串，你可以选择是否翻转它。在所有可能的循环字符串中，你需要分割循环字符串（这将使循环字符串变成一个常规的字符串），然后找到字典序最大的字符串。
具体来说，要找到字典序最大的字符串，你需要经历两个阶段：
1.将所有字符串连接成一个循环字符串，你可以选择是否翻转某些字符串，并按照给定的顺序连接它们。
2.在循环字符串的某个位置分割它，这将使循环字符串从分割点变成一个常规的字符串。
你的工作是在所有可能的常规字符串中找到字典序最大的一个。
提示:
1 <= strs.length <= 1000
1 <= strs[i].length <= 1000
1 <= sum(strs[i].length) <= 1000
strs[i] 只包含小写英文字母

贪心 + 枚举
时间复杂度 O(n^2)
空间复杂度 O(n)
 */