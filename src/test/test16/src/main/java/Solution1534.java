public class Solution1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int len = arr.length;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((Math.abs(arr[i] - arr[j]) <= a)) {
                    cnt = getCnt(arr, b, c, len, cnt, i, j);
                }
            }
        }
        return cnt;
    }

    private int getCnt(int[] arr, int b, int c, int len, int cnt, int i, int j) {
        for (int k = j + 1; k < len; k++) {
            if ((Math.abs(arr[j] - arr[k]) <= b) && (Math.abs(arr[i] - arr[k]) <= c)) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
1534. 统计好三元组
https://leetcode.cn/problems/count-good-triplets/

第 200 场周赛 T1。

给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
- 0 <= i < j < k < arr.length
- |arr[i] - arr[j]| <= a
- |arr[j] - arr[k]| <= b
- |arr[i] - arr[k]| <= c
其中 |x| 表示 x 的绝对值。
返回 好三元组的数量 。
提示：
3 <= arr.length <= 100
0 <= arr[i] <= 1000
0 <= a, b, c <= 1000

暴力枚举即可。时间复杂度 O(n^3)
可以进行剪枝，时间复杂度 O(n^2)
抽取方法避免嵌套过深。
 */