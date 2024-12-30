import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1002 {
    public List<String> commonChars(String[] words) {
        int C = 26, MAX_N = 100;
        int[] cnt_min = new int[C];
        Arrays.fill(cnt_min, MAX_N);
        for (String word : words) {
            int[] cnt = new int[C];
            for (char c : word.toCharArray()) {
                cnt[c - 'a']++;
            }
            for (int i = 0; i < C; i++) {
                cnt_min[i] = Math.min(cnt_min[i], cnt[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < cnt_min[i]; j++) {
                String c = String.valueOf((char) (i + 'a'));
                ans.add(c);
            }
        }
        return ans;
    }
}
/*
1002. 查找共用字符
https://leetcode.cn/problems/find-common-characters/description/

给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。
提示：
1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] 由小写英文字母组成

模拟。每个字符串计算字符频次，然后取最小值。
时间复杂度 O(n(26 + m))。其中 m 是字符串的平均长度。
 */