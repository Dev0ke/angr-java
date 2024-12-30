import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution3295 {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, bannedWords);

        int cnt = 0;
        for (String s : message) {
            if (set.contains(s)) cnt++;
            if (cnt >= 2) return true;
        }
        return false;
    }
}
/*
3295. 举报垃圾信息
https://leetcode.cn/problems/report-spam-message/description/

第 416 场周赛 T1。

给你一个字符串数组 message 和一个字符串数组 bannedWords。
如果数组中 至少 存在两个单词与 bannedWords 中的任一单词 完全相同，则该数组被视为 垃圾信息。
如果数组 message 是垃圾信息，则返回 true；否则返回 false。
提示：
1 <= message.length, bannedWords.length <= 10^5
1 <= message[i].length, bannedWords[i].length <= 15
message[i] 和 bannedWords[i] 都只由小写英文字母组成。

模拟。
 */