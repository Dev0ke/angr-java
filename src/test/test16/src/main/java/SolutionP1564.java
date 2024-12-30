import java.util.Arrays;

public class SolutionP1564 {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        for (int i = 1; i < warehouse.length; i++) {
            warehouse[i] = Math.min(warehouse[i - 1], warehouse[i]);
        }
        Arrays.sort(boxes);
        int i = 0;
        int j = warehouse.length - 1;
        while (i < boxes.length && j >= 0) {
            if (boxes[i] <= warehouse[j]) {
                i++;
                j--;
            } else {
                j--;
            }
        }
        return i;
    }
}
/*
$1564. 把箱子放进仓库里 I
https://leetcode.cn/problems/put-boxes-into-the-warehouse-i/

给定两个正整数数组 boxes 和 warehouse ，分别包含单位宽度的箱子的高度，以及仓库中 n 个房间各自的高度。仓库的房间分别从 0 到 n - 1 自左向右编号， warehouse[i] （索引从 0 开始）是第 i 个房间的高度。
箱子放进仓库时遵循下列规则：
- 箱子不可叠放。
- 你可以重新调整箱子的顺序。
- 箱子只能从左向右推进仓库中。
- 如果仓库中某房间的高度小于某箱子的高度，则这个箱子和之后的箱子都会停在这个房间的前面。
你最多可以在仓库中放进多少个箱子？
提示：
n == warehouse.length
1 <= boxes.length, warehouse.length <= 10^5
1 <= boxes[i], warehouse[i] <= 10^9

贪心 + 排序 + 双指针
时间复杂度 O(nlogn + m)。
相似题目: 1580. 把箱子放进仓库里 II
https://leetcode.cn/problems/put-boxes-into-the-warehouse-ii/description/
 */