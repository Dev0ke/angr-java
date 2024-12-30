import java.util.HashMap;
import java.util.Map;

public class Solution2306 {
    public long distinctNames(String[] ideas) {
        Map<String, Integer> subStringMaskMap = new HashMap<>();
        for (String idea : ideas) {
            String subString = idea.substring(1);
            int mask = subStringMaskMap.getOrDefault(subString, 0);
            subStringMaskMap.put(subString, mask | 1 << (idea.charAt(0) - 'a'));
        }

        long res = 0L;
        int[][] cnt = new int[26][26];
        for (int mask : subStringMaskMap.values()) {
            for (int i = 0; i < 26; i++) {
                if (((mask >> i) & 1) == 1) {
                    for (int j = 0; j < 26; j++) {
                        if (((mask >> j) & 1) == 0) {
                            res += cnt[i][j];
                        }
                    }
                } else {
                    for (int j = 0; j < 26; j++) {
                        if (((mask >> j) & 1) == 1) {
                            cnt[i][j]++;
                        }
                    }
                }
            }
        }
        return res * 2;
    }
}
/*
2306. 公司命名
https://leetcode.cn/problems/naming-a-company/

第 297 场周赛 T4。

给你一个字符串数组 ideas 表示在公司命名过程中使用的名字列表。公司命名流程如下：
1.从 ideas 中选择 2 个 不同 名字，称为 ideaA 和 ideaB 。
2.交换 ideaA 和 ideaB 的首字母。
3.如果得到的两个新名字 都 不在 ideas 中，那么 ideaA ideaB（串联 ideaA 和 ideaB ，中间用一个空格分隔）是一个有效的公司名字。
4.否则，不是一个有效的名字。
返回 不同 且有效的公司名字的数目。
提示：
2 <= ideas.length <= 5 * 10^4
1 <= ideas[i].length <= 10
ideas[i] 由小写英文字母组成
ideas 中的所有字符串 互不相同

对于每个 subString，状态压缩记录其都有哪些首字母。
时间复杂度 O(n) 其中常数为 26
空间复杂度 O(n) 其中 n=ideas.length, 常数为 10
 */