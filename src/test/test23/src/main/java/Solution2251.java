import java.util.Arrays;
import java.util.Comparator;

public class Solution2251 {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int len = persons.length;

        // 排序前先记录 idx
        int[][] persons2d = new int[len][3];
        for (int i = 0; i < len; i++) {
            // [idx, persons[i], number]
            persons2d[i] = new int[]{i, persons[i]};
        }
        Arrays.sort(persons2d, Comparator.comparing(o -> o[1]));
        int min = persons2d[0][1];
        int max = persons2d[len - 1][1];

        // 差分数组
        int[] diff = new int[len + 1];
        for (int[] flower : flowers) {
            int start = flower[0];
            int end = flower[1];
            // 判断边界
            if (start > max || max < min) {
                continue;
            }

            // 二分
            // 左边界
            int left = 0;
            int right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (persons2d[mid][1] >= start) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int leftIdx = Math.min(len - 1, left);

            // 右边界
            left = 0;
            right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (persons2d[mid][1] > end) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int rightIdx = left - 1;

            diff[leftIdx] += 1;
            diff[rightIdx + 1] -= 1;
        }

        // 差分原数组
        int[] origin = new int[len];
        origin[0] = diff[0];
        for (int i = 1; i < len; i++) {
            origin[i] = origin[i - 1] + diff[i];
        }

        // 答案
        for (int i = 0; i < len; i++) {
            persons2d[i] = new int[]{persons2d[i][0], persons2d[i][1], origin[i]};
        }
        return Arrays.stream(persons2d).sorted(Comparator.comparing(o -> o[0])).mapToInt(o -> o[2]).toArray();
    }
}
/*
2251. 花期内花的数目
https://leetcode.cn/problems/number-of-flowers-in-full-bloom/

第 290 场周赛 T4。

给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期 从 starti 到 endi （都 包含）。
同时给你一个下标从 0 开始大小为 n 的整数数组 persons ，persons[i] 是第 i 个人来看花的时间。
请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。
提示：
1 <= flowers.length <= 5 * 10^4
flowers[i].length == 2
1 <= starti <= endi <= 10^9
1 <= persons.length <= 5 * 10^4
1 <= persons[i] <= 10^9

离散化差分数组。
由于 endi <= 10^9，直接套差分数组会 MLE。观察到 persons.length <= 5 * 10^4，可以基于 person 做离散化。
 */