import java.util.Arrays;

public class SolutionP1580 {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int n = boxes.length, m = warehouse.length;
        int[] l = new int[m], r = new int[m];
        l[0] = r[m - 1] = Integer.MAX_VALUE;
        for (int i = 1; i < m; ++i) {
            l[i] = Math.min(l[i - 1], warehouse[i - 1]);
        }
        for (int i = m - 2; i >= 0; --i) {
            r[i] = Math.min(r[i + 1], warehouse[i + 1]);
        }
        for (int i = 0; i < m; ++i) {
            warehouse[i] = Math.min(warehouse[i], Math.max(l[i], r[i]));
        }
        Arrays.sort(boxes);
        Arrays.sort(warehouse);
        int ans = 0, idx = 0;
        for (int box : boxes) {
            while (idx < m && warehouse[idx] < box) {
                idx++;
            }
            if (idx == m) break;
            ans++;
            idx++;
        }
        return ans;
    }
}
/*
$1580. 把箱子放进仓库里 II
https://leetcode.cn/problems/put-boxes-into-the-warehouse-ii/description/

给定两个正整数数组 boxes 和 warehouse ，分别包含单位宽度的箱子的高度，以及仓库中n个房间各自的高度。仓库的房间分别从0 到 n - 1自左向右编号，warehouse[i]（索引从 0 开始）是第 i 个房间的高度。
箱子放进仓库时遵循下列规则：
- 箱子不可叠放。
- 你可以重新调整箱子的顺序。
- 箱子可以从任意方向（左边或右边）推入仓库中。
- 如果仓库中某房间的高度小于某箱子的高度，则这个箱子和之后的箱子都会停在这个房间的前面。
你最多可以在仓库中放进多少个箱子？
提示:
n == warehouse.length
1 <= boxes.length, warehouse.length <= 10^5
1 <= boxes[i], warehouse[i] <= 10^9

因为只能从最左边或者最右边装货，所以中间货仓的最大容纳高度（能放进去东西的最大高度）可能小于其本身的高度。
https://leetcode.cn/problems/put-boxes-into-the-warehouse-ii/solutions/408218/zhao-chu-huo-cang-de-zui-da-rong-na-gao-du-by-luci/
时间复杂度 O(nlogn)。
相似题目: $1564. 把箱子放进仓库里 I
https://leetcode.cn/problems/put-boxes-into-the-warehouse-i/
 */