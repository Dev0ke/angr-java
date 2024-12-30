import java.util.Arrays;

public class Solution1691 {
    public int maxHeight(int[][] cuboids) {
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        Arrays.sort(cuboids, (o1, o2) -> {
            for (int i = 0; i < 3; i++) {
                if (o1[i] != o2[i]) {
                    return Integer.compare(o1[i], o2[i]);
                }
            }
            return 0;
        });

        int max = 0;
        int len = cuboids.length;
        int[] f = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 排序后，cuboids[j][0] <= cuboids[i][0] 恒成立
                if (cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    // cuboids[j] 可以堆在 cuboids[i] 上
                    f[i] = Math.max(f[i], f[j]);
                }
            }
            f[i] += cuboids[i][2];
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
/*
1691. 堆叠长方体的最大高度
https://leetcode.cn/problems/maximum-height-by-stacking-cuboids/

给你 n 个长方体 cuboids ，其中第 i 个长方体的长宽高表示为 cuboids[i] = [widthi, lengthi, heighti]（下标从 0 开始）。请你从 cuboids 选出一个 子集 ，并将它们堆叠起来。
如果 widthi <= widthj 且 lengthi <= lengthj 且 heighti <= heightj ，你就可以将长方体 i 堆叠在长方体 j 上。你可以通过旋转把长方体的长宽高重新排列，以将它放在另一个长方体上。
返回 堆叠长方体 cuboids 可以得到的 最大高度 。
提示：
n == cuboids.length
1 <= n <= 100
1 <= widthi, lengthi, heighti <= 100

时间复杂度 O(n^2)
空间复杂度 O(n)
相似题目: 354. 俄罗斯套娃信封问题
https://leetcode.cn/problems/russian-doll-envelopes/
面试题 08.13. 堆箱子
https://leetcode.cn/problems/pile-box-lcci/
 */