public class Solution2303 {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        int pre = 0;
        for (int[] bracket : brackets) {
            if (income >= pre) {
                res += Math.min(income - pre, bracket[0] - pre) * bracket[1] / 100.0;
                pre = bracket[0];
            } else {
                break;
            }
        }
        return res;
    }
}
/*
2303. 计算应缴税款总额
https://leetcode.cn/problems/calculate-amount-paid-in-taxes/

第 297 场周赛 T1。

给你一个下标从 0 开始的二维整数数组 brackets ，其中 brackets[i] = [upperi, percenti] ，表示第 i 个税级的上限是 upperi ，征收的税率为 percenti 。
税级按上限 从低到高排序（在满足 0 < i < brackets.length 的前提下，upperi-1 < upperi）。
税款计算方式如下：
- 不超过 upper0 的收入按税率 percent0 缴纳
- 接着 upper1 - upper0 的部分按税率 percent1 缴纳
- 然后 upper2 - upper1 的部分按税率 percent2 缴纳
- 以此类推
给你一个整数 income 表示你的总收入。返回你需要缴纳的税款总额。与标准答案误差不超 10^-5 的结果将被视作正确答案。
提示：
1 <= brackets.length <= 100
1 <= upperi <= 1000
0 <= percenti <= 100
0 <= income <= 1000
upperi 按递增顺序排列
upperi 中的所有值 互不相同
最后一个税级的上限大于等于 income

模拟。
 */