import java.util.HashMap;
import java.util.Map;

public class Solution781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int x : answers) {
            cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int x = entry.getKey();
            int y = entry.getValue();
            // ceil(y/(x+1)) * (x+1)
            res += (y + x) / (x + 1) * (x + 1);
        }
        return res;
    }
}
/*
781. 森林中的兔子
https://leetcode.cn/problems/rabbits-in-forest/

森林中有未知数量的兔子。提问其中若干只兔子 "还有多少只兔子与你（指被提问的兔子）颜色相同?" ，将答案收集到一个整数数组 answers 中，其中 answers[i] 是第 i 只兔子的回答。
给你数组 answers ，返回森林中兔子的最少数量。
提示：
1 <= answers.length <= 1000
0 <= answers[i] < 1000

HashMap 统计后分组，由于可能存在没有回答的兔子，需要向上取值。
 */