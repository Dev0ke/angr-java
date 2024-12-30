import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] ids = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(ids, (o1, o2) -> Integer.compare(heights[o2], heights[o1]));

        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = names[ids[i]];
        }
        return res;
    }
}
/*
2418. 按身高排序
https://leetcode.cn/problems/sort-the-people/

第 312 场周赛 T1。

给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。
对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
请按身高 降序 顺序返回对应的名字数组 names 。
提示：
n == names.length == heights.length
1 <= n <= 10^3
1 <= names[i].length <= 20
1 <= heights[i] <= 10^5
names[i] 由大小写英文字母组成
heights 中的所有值互不相同

组合排序
时间复杂度 O(nlogn)
 */