public class Solution997 {
    public int findJudge(int n, int[][] trust) {
        // 从 1 到 n 为 n 个人进行编号
        int[] outDegrees = new int[n + 1];
        int[] inDegrees = new int[n + 1];
        for (int[] tru : trust) {
            int from = tru[0];
            int to = tru[1];
            outDegrees[from]++;
            inDegrees[to]++;
        }
        for (int i = 1; i <= n; i++) {
            if (outDegrees[i] == 0 && inDegrees[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
/*
997. 找到小镇的法官
https://leetcode.cn/problems/find-the-town-judge/

第 125 场周赛 T1。

在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。
如果小镇的法官真的存在，那么：
1.小镇的法官不相信任何人。
2.每个人（除了小镇法官外）都信任小镇的法官。
3.只有一个人同时满足条件 1 和条件 2 。
给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示编号为 a 的人信任编号为 b 的人。
如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。
提示：
1 <= n <= 1000
0 <= trust.length <= 10^4
trust[i].length == 2
trust 中的所有trust[i] = [ai, bi] 互不相同
ai != bi
1 <= ai, bi <= n

有向图
1.小镇的法官不相信任何人 => 小镇的法官出度为 0
2.每个人（除了小镇法官外）都信任小镇的法官 => 小镇的法官入度为 n-1
 */