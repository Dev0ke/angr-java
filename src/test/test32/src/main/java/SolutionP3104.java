import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SolutionP3104 {
    public int maxSubstringLength(String s) {
        int[][] dc = new int[26][];
        for (int i = 0; i < s.length(); ++i) {
            int o = s.charAt(i) - 'a';
            if (dc[o] == null) dc[o] = new int[]{i, i, 1};
            else {
                dc[o][1] = i;
                dc[o][2] += 1;
            }
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            if (dc[i] == null) continue;
            list.add(dc[i]);
        }
        list.sort(Comparator.comparingInt(o -> o[0]));
        int ans = -1;
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i)[0], b = 0, c = 0;
            int up = i == 0 ? list.size() - 1 : list.size();
            for (int j = i; j < up; j++) {
                int nb = list.get(j)[1], nc = list.get(j)[2];
                b = Math.max(b, nb);
                c += nc;
                if (b - a + 1 == c) {
                    ans = Math.max(ans, c);
                }
            }
        }
        return ans;
    }
}
/*
$3104. 查找最长的自包含子串
https://leetcode.cn/problems/find-longest-self-contained-substring/description/

给定字符串 s，你需要找到 s 的 最长自包含 子串 的长度。
如果 s 的一个子串 t 满足 t != s 且 t 中的每一个字符在 s 的剩余部分都不存在，则被称为是 自包含 的。
如果存在  s 的最长自包含子串，返回它的长度，否则返回 -1。
提示：
2 <= s.length <= 5 * 10^4
s 只包含小写英文字母。

假设每个字符有dc[x] = [a,b,c]表示最早出现的下标，最后出现的下标，以及总计个数，有一个子串s0，其所有字符分别为dc[vi] = [ai,bi,ci]，则其为自包含子串当且仅当sum(ci) = max(bi)-min(ai)+1。即所有字符的的总数恰好等同于该子字符串的长度。
对字符最早出现下标ai排序，遍历每一个开头字符xi：
向后遍历每一个结束字符xj，每遍历一个，将子串扩展到将其所有字符加入子串，判断该子串是否自包含子串。
返回最长的长度即可。该方法不仅能返回最长长度，也能找到对应的子串，而且与字符串长度无关。
https://leetcode.cn/problems/find-longest-self-contained-substring/solutions/2724818/an-zi-fu-chu-xian-shun-xu-bian-li-14xing-8cfi/
时间复杂度 O(26^2 + n)。
空间复杂度 O(26)。
 */