import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionP1153 {
    public boolean canConvert(String str1, String str2) {
        // 特判：str1 = "abcdefghijklmnopqrstuvwxyz", str2 = "abcdefghijklmnopqrstuvwxyz"
        if (str1.equals(str2)) {
            return true;
        }

        int n = str1.length();
        int[] mp = new int[26];
        Arrays.fill(mp, -1);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = str1.charAt(i) - 'a';
            int y = str2.charAt(i) - 'a';
            if (mp[x] == -1) {
                mp[x] = y;
                set.add(y);
            } else {
                if (mp[x] != y) {
                    return false;
                }
            }
        }
        // 因为一共只有 26 个字符，如果 str2 中存在 26 个不同的字符，那么将无法进行转换。
        return set.size() < 26;
    }
}
/*
$1153. 字符串转化
https://leetcode.cn/problems/string-transforms-into-another-string/

给出两个长度相同的字符串 str1 和 str2。请你帮忙判断字符串 str1 能不能在 零次 或 多次 转化 后变成字符串 str2。
每一次转化时，你可以将 str1 中出现的 所有 相同字母变成其他 任何 小写英文字母。
只有在字符串 str1 能够通过上述方式顺利转化为字符串 str2 时才能返回 true 。
提示：
1 <= str1.length == str2.length <= 10^4
str1 和 str2 中都只会出现小写英文字母

哈希表。每个字符最多只能映射一个字符。
当 str1 中某两个下标 i 和 j 字符相同时，那么 str2 中这个两个下标的字符也必须相同
相似题目: 890. 查找和替换模式
https://leetcode.cn/problems/find-and-replace-pattern/
 */