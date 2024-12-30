public class Solution3006 {
}
/*
3006. 找出数组中的美丽下标 I
https://leetcode.cn/problems/find-beautiful-indices-in-the-given-array-i/description/

第 380 场周赛 T2。

给你一个下标从 0 开始的字符串 s 、字符串 a 、字符串 b 和一个整数 k 。
如果下标 i 满足以下条件，则认为它是一个 美丽下标：
- 0 <= i <= s.length - a.length
- s[i..(i + a.length - 1)] == a
- 存在下标 j 使得：
  - 0 <= j <= s.length - b.length
  - s[j..(j + b.length - 1)] == b
  - |j - i| <= k
以数组形式按 从小到大排序 返回美丽下标。
提示：
1 <= k <= s.length <= 10^5
1 <= a.length, b.length <= 10
s、a、和 b 只包含小写英文字母。

同: 3008. 找出数组中的美丽下标 II
https://leetcode.cn/problems/find-beautiful-indices-in-the-given-array-ii/description/
 */