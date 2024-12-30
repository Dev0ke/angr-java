public class Solution565 {
    public int arrayNesting(int[] nums) {
        int len = nums.length;

        int max = 0;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            // 环长
            int cnt = 0;
            while (!visited[i]) {
                visited[i] = true;
                i = nums[i];
                cnt++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
/*
565. 数组嵌套
https://leetcode.cn/problems/array-nesting/

索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] < nums.length
A中不含有重复的元素。

问题等价于求有向图最大环长。
时间复杂度 O(n)
空间复杂度 O(n)
一个有趣的问题: https://www.bilibili.com/video/BV17W4y1S7WR?vd_source=8ed800ee72909f0ae7e3ed18314f50e0
100名囚犯，编号1-100
写有他们编号的纸条随机放入房间里的100个箱子
囚犯依次独自进入房间，查看50个箱子
离开房间时一切必须保持原样，不能与后来的人交流
所有人找到自己的编号则全部释放，一人没找到则全部处决
他们的最佳策略是什么？
最佳策略概率约为 0.31
 */