import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SolutionP2021 {
    // 146ms
    public int brightestPosition(int[][] lights) {
        TreeMap<Integer, Integer> diff = new TreeMap<>();
        for (int[] p : lights) {
            int l = p[0] - p[1], r = p[0] + p[1];
            diff.merge(l, 1, Integer::sum);
            diff.merge(r + 1, -1, Integer::sum);
        }
        int sumD = 0;
        int max = 0, ans = -1;
        for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
            int k = entry.getKey();
            sumD += entry.getValue();
            if (sumD > max) {
                max = sumD;
                ans = k;
            }
        }
        return ans;
    }

    // 128ms
    public int brightestPosition2(int[][] lights) {
        // 离散化
        int[] yArr = getDiscrete(lights);

        int[] diff = new int[yArr.length];
        for (int[] p : lights) {
            int l = getId(yArr, p[0] - p[1]);
            int r = getId(yArr, p[0] + p[1] + 1);
            diff[l]++;
            diff[r]--;
        }
        int sumD = 0;
        int max = 0, ans = -1;
        for (int i = 0; i < yArr.length; i++) {
            sumD += diff[i];
            if (sumD > max) {
                max = sumD;
                ans = yArr[i];
            }
        }
        return ans;
    }

    // x:type=0, y:type=1
    private int[] getDiscrete(int[][] lights) {
        Set<Integer> set = new HashSet<>();
        for (int[] p : lights) {
            set.add(p[0] - p[1]);
            set.add(p[0] + p[1] + 1);
        }
        int sz = set.size();
        int[] arr = new int[sz];
        int id = 0;
        for (Integer x : set) arr[id++] = x;
        Arrays.sort(arr);
        return arr;
    }

    private int getId(int[] arr, int x) {
        return Arrays.binarySearch(arr, x);
    }
}
/*
$2021. 街上最亮的位置
https://leetcode.cn/problems/brightest-position-on-street/description/

一条街上有很多的路灯，路灯的坐标由数组 lights 的形式给出。 每个 lights[i] = [positioni, rangei] 代表坐标为 positioni 的路灯照亮的范围为 [positioni - rangei, positioni + rangei] （包括顶点）。
位置 p 的亮度由能够照到 p的路灯的数量来决定的。
给出 lights, 返回最亮的位置 。如果有很多，返回坐标最小的。
提示:
1 <= lights.length <= 10^5
lights[i].length == 2
-10^8 <= positioni <= 10^8
0 <= rangei <= 10^8

差分数组。
时间复杂度 O(nlogn)。
相似题目: $2015. 每段建筑物的平均高度
https://leetcode.cn/problems/average-height-of-buildings-in-each-segment/description/
 */