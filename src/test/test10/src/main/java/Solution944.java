public class Solution944 {
    public int minDeletionSize(String[] strs) {
        int lenM = strs.length;
        int lenN = strs[0].length();
        int res = 0;
        for (int i = 0; i < lenN; i++) {
            for (int j = 1; j < lenM; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    res++;
                    // 剪枝
                    break;
                }
            }
        }
        return res;
    }
}
/*
944. 删列造序
https://leetcode.cn/problems/delete-columns-to-make-sorted/

第 111 场周赛 T2。

给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
abc
bce
cae
你需要找出并删除 不是按字典序升序排列的 列。在上面的例子（下标从 0 开始）中，列 0（'a', 'b', 'c'）和列 2（'c', 'e', 'e'）都是按升序排列的，而列 1（'b', 'c', 'a'）不是，所以要删除列 1 。
返回你需要删除的列数。
提示：
n == strs.length
1 <= n <= 100
1 <= strs[i].length <= 1000
strs[i] 由小写英文字母组成

模拟
相似题目: 955. 删列造序 II
https://leetcode.cn/problems/delete-columns-to-make-sorted-ii/
960. 删列造序 III
https://leetcode.cn/problems/delete-columns-to-make-sorted-iii/
 */