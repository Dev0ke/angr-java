import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SolutionP3119 {
    public int maxPotholes(String road, int budget) {
        int n = road.length();
        List<Integer> potholes = new ArrayList<>();
        int i = 0;
        while (i < n) {
            // 分组循环
            int st = i;
            for (i++; i < n && road.charAt(i) == road.charAt(st); i++) {
            }
            if (road.charAt(st) == 'x') potholes.add(i - st);
        }

        // 'x' 段长度 降序排序
        potholes.sort(Comparator.reverseOrder());
        int ans = 0;
        for (Integer pothole : potholes) {
            if (budget >= pothole + 1) {
                budget -= pothole + 1;
                ans += pothole;
            } else {
                ans += Math.max(0, budget - 1);
                break;
            }
        }
        return ans;
    }
}
/*
$3119. 最大数量的可修复坑洼
https://leetcode.cn/problems/maximum-number-of-potholes-that-can-be-fixed/description/

给定一个字符串 road，只包含字符 "x" 和 "."，其中每个 "x" 代表一个坑洼，每个 "." 代表一个平滑的道路，以及一个整数 budget。
在一次修复操作中，您可以以 n + 1 的价格修复 n 个连续坑洼。
返回可以修复的坑洼的 最大 数量，以便所有修复的价格总和 不会超过 给定的预算 budget。
提示：
1 <= road.length <= 10^5
1 <= budget <= 10^5 + 1
road 只包含字符 '.' 和 'x'。

分组循环 + 贪心。
时间复杂度 O(nlogn)。
 */