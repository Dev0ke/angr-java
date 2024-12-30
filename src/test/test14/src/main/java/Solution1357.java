import java.util.HashMap;
import java.util.Map;

public class Solution1357 {
    static class Cashier {
        Map<Integer, Integer> price;
        int n, discount, customId;

        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.n = n;
            this.discount = discount;
            price = new HashMap<>();
            for (int i = 0; i < products.length; i++) {
                price.put(products[i], prices[i]);
            }
        }

        public double getBill(int[] product, int[] amount) {
            customId++;
            double ans = 0;
            for (int i = 0; i < product.length; i++) {
                ans += price.get(product[i]) * amount[i];
            }
            if (customId % n == 0) { // 每隔 n 个顾客结账时，该顾客的账单都会打折
                ans -= ans * discount / 100;
            }
            return ans;
        }
    }
}
/*
1357. 每隔 n 个顾客打折
https://leetcode.cn/problems/apply-discount-every-n-orders/description/

超市里正在举行打折活动，每隔 n 个顾客会得到 discount 的折扣。
超市里有一些商品，第 i 种商品为 products[i] 且每件单品的价格为 prices[i] 。
结账系统会统计顾客的数目，每隔 n 个顾客结账时，该顾客的账单都会打折，折扣为 discount （也就是如果原本账单为 x ，那么实际金额会变成 x - (discount * x) / 100 ），然后系统会重新开始计数。
顾客会购买一些商品， product[i] 是顾客购买的第 i 种商品， amount[i] 是对应的购买该种商品的数目。
请你实现 Cashier 类：
- Cashier(int n, int discount, int[] products, int[] prices) 初始化实例对象，参数分别为打折频率 n ，折扣大小 discount ，超市里的商品列表 products 和它们的价格 prices 。
- double getBill(int[] product, int[] amount) 返回账单的实际金额（如果有打折，请返回打折后的结果）。返回结果与标准答案误差在 10^-5 以内都视为正确结果。
提示：
1 <= n <= 10^4
0 <= discount <= 100
1 <= products.length <= 200
1 <= products[i] <= 200
products 列表中 不会 有重复的元素。
prices.length == products.length
1 <= prices[i] <= 1000
1 <= product.length <= products.length
product[i] 在 products 出现过。
amount.length == product.length
1 <= amount[i] <= 1000
最多有 1000 次对 getBill 函数的调用。
返回结果与标准答案误差在 10^-5 以内都视为正确结果。

模拟。
 */