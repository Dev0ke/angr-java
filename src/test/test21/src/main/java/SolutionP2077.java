import java.util.Arrays;
import java.util.BitSet;

public class SolutionP2077 {
    // https://atcoder.jp/contests/abc258/tasks/abc258_g
    // https://leetcode.cn/problems/paths-in-maze-that-lead-to-same-room/solutions/1645983/by-freeyourmind-dzkw
    public int numberOfPaths(int n, int[][] corridors) {
        BitSet[] bits = new BitSet[n];
        Arrays.setAll(bits, e -> new BitSet());
        for (int[] p : corridors) {
            int a = p[0] - 1, b = p[1] - 1;
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            bits[a].set(b);
        }
        int ans = 0;
        for (int[] p : corridors) {
            int a = p[0] - 1, b = p[1] - 1;
            BitSet bitA = (BitSet) bits[a].clone();
            bitA.and(bits[b]);
            ans += bitA.cardinality();
        }
        return ans;
    }
}
/*
$2077. 殊途同归
https://leetcode.cn/problems/paths-in-maze-that-lead-to-same-room/description/

迷宫由 n 个从 1 到 n 的房间组成，有些房间由走廊连接。给定一个二维整数数组 corridors，其中 corridors[i] = [room1i, room2i] 表示有一条走廊连接 room1i 和room2i，允许迷宫中的一个人从 room1i 到 room2i ，反之亦然。
迷宫的设计者想知道迷宫有多让人困惑。迷宫的 混乱分数 是 长度为 3 的不同的环的数量。
- 例如, 1 → 2 → 3 → 1 是长度为 3 的环, 但 1 → 2 → 3 → 4 和 1 → 2 → 3 → 2 → 1 不是。
如果在第一个环中访问的一个或多个房间 不在 第二个环中，则认为两个环是 不同 的。
返回迷宫的混乱分数。
提示:
2 <= n <= 1000
1 <= corridors.length <= 5 * 10^4
corridors[i].length == 2
1 <= room1i, room2i <= n
room1i != room2i
没有重复的走廊。

```py
class Solution:
    def numberOfPaths(self, n: int, corridors: List[List[int]]) -> int:
        bits = [0] * (n + 1)
        for a, b in corridors:
            if a > b: a, b = b, a
            bits[a] += 1 << b
        return sum((bits[a] & bits[b]).bit_count() for a, b in corridors)
```
加强版：
```py
B = 63

class Solution:
    def numberOfPaths(self, n: int, corridors: List[List[int]]) -> int:
        bits, res = [[0] * ((n + B) // B) for _ in range(n)], 0
        for a, b in corridors:
            a, b = a - 1, b - 1
            if a > b: a, b = b, a
            bi, bp = divmod(b, B)
            bits[a][bi] += 1 << bp

        for a, b in corridors:
            a, b = a - 1, b - 1
            if a > b: a, b = b, a
            bi = b // B
            res += sum((bits[a][i] & bits[b][i]).bit_count() for i in range(b // B, len(bits[a])))

        return res
```
 */