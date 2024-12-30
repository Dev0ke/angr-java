import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3039 {
    public String lastNonEmptyString(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            int j = s.charAt(i) - 'a';
            cnt[j]++;
            last[j] = i;
        }

        int mx = Arrays.stream(cnt).max().orElseThrow();
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == mx) {
                ids.add(last[i]);
            }
        }
        ids.sort(null);
        StringBuilder ans = new StringBuilder();
        for (Integer id : ids) {
            ans.append(s.charAt(id));
        }
        return ans.toString();
    }
}
/*
3039. 进行操作使字符串为空
https://leetcode.cn/problems/apply-operations-to-make-string-empty/description/

第 124 场双周赛 T2。

给你一个字符串 s 。
请你进行以下操作直到 s 为 空 ：
- 每次操作 依次 遍历 'a' 到 'z'，如果当前字符出现在 s 中，那么删除出现位置 最早 的该字符（如果存在的话）。
例如，最初 s = "aabcbbca"。我们执行下述操作：
- 移除下划线的字符  s = "aabcbbca"。结果字符串为 s = "abbca"。
- 移除下划线的字符  s = "abbca"。结果字符串为 s = "ba"。
- 移除下划线的字符  s = "ba"。结果字符串为 s = ""。
请你返回进行 最后 一次操作 之前 的字符串 s 。在上面的例子中，答案是 "ba"。
提示：
1 <= s.length <= 5 * 10^5
s 只包含小写英文字母。

贪心。
统计字符频次，最后剩下的必然是频次最大的，记录这些下标，排序还原出答案。
时间复杂度 O(n + 26log26)
 */