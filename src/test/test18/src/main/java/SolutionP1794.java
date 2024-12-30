import java.util.Arrays;

public class SolutionP1794 {
    public int countQuadruples(String firstString, String secondString) {
        int[] index1 = new int[26];
        int[] index2 = new int[26];
        Arrays.fill(index1, -1);
        Arrays.fill(index2, -1);
        int cnt = 0;
        for (int i = 0; i < firstString.length(); ++i) {
            int c = firstString.charAt(i) - 'a';
            if (index1[c] == -1) {
                index1[c] = i;
                ++cnt;
            }
            if (cnt == 26) {
                break;
            }
        }
        cnt = 0;
        for (int i = secondString.length() - 1; i >= 0; --i) {
            int c = secondString.charAt(i) - 'a';
            if (index2[c] == -1) {
                index2[c] = i;
                ++cnt;
            }
            if (cnt == 26) {
                break;
            }
        }

        // 再次遍历去找位置
        int minDiff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < 26; ++i) {
            if (index1[i] != -1 && index2[i] != -1) {
                int diff = index1[i] - index2[i];
                if (diff < minDiff) {
                    minDiff = diff;
                    res = 1;
                } else if (minDiff == diff) {
                    ++res;
                }
            }
        }

        return res;
    }
}
/*
$1794. 统计距离最小的子串对个数
https://leetcode.cn/problems/count-pairs-of-equal-substrings-with-minimum-difference/description/

输入数据为两个字符串firstString 和 secondString，两个字符串下标均从0开始，且均只包含小写的英文字符，请计算满足下列要求的下标四元组(i,j,a,b)的个数：
- 0 <= i <= j < firstString.length
- 0 <= a <= b < secondString.length
- firstString字符串中从i位置到j位置的子串(包括j位置的字符)和secondString字符串从a位置到b位置的子串(包括b位置字符)相等
- j-a的数值是所有符合前面三个条件的四元组中可能的最小值
返回符合上述 4 个条件的四元组的 个数 。
提示：
1 <= firstString.length, secondString.length <= 2 * 10^5
两个输入字符串均只包含小写英文字符.

题目有点绕，但是核心其实就是取尽可能小的 j，和尽可能大的 a，那么单个字符是最好的
遍历第一个字符去找最左边出现的字符的位置，第二个字符找最右边出现字符的位置
遍历左边的位置，去找对应的右边，计算 j-a 的差值，计算个数即是结果
https://leetcode.cn/problems/count-pairs-of-equal-substrings-with-minimum-difference/solutions/1354075/by-ffreturn-c4fn/
 */