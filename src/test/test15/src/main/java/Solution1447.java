import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1447 {
    private static Map<Integer, List<String>> cacheMap;

    public List<String> simplifiedFractions(int n) {
        if (cacheMap == null) {
            cacheMap = new HashMap<>();
            for (int i = 2; i <= 100; i++) {
                List<String> list = new ArrayList<>();
                for (int j = 1; j < i; j++) {
                    if (j == 1 || (getGCD(i, j) == 1)) {
                        list.add(j + "/" + i);
                    }
                }
                cacheMap.put(i, list);
            }
        }

        List<String> resList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            resList.addAll(cacheMap.get(i));
        }
        return resList;
    }

    private static int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
1447. 最简分数
https://leetcode.cn/problems/simplified-fractions/

给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
提示：
1 <= n <= 100

数据量很小，可以直接打表。
化简分数实质上是求 gcd，分子分母互质（gcd == 1）
 */
