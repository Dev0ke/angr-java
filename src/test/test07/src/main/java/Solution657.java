import java.util.HashMap;
import java.util.Map;

public class Solution657 {
    public boolean judgeCircle(String moves) {
        Map<Character, Integer> map = new HashMap<>(4);
        for (char ch : moves.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map.getOrDefault('U', 0).equals(map.getOrDefault('D', 0))
                && map.getOrDefault('L', 0).equals(map.getOrDefault('R', 0));
    }
}
/*
657. 机器人能否返回原点
https://leetcode.cn/problems/robot-return-to-origin/

在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
移动顺序由字符串 moves 表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
提示:
1 <= moves.length <= 2 * 10^4
moves 只包含字符 'U', 'D', 'L' 和 'R'

统计字符次数。若 U == D 并且 L == R 即能返回原点
 */