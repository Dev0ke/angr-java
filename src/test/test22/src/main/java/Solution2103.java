import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2103 {
    public int countPoints(String rings) {
        int n = rings.length() / 2;
        Map<Character, Set<Character>> cntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch1 = rings.charAt(2 * i);
            char ch2 = rings.charAt(2 * i + 1);

            Set<Character> set = cntMap.getOrDefault(ch2, new HashSet<>());
            set.add(ch1);
            cntMap.put(ch2, set);
        }
        // 统计
        int cnt = 0;
        for (Map.Entry<Character, Set<Character>> entry : cntMap.entrySet()) {
            if (entry.getValue().size() == 3) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
2103. 环和杆
https://leetcode.cn/problems/rings-and-rods/

第 271 场周赛 T1。

总计有 n 个环，环的颜色可以是红、绿、蓝中的一种。这些环分布穿在 10 根编号为 0 到 9 的杆上。
给你一个长度为 2n 的字符串 rings ，表示这 n 个环在杆上的分布。rings 中每两个字符形成一个 颜色位置对 ，用于描述每个环：
- 第 i 对中的 第一个 字符表示第 i 个环的 颜色（'R'、'G'、'B'）。
- 第 i 对中的 第二个 字符表示第 i 个环的 位置，也就是位于哪根杆上（'0' 到 '9'）。
例如，"R3G2B1" 表示：共有 n == 3 个环，红色的环在编号为 3 的杆上，绿色的环在编号为 2 的杆上，蓝色的环在编号为 1 的杆上。
找出所有集齐 全部三种颜色 环的杆，并返回这种杆的数量。

范围 10^2
时间复杂度 O(n)
HashMap 统计。
 */