import java.util.Arrays;

public class Solution1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        int res = 0;
        int curSize = 0;
        for (int[] boxType : boxTypes) {
            if (curSize + boxType[0] <= truckSize) {
                curSize += boxType[0];
                res += boxType[0] * boxType[1];
            } else {
                res += (truckSize - curSize) * boxType[1];
                break;
            }
        }
        return res;
    }
}
/*
1710. 卡车上的最大单元数
https://leetcode.cn/problems/maximum-units-on-a-truck/

第 222 场周赛 T1。

请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
- numberOfBoxesi 是类型 i 的箱子的数量。
- numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
返回卡车可以装载 单元 的 最大 总数。
提示：
1 <= boxTypes.length <= 1000
1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
1 <= truckSize <= 10^6

贪心。
 */