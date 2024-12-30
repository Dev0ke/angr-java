import java.util.Arrays;

public class SolutionP1196 {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int sum = 0;
        int cnt = 0;
        for (int wi : weight) {
            if (sum + wi <= 5000) {
                sum += wi;
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
}
/*
$1196. 最多可以买到的苹果数量
https://leetcode.cn/problems/how-many-apples-can-you-put-into-the-basket/

你有一些苹果和一个可以承载 5000 单位重量的篮子。
给定一个整数数组 weight ，其中 weight[i] 是第 i 个苹果的重量，返回 你可以放入篮子的最大苹果数量 。
提示：
1 <= weight.length <= 10^3
1 <= weight[i] <= 10^3

排序，贪心。
时间复杂度 O(nlogn)
 */