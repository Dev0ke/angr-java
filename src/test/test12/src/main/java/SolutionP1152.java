import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionP1152 {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int len = username.length;
        Map<String, List<Node>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.computeIfAbsent(username[i], key -> new ArrayList<>()).add(new Node(timestamp[i], website[i]));
        }

        int maxCnt = 0;
        Map<String, Integer> cntMap = new HashMap<>();
        for (List<Node> nodeList : map.values()) {
            nodeList.sort(Comparator.comparingInt(o -> o.time));
            int sz = nodeList.size();
            Set<String> set = new HashSet<>();
//            for (int i = 2; i < sz; i++) {
//                set.add(nodeList.get(i - 2).web + ":" + nodeList.get(i - 1).web + ":" + nodeList.get(i).web);
//            }
            for (int i = 0; i < sz; i++) {
                for (int j = i + 1; j < sz; j++) {
                    for (int k = j + 1; k < sz; k++) {
                        set.add(nodeList.get(i).web + ":" + nodeList.get(j).web + ":" + nodeList.get(k).web);

                    }
                }
            }
            for (String x : set) {
                cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
                maxCnt = Math.max(maxCnt, cntMap.get(x));
            }
        }
        List<String> maxCntList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() == maxCnt) {
                maxCntList.add(entry.getKey());
            }
        }
        Collections.sort(maxCntList);
        return Arrays.stream(maxCntList.get(0).split(":")).toList();
    }

    private static class Node {
        int time;
        String web;

        public Node(int time, String web) {
            this.time = time;
            this.web = web;
        }
    }
}
/*
$1152. 用户网站访问行为分析
https://leetcode.cn/problems/analyze-user-website-visit-pattern/

给定两个字符串数组 username 和 website 和一个整数数组 timestamp 。给定的数组长度相同，
其中元组 [username[i], website[i], timestamp[i]] 表示用户 username[i] 在时间 timestamp[i] 访问了网站 website[i] 。
访问模式 是包含三个网站的列表(不一定是完全不同的)。
- 例如，["home"， "away"， "love"]， ["leetcode"， "love"， "leetcode"]，和 ["luffy"， "luffy"， "luffy"] 都是模式。
一种 访问模式 的 得分 是访问该模式中所有网站的用户数量，这些网站在该模式中出现的顺序相同。
- 例如，如果模式是 [“home”，“away”，“love”] ，那么分数就是用户数量 x , x 访问了 “home” ，然后访问了 “away” ，然后访问了 “love” 。
- 同样，如果模式是 ["leetcode"， "love"， "leetcode"] ，那么分数就是用户数量 x ，使得 x 访问了"leetcode"，然后访问了 "love" ，之后又访问了 "leetcode" 。
- 另外，如果模式是 [“luffy”，“luffy”，“luffy”] ，那么分数就是用户数量 x ，这样 x 就可以在不同的时间戳上访问 “luffy” 三次。
返回 得分 最大的 访问模式 。如果有多个访问模式具有相同的最大分数，则返回字典序最小的。
提示：
3 <= username.length <= 50
1 <= username[i].length <= 10
timestamp.length == username.length
1 <= timestamp[i] <= 10^9
website.length == username.length
1 <= website[i].length <= 10
username[i] 和 website[i] 都只含小写字符
它保证至少有一个用户访问了至少三个网站
所有元组 [username[i]， timestamp[i]， website[i] 均 不重复

模拟
时间复杂度 O(n^3)
 */