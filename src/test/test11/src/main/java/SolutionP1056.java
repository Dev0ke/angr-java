public class SolutionP1056 {
    public boolean confusingNumber(int n) {
        String str = String.valueOf(n);
        if (str.contains("2") || str.contains("3") || str.contains("4") || str.contains("5") || str.contains("7")) {
            return false;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
            } else if (chars[i] == '9') {
                chars[i] = '6';
            }
        }
        return !new StringBuilder(String.valueOf(chars)).reverse().toString().equals(str);
    }
}
/*
$1056. 易混淆数
https://leetcode.cn/problems/confusing-number/

给定一个数字 N，当它满足以下条件的时候返回 true：
原数字旋转 180° 以后可以得到新的数字。
如 0, 1, 6, 8, 9 旋转 180° 以后，得到了新的数字 0, 1, 9, 8, 6 。
2, 3, 4, 5, 7 旋转 180° 后，得到的不是数字。
易混淆数 (confusing number) 在旋转180°以后，可以得到和原来不同的数，且新数字的每一位都是有效的。
提示：
0 <= N <= 10^9
可以忽略掉旋转后得到的前导零，例如，如果我们旋转后得到 0008 那么该数字就是 8 。

模拟。
 */