import java.util.HashMap;
import java.util.Map;

public class Solution1400 {
    public boolean canConstruct(String s, int k) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }
        // 最少能组成 oddCnt 的回文串
        int oddCnt = 0;
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddCnt++;
            }
        }
        int max = s.length();
        return k >= oddCnt && k <= max;
    }
}
/*
1400. 构造 K 个回文字符串
https://leetcode.cn/problems/construct-k-palindrome-strings/

第 23 场双周赛 T2。

给你一个字符串 s 和一个整数 k 。请你用 s 字符串中 所有字符 构造 k 个非空 回文串 。
如果你可以用 s 中所有字符构造 k 个回文字符串，那么请你返回 True ，否则返回 False 。
提示：
1 <= s.length <= 10^5
s 中所有字符都是小写英文字母。
1 <= k <= 10^5

贪心。
需判断字符串 s 能组成的最少回文个数与最多回文数，k 介于二者之间即可。
字符频数为偶数的字符可以成对组合，因此只需考虑字符频数为奇数情况，
有多少个频数为奇数，就必须要组成多少个回文串。
最多回文串等于字符串长度。
 */