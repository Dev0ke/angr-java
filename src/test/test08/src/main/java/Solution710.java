import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Solution710 {
    static class Solution {
        private final Map<Integer, Integer> b2w;
        private final Random random;
        private final int bound;

        public Solution(int n, int[] blacklist) {
            b2w = new HashMap<>();
            random = new Random();
            int m = blacklist.length;
            bound = n - m;
            Set<Integer> black = new HashSet<>();
            for (int b : blacklist) {
                if (b >= bound) {
                    black.add(b);
                }
            }

            int w = bound;
            for (int b : blacklist) {
                if (b < bound) {
                    while (black.contains(w)) {
                        ++w;
                    }
                    b2w.put(b, w);
                    ++w;
                }
            }
        }

        public int pick() {
            int x = random.nextInt(bound);
            return b2w.getOrDefault(x, x);
        }
    }
}
/*
710. 黑名单中的随机数
https://leetcode.cn/problems/random-pick-with-blacklist/

给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 blacklist 的整数。
任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
优化你的算法，使它最小化调用语言 内置 随机函数的次数。
实现 Solution 类:
- Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数
- int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数
提示:
1 <= n <= 10^9
0 <= blacklist.length <= min(10^5, n - 1)
0 <= blacklist[i] < n
blacklist 中所有值都 不同
pick 最多被调用 2 * 10^4 次

哈希表
不能使用普通的拒绝采样做法，这样单次 pick 被拒绝的次数可能很大。
相似题目: 478. 在圆内随机生成点
https://leetcode.cn/problems/generate-random-point-in-a-circle/
 */