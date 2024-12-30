import java.util.ArrayDeque;
import java.util.Deque;

public class Solution682 {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                int num = pop1 + pop2;
                stack.push(pop2);
                stack.push(pop1);
                stack.push(num);
            } else if (op.equals("D")) {
                int pop1 = stack.pop();
                int num = pop1 * 2;
                stack.push(pop1);
                stack.push(num);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        // 求和
        int sum = 0;
        for (Integer integer : stack) {
            sum += integer;
        }
        return sum;
    }
}
/*
682. 棒球比赛
https://leetcode.cn/problems/baseball-game/

你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
1.整数 x - 表示本回合新获得分数 x
2."+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
3."D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
4."C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
请你返回记录中所有得分的总和。
提示：
1 <= ops.length <= 1000
ops[i] 为 "C"、"D"、"+"，或者一个表示整数的字符串。整数范围是 [-3 * 10^4, 3 * 10^4]
对于 "+" 操作，题目数据保证记录此操作时前面总是存在两个有效的分数
对于 "C" 和 "D" 操作，题目数据保证记录此操作时前面总是存在一个有效的分数

模拟。
 */