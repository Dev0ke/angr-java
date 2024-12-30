import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> xPowerList = getPowerList(x, bound);
        List<Integer> yPowerList = getPowerList(y, bound);
        // 枚举
        Set<Integer> ans = new HashSet<>();
        for (int xPower : xPowerList) {
            for (int yPower : yPowerList) {
                int sum = xPower + yPower;
                if (sum <= bound) {
                    ans.add(sum);
                } else {
                    // 两个 List 都是有序的，后面的可以直接剪枝掉
                    break;
                }
            }
        }
        return new ArrayList<>(ans);
    }

    private List<Integer> getPowerList(int num, int bound) {
        // 1 的任意次方都等于 1，需单独处理，否则死循环
        if (num == 1) {
            return List.of(1);
        }
        int pow = 0;
        List<Integer> powerList = new ArrayList<>();
        while (Math.pow(num, pow) < bound) {
            powerList.add((int) Math.pow(num, pow));
            pow++;
        }
        return powerList;
    }
}
/*
970. 强整数
https://leetcode.cn/problems/powerful-integers/

第 118 场周赛 T1。

给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
返回值小于或等于 bound 的所有强整数组成的列表。
你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
提示：
1 <= x, y <= 100
0 <= bound <= 10^6

根据题意枚举即可。
 */