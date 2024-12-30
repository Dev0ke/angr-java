import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution679 {
    private static final double SUM = 24.0;
    private static final double ZERO = 1e-6;

    public boolean judgePoint24(int[] nums) {
        int sz = nums.length;
        double[] dNums = new double[sz];
        for (int i = 0; i < sz; i++) {
            dNums[i] = nums[i];
        }
        return dfs(dNums, sz);
    }

    private boolean dfs(double[] nums, int sz) {
        if (sz == 1) {
            return Math.abs(nums[0] - SUM) < ZERO;
        }
        for (int i = 0; i < sz; i++) {
            for (int j = i + 1; j < sz; j++) {
                double n1 = nums[i];
                double n2 = nums[j];
                nums[j] = nums[sz - 1];
                nums[i] = n1 + n2;
                if (dfs(nums, sz - 1)) {
                    return true;
                }
                nums[i] = n1 * n2;
                if (dfs(nums, sz - 1)) {
                    return true;
                }
                nums[i] = n1 - n2;
                if (dfs(nums, sz - 1)) {
                    return true;
                }
                nums[i] = n2 - n1;
                if (dfs(nums, sz - 1)) {
                    return true;
                }
                if (n2 != 0) {
                    nums[i] = n1 / n2;
                    if (dfs(nums, sz - 1)) {
                        return true;
                    }
                }
                if (n1 != 0) {
                    nums[i] = n2 / n1;
                    if (dfs(nums, sz - 1)) {
                        return true;
                    }
                }
                nums[i] = n1;
                nums[j] = n2;
            }
        }
        return false;
    }

    private static Set<String> TABLE_SET;

    public boolean judgePoint242(int[] cards) {
        if (TABLE_SET == null) {
            TABLE_SET = new HashSet<>();
            TABLE_SET.add("1:1:1:1");
            TABLE_SET.add("1:1:1:2");
            TABLE_SET.add("1:1:1:3");
            TABLE_SET.add("1:1:1:4");
            TABLE_SET.add("1:1:1:5");
            TABLE_SET.add("1:1:1:6");
            TABLE_SET.add("1:1:1:7");
            TABLE_SET.add("1:1:1:9");
            TABLE_SET.add("1:1:2:2");
            TABLE_SET.add("1:1:2:3");
            TABLE_SET.add("1:1:2:4");
            TABLE_SET.add("1:1:2:5");
            TABLE_SET.add("1:1:3:3");
            TABLE_SET.add("1:1:5:9");
            TABLE_SET.add("1:1:6:7");
            TABLE_SET.add("1:1:7:7");
            TABLE_SET.add("1:1:7:8");
            TABLE_SET.add("1:1:7:9");
            TABLE_SET.add("1:1:8:9");
            TABLE_SET.add("1:1:9:9");
            TABLE_SET.add("1:2:2:2");
            TABLE_SET.add("1:2:2:3");
            TABLE_SET.add("1:2:9:9");
            TABLE_SET.add("1:3:5:5");
            TABLE_SET.add("1:4:9:9");
            TABLE_SET.add("1:5:5:7");
            TABLE_SET.add("1:5:5:8");
            TABLE_SET.add("1:5:7:7");
            TABLE_SET.add("1:6:6:7");
            TABLE_SET.add("1:6:7:7");
            TABLE_SET.add("1:6:7:8");
            TABLE_SET.add("1:7:7:7");
            TABLE_SET.add("1:7:7:8");
            TABLE_SET.add("1:8:9:9");
            TABLE_SET.add("1:9:9:9");
            TABLE_SET.add("2:2:2:2");
            TABLE_SET.add("2:2:2:6");
            TABLE_SET.add("2:2:7:9");
            TABLE_SET.add("2:2:9:9");
            TABLE_SET.add("2:3:3:4");
            TABLE_SET.add("2:5:5:5");
            TABLE_SET.add("2:5:5:6");
            TABLE_SET.add("2:5:9:9");
            TABLE_SET.add("2:6:7:7");
            TABLE_SET.add("2:7:7:7");
            TABLE_SET.add("2:7:7:9");
            TABLE_SET.add("2:7:9:9");
            TABLE_SET.add("2:9:9:9");
            TABLE_SET.add("3:3:5:8");
            TABLE_SET.add("3:4:6:7");
            TABLE_SET.add("3:4:8:8");
            TABLE_SET.add("3:5:5:5");
            TABLE_SET.add("3:5:7:7");
            TABLE_SET.add("4:4:5:9");
            TABLE_SET.add("4:4:6:6");
            TABLE_SET.add("4:4:6:7");
            TABLE_SET.add("4:4:9:9");
            TABLE_SET.add("4:7:7:9");
            TABLE_SET.add("4:9:9:9");
            TABLE_SET.add("5:5:5:7");
            TABLE_SET.add("5:5:5:8");
            TABLE_SET.add("5:5:6:9");
            TABLE_SET.add("5:5:7:9");
            TABLE_SET.add("5:7:7:7");
            TABLE_SET.add("5:7:7:8");
            TABLE_SET.add("5:7:9:9");
            TABLE_SET.add("5:8:9:9");
            TABLE_SET.add("5:9:9:9");
            TABLE_SET.add("6:6:6:7");
            TABLE_SET.add("6:6:7:7");
            TABLE_SET.add("6:6:7:8");
            TABLE_SET.add("6:6:9:9");
            TABLE_SET.add("6:7:7:7");
            TABLE_SET.add("6:7:7:8");
            TABLE_SET.add("6:7:7:9");
            TABLE_SET.add("6:7:8:8");
            TABLE_SET.add("6:9:9:9");
            TABLE_SET.add("7:7:7:7");
            TABLE_SET.add("7:7:7:8");
            TABLE_SET.add("7:7:7:9");
            TABLE_SET.add("7:7:8:8");
            TABLE_SET.add("7:7:8:9");
            TABLE_SET.add("7:7:9:9");
            TABLE_SET.add("7:8:8:8");
            TABLE_SET.add("7:8:9:9");
            TABLE_SET.add("7:9:9:9");
            TABLE_SET.add("8:8:8:8");
            TABLE_SET.add("8:8:8:9");
            TABLE_SET.add("8:8:9:9");
            TABLE_SET.add("8:9:9:9");
            TABLE_SET.add("9:9:9:9");
        }
        Arrays.sort(cards);
        String card = MessageFormat.format("{0}:{1}:{2}:{3}", cards[0], cards[1], cards[2], cards[3]);
        return !TABLE_SET.contains(card);
    }
}
/*
679. 24 点游戏
https://leetcode.cn/problems/24-game/

给定一个长度为4的整数数组 cards 。你有 4 张卡片，每张卡片上都包含一个范围在 [1,9] 的数字。您应该使用运算符 ['+', '-', '*', '/'] 和括号 '(' 和 ')' 将这些卡片上的数字排列成数学表达式，以获得值24。
你须遵守以下规则:
- 除法运算符 '/' 表示实数除法，而不是整数除法。
 - 例如， 4 /(1 - 2 / 3)= 4 /(1 / 3)= 12 。
- 每个运算都在两个数字之间。特别是，不能使用 “-” 作为一元运算符。
 - 例如，如果 cards =[1,1,1,1] ，则表达式 “-1 -1 -1 -1” 是 不允许 的。
- 你不能把数字串在一起
 - 例如，如果 cards =[1,2,1,2] ，则表达式 “12 + 12” 无效。
如果可以得到这样的表达式，其计算结果为 24 ，则返回 true ，否则返回 false 。
提示:
cards.length == 4
1 <= cards[i] <= 9

本题 1~9，共 495 种，有解 404 种，无解 91 种。
若拓展到 1~13，共 1820 种，有解 1362 种，无解 458 种。
 */