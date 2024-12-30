import java.util.HashMap;
import java.util.Map;

public class Solution3365 {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int n = s.length();
        int m = n / k; // 每个子字符串长度
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i += m) {
            cnt.merge(s.substring(i, i + m), 1, Integer::sum);
            cnt.merge(t.substring(i, i + m), -1, Integer::sum);
        }
        for (Integer c : cnt.values()) {
            if (c != 0) return false;
        }
        return true;
    }
}
/*
3365. 重排子字符串以形成目标字符串
https://leetcode.cn/problems/rearrange-k-substrings-to-form-target-string/description/

第 425 场周赛 T2。

给你两个字符串 s 和 t（它们互为字母异位词），以及一个整数 k。
你的任务是判断是否可以将字符串 s 分割成 k 个等长的子字符串，然后重新排列这些子字符串，并以任意顺序连接它们，使得最终得到的新字符串与给定的字符串 t 相匹配。
如果可以做到，返回 true；否则，返回 false。
字母异位词 是指由另一个单词或短语的所有字母重新排列形成的单词或短语，使用所有原始字母恰好一次。
子字符串 是字符串中的一个连续 非空 字符序列。
提示：
1 <= s.length == t.length <= 2 * 10^5
1 <= k <= s.length
s.length 能被 k 整除。
s 和 t 仅由小写英文字母组成。
输入保证 s 和 t 互为字母异位词。

哈希表。
 */