import java.util.Arrays;
import java.util.Comparator;

public class Solution2280 {
    public int minimumLines(int[][] stockPrices) {
        int len = stockPrices.length;
        Arrays.sort(stockPrices, Comparator.comparingInt(o -> o[0]));

        int cnt = 0;
        int preX = 0;
        int preY = 0;
        for (int i = 1; i < len; i++) {
            int x = stockPrices[i][0] - stockPrices[i - 1][0];
            int y = stockPrices[i][1] - stockPrices[i - 1][1];
            int gcdXY = getGCD(x, y);
            x /= gcdXY;
            y /= gcdXY;
            if (x != preX || y != preY) {
                preX = x;
                preY = y;
                cnt++;
            }
        }
        return cnt;
    }

    private int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
2280. 表示一个折线图的最少线段数
https://leetcode.cn/problems/minimum-lines-to-represent-a-line-chart/

第 294 场周赛 T3。

给你一个二维整数数组 stockPrices ，其中 stockPrices[i] = [dayi, pricei] 表示股票在 dayi 的价格为 pricei 。
折线图 是一个二维平面上的若干个点组成的图，横坐标表示日期，纵坐标表示价格，折线图由相邻的点连接而成。比方说下图是一个例子：
请你返回要表示一个折线图所需要的 最少线段数 。
提示：
1 <= stockPrices.length <= 10^5
stockPrices[i].length == 2
1 <= dayi, pricei <= 10^9
所有 dayi 互不相同 。

枚举斜率
相似题目: 149. 直线上最多的点数
https://leetcode.cn/problems/max-points-on-a-line/
 */