public class Solution2678 {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String s : details) {
            int age = Integer.parseInt(s.substring(11, 13));
            if (age > 60) {
                ans++;
            }
        }
        return ans;
    }
}
/*
2678. 老人的数目
https://leetcode.cn/problems/number-of-senior-citizens/

第 104 场双周赛 T1。

给你一个下标从 0 开始的字符串 details 。details 中每个元素都是一位乘客的信息，信息用长度为 15 的字符串表示，表示方式如下：
- 前十个字符是乘客的手机号码。
- 接下来的一个字符是乘客的性别。
- 接下来两个字符是乘客的年龄。
- 最后两个字符是乘客的座位号。
请你返回乘客中年龄 严格大于 60 岁 的人数。
提示：
1 <= details.length <= 100
details[i].length == 15
details[i] 中的数字只包含 '0' 到 '9' 。
details[i][10] 是 'M' ，'F' 或者 'O' 之一。
所有乘客的手机号码和座位号互不相同。

字符串模拟。
时间复杂度 O(n)
 */