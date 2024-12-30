import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP1257 {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> faMap = new HashMap<>();
        for (List<String> region : regions) {
            int sz = region.size();
            for (int i = 1; i < sz; i++) {
                faMap.put(region.get(i), region.get(0));
            }
        }
        // LCA
        String p1 = region1;
        String p2 = region2;
        while (!p1.equals(p2)) {
            p1 = faMap.getOrDefault(p1, region2);
            p2 = faMap.getOrDefault(p2, region1);
        }
        return p1;
    }
}
/*
$1257. 最小公共区域
https://leetcode.cn/problems/smallest-common-region/

给你一些区域列表 regions ，每个列表的第一个区域都包含这个列表内所有其他区域。
很自然地，如果区域 X 包含区域 Y ，那么区域 X  比区域 Y 大。
给定两个区域 region1 和 region2 ，找到同时包含这两个区域的 最小 区域。
如果区域列表中 r1 包含 r2 和 r3 ，那么数据保证 r2 不会包含 r3 。
数据同样保证最小公共区域一定存在。
提示：
2 <= regions.length <= 10^4
region1 != region2
所有字符串只包含英文字母和空格，且最多只有 20 个字母。

相似题目: 160. 相交链表
https://leetcode.cn/problems/intersection-of-two-linked-lists/
$1650. 二叉树的最近公共祖先 III
https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree-iii/
 */