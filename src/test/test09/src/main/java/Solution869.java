import java.util.Arrays;

public class Solution869 {
    public boolean reorderedPowerOf2(int n) {
        int[] nArr = caseNum2Array(n);
        // int 32bit
        for (int i = 0; i < 32; i++) {
            int powStr = (int) Math.pow(2, i);
            if (Arrays.equals(nArr, caseNum2Array(powStr))) {
                return true;
            }
        }
        return false;
    }

    private int[] caseNum2Array(int num) {
        // 0~9 10 个字符
        int[] res = new int[10];
        for (char ch : String.valueOf(num).toCharArray()) {
            res[ch - '0']++;
        }
        return res;
    }
}
/*
869. 重新排序得到 2 的幂
https://leetcode.cn/problems/reordered-power-of-2/

第 93 场周赛 T2。

给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
提示：
1 <= n <= 10^9

按任何顺序重排，但是字符出现次数是不变的。
魔鬼数字解释：
32: int 最大是 32bit
10: 0~9 共 10 个字符
 */