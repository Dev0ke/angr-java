public class SolutionP2979 {
    public int mostExpensiveItem(int primeOne, int primeTwo) {
        return primeOne * primeTwo - primeOne - primeTwo;
    }
}
/*
2979. 最贵的无法购买的商品
https://leetcode.cn/problems/most-expensive-item-that-can-not-be-bought/description/

给定两个 不同的质数 primeOne 和 primeTwo。
Alice 和 Bob 正在逛市场。该市场有 无数种 商品，对于 任何 正整数 x，都存在一个价格为 x 的物品。Alice 想从市场里买一些东西送给 Bob。她有 无数个 面值为 primeOne 和 primeTwo 的硬币。她想知道她 无法 用她拥有的硬币购买的 最贵 商品的价格。
返回 Alice 无法买给 Bob 的 最贵 商品的价格。
提示：
1 < primeOne, primeTwo < 10^4
primeOne, primeTwo 都是质数。
primeOne * primeTwo < 10^5

麦乐鸡定理（Chicken McNugget Theorem）
对于任意互质的 a,b 不能被表示为 ax+by 的形式的最大整数为 ab-a-b
 */