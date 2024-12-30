import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3327 {
    private List<Integer>[] g;
    private char[] s, dfsStr;
    private int time = 0;
    private int[] dfs_in, dfs_out; // dfs 序

    public boolean[] findAnswer(int[] parent, String s) {
        int n = parent.length;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int p = parent[i];
            // 由于 i 是递增的，所以 g[p] 必然是有序的，下面无需排序
            g[p].add(i);
        }
        this.s = s.toCharArray();

        // dfsStr 是后序遍历整棵树得到的字符串
        dfsStr = new char[n];
        // 表示子树 i 的后序遍历的开始时间戳和结束时间戳+1（左闭右开区间）
        dfs_in = new int[n];
        dfs_out = new int[n];
        dfs(0);

        // Manacher 模板
        // 将 dfsStr 改造为 t，这样就不需要讨论 n 的奇偶性，因为新串 t 的每个回文子串都是奇回文串（都有回文中心）
        char[] t = new char[n * 2 + 3];
        Arrays.fill(t, '#');
        t[0] = '^';
        for (int i = 0; i < n; i++) {
            t[i * 2 + 2] = dfsStr[i];
        }
        t[n * 2 + 2] = '$';

        // 定义一个奇回文串的回文半径=(长度+1)/2，即保留回文中心，去掉一侧后的剩余字符串的长度
        // halfLen[i] 表示在 t 上的以 t[i] 为回文中心的最长回文子串的回文半径
        // 即 [i-halfLen[i]+1,i+halfLen[i]-1] 是 t 上的一个回文子串
        int[] halfLen = new int[t.length - 2];
        halfLen[1] = 1;
        // boxR 表示当前右边界下标最大的回文子串的右边界下标+1
        // boxM 为该回文子串的中心位置，二者的关系为 r=mid+halfLen[mid]
        int boxM = 0, boxR = 0;
        for (int i = 2; i < halfLen.length; i++) { // 循环的起止位置对应着原串的首尾字符
            int hl = 1;
            if (i < boxR) {
                // 记 i 关于 boxM 的对称位置 i'=boxM*2-i
                // 若以 i' 为中心的最长回文子串范围超出了以 boxM 为中心的回文串的范围（即 i+halfLen[i'] >= boxR）
                // 则 halfLen[i] 应先初始化为已知的回文半径 boxR-i，然后再继续暴力匹配
                // 否则 halfLen[i] 与 halfLen[i'] 相等
                hl = Math.min(halfLen[boxM * 2 - i], boxR - i);
            }
            // 暴力扩展
            // 算法的复杂度取决于这部分执行的次数
            // 由于扩展之后 boxR 必然会更新（右移），且扩展的的次数就是 boxR 右移的次数
            // 因此算法的复杂度 = O(len(t)) = O(n)
            while (t[i - hl] == t[i + hl]) {
                hl++;
                boxM = i;
                boxR = i + hl;
            }
            halfLen[i] = hl;
        }

        // t 中回文子串的长度为 hl*2-1
        // 由于其中 # 的数量总是比字母的数量多 1
        // 因此其在 dfsStr 中对应的回文子串的长度为 hl-1
        // 这一结论可用在 isPalindrome 中

        // 判断左闭右开区间 [l,r) 是否为回文串  0<=l<r<=n
        // 根据下标转换关系得到 dfsStr 的 [l,r) 子串在 t 中对应的回文中心下标为 l+r+1
        boolean[] ans = new boolean[n];
        for (int i = 0; i < n; i++) {
            int l = dfs_in[i], r = dfs_out[i];
            ans[i] = halfLen[l + r + 1] > r - l;
        }
        return ans;
    }

    private void dfs(int x) {
        dfs_in[x] = time;
        for (int y : g[x]) {
            dfs(y);
        }
        dfsStr[time++] = s[x]; // 后序遍历
        dfs_out[x] = time;
    }
}
/*
3327. 判断 DFS 字符串是否是回文串
https://leetcode.cn/problems/check-if-dfs-strings-are-palindromes/description/

第 420 场周赛 T4。

给你一棵 n 个节点的树，树的根节点为 0 ，n 个节点的编号为 0 到 n - 1 。这棵树用一个长度为 n 的数组 parent 表示，其中 parent[i] 是节点 i 的父节点。由于节点 0 是根节点，所以 parent[0] == -1 。
给你一个长度为 n 的字符串 s ，其中 s[i] 是节点 i 对应的字符。
一开始你有一个空字符串 dfsStr ，定义一个递归函数 dfs(int x) ，它的输入是节点 x ，并依次执行以下操作：
- 按照 节点编号升序 遍历 x 的所有孩子节点 y ，并调用 dfs(y) 。
- 将 字符 s[x] 添加到字符串 dfsStr 的末尾。
注意，所有递归函数 dfs 都共享全局变量 dfsStr 。
你需要求出一个长度为 n 的布尔数组 answer ，对于 0 到 n - 1 的每一个下标 i ，你需要执行以下操作：
- 清空字符串 dfsStr 并调用 dfs(i) 。
- 如果结果字符串 dfsStr 是一个 回文串 ，answer[i] 为 true ，否则 answer[i] 为 false 。
请你返回字符串 answer 。
提示：
n == parent.length == s.length
1 <= n <= 10^5
对于所有 i >= 1 ，都有 0 <= parent[i] <= n - 1 。
parent[0] == -1
parent 表示一棵合法的树。
s 只包含小写英文字母。

DFS 时间戳 + Manacher 算法
https://leetcode.cn/problems/check-if-dfs-strings-are-palindromes/solutions/2957704/mo-ban-dfs-shi-jian-chuo-manacher-suan-f-ttu6/
rating 2475 (clist.by)
 */