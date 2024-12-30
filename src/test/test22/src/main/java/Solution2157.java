import java.util.HashMap;
import java.util.Map;

public class Solution2157 {
    private Map<Integer, Integer> faMap;
    private Map<Integer, Integer> szMap;
    // ans[0] 是 words 分组后的 总组数 。
    private int groups;
    // ans[1] 是字符串数目最多的组所包含的字符串数目。
    private int maxSize;

    public int[] groupStrings(String[] words) {
        groups = words.length;
        maxSize = 0;
        faMap = new HashMap<>();
        szMap = new HashMap<>();

        for (String word : words) {
            int mask = 0;
            for (char ch : word.toCharArray()) {
                mask |= 1 << (ch - 'a');
            }
            faMap.put(mask, mask);
            szMap.put(mask, szMap.getOrDefault(mask, 0) + 1);
            maxSize = Math.max(maxSize, szMap.get(mask));
            if (szMap.get(mask) > 1) {
                groups--;
            }
        }

        for (Map.Entry<Integer, Integer> entry : faMap.entrySet()) {
            int mask = entry.getKey();
            for (int i = 0; i < 26; i++) {
                // 添加或删除字符 i
                union(mask, mask ^ (1 << i));

                if (((mask >> i) & 1) == 0) {
                    continue;
                }
                for (int j = 0; j < 26; j++) {
                    if (((mask >> j) & 1) == 0) {
                        // 替换字符 i 为 j
                        union(mask, mask ^ (1 << i) | (1 << j));
                    }
                }
            }
        }
        return new int[]{groups, maxSize};
    }

    int find(int x) {
        if (x != faMap.get(x)) {
            faMap.put(x, find(faMap.get(x)));
        }
        return faMap.get(x);
    }

    void union(int p, int q) {
        if (!faMap.containsKey(q)) {
            return;
        }
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        faMap.put(rootQ, rootP);
        szMap.put(rootP, szMap.get(rootQ) + szMap.get(rootP));
        maxSize = Math.max(maxSize, szMap.get(rootP));
        groups--;
    }
}
/*
2157. 字符串分组
https://leetcode.cn/problems/groups-of-strings/

第 278 场周赛 T4。

给你一个下标从 0 开始的字符串数组 words 。每个字符串都只包含 小写英文字母 。words 中任意一个子串中，每个字母都至多只出现一次。
如果通过以下操作之一，我们可以从 s1 的字母集合得到 s2 的字母集合，那么我们称这两个字符串为 关联的 ：
- 往 s1 的字母集合中添加一个字母。
- 从 s1 的字母集合中删去一个字母。
- 将 s1 中的一个字母替换成另外任意一个字母（也可以替换为这个字母本身）。
数组 words 可以分为一个或者多个无交集的 组 。如果一个字符串与另一个字符串关联，那么它们应当属于同一个组。
注意，你需要确保分好组后，一个组内的任一字符串与其他组的字符串都不关联。可以证明在这个条件下，分组方案是唯一的。
请你返回一个长度为 2 的数组 ans ：
- ans[0] 是 words 分组后的 总组数 。
- ans[1] 是字符串数目最多的组所包含的字符串数目。

并查集。
HashMap 版本并查集
ans[0] 即为并查集连通分量大小
ans[1] 即为最大连通分量的大小
 */