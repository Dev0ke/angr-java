import java.util.ArrayList;
import java.util.List;

public class Solution2162 {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int min = Integer.MAX_VALUE;

        List<String> stringList = convert2Strings(targetSeconds);
        for (String str : stringList) {
            // 不忽略 0
            int cnt = 0;
            char curAt = (char) ('0' + startAt);
            for (char ch : str.toCharArray()) {
                if (curAt != ch) {
                    cnt += moveCost;
                    curAt = ch;
                }
                cnt += pushCost;
            }
            min = Math.min(min, cnt);
        }
        return min;
    }

    private List<String> convert2Strings(int targetSeconds) {
        List<String> resList = new ArrayList<>();
        int minutes = targetSeconds / 60;
        if (minutes == 0) {
            // 00
            resList.add("00" + format(targetSeconds));
            resList.add(String.valueOf(targetSeconds));
        } else if (minutes == 100) {
            // 99
            resList.add("99" + format(targetSeconds % 60 + 60));
        } else {
            // 01-99
            String str1 = format(minutes) + format(targetSeconds % 60);
            resList.add(str1);
            resList.add(String.valueOf(Integer.parseInt(str1)));
            if (targetSeconds % 60 + 60 <= 99) {
                String str2 = format(minutes - 1) + format(targetSeconds % 60 + 60);
                resList.add(str2);
                resList.add(String.valueOf(Integer.parseInt(str2)));
            }
        }
        return resList;
    }

    private String format(int seconds) {
        if (seconds < 10) {
            return "0" + seconds;
        }
        return String.valueOf(seconds);
    }
}
/*
2162. 设置时间的最少代价
https://leetcode.cn/problems/minimum-cost-to-set-cooking-time/

第 71 场双周赛 T3。

常见的微波炉可以设置加热时间，且加热时间满足以下条件：
- 至少为 1 秒钟。
- 至多为 99 分 99 秒。
你可以 最多 输入 4 个数字 来设置加热时间。如果你输入的位数不足 4 位，微波炉会自动加 前缀 0 来补足 4 位。
微波炉会将设置好的四位数中，前 两位当作分钟数，后 两位当作秒数。它们所表示的总时间就是加热时间。比方说：
- 你输入 9 5 4 （三个数字），被自动补足为 0954 ，并表示 9 分 54 秒。
- 你输入 0 0 0 8 （四个数字），表示 0 分 8 秒。
- 你输入 8 0 9 0 ，表示 80 分 90 秒。
- 你输入 8 1 3 0 ，表示 81 分 30 秒。
给你整数 startAt ，moveCost ，pushCost 和 targetSeconds 。一开始，你的手指在数字 startAt 处。
将手指移到 任何其他数字 ，需要花费 moveCost 的单位代价。每 输入你手指所在位置的数字一次，需要花费 pushCost 的单位代价。
要设置 targetSeconds 秒的加热时间，可能会有多种设置方法。你想要知道这些方法中，总代价最小为多少。
请你能返回设置 targetSeconds 秒钟加热时间需要花费的最少代价。
请记住，虽然微波炉的秒数最多可以设置到 99 秒，但一分钟等于 60 秒。
提示：
0 <= startAt <= 9
1 <= moveCost, pushCost <= 10^5
1 <= targetSeconds <= 6039

比赛时存在读题障碍，被附图误导了，
startAt 指的是数字 0~9（而不是触摸显示面板的 4 个数字）
moveCost 是切换数字 0~9（而不是在显示面板 4 个数字间移动）
pushCost 是键入数字的单位代价。

主要复杂度应该在于分类讨论，将 targetSeconds 转换成时分（可能有 1~2 种方案，考虑前导 0 与不考虑前导 0）
注意边界 6039 = 99:99
 */