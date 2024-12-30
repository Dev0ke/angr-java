import java.util.HashSet;
import java.util.Set;

public class Solution1496 {
    public boolean isPathCrossing(String path) {
        Set<Integer> vis = new HashSet<>();
        int x = 0, y = 0;
        vis.add(0);
        for (char c : path.toCharArray()) {
            if (c == 'N') x--;
            else if (c == 'S') x++;
            else if (c == 'W') y--;
            else if (c == 'E') y++;
            int hash = x * 20005 + y;
            if (vis.contains(hash)) return true;
            vis.add(hash);
        }
        return false;
    }
}
/*
1496. 判断路径是否相交
https://leetcode.cn/problems/path-crossing/description/

给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
你从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
如果路径在任何位置上与自身相交，也就是走到之前已经走过的位置，请返回 true ；否则，返回 false 。
提示：
1 <= path.length <= 10^4
path[i] 为 'N'、'S'、'E' 或 'W'

哈希表模拟。
时间复杂度 O(n)。
 */