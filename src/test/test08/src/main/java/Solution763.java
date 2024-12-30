import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution763 {
    public List<Integer> partitionLabels(String s) {
        // 统计每个字母第一次出现和最后一次出现的坐标
        Map<Character, int[]> chLrIdxMap = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int[] lrIdx = chLrIdxMap.getOrDefault(s.charAt(i), new int[]{i, i});
            lrIdx[1] = i;
            chLrIdxMap.put(s.charAt(i), lrIdx);
        }
        // 按照第一次出现的坐标升序排序
        List<int[]> rlList = new ArrayList<>(chLrIdxMap.values());
        rlList.sort(Comparator.comparingInt(o -> o[0]));

        // 统计结果
        List<Integer> resList = new ArrayList<>();
        int[] pre = rlList.get(0);
        for (int i = 1; i < rlList.size(); i++) {
            int[] cur = rlList.get(i);
            if (cur[0] < pre[1]) {
                if (cur[1] > pre[1]) {
                    pre[1] = cur[1];
                }
            } else {
                resList.add(pre[1] - pre[0] + 1);
                pre[0] = cur[0];
                pre[1] = cur[1];
            }
        }
        resList.add(len - pre[0]);
        return resList;
    }
}
/*
763. 划分字母区间
https://leetcode.cn/problems/partition-labels/

给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
返回一个表示每个字符串片段的长度的列表。
示例 1：
输入：s = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。 
提示：
1 <= s.length <= 500
s 仅由小写英文字母组成

"ababcbacadefegdehijhklij"
a -> 0,8
b -> 1,5
c -> 4,7
---
d -> 9,14
e -> 10,15
f -> 11,11
g -> 13,13
---
h -> 16,19
i -> 17,22
j -> 18,23
k -> 20,20
l -> 21,21
 */