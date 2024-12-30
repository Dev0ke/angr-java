public class SolutionP1256 {
    public String encode(int num) {
        return Integer.toBinaryString(num + 1).substring(1);
    }
}
/*
$1256. 加密数字
https://leetcode.cn/problems/encode-number/

给你一个非负整数 num ，返回它的「加密字符串」。
加密的过程是把一个整数用某个未知函数进行转化，你需要从下表推测出该转化函数：
```
n   f(n)
0   ""
1   "0"
2   "1"
3   "00"
4   "01"
5   "10"
6   "11"
7   "000"
```
提示：
0 <= num <= 10^9

规律便是 (num+1) 转换为二进制后去掉第一位即可
 */