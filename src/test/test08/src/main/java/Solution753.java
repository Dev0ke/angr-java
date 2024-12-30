import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution753 {
    private StringBuilder ans;
    private Map<String, Queue<String[]>> adj;

    // 假设 k = 4, n = 3 时，节点分别为 00, 01, 02, 03, 10, 11, 12, 13, 20, 21, 22, 23, 30, 31, 32, 33，
    // 每个节点的出边的编号分别为 0, 1, 2, 3，
    // 那么 00 和它的出边形成了 000, 001, 002, 003 这 4 个 3 位数，32 和它的出边形成了 320, 321, 322, 323 这 4 个 3 位数
    // 形成一个有向图，16 个节点，64 条边，每个节点 4 条出边，4 条入边
    public String crackSafe(int n, int k) {
        ans = new StringBuilder();

        // 0,1,···,k-1
        String[] ss = new String[k];
        String[] permute = {""};
        for (int i = 0; i < k; i++) {
            ss[i] = String.valueOf(i);
        }
        for (int i = 0; i < n - 1; i++) {
            permute = cartesianProduct(permute, ss);
        }

        // 建图
        adj = new HashMap<>();
        for (String u : permute) {
            for (int x = 0; x < k; x++) {
                String v = (u + x).substring(1);
                String w = String.valueOf(x);
                adj.computeIfAbsent(u, key -> new LinkedList<>()).add(new String[]{v, w});
            }
        }
        // 欧拉回路
        dfs(permute[0]);
        return ans.toString() + permute[0];
    }

    private void dfs(String u) {
        while (adj.containsKey(u) && adj.get(u).size() > 0) {
            String[] v = adj.get(u).remove();
            dfs(v[0]);
            ans.append(v[1]);
        }
    }

    // 笛卡尔积
    private String[] cartesianProduct(String[] arr1, String[] arr2) {
        int len = arr1.length * arr2.length;
        String[] res = new String[len];
        int id = 0;
        for (String s1 : arr1) {
            for (String s2 : arr2) {
                res[id++] = s1 + s2;
            }
        }
        return res;
    }

    private int k;
    private Set<Integer> seen;
    private StringBuilder stringBuilder;
    private int highest;

    // 官方解
    public String crackSafe2(int n, int k) {
        this.k = k;
        seen = new HashSet<>();
        stringBuilder = new StringBuilder();
        // 10^(n-1)
        highest = (int) Math.pow(10, n - 1);

        dfs(0);
        stringBuilder.append("0".repeat(n - 1));
        return stringBuilder.toString();
    }

    private void dfs(int u) {
        for (int x = 0; x < k; x++) {
            int v = u * 10 + x;
            if (!seen.contains(v)) {
                seen.add(v);
                dfs(v % highest);
                stringBuilder.append(x);
            }
        }
    }
}
/*
753. 破解保险箱
https://leetcode.cn/problems/cracking-the-safe/

有一个需要密码才能打开的保险箱。密码是 n 位数, 密码的每一位都是范围 [0, k - 1] 中的一个数字。
保险箱有一种特殊的密码校验方法，你可以随意输入密码序列，保险箱会自动记住 最后 n 位输入 ，如果匹配，则能够打开保险箱。
- 例如，正确的密码是 "345" ，并且你输入的是 "012345" ：
  - 输入 0 之后，最后 3 位输入是 "0" ，不正确。
  - 输入 1 之后，最后 3 位输入是 "01" ，不正确。
  - 输入 2 之后，最后 3 位输入是 "012" ，不正确。
  - 输入 3 之后，最后 3 位输入是 "123" ，不正确。
  - 输入 4 之后，最后 3 位输入是 "234" ，不正确。
  - 输入 5 之后，最后 3 位输入是 "345" ，正确，打开保险箱。
在只知道密码位数 n 和范围边界 k 的前提下，请你找出并返回确保在输入的 某个时刻 能够打开保险箱的任一 最短 密码序列 。
提示：
1 <= n <= 4
1 <= k <= 10
1 <= kn <= 4096

欧拉回路
官方解非常优雅 https://leetcode.cn/problems/cracking-the-safe/solution/po-jie-bao-xian-xiang-by-leetcode-solution/
相似题目: 332. 重新安排行程
https://leetcode.cn/problems/reconstruct-itinerary/
2097. 合法重新排列数对
https://leetcode.cn/problems/valid-arrangement-of-pairs/
 */