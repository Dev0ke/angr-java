import java.util.Arrays;

public class Solution575 {
    public int distributeCandies(int[] candyType) {
        int m = (int) Arrays.stream(candyType).distinct().count();
        return Math.min(candyType.length / 2, m);
    }
}
/*
575. 分糖果
https://leetcode.cn/problems/distribute-candies/

Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。Alice 注意到她的体重正在增长，所以前去拜访了一位医生。
医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。
给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的最多种类数。
提示：
n == candyType.length
2 <= n <= 10^4
n 是一个偶数
-10^5 <= candyType[i] <= 10^5

数学。
假设 n 枚糖共 m 种糖。Alice 最多吃到 m 种糖，同时数量不会超过 n / 2，取二者最少值即可。
相似题目: 1103. 分糖果 II
https://leetcode.cn/problems/distribute-candies-to-people/description/
 */