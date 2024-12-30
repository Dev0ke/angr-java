import java.util.HashMap;
import java.util.Map;

public class Solution2423 {
    public boolean equalFrequency(String word) {
        int len = word.length();
        for (int i = 0; i < len; i++) {
            Map<Character, Integer> cntMap = new HashMap<>();
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                char ch = word.charAt(j);
                cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
            }
            if (check(cntMap)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(Map<Character, Integer> cntMap) {
        int pre = -1;
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            if (pre == -1) {
                pre = entry.getValue();
            } else {
                if (entry.getValue() != pre) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
2423. 删除字符使频率相同
https://leetcode.cn/problems/remove-letter-to-equalize-frequency/

第 88 场双周赛 T1。

给你一个下标从 0 开始的字符串 word ，字符串只包含小写英文字母。你需要选择 一个 下标并 删除 下标处的字符，使得 word 中剩余每个字母出现 频率 相同。
如果删除一个字母后，word 中剩余所有字母的出现频率都相同，那么返回 true ，否则返回 false 。
注意：
字母 x 的 频率 是这个字母在字符串中出现的次数。
你 必须 恰好删除一个字母，不能一个字母都不删除。
提示：
2 <= word.length <= 100
word 只包含小写英文字母。

暴力模拟。枚举每个下标被删除后是否满足即可。。
时间复杂度 O(n^2)
 */