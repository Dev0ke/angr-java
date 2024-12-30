public class Solution2124 {
    public boolean checkString(String s) {
        if (!s.contains("a") || !s.contains("b")) {
            return true;
        }
        int lastA = s.lastIndexOf("a");
        int firstB = s.indexOf("b");
        return lastA < firstB;
    }
}
/*
2124. 检查是否所有 A 都在 B 之前
https://leetcode.cn/problems/check-if-all-as-appears-before-all-bs/

第 274 场周赛 T1。

给你一个 仅 由字符 'a' 和 'b' 组成的字符串 s 。如果字符串中 每个 'a' 都出现在 每个 'b' 之前，返回 true ；否则，返回 false 。

比赛时看到示例全 "bbb" 为 true，但不知道 "aaa" 是属于那种情况，赌一把，WA 了。。
 */