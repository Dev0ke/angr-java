public class SolutionP246 {
    public boolean isStrobogrammatic(String num) {
        int l = 0, r = num.length() - 1;
        while (l <= r) {
            int x = num.charAt(l) - '0';
            int y = num.charAt(r) - '0';
            // 无法组成中心对称数的数字 2,3,4,5,7
            if (is23457(x) || is23457(y)) {
                return false;
            }
            if ((x == 0 && y != 0)
                    || (x == 1 && y != 1)
                    || (x == 6 && y != 9)
                    || (x == 8 && y != 8)
                    || (x == 9 && y != 6)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean is23457(int num) {
        return num == 2 || num == 3 || num == 4 || num == 5 || num == 7;
    }
}
/*
$246. 中心对称数
https://leetcode.cn/problems/strobogrammatic-number/

中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。

相似题目: $247. 中心对称数 II
https://leetcode.cn/problems/strobogrammatic-number-ii/
$248. 中心对称数 III
https://leetcode.cn/problems/strobogrammatic-number-iii/
 */