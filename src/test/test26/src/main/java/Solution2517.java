import java.util.Arrays;

public class Solution2517 {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);

        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(price, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean checkMid(int[] price, int k, int d) {
        int len = price.length;
        int cnt = 1;
        int want = price[0] + d;
        for (int i = 1; i < len; i++) {
            if (price[i] >= want) {
                cnt++;
                want = price[i] + d;
            }
        }
        return cnt >= k;
    }
}
/*
2517. 礼盒的最大甜蜜度
https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/

第 325 场周赛 T3。

给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。
商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。
返回礼盒的 最大 甜蜜度。
提示：
1 <= price.length <= 10^5
1 <= price[i] <= 10^9
2 <= k <= price.length

二分查找
 */