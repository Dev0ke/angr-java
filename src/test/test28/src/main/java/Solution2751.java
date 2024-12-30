import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2751 {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, positions[i], healths[i], directions.charAt(i) == 'R' ? 1 : -1);
        }
        Arrays.sort(nodes, Comparator.comparingInt(o -> o.pos));

        List<Node> ans = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        for (Node node : nodes) {
            if (node.dir == 1) {
                stack.push(node);
                continue;
            }
            // 向左
            // Python while-else 语法
            label:
            {
                while (!stack.isEmpty()) {
                    if (node.health < stack.peek().health) {
                        // 栈顶健康度更大
                        stack.peek().health--;
                        break label;
                    } else if (node.health == stack.peek().health) {
                        // 健康度一样大
                        stack.pop();
                        break label;
                    } else {
                        // 向左的更大
                        node.health--;
                        stack.pop();
                    }
                }
                ans.add(node);
            }
        }
        ans.addAll(stack);
        ans.sort(Comparator.comparingInt(o -> o.id));
        return ans.stream().map(o -> o.health).collect(Collectors.toList());
    }

    private static class Node {
        int id, pos, health, dir;

        public Node(int id, int pos, int health, int dir) {
            this.id = id;
            this.pos = pos;
            this.health = health;
            this.dir = dir;
        }
    }
}
/*
2751. 机器人碰撞
https://leetcode.cn/problems/robot-collisions/

第 351 场周赛 T4。

现有 n 个机器人，编号从 1 开始，每个机器人包含在路线上的位置、健康度和移动方向。
给你下标从 0 开始的两个整数数组 positions、healths 和一个字符串 directions（directions[i] 为 'L' 表示 向左 或 'R' 表示 向右）。 positions 中的所有整数 互不相同 。
所有机器人以 相同速度 同时 沿给定方向在路线上移动。如果两个机器人移动到相同位置，则会发生 碰撞 。
如果两个机器人发生碰撞，则将 健康度较低 的机器人从路线中 移除 ，并且另一个机器人的健康度 减少 1 。幸存下来的机器人将会继续沿着与之前 相同 的方向前进。如果两个机器人的健康度相同，则将二者都从路线中移除。
请你确定全部碰撞后幸存下的所有机器人的 健康度 ，并按照原来机器人编号的顺序排列。即机器人 1 （如果幸存）的最终健康度，机器人 2 （如果幸存）的最终健康度等。 如果不存在幸存的机器人，则返回空数组。
在不再发生任何碰撞后，请你以数组形式，返回所有剩余机器人的健康度（按机器人输入中的编号顺序）。
注意：位置  positions 可能是乱序的。
提示：
1 <= positions.length == healths.length == directions.length == n <= 10^5
1 <= positions[i], healths[i] <= 10^9
directions[i] == 'L' 或 directions[i] == 'R'
positions 中的所有值互不相同

栈模拟
相似题目: 735. 行星碰撞
https://leetcode.cn/problems/asteroid-collision/
 */