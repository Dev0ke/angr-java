public class SolutionP2955 {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int[][] dc = new int[26][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a'; // 将字符转换为0-25的索引
            for (int j = 0; j < 26; j++) {
                dc[j][i + 1] = dc[j][i];
                if (j == index) {
                    dc[j][i + 1]++;
                }
            }
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int left = queries[i][0], right = queries[i][1];
            int count = 0;
            for (int k = 0; k < 26; k++) {
                // 计算区间内字符k的数量
                int num = dc[k][right + 1] - dc[k][left];
                // 计算以该字符结尾的相同子字符串数量
                count += (num * (num + 1)) / 2;
            }
            ans[i] = count;
        }
        return ans;
    }
}
/*
$2955. 同端子串的数量
https://leetcode.cn/problems/number-of-same-end-substrings/description/

给定一个 下标从0开始 的字符串 s，以及一个二维整数数组 queries，其中 queries[i] = [li, ri] 表示 s 中从索引 li 开始到索引 ri 结束的子串（包括两端），即 s[li..ri]。
返回一个数组 ans，其中 ans[i] 是 queries[i] 的 同端 子串的数量。
如果一个 下标从0开始 且长度为 n 的字符串 t 两端的字符相同，即 t[0] == t[n - 1]，则该字符串被称为 同端。
子串 是一个字符串中连续的非空字符序列。
提示：
2 <= s.length <= 3 * 10^4
s 仅包含小写英文字母。
1 <= queries.length <= 3 * 10^4
queries[i] = [li, ri]
0 <= li <= ri < s.length

基本思路都一致，假设查询范围为[i,j]，其范围内字符c的数量为x，则以x为头尾的子串数量为x*(x+1)//2。因此对于每个查询范围，遍历26个字母，找到对应的区间数量即可。
获得区间数有两种方法，实时二分或前缀和，如果queries数组短而s长用前者，否则用后者。
前缀和是对每个字符预处理其前缀计数列表，查询时调用前缀和相减即是数量。
二分法是记录每个字符所在的位置，对于该递增数组，查询时二分查询递增数组下标，下标差即是数量。
https://leetcode.cn/problems/number-of-same-end-substrings/solutions/2558555/er-fen-huo-qian-zhui-he-bian-li-ge-zi-fu-yw8h/
 */