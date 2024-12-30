public class Solution2525 {
    private static final int E4 = (int) 1e4;
    private static final int E9 = (int) 1e9;
    private static final String BULKY = "Bulky";
    private static final String HEAVY = "Heavy";
    private static final String BOTH = "Both";
    private static final String NEITHER = "Neither";

    public String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = false;
        boolean heavy = false;
        if (length >= E4 || width >= E4 || height >= E4
                || (long) length * width * height >= E9) {
            bulky = true;
        }
        if (mass >= 100) {
            heavy = true;
        }
        if (bulky && heavy) {
            return BOTH;
        }
        if (!bulky && !heavy) {
            return NEITHER;
        }
        if (bulky) {
            return BULKY;
        }
        return HEAVY;
    }
}
/*
2525. 根据规则将箱子分类
https://leetcode.cn/problems/categorize-box-according-to-criteria/

第 95 场双周赛 T1。

给你四个整数 length ，width ，height 和 mass ，分别表示一个箱子的三个维度和质量，请你返回一个表示箱子 类别 的字符串。
- 如果满足以下条件，那么箱子是 "Bulky" 的：
  - 箱子 至少有一个 维度大于等于 10^4 。
  - 或者箱子的 体积 大于等于 10^9 。
- 如果箱子的质量大于等于 100 ，那么箱子是 "Heavy" 的。
- 如果箱子同时是 "Bulky" 和 "Heavy" ，那么返回类别为 "Both" 。
- 如果箱子既不是 "Bulky" ，也不是 "Heavy" ，那么返回类别为 "Neither" 。
- 如果箱子是 "Bulky" 但不是 "Heavy" ，那么返回类别为 "Bulky" 。
- 如果箱子是 "Heavy" 但不是 "Bulky" ，那么返回类别为 "Heavy" 。
注意，箱子的体积等于箱子的长度、宽度和高度的乘积。
提示：
1 <= length, width, height <= 10^5
1 <= mass <= 10^3

模拟
 */