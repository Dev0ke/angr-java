import java.util.ArrayList;
import java.util.List;

public class Solution833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int k = indices.length;

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new Node(indices[i], sources[i], targets[i]));
        }
        list.sort((o1, o2) -> Integer.compare(o2.idx, o1.idx));

        for (Node node : list) {
            int idx = node.idx;
            String si = node.source;
            String ti = node.target;
            if (s.startsWith(si, idx)) {
                s = s.substring(0, idx) + ti + s.substring(idx + si.length());
            }
        }
        return s;
    }

    private static class Node {
        int idx;
        String source;
        String target;

        public Node(int idx, String source, String target) {
            this.idx = idx;
            this.source = source;
            this.target = target;
        }
    }
}
/*
833. 字符串中的查找与替换
https://leetcode.cn/problems/find-and-replace-in-string/

你会得到一个字符串 s (索引从 0 开始)，你必须对它执行 k 个替换操作。替换操作以三个长度均为 k 的并行数组给出：indices, sources,  targets。
要完成第 i 个替换操作:
1. 检查 子字符串  sources[i] 是否出现在 原字符串 s 的索引 indices[i] 处。
2. 如果没有出现， 什么也不做 。
3. 如果出现，则用 targets[i] 替换 该子字符串。
例如，如果 s = "abcd" ， indices[i] = 0 , sources[i] = "ab"， targets[i] = "eee" ，那么替换的结果将是 "eeecd" 。
所有替换操作必须 同时 发生，这意味着替换操作不应该影响彼此的索引。测试用例保证元素间不会重叠 。
- 例如，一个 s = "abc" ，  indices = [0,1] ， sources = ["ab"，"bc"] 的测试用例将不会生成，因为 "ab" 和 "bc" 替换重叠。
在对 s 执行所有替换操作后返回 结果字符串 。
子字符串 是字符串中连续的字符序列。
提示：
1 <= s.length <= 1000
k == indices.length == sources.length == targets.length
1 <= k <= 100
0 <= indexes[i] < s.length
1 <= sources[i].length, targets[i].length <= 50
s 仅由小写英文字母组成
sources[i] 和 targets[i] 仅由小写英文字母组成

后往前替换，解决后效性问题。
 */