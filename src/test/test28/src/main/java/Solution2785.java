import java.util.ArrayList;
import java.util.List;

public class Solution2785 {
    public String sortVowels(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();

        List<Integer> ids = new ArrayList<>();
        List<Character> chs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isVowel(cs[i])) {
                ids.add(i);
                chs.add(cs[i]);
            }
        }
        chs.sort(null);
        for (int i = 0; i < ids.size(); i++) {
            cs[ids.get(i)] = chs.get(i);
        }
        return new String(cs);
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }
}
/*
2785. 将字符串中的元音字母排序
https://leetcode.cn/problems/sort-vowels-in-a-string/

第 109 场双周赛 T2。

给你一个下标从 0 开始的字符串 s ，将 s 中的元素重新 排列 得到新的字符串 t ，它满足：
- 所有辅音字母都在原来的位置上。更正式的，如果满足 0 <= i < s.length 的下标 i 处的 s[i] 是个辅音字母，那么 t[i] = s[i] 。
- 元音字母都必须以他们的 ASCII 值按 非递减 顺序排列。更正式的，对于满足 0 <= i < j < s.length 的下标 i 和 j  ，如果 s[i] 和 s[j] 都是元音字母，那么 t[i] 的 ASCII 值不能大于 t[j] 的 ASCII 值。
请你返回结果字母串。
元音字母为 'a' ，'e' ，'i' ，'o' 和 'u' ，它们可能是小写字母也可能是大写字母，辅音字母是除了这 5 个字母以外的所有字母。
提示：
1 <= s.length <= 10^5
s 只包含英语字母表中的 大写 和 小写 字母。

模拟
 */