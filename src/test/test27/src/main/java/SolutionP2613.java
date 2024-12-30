import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class SolutionP2613 {
    public int[] beautifulPair(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[]{n, n};
        Map<Long, Integer> map = new HashMap<>();
        Point[] a = new Point[n];
        for (int j = 0; j < n; j++) {
            long key = (long) nums1[j] << 32 | nums2[j];
            if (map.containsKey(key)) {
                int i = map.get(key);
                if (i < ans[0]) {
                    ans[0] = i;
                    ans[1] = j;
                }
            } else {
                map.put(key, j);
            }
            a[j] = new Point(nums1[j], nums2[j], j);
        }
        if (ans[0] < n) return ans;

        Arrays.sort(a, (p, q) -> p.x != q.x ? Integer.compare(p.x, q.x) : Integer.compare(p.y, q.y));
        int mn = Integer.MAX_VALUE;
        TreeSet<Point> s = new TreeSet<>((p, q) -> p.y != q.y ? Integer.compare(p.y, q.y) : Integer.compare(p.i, q.i));

        for (int i = 0, l = 0; i < n; i++) {
            while (l < i && a[i].x - a[l].x > mn) {
                s.remove(a[l++]);
            }
            Point lowerBound = new Point(a[i].x, a[i].y - mn, 0);
            for (Point p1 : s.tailSet(lowerBound)) {
                if (p1.y - a[i].y > mn) break;
                Point p2 = a[i];
                int d = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
                int i0 = Math.min(p1.i, p2.i);
                int i1 = Math.max(p1.i, p2.i);
                if (d < mn || (d == mn && i0 < ans[0]) || (d == mn && i0 == ans[0] && i1 < ans[1])) {
                    mn = d;
                    ans[0] = i0;
                    ans[1] = i1;
                }
            }
            s.add(a[i]);
        }

        return ans;
    }

    static class Point {
        int x, y, i;

        Point(int x, int y, int i) {
            this.x = x;
            this.y = y;
            this.i = i;
        }
    }
}
/*
$2613. 美数对
https://leetcode.cn/problems/beautiful-pairs/description/

给定两个长度相同的 下标从 0 开始 的整数数组 nums1 和 nums2 ，如果 |nums1[i] - nums1[j]| + |nums2[i] - nums2[j]| 在所有可能的下标对中是最小的，其中 i < j ，则称下标对 (i,j) 为 美 数对，
返回美数对。如果有多个美数对，则返回字典序最小的美数对。
注意：
- |x| 表示 x 的绝对值。
- 一对索引 (i1, j1) 在字典序意义下小于 (i2, j2) ，当且仅当 i1 < i2 或 i1 == i2 且 j1 < j2 。
提示：
2 <= nums1.length, nums2.length <= 10^5
nums1.length == nums2.length
0 <= nums1i <= nums1.length
0 <= nums2i <= nums2.length

平面最近点对
https://leetcode.cn/problems/beautiful-pairs/solutions/2211803/python3c-ping-mian-zui-jin-dian-dui-wen-3hpl8/
http://oi-wiki.com/geometry/nearest-points/
https://github.com/EndlessCheng/codeforces-go/blob/a707a2c9af5063a42fae95bcd38a0be21ea600cc/copypasta/geometry.go#L766
 */